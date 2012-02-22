// Voegt algemene fallbacks toe aan de ControllerFactory. Tevens zijn deze controllers
// geschikt als baseclasses

// Voor Intellisense in Visual Studio
/// <reference path="~/lib/yui/yahoo/yahoo.js" />
/// <reference path="~/lib/yui/dom/dom.js" />
/// <reference path="~/lib/yui/event/event.js" />
/// <reference path="~/lib/yui/json/json.js" />
/// <reference path="~/mvc/core.js" />

aquima.mvc.generic = {};
aquima.mvc.generic.controller = {};

(function () {

    // Aliases
    var Dom = YAHOO.util.Dom;
    var Event = YAHOO.util.Event;

    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;
    var hasFormat = Util.hasFormat;

    var div = Util.createElementFactory('div');
    var span = Util.createElementFactory('span');
    var a = Util.createElementFactory('a');
    var ul = Util.createElementFactory('ul');
    var li = Util.createElementFactory('li');
    var input = Util.createElementFactory('input');
    var select = Util.createElementFactory('select');
    var option = Util.createElementFactory('option');
    var button = Util.createElementFactory('button');
    var label = Util.createElementFactory('label');
    var h1 = Util.createElementFactory('h1');
    var img = Util.createElementFactory('img');

    // Different classes can be 'augmented' with the methods from this class, which provides error
    // messages inside a new div
    // Usage: YAHOO.lang.augment(XXXController, MessagesProvider);
    var MessagesProvider = aquima.mvc.generic.controller.MessagesProvider = function () {
        this.messagesDiv = null;
    };
    MessagesProvider.prototype = {

    	// Returns the messagesDiv and sets messagesDivChildrenNode to the element
    	// receiving the child-errors
        createMessagesDiv: function() {
            return this.messagesDivChildrenNode = div({ className: 'aq-alertcontainer' });
        },
    		
        // adds or removes the this.messagesDiv div and updates its contents
        updateMessages: function(messages) {
            var result = false;
            if (!this.messagesDiv && messages.length > 0) { // Add this.messagesDiv
                this.messagesDiv = this.createMessagesDiv();
                this.addMessagesDiv();
                result = true;
            }
            if (this.messagesDiv && messages.length === 0) { // Remove this.messagesDiv
                this.removeMessagesDiv();
                this.messagesDiv = null;
                result = true;
            }
            if (messages.length > 0) { this.updateMessagesDiv(messages); }
            return result;
        },

        // Can be overridden to enable another place for this.messagesDiv in the dom tree
        addMessagesDiv: function() {
            if (this.config.createOuterAnimDiv) {
                this.viewNodes.push(div({className:'anim'}, this.messagesDiv));
            } else {
                this.viewNodes.push(this.messagesDiv);
            }
        },

        removeMessagesDiv: function() {
            if (this.config.createOuterAnimDiv) {
                if (this.viewNodes.pop().childNodes[0] != this.messagesDiv) { throw new Error('messagesDiv not found'); }
            } else {
                if (this.viewNodes.pop() != this.messagesDiv) { throw new Error('messagesDiv not found'); }
            }
        },

        // Renders newMessages in 'this.messagesDiv'
        updateMessagesDiv: function(newMessages) {
        	Util.removeAllChildren(this.messagesDivChildrenNode);
            for (var i = 0; i < newMessages.length; i++) {
                this.messagesDivChildrenNode.appendChild(this.createMessageViewNode(newMessages[i]));
            }
        },
        
        createMessageViewNode: function(message) {
            return div({className: 'aq-alert'}, 
                       div({ className: 'aq-'+message.type }, //type can be either 'warn' or 'error'
                            span(message.display)
                       )
                   );
        }
    };

    // Different classes can be 'augmented' with the methods from this class, which can
    // aggregate messages from everywhere in the model tree below the node. 
    // this.updateMessages will be called if something changed.
    var MessagesAggregatorProvider = aquima.mvc.generic.controller.MessagesAggregatorProvider = function () { 
        this.oldAggregatedMessages = [];
    };
    MessagesAggregatorProvider.prototype = {
        // Should be called during init and update. This method will call this.updateMessages when necessary
        checkMessages: function(newModel) {
            var messages = [];
            function addMessages(model) {
                if (model.content) {
                    for (var ii=0;ii<model.content.length;ii++) {
                        addMessages(model.content[ii]);
                    }
                }
                if (model.messages) {
                    for (var i=0;i<model.messages.length;i++) {
                        messages.push(model.messages[i]);
                    }
                }
            }
            addMessages(newModel);
            var result = false;
            if (Util.messagesUpdated(this.oldAggregatedMessages, messages)) {
                result = this.updateMessages(messages);
            }
            this.oldAggregatedMessages = messages;
            return result;
        }
    };

    // ContainerController
    // Abstract baseclass for (Dyamic) Containers. 
    // This is a thin wrapper around the contentcontroller which also handles (error)messages and
    // puts these in a separate div.
    var ContainerController = aquima.mvc.generic.controller.ContainerController =
        Util.extend(aquima.mvc.ContentController, {

            init: function(model) {
                ContainerController.superclass.init.call(this, model); //super.init
                if (this.model.messages && this.model.messages.length !== 0) {
                    this.updateMessages(this.model.messages || []);
                }
            },

            update: function(newModel) {
                var result = false;
                if (Util.messagesUpdated(this.model.messages, newModel.messages)) {
                    result = this.updateMessages(newModel.messages || []) || result;
                }
                result = ContainerController.superclass.update.call(this, newModel) || result; //super.update
                return result;
            }

        });
    YAHOO.lang.augment(ContainerController, MessagesProvider);

    // DivController
    // Controller for a container, which renders just 1 div element. 
    // (when there are messages on the container they are rendered as well)
    // Use config.className for the CSS class
    var DivController = aquima.mvc.generic.controller.DivController =
        Util.extend(aquima.mvc.generic.controller.ContainerController, {

            createViewNodes: function() {
                this.viewNodes = [
this.childrenNode = div({ id: this.model.id, className: this.config.className })
                ];
            }

        });

    // HeaderDivController
    // Controller for a container which renders a div containing a head div and a body div.
    // The head div contains the displaytext from the container the body div contains the content.
    // Use config.className for the CSS class for the main div
    // Use config.headClassName if config.className+'-caption' is not a good CSS class for the head div
    // Use config.bodyClassName if config.className+'-content' is not a good CSS class for the body div
    var HeaderDivController = aquima.mvc.generic.controller.HeaderDivController =
        Util.extend(aquima.mvc.generic.controller.ContainerController, {

            createViewNodes: function() {
                var headClassName = this.config.headClassName || (this.config.className||'')+'-caption';
                var bodyClassName = this.config.bodyClassName || (this.config.className||'')+'-content';
                this.viewNodes = [
                    div({ id: this.model.id, className: this.config.className },
                        div({ className: headClassName },
this.displayNode =          span(this.model.display)
                        ),
this.childrenNode =     div({ className: bodyClassName })
                    )
                ];
            },

            update: function(newModel) {
                var oldModel = this.model;
                HeaderDivController.superclass.update.call(this, newModel); //super.update(newModel)
                if (oldModel.display != newModel.display) {
                    this.updateDisplay(newModel.display);
                }
                return false;
            },

            updateDisplay: function(display) {
                Util.setText(this.displayNode, display);
            }
        });

    // ButtonController
    // Renders a link which functions as a button. This is a basic alternative for the fancier PushButtonController
    // Config:
    // -  display: overrides the button's text/caption
    var ButtonController = aquima.mvc.generic.controller.ButtonController =
        Util.extend(aquima.mvc.Controller, {

            // If the user presses enter on the page, the single button with the highest 
            // enterpriority greater than 0 will receive a click
            getEnterPriority: function() {
                if (this.config.enterPriority != null) {
                    return this.config.enterPriority;
                }
                return 1;
            },

            init: function(model) {
                this.model = model;
                this.createViewNodes();
                Event.on(this.actionElement, 'click', this.onClick, null, this);
                this.createOuterAnimDiv();
            },

            update: function(newModel) {
                if (this.model.readonly != newModel.readonly) {
                    this.updateReadonly(newModel.readonly);
                }
                if (this.model.display != newModel.display) {
                    this.updateDisplay(newModel.display);
                }
                this.model = newModel;
                return false;
            },

            updateDisplay: function(newDisplay) {
            	this.inputButtonViewNode.value=this.config.display || newDisplay;
            	this.inputButtonViewNode.title=newDisplay;
            },

            // This method can be overridden by subclasses.
            // This method is responsible for populating this.viewNodes 
            // and setting this.actionElement to the element receiving clicks.
            createViewNodes: function() {
                this.actionElement = this.inputButtonViewNode = 
                	input({
                		type: 'button', id: this.model.id, title: this.model.display,
                		className: this.config.className,
                		value: this.config.display || this.model.display
                	});
                if (this.model.readonly) {
                    this.updateReadonly(true);
                }
                this.viewNodes = [this.actionElement];
            },

            onClick: function(event) {
                if (this.model.readonly) { return; }
                this.engine.buttonClicked.fire(this);
                this.fireSubmit(event);
                if (event) {
                    Event.preventDefault(event);
                }
            },

            // Fires the submit
            // Can be overridden by subclasses to do something different
            fireSubmit: function(event) {
                this.engine.submit(event, this, this.config.scrollToTop);
            },

            updateReadonly: function(readonly) {
                if (readonly) {
                    Dom.addClass(this.actionElement, 'aq-disabled');
                    this.inputButtonViewNode.disabled = true;
                } else {
                    Dom.removeClass(this.actionElement, 'aq-disabled');
                    this.inputButtonViewNode.disabled = false;
                }
            }
        });
    
    // PushButtonController
    // Fancier Buttons wich changes style when hovered over and when pressed
    var PushButtonController = aquima.mvc.generic.controller.PushButtonController =
        Util.extend(aquima.mvc.generic.controller.ButtonController, {

            init: function(model) {
                this.model = model;
                this.createViewNodes();
                this.button.on('click', this.onClick, null, this);
                this.createOuterAnimDiv();
            },
            
            createViewNodes: function() {
                var className = Util.strcat('aq-button ', this.config.className);
                this.viewNodes=[span({className:className})];
                this.button = new YAHOO.widget.Button({
                    id: this.model.id,
                    type: 'push',
                    label: this.model.display ? this.model.display : '&nbsp;&nbsp;&nbsp;',
                    container: this.viewNodes[0]
                });
            },
        
            updateDisplay: function(newDisplay) {
                this.button.set('label', newDisplay);
            },

            updateReadonly: function(readonly) {
                this.button.set('disabled', readonly);
            }
        });
    

    // DivFieldController
    // A FieldController which uses divs. See FieldController.
    var DivFieldController = aquima.mvc.generic.controller.DivFieldController =
        Util.extend(aquima.mvc.FieldController, {

            createViewNodes: function() {
                this.createDivStructure();
                if (this.model.readonly) {
                    this.updateReadonly(this.model.readonly);
                }
                if (this.model.required) {
                    this.updateRequired(true);
                }
                if (this.model.explain != null && this.model.explain != '') {
                    this.updateExplain(this.model.explain);
                }
            },

            updateReadonly: function(readonly) {
                if (readonly) {
                    Dom.addClass(this.answerDiv, 'disabled');
                } else {
                    Dom.removeClass(this.answerDiv, 'disabled');
                }
            },

            createDivStructure: function() {
                this.viewNodes = [
this.inputHolder =  div({ className: Util.strcat('aq-field ',this.config.className) },
this.questionDiv =      div({className: 'aq-question'},
                            this.labelElement
                        ),
                        
this.answerDiv =        div({className: 'aq-answer'},
                            div({className: 'aq-answer-holder'},
                                this.input.viewNode
                            )
                        )
                        // requiredDiv gets added here dynamically
                        // explainIcon gets added here dynamically
                    )
                ];
            },

            updateRequired: function(required) {
                if (required) {
                    this.requiredDiv = this.createRequiredDiv();
                    this.insertRequiredDiv();
                } else {
                    this.requiredDiv.parentNode.removeChild(this.requiredDiv);
                    this.requiredDiv = null;
                }
            },

            createRequiredDiv: function() {
                return div({ className: 'aq-required' }, span('*'));
            },

            // Default location: After answerDiv
            insertRequiredDiv: function() {
                Util.insertAfter(this.answerDiv.parentNode, this.answerDiv, this.requiredDiv);
            },

            updateExplain: function(explain) {
                if (explain == null || explain == '') {
                    if (this.explainIcon != null) {
                        this.destroyExplainIcon();
                        this.explainIcon.parentNode.removeChild(this.explainIcon);
                    }
                    this.explainIcon = null;
                } else {
                    if (this.explainIcon == null) {
                        this.explainIcon = this.createExplainIcon();
                        this.insertexplainIcon();
                    }
                }
            },

            createExplainIcon: function() {
                var icondiv = div({ className: 'aq-explain' }, span('?'));
                this.explainTooltip = this.createExplainTooltip(icondiv);
                this.explainTooltip.contextTriggerEvent.subscribe(this.setTooltipText, null, this);
                return icondiv;
            },

        	createExplainTooltip: function(icondiv) {
                return new YAHOO.widget.Tooltip(
                    this.model.id + '-tooltip',
                    {
                        context: icondiv,
                        xyoffset: [20, -20],
                        container: this.engine.tooltipDiv,
                        showdelay: 50,
                        hidedelay: 50,
                        autodismissdelay: 5000000
                    }
                );
            },

        	setTooltipText: function() {
            	var explain = Util.cleanupHtml(this.model.explain);
            	var divExplain = '<div class="aq-explain-header">&nbsp;</div>'
            					+ '<div class="aq-explain-body"><span class="aq-explain">' + explain + '</span></div>'
            					+ '<div class="aq-explain-footer">&nbsp;</div>';
                
                this.explainTooltip.cfg.setProperty('text', divExplain);
            },

            destroyExplainIcon: function() {
                this.explainTooltip.contextTriggerEvent.unsubscribe(this.setTooltipText);
                this.explainTooltip.destroy();
            },

            // Default location: As the last sibling of answerDiv
            insertexplainIcon: function() {
                this.answerDiv.parentNode.appendChild(this.explainIcon);
            }
        });
    YAHOO.lang.augment(DivFieldController, MessagesProvider, true); // provides the updateMessages method

    var PageController = aquima.mvc.generic.controller.PageController =
        Util.extend(HeaderDivController, {

            init: function(model) {
                this.config.animate = false;
                PageController.superclass.init.call(this, model); //super.init
                this.updateBrowserTitle();
            },

            update: function(newModel) {
                PageController.superclass.update.call(this, newModel); //super.update
                this.updateBrowserTitle();
            },
            
            createViewNodes: function() {
                var bodyClassName = this.config.bodyClassName || this.config.className+'-content';
                this.viewNodes = [
                    div({ id: this.model.id, className: this.config.className },
                        this.createHeader(),    
this.childrenNode =     div({ className: bodyClassName })
                    )
                ];
            },
            
            createHeader: function() {
                var headerClassName = this.config.headerClassName || this.config.className+'-header';
                var captionClassName = this.config.captionClassName || this.config.className+'-header';
                return div({className:headerClassName},
                    div({className:captionClassName},
this.displayNode =      span(this.model.display)
                    ),
this.extraHeader =  div()
                );
            },

            // Places some of the subcontrollers in the header
            replaceChildrenViewNodes: function() {
                var bodyChildrenViewNodes = [];
                var headerChildrenViewNodes = [];
                for (var i = 0; i < this.children.length; i++) {
                    var childController = this.children[i];
                    for (var ii = 0; ii < childController.viewNodes.length; ii++) {
                        if (childController.placeViewNodesInHeader){
                            headerChildrenViewNodes.push(childController.viewNodes[ii]);
                        } else {
                            bodyChildrenViewNodes.push(childController.viewNodes[ii]);
                        }
                    }
                }
                this.replaceChildNodes(this.extraHeader, headerChildrenViewNodes);
                this.replaceChildNodes(this.childrenNode, bodyChildrenViewNodes);
                return false;
            },
            

            createOuterAnimDiv: function() {},

            updateBrowserTitle: function() {
            	if (this.model.display) {
                    try {
                        if (!this.oldTitle) {
                            this.oldTitle = top.document.title; 
                        }
                        top.document.title = this.model.display;
                    } catch (ex) {}
            	}
            },

            serverErrorMessage: function(o) {
                return Settings.texts.serverError;
            },

            serverError: function(o) {
                var message = { type: 'error', display: this.serverErrorMessage(o) };
                if (this.updateMessages([message])) {
                    // this.messagesDiv needs to be added manually
                    this.childrenNode.parentNode.insertBefore(this.messagesDiv, this.childrenNode);
                }
            },

            destroy: function() {
                if (this.oldTitle) {
                    try {
                        top.document.title = this.oldTitle;
                    } catch (ex) {}
                }
                PageController.superclass.destroy.call(this); //super.destroy
            },

            // The messagesDiv is inserted before the rest
            addMessagesDiv: function() {
                this.viewNodes.unshift(this.messagesDiv);
            },

            removeMessagesDiv: function() {
                if (this.viewNodes.shift() != this.messagesDiv) { throw new Error('messagesDiv not found'); }
            }
        });

    // TextController
    // Used for displaying assets
    var TextController = aquima.mvc.generic.controller.TextController =
        Util.extend(aquima.mvc.Controller, {

            init: function(model) {
                this.model = model;
                this.viewNodes = [
this.contentDiv =   div({ className: this.config.className },
this.innerSpan =        span()                
                    )
                ];
                this.updateDisplay(model.display);
                this.createOuterAnimDiv();
            },

            update: function(newModel) {
                if (this.model.display != newModel.display) {
                    this.updateDisplay(newModel.display);
                }
                this.model = newModel;
                return false;
            },

            updateDisplay: function(display) {
                if (this.config.allowInnerHtml) {
                    var text = Util.cleanupHtml(display);
                    this.innerSpan.innerHTML = text;
                } else {
                    Util.setText(this.innerSpan, display);
                }
            }
        });
    
    // TextItemController
    // Used for displaying text items, which may contain multiple texts
    var TextItemController = aquima.mvc.generic.controller.TextItemController =
        Util.extend(aquima.mvc.Controller, {

            init: function(model) {
                this.model = model;
                this.viewNodes = [
this.contentDiv =   div({ className: this.config.className },
                        this.createNodes(this.model.nodes)
                    )
                ];
                this.createOuterAnimDiv();
            },

            update: function(newModel) {
                var oldModel = this.model;
                this.model = newModel;
                if (this.modelChanged(oldModel, newModel)) {
                    var nodes = this.createNodes(this.model.nodes);
                    Util.replaceChildNodes(this.contentDiv, nodes)
                }
                return false;
            },

            createNodes: function(nodes) {
                var result = [];
                if( !nodes ) {
                    return result;
                }
                for( var i=0; i < nodes.length; i ++ ) {
                    result.push( this.createNode( nodes[i] ) );
                }
                return result;
            },
            
            modelChanged: function(oldModel, newModel) {
                if (!oldModel.nodes && !newModel.nodes) {return false;}
                if (!oldModel.nodes || !newModel.nodes) {return true;}
                if (oldModel.nodes.length != newModel.nodes.length) {return true;}
                for (var i=0;i<oldModel.nodes.length;i++) {
                    if (this.nodeChanged(oldModel.nodes[i], newModel.nodes[i])) {return true;}
                }
                return false;
            },
            
            nodeChanged: function(oldNode, newNode) {
                if (oldNode.text && (oldNode.text!=newNode.text)) {return true;}
                if (oldNode.value && (oldNode.value!=newNode.value)) {return true;}
                if (oldNode.style && (oldNode.style!=newNode.style)) {return true;}
                if (!oldNode.nodes && !newNode.nodes) {return false;}
                // We now now that there are subnodes
                if (!oldNode.nodes || !newNode.nodes) {return true;}
                if (oldNode.nodes.length !=newNode.nodes.length) {return true;}
                for (var i=0;i<oldNode.nodes.length;i++) {
                    if (this.nodeChanged(oldNode.nodes[i], newNode.nodes[i])) {return true;}
                }
                return false;
            },
            
            createNode: function(node) {
                if( node.text ) {
                    var s = span();
                    s.innerHTML = Util.cleanupHtml(node.text).replace(/\n/g, '<br/>');
                    return s;    
                }
                if( node.value ) {
                    return span( node.value );    
                }
                if( node.style ) {
                    return span( { className: node.style }, this.createNodes( node.nodes ) );    
                }
            }
        });    

    // DownloadController
    // used to download generated documents
    // Configuration options:
    // - See Controller
    var DownloadController = aquima.mvc.generic.controller.DownloadController =
        Util.extend(aquima.mvc.Controller, {
            
            init: function(model) {
                this.model = model;
                this.createViewNodes();
                this.createOuterAnimDiv();
            },

            createViewNodes: function() {
                this.viewNodes = [
                    div({ className: 'DownloadContainer' },
                        div({ className: 'documentOpen' },
                            span({ className: 'icon-' + this.model.params['document-type'] }),
this.actionElement =        a({ target : "_blank", className: "aq-document-link", href: this.createDoclinkUrl() }, this.model.display)
                        )
                    )
                ];
            },

            createDoclinkUrl: function() {
                return Settings.baseUrl + 'Document.aquima'
                    + '?document-name=' + this.model.params['document-name']
                    + '&document-type=' + this.model.params['document-type']
                    + '&document-saveas=false'
                    + '&sessionId=' + encodeURIComponent(this.engine.aquimaSessionId);
            }
        });
    
    // ImageController
    // used to display images defined in the Aquima application
    // Configuration options:
    // - See Controller
    var ImageController = aquima.mvc.generic.controller.ImageController =
        Util.extend(aquima.mvc.Controller, {
            
            init: function(model) {
                this.model = model;
                this.createViewNodes();
                this.createOuterAnimDiv();
            },

            createViewNodes: function() {
                this.viewNodes = [
                    img({ 
                    	src : this.createSource(), 
                    	height : this.model.height, 
                    	width : this.model.width, 
                    	className: this.config.className 
                    })
                ];
            },

            createSource: function() {
                return Settings.baseUrl + 'Image.aquima'
                    + '?name=' + this.model.name
                    + '&sessionId=' + encodeURIComponent(this.engine.aquimaSessionId);
            }
        });    

    var BreadCrumbContainerController = aquima.mvc.generic.controller.BreadCrumbContainerController =
        Util.extend(aquima.mvc.generic.controller.ContainerController, {
            
            placeViewNodesInHeader: true, // Hint for the PageController
            
            createViewNodes: function() {
                this.viewNodes = [
                    div({className: this.config.className},
this.childrenNode =     ul()
                    )
                ];
            }
        })

    // BreadCrumbController
    // used to control a bread crumb container
    var BreadCrumbController = aquima.mvc.generic.controller.BreadCrumbController =
        Util.extend(aquima.mvc.generic.controller.ButtonController, {

            createViewNodes: function() {
                this.config.enterPriority = 0;
                var labelElement;
                var liClassName;
                var liCaptionClass;
                var breadCrumbNumber = (parseInt(this.model.id.substr((this.model.id.length - 1), 1)) + 1);
                if (this.model.isPassed) {
                    liClassName='aq-breadcrumb-passed'
                    labelElement = a({ href: '#' }, this.model.text);
                    this.actionElement = labelElement;
                } else {
                    liClassName = this.model.isCurrent ? 'aq-breadcrumb-current' : 'aq-breadcrumb-disabled';
                    labelElement = span(this.model.text);
                }
                liCaptionClass = this.model.isCurrent ? 'aq-breadcrumb-caption-current' : 'aq-breadcrumb-caption';
                if (breadCrumbNumber == 1) { liClassName += ' first'; liCaptionClass += ' first-caption'; } 
                this.viewNodes = [
                    li({ className: liCaptionClass }, breadCrumbNumber+''),
                    this.breadNode = li({ className: Util.concatCssClasses(this.config.className, liClassName) }, labelElement)
                ];
                Dom.setStyle(this.breadNode, 'z-index', (20 - breadCrumbNumber).toString() );
            },
            
            createOuterAnimDiv: function() {}

        });

    // FailedElementController
    // used to control failed elements
    var FailedElementController = aquima.mvc.generic.controller.FailedElementController =
        Util.extend(aquima.mvc.Controller, {
            init: function(model) {
                this.model = model;
                this.viewNodes = [
                    div(
                        span({ className: 'aq-error' }, model["failedelement-type"] + " element '" + model.name + "' resulted in an error: " + model.message),
                        div({ className: 'aq-stacktrace' }, model.stacktrace)
                    )
                ];
                this.createOuterAnimDiv();
            }
        });

    // RowController
    // Creates a row div containing a column div for each child's viewNodes.
    var RowController = aquima.mvc.generic.controller.RowController =
        Util.extend(aquima.mvc.ContentController, {

            createViewNodes: function() {
                this.viewNodes = [
this.rowNode =      div({ className: Util.strcat("aq-row ", this.config.className) })
                ];
                this.replaceChildrenViewNodes();
            },

            createColumnNode: function(index) {
                return div({ className: 'aq-column aq-column' + (index + 1) });
            },

            replaceChildrenViewNodes: function() {
                var headerCount = 1000;
                if (this.parent.headerCount) {
                    headerCount = this.parent.headerCount();
                }
                var columnNodes = [];
                var columnIndex = 0;
                for (var i = 0; i < this.children.length; i++) {
                    var child = this.children[i];
                    for (var ii=0;ii<child.viewNodes.length;ii++) {
                        var viewNode = child.viewNodes[ii];
                        var columnNode = viewNode.parentNode;
                        if (columnNode == null || !columnNode.tagName) { // : Raar IE (zelfs IE8) gedrag: parentNode is geen Element
                            columnNode = this.createColumnNode(columnIndex);
                            if (columnIndex >= headerCount) {
                                Dom.addClass(columnNode, 'noheader');
                            }
                            columnNode.appendChild(viewNode);
                        }
                        columnNodes.push(columnNode);
                        columnIndex++;
                    }
                }
                Util.replaceChildNodes(this.rowNode, columnNodes);
            }
        });

    var RowWithAggregatedMessagesController = aquima.mvc.generic.controller.RowWithAggregatedMessagesController =
        Util.extend(aquima.mvc.generic.controller.DivController, {

            init: function (model) {
                RowWithAggregatedMessagesController.superclass.init.call(this, model); //super.init
                this.checkMessages(model);
            },

            update: function (newModel) {
                var result = this.checkMessages(newModel);
                result = ContainerController.superclass.update.call(this, newModel) || result; //super.update
                return result;
            }

        });
    YAHOO.lang.augment(RowWithAggregatedMessagesController, MessagesProvider);
    YAHOO.lang.augment(RowWithAggregatedMessagesController, MessagesAggregatorProvider);

    var InstanceSelectorController = aquima.mvc.generic.controller.InstanceSelectorController =
        Util.extend(aquima.mvc.generic.controller.ContainerController, {

            createViewNodes: function() {
                this.viewNodes = [
                    div({ className: this.config.className },
this.headerNode =       div({ className: 'aq-header' }),
this.childrenNode =     div({ className: 'aq-instances' }),
this.buttonsNode =      div({ className: 'aq-buttons' })
                    )
                ];
            },

            getHeaderController: function() {
                for (var i = 0; i < this.children.length; i++) {
                    if (this.children[i].model.type == 'header') {
                        return this.children[i];
                    }
                }
            },

            getButtonsController: function() {
                for (var i = 0; i < this.children.length; i++) {
                    if (this.children[i].model.type == 'buttons') {
                        return this.children[i];
                    }
                }
            },

            // Overridden to only collect viewNodes from instances (skips buttons and header)
            getChildrenViewNodes: function() {
                var result = [];
                for (var i = 0; i < this.children.length; i++) {
                    var child = this.children[i];
                    if (child.model.type != 'header' && child.model.type != 'buttons') {
                        for (var ii = 0; ii < child.viewNodes.length; ii++) {
                            result.push(child.viewNodes[ii]);
                        }
                    }
                }
                return result;
            },

            replaceChildrenViewNodes: function() {
                // Special treatment for header and buttons
                var headerController = this.getHeaderController();
                if (headerController) {
                    this.headerNode.style.display='block';
                    this.replaceChildNodes(this.headerNode, headerController.viewNodes);
                } else {
                    this.headerNode.style.display='none';
                }
                var buttonsController = this.getButtonsController();
                if (buttonsController) {
                    this.replaceChildNodes(this.buttonsNode, buttonsController.viewNodes);
                }
                // Normal behavior which will use getChildrenViewNodes
                InstanceSelectorController.superclass.replaceChildrenViewNodes.call(this);
            },

            headerCount: function() {
                var headerController = this.getHeaderController();
                if (headerController) {
                    return this.getHeaderController().children.length;
                }
                return 1000;
            }
        });

    // For debugging purposes
    Util.addClassNames(aquima.mvc.generic.controller, 'aquima.mvc.generic.controller');
} ());