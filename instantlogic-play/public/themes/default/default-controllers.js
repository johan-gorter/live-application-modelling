var defaultTheme = {};
defaultTheme.mvc = {};
defaultTheme.mvc.controller = {};

(function() {

    // Aliases
    var Dom = YAHOO.util.Dom;
    var Event = YAHOO.util.Event;

    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;

    var div = Util.createElementFactory('div');
    var span = Util.createElementFactory('span');
    var a = Util.createElementFactory('a');
    var input = Util.createElementFactory('input');
    var ul = Util.createElementFactory('ul');
    var li = Util.createElementFactory('li');

    
    // Add your project-specific controllers here
    
    // var SpecialController = defaultTheme.mvc.controller.SpecialController =         
    //    Util.extend(aquima.mvc.ContentController, {
    //    });
    var DefaultDivFieldController = defaultTheme.mvc.controller.DefaultDivFieldController =
        Util.extend(aquima.mvc.generic.controller.DivFieldController, {
        	
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
            }
        });
    
    // BreadCrumbController
    // used to control a bread crumb container
    var DefaultBreadCrumbController = defaultTheme.mvc.controller.DefaultBreadCrumbController =
        Util.extend(aquima.mvc.generic.controller.BreadCrumbController, {

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
    
 // ButtonController
    // Renders a link which functions as a button. This is a basic alternative for the fancier PushButtonController
    var DefaultButtonController = defaultTheme.mvc.controller.DefaultButtonController =
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
            	this.inputButtonViewNode.value=newDisplay;
            },

            createViewNodes: function() {            	
            	if (this.model.name.indexOf('delete') != -1) { 
            		buttonClass = 'aq-button-delete'; 
            		containerClass = 'aq-button-container-delete'; 
            	} else { 
            		buttonClass = 'aq-button'; 
            		containerClass = 'aq-button-container'; 
            	}
            	this.config.className = buttonClass;
                this.actionElement = 
                	div({className: containerClass},
                		div({className: buttonClass},
                			this.inputButtonViewNode = input({type: this.model.type, id: this.model.id, className: this.config.className, title: this.model.display, value: this.model.display })
                		)
                	);
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
                    Dom.addClass(this.actionElement, 'disabled');
                } else {
                    Dom.removeClass(this.actionElement, 'disabled');
                }
            }
        });
    
    // For debugging purposes
    Util.addClassNames(defaultTheme.mvc.controller, 'defaultTheme.mvc.controller');
} ());