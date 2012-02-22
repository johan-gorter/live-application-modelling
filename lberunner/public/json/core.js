/*jslint browser: true, undef: true */
/*global YAHOO, window */

// Namespaces
var aquima = {};
aquima.mvc = {};
aquima.mvc.runningEngines = [];
aquima.mvc.engineStarting = new YAHOO.util.CustomEvent('engineStarting');

// These default settings can be changed or expanded by subsequent javascript 
// files or in the html page
aquima.mvc.Settings = {
    // Path to the root of the webapp, relative to the current page
    baseUrl: '../',
    // Path to where non-background images can be found, relative to baseUrl.
    // This setting can be used by custom controllers which want to use <img> tags
    styleUrl: 'themes/not_specified/',
    // Duration of all animations
    animationSeconds: 0.5,
    // Settings for the engine
    engine: {
        // Servlet/aspx serving the JSON, relative to baseUrl
        aquimaUrl: 'json/engine',
        aquimaUrlMethod: 'POST',
        // Send no-ops to prevent session timeouts
        keepAliveMinutes: 4,
        // single-page applications terminate immediately after the first page is shown
        singlePage: false,
        // Submit all (non-readonly) values on the page always so they become user-set?
        submitUnchangedValues: true        
    },
    // Default config for all controllers 
    defaultControllerConfig: {
        // Animate appearing and disappearing of childcontrols?
        animate: true,
        // Create an extra div outside the viewNodes to make styling for animations easier
        createOuterAnimDiv: true,
        // Allow assets, questiontexts etc to contain HTML 
        allowInnerHtml: false
    },
    // Default config for all inputs 
    defaultInputConfig: {
    },
    // Texts that can be displayed to the user
    texts : {
        serverError: 'An unexpected server error occurred',
        warnUnload: 'Any information you entered will be lost'
    }
};

// Within this function, variables will be local instead of global
(function() {

    // Aliases
    var Dom = YAHOO.util.Dom;
    var Event = YAHOO.util.Event;
    var YUC = YAHOO.util.Connect;
    var JSON = YAHOO.lang.JSON;
    var Anim = YAHOO.util.Anim;
    var Settings = aquima.mvc.Settings;

    // Constants
    var ANIMATION_EASING = YAHOO.util.Easing.easeOut;
    var MINUTE_IN_MS = 60 * 1000;

    // Change YUI setting for fail early
    Event.throwErrors = true;

    // Internet explorer 6 or 7?
    var ie67mode = YAHOO.env.ua.ie >= 6 && YAHOO.env.ua.ie < 8;

    // Log
    var Log = aquima.mvc.Log = {
        debug: function() { },
        info: function() { },
        warn: function() { }
    };

    // Private utility functions

    // Adds attributes to an HTML Element
    var setAttributes = function(element, attributes) {
        for (var attribute in attributes) {
            if (attributes.hasOwnProperty(attribute)) {
                var value = attributes[attribute];
                if (value !== null && value !== undefined) {
                    element[attribute] = value;
                }
            }
        }
    };

    // IE does not implement the standard way of creating elements and adding attributes like 'name'
    var createIE67Element = function(tagName, attributes) {
        var string = '<' + tagName + ' ';
        for (var attribute in attributes) {
            if (attributes.hasOwnProperty(attribute)) {
                var value = attributes[attribute];
                if (value !== null && value !== undefined) {
                    var attName = attribute;
                    if (attName == 'className') { attName = 'class'; }
                    if (attName == 'htmlFor') { attName = 'for'; }
                    if (attName == 'checked' && value === false) { continue; }
                    string += attName + '="' + value + '" ';
                }
            }
        }
        string += '>';
        return document.createElement(string);
    };

    // Recursive function which adds attributes and childnodes to an HTML Element
    var addChildNodes = function(element, content, isRoot) {
        for (var i = 0; i < content.length; i++) {
            var child = content[i];
            if (child === null || child === undefined) {
                // Nothing
            } else if (YAHOO.lang.isString(child)) { // Textnode
                element.appendChild(document.createTextNode(child));
            } else if (YAHOO.lang.isArray(child)) { // Recursion
                addChildNodes(element, child, false);
            } else if (i === 0 && !child.nodeName && isRoot) { // Attributes object
                if (ie67mode) {
                    element = createIE67Element(element.tagName.toLowerCase(), child);
                } else {
                    setAttributes(element, child);
                }
            } else if (child.nodeName) { // HTMLElement
                element.appendChild(child);
            } else {
                throw new Error('Cannot create child node from "' + child + '"');
            }
        }
        return element;
    };

    var indexOfModelWithId = function(models, id, start) {
        for (var i = start; i < models.length; i++) {
            if (models[i].id == id) { return i; }
        }
        return -1;
    };
    
    // Decimal separator detection    
    var COMMA_DECIMAL_SEPARATOR_LANGUAGES = {};
    (function() {
        var cdslList = ['ar-ae','ar-bh','ar-dz','ar-eg','ar-jo','ar-kw','ar-lb','ar-ma','ar-om',
            'ar-qa','ar-sa','ar-sy','ar-tn','ar-ye','cs-cz','da-dk','de-at','de-de','de-lu',
            'el-gr','es-ar','es-bo','es-cl','es-co','es-cr','es-do','es-ec','es-es','es-py',
            'es-uy','es-ve','fi-fi','fr-be','fr-ca','fr-fr','fr-lu','hu-hu','it-it','no-no',
            'nl-be','nl-nl','pl-pl','pt-br','ru-ru','sv-se','tr-tr'];
        for (var i=0;i<cdslList.length;i++) {
            COMMA_DECIMAL_SEPARATOR_LANGUAGES[cdslList[i]]=true;
        }
    })();
    

    // Util: Useful utilities for controllers
    var Util = aquima.mvc.Util = {

        // General Javascript language extension utilities
        
        // Easy way to extend classes, built for extending Controllers and Inputs. 
        // The superclass constructor is assumed to have just one argument 'config'
        // The subclass will also receive this constructor which invokes the superclass.
        extend: function(superClass, overrides) {
            var result = function(config) {
                superClass.prototype.constructor.call(this, config);
            };
            YAHOO.lang.extend(result, superClass, overrides);
            return result;
        },
        
        // concats 2 strings where it is okay for one of them to be empty or null
        strcat: function(s1, s2) {
            if (!s1) { s1 = ''; }
            if (!s2) { s2 = ''; }
            return s1 + s2;
        },
        
        // Concats all passed arguments to a single string which can be used as a css class.
        // Arguments can be either a string or an arrays or strings. 
        // Spaces are added automatically between css classNames, 
        // example: concatCssClasses('a',['b','c']) --> 'a b c'
        concatCssClasses: function() {
        	var result = [];
        	for (var i=0;i<arguments.length;i++) {
        		var arg = arguments[i];
        		if (typeof arg == 'string') {
        			result.push(arg);
        		} else if (arg) {
        			// assume it is an array of strings
        			for (var ii=0;ii<arg.length;ii++) {
            			result.push(arg[ii]);
        			}
        		}
        	}
        	return result.join(' ');
        },
        
        
        indexOf: function(array, obj) {
            for (var i = 0; i < array.length; i++) {
                if (array[i] == obj) { return i; }
            }
            return -1;
        },
        
        arrayEquals: function(a1, a2) {
            if (a1.length!=a2.length) { return false; }
            for (var i=0;i<a1.length;i++) {
                if (a1[i]!=a2[i]) { return false; }
            }
            return true;
        },
        
        isCommaDecimalSeparator: function(language) {
            if (language) {
                return COMMA_DECIMAL_SEPARATOR_LANGUAGES[language.toLowerCase()]===true;
            }
        },
        
        formatNumber: function(data, numberOfDecimals, isCommaDecimalSeparator, useThousandSeparator) {
            if (!numberOfDecimals) {numberOfDecimals=0}
            var result = new Number(data).toFixed(numberOfDecimals);
            if (result=="NaN") {return data;}
            var separator = result.indexOf('.');
            if (separator<0) {
                separator = result.length;
            }
            if (isCommaDecimalSeparator) {
                result = result.replace(/\./,',');
            }
            if (useThousandSeparator) {
                var thousandSeparator = isCommaDecimalSeparator?'.':',';
                separator -=3;
                while (separator>0) {
                    if (!(separator==1 && result.charAt(0)=='-')) {
                        result = result.substr(0,separator)+thousandSeparator+result.substr(separator);
                    }
                    separator -=3;
                }
            }
            return result;
        },
        

        // Dom manipulation utilities
        
        // Returns a function which can be used to create elements with a specific tagName.
        // See generic.js for examples. The returned function can handle the following:
        // - (Optional first argument) object containing attributes for the element
        //       Note: Use 'className' instead of 'class'. Also use 'htmlFor' instead of 'for'
        // - Other HTMLElements
        // - String, will be converted to a textNode
        // - Array, will be recursed
        createElementFactory: function(tagName) {
            return function() {
                var result = document.createElement(tagName);
                result = addChildNodes(result, arguments, true);
                return result;
            };
        },

        // Counterpart of HTMLElement.insertBefore
        insertAfter: function(element, child, newChild) {
            if (child === null || child === undefined || child.nextSibling === null || child.nextSibling === undefined) {
                element.appendChild(newChild);
            } else {
                element.insertBefore(newChild, child.nextSibling);
            }
        },

        // HTMLElement.insertBefore, but also works if child==null
        insertBefore: function(element, child, newChild) {
            if (child === null || child === undefined) {
                element.appendChild(newChild);
            } else {
                element.insertBefore(newChild, child);
            }
        },

        removeAllChildren: function(element) {
            while (true) {
                var childNode = element.firstChild;
                if (childNode === null || childNode === undefined) { return; }
                element.removeChild(childNode);
            }
        },

        // Replaces the content of an element with a textnode containing text.
        setText: function(element, text) {
            this.removeAllChildren(element);
            element.appendChild(document.createTextNode(text));
        },

        // Gets the text from the only textelement within the element
        getText: function(element) {
            var child = element.firstChild;
            if (child !== null) {
                return child.nodeValue;
            }
            return null;
        },

        // Makes a string 'safe' to be used as innerHTML        
        cleanupHtml: function(txt) {
            if (txt === null || txt === undefined || txt.length === 0) { return null; }
            // replace 'sensitive' tags
            txt = txt.replace(/<script/gi, "<span");
            txt = txt.replace(/<object/gi, "<span");
            txt = txt.replace(/<embed/gi, "<span");
            txt = txt.replace(/<\/script/gi, "</span");
            txt = txt.replace(/<\/object/gi, "</span");
            txt = txt.replace(/<\/embed/gi, "</span");
            return txt;
        },

        // Changes element's childNodes to nodes, making as few modifications as possible
        replaceChildNodes: function(element, nodes) {
            var nodesIndex = 0;
            var child = element.firstChild;
            while (nodesIndex < nodes.length) {
                var newChild = nodes[nodesIndex];
                if (child != newChild) {
                    if (newChild.parentNode == element) {
                        // Delete every node until we reach newChild
                        do {
                            var nextChild = child.nextSibling;
                            element.removeChild(child);
                            child = nextChild;
                        } while (child != newChild);
                        child = child.nextSibling;
                    }
                    else {
                        // Insert newChild
                        this.insertBefore(element, child, newChild);
                    }
                } else {
                    child = child.nextSibling;
                }
                nodesIndex++;
            }
            // remove everything else
            while (child !== null) {
                var next = child.nextSibling;
                element.removeChild(child);
                child = next;
            }
        },

        // Does a replaceChildNodes, but does not remove any nodes, instead an object
        // containing removes and additions is returned. Used for animating smooth transitions.
        replaceChildNodesNoDelete: function(element, nodes) {
            var result = { removes: [], additions: [] };
            var nodesIndex = 0;
            var child = element.firstChild;
            while (nodesIndex < nodes.length) {
                var newChild = nodes[nodesIndex];
                if (child != newChild) {
                    if (newChild.parentNode == element) {
                        // Delete every node until we reach newChild
                        do {
                            result.removes.push(child);
                            child = child.nextSibling;
                        } while (child != newChild);
                        child = child.nextSibling;
                    }
                    else {
                        // Insert newChild
                        this.insertBefore(element, child, newChild);
                        result.additions.push(newChild);
                    }
                } else {
                    child = child.nextSibling;
                }
                nodesIndex++;
            }
            // remove everything else
            while (child !== null) {
                result.removes.push(child);
                child = child.nextSibling;
            }
            return result;
        },

        // Wrapper for the Anim class, which uses our settings
        animate: function(el, attributes, onComplete, onCompleteScope) {
            var result = new Anim(el, attributes, Settings.animationSeconds, ANIMATION_EASING);
            if (onComplete) {
                result.onComplete.subscribe(onComplete, el, onCompleteScope);
            }
            result.animate();
            return result;
        },

        // Same effect as replaceChildNodes, but uses animation. Make sure the animated
        // elements and their parents have position:relative and overflow:hidden.
        // Returns an array of Anim objects representing the animations that have started.
        animateReplaceChildNodes: function(element, nodes) {
            var result = [];
            var diff = this.replaceChildNodesNoDelete(element, nodes);
            var i, el;
            // Removes
            var removeOnComplete =
                function(event, animation, element) {
                    element.parentNode.removeChild(element);
                };
            for (i = 0; i < diff.removes.length; i++) {
                el = diff.removes[i];
                el.style.borderBottomWidth = '0px';
                el.style.borderTopWidth = '0px';
                result.push(this.animate(el, { height: { to: 0 }, opacity: { to: 0} }, removeOnComplete));
            }
            // Additions
            var fullHeightOnComplete =
                function(event, animation, element) {
                    element.style.height = '100%';
                };
            for (i = 0; i < diff.additions.length; i++) {
                el = diff.additions[i];
                var height = el.clientHeight; // 0 padding and 0 margin (top+bottom) is assumed
                el.style.height = '0px';
                result.push(this.animate(el, { height: { from: 0, to: height} }, fullHeightOnComplete));
            }
            // Uncomment for in-animation debugging
            //if (diff.additions.length>0) { result[result.length-1].onTween.subscribe( function(event, args) { if (args[0].currentFrame>=20) debugger; }) }
            return result;
        },
        
        isVisible: function(element) {
            if (!Dom.inDocument(element)) { return false; }
            while (element && element!=document.body) {
                if (Dom.getStyle(element, 'display') == 'none' || Dom.getStyle(element, 'visibility') == 'hidden') {
                    return false;
                }
                element = element.parentNode;
            }
            return true;
        },
        
        // Utilities for the MVC objects

        hasPresentationStyle: function(model, presentationStyle) {
        	if (!presentationStyle) { throw new Error('null presentationStyle'); }
        	return model.presentationStyles && Util.indexOf(model.presentationStyles, presentationStyle)>=0;
        },
        
        // Deprecated, use hasPresentationStyle instead
        hasFormat: function(model, format) {
            if (!format) { throw new Error('null format'); }
            format = format.replace('(', '\\(').replace(')', '\\)'); // There may be ( and ) in the format
            return (model.format) && (model.format.match('\\b' + format + '(\\s|,|$)'));
        },

        findAncestorController: function(parent, filterFunction) {
            if (!parent) { return null; }
            if (filterFunction(parent) === true) {
                return parent;
            }
            return this.findAncestorController(parent.parent, filterFunction);
        },

        mergeFactories: function(factory1, factory2) {
            return {
                createController: function(model, childIndexPath) {
                    return ((factory1.createController && factory1.createController(model, childIndexPath)) ||
                        factory2.createController(model, childIndexPath));
                },
                createInput: function(model, childIndexPath) {
                    return ((factory1.createInput && factory1.createInput(model, childIndexPath)) ||
                        factory2.createInput(model, childIndexPath));
                }
            };
        },

        // Are there differences in the message arrays?
        messagesUpdated: function(oldMessages, newMessages) {
            if (!oldMessages && !newMessages) { return false; }
            if (!oldMessages || !newMessages) { return true; }
            if (oldMessages.length != newMessages.length) { return true; }
            for (var i = 0; i < oldMessages.length; i++) {
                if (oldMessages[i].type != newMessages[i].type) { return true; }
                if (oldMessages[i].display != newMessages[i].display) { return true; }
            }
            return false;
        },
        
        // Adds a class and package attribute to all classes inside a package.
        // This will make the toString work, which will make debugging much easier.
        // Usage: addClassNames(aquima.mvc, 'aquima.mvc')
        // You can call this method multiple times if needed
        addClassNames: function(packageObject, packageName) {
            for (var className in packageObject) {
				if (packageObject.hasOwnProperty(className)) {
					var obj = packageObject[className];
					if (obj.prototype) {
						obj.prototype['class'] = className;
						obj.prototype['package'] = packageName;
					} else if (obj.createInput || obj.createController || obj.postProcessControllerConfig) {
						obj['class'] = className;
						obj['package'] = packageName;
					}
				}
            }
        }
    };

    // Element factories
    var span = Util.createElementFactory('span');
    var label = Util.createElementFactory('label');
    var div = Util.createElementFactory('div');

    // Controller
    // Responsible for translating the model into viewNodes
    var Controller = aquima.mvc.Controller = function(config) {
        this.config = config || {}; // Object/hashmap containing configuration parameters
        YAHOO.lang.augmentObject(this.config, Settings.defaultControllerConfig);
        this.viewNodes = null; // The html node-array that represents the view to the user
        this.parent = null;    // The parent controller
        this.model = null;     // The last (JSON) model retrieved from the server
        this.engine = null;    // The Aquima Engine
        this.childIndex = null; // The index of the child in its parent's children array, at the time the child was created
    };

    Controller.prototype = {

        // After execution of this method 
        // this.viewNodes must be filled with an array of the viewNodes for this controller
        // this.model must be set to the model parameters
        init: function(model) {
        },

        // This method should (efficiently) check for updates in the model and apply changes to
        // this.viewNodes accordingly. 
        // return whether the this.viewNodes array itself has changes, return false otherwise
        update: function(newModel) {
            return false;
        },

        // Called before the controller is removed
        destroy: function() {
        },

        // Let all inputs append an {id:'', value:''} object to the values array if its value has changed
        submit: function(values) {
        },

        createOuterAnimDiv: function() {
            if (this.config.createOuterAnimDiv) {
                this.viewNodes = [ div({className:'anim'}, this.viewNodes) ];
            }
        },

        // For debugging purposes
        toString: function() {
            var result = ''+this['package']+'.'+this['class'];
            if (this.model && this.model.name) { 
                result += '(' + this.model.name + ')'; 
            } else if (this.model && this.model.id) {
                result += '(' + this.model.id + ')'; 
            }
            return result;
        }
    };

    // StaticTextController
    // Creates a span with config.attributes as attributes and config.text as inner text
    // Used for displaying error messages
    var StaticTextController = aquima.mvc.StaticTextController =
        Util.extend(Controller, {
            init: function(model) {
                this.viewNodes = [div(span(this.config.attributes, '' + this.config.text))];
                this.model = model;
                this.createOuterAnimDiv();
            }
        });

    // EmptyController
    // Renders no viewnodes at all, effectively hiding the model from the user.
    var EmptyController = aquima.mvc.EmptyController =
        Util.extend(Controller, {
            init: function(model) {
                this.viewNodes = [];
                this.model = model;
            }
        });

    // ContentController
    // Controller which has other controllers as children.
    // Subclasses MUST implement the createViewNodes method
    var ContentController = aquima.mvc.ContentController = function(config) {
        ContentController.superclass.constructor.call(this, config);
        this.childrenNode = null;
        this.children = [];
    };
    YAHOO.lang.extend(ContentController, Controller, {

        init: function(model) {
            this.model = model;
            this.initChildren();
            this.createViewNodes();
            if (this.childrenNode) {
                this.replaceChildrenViewNodes();
            }
            this.createOuterAnimDiv();
        },

        // Create and initialize children controllers
        initChildren: function() {
        	var content = this.model.content || [];
            for (var i = 0; i < content.length; i++) {
                var childModel = content[i];
                if (!childModel.id) {throw new Error("submodel without id with type "+childModel.type);}
                var child = this.createChild(childModel, [i], this);
                child.parent = this;
                this.children.push(child);
                child.init(childModel);
            }
        },

        // Subclasses must override this method to add nodes to this.viewNodes.
        // They can also set this.childrenNode, this makes the default implementation for
        // replaceChildrenViewNodes work.
        createViewNodes: function() {
            throw new Error('Subclasses should implement createViewNodes');
        },

        update: function(newModel) {
            // process updates on this model node
            var result = this.updateModelLocal(newModel);
            // Update our model
            var oldChildModels = this.model.content || [];
            this.model = newModel;
            // Update child controllers
            if (this.updateChildren(oldChildModels, newModel.content || [])) {
                result = this.replaceChildrenViewNodes() || result;
            }
            return result;
        },
        
        postProcessChildConfig: function(model, childIndexPath, controller) {
            if (this.parent) {// Top(root)->Down(leaf)
                childIndexPath.unshift(this.childIndex);
                this.parent.postProcessChildConfig(model, childIndexPath, controller);
            }
            childIndexPath.shift();
            if (this.config.factory && this.config.factory.postProcessControllerConfig) {
                this.config.factory.postProcessControllerConfig(model, childIndexPath, controller);
            }
        },

        // Subclasses can change the way childcontrollers are created.
        // Default behavior is that first our config.factory can try 
        // and then parent.createChild is called.
        createChild: function(model, childIndexPath, parent) {
            if (this.config.factory && this.config.factory.createController) {
                var result = this.config.factory.createController(model, childIndexPath);
                if (result) {
                    parent.postProcessChildConfig(model, [childIndexPath[childIndexPath.length-1]], result);
                    result.engine = this.engine;
                    result.parent = parent;
                    result.childIndex = childIndexPath[childIndexPath.length - 1];
                    return result;
                }
            }
            if (!this.parent) {
                throw new Error('Could not create controller');
            }
            // Have our parent create the controller, using its factory.
            childIndexPath.unshift(this.childIndex);
            return this.parent.createChild(model, childIndexPath, parent);
        },

        // This method can be used to create an input for child FieldControllers
        // Default behavior is that first our config.factory can try 
        // and then parent.createInput is called.
        createInput: function(model, childIndexPath, fieldController) {
            if (this.config.factory && this.config.factory.createInput) {
                var result = this.config.factory.createInput(model, childIndexPath);
                if (result) {
                    result.engine = this.engine;
                    result.fieldController = fieldController;
                    return result;
                }
            }
            if (!this.parent) {
                throw new Error('Could not create input');
            }
            childIndexPath.unshift(this.childIndex);
            return this.parent.createInput(model, childIndexPath, fieldController);
        },

        // Collects the viewNodes from all children
        getChildrenViewNodes: function() {
            var result = [];
            for (var i = 0; i < this.children.length; i++) {
                for (var ii = 0; ii < this.children[i].viewNodes.length; ii++) {
                    result.push(this.children[i].viewNodes[ii]);
                }
            }
            return result;
        },

        // The default implementation puts the viewNodes from all the children under this.childrenNode
        // animating them if config.animate is set to true
        replaceChildrenViewNodes: function() {
            if (!this.childrenNode) { throw new Error('ChildrenNode not set'); }
            var childViewNodes = this.getChildrenViewNodes();
            this.replaceChildNodes(this.childrenNode, childViewNodes);
            return false;
        },

        replaceChildNodes: function(node, children) {
            if (this.config.animate === true && Dom.getXY(node)) {
                this.animateReplaceChildNodes(node, children);
            } else {
                Util.replaceChildNodes(node, children);
            }
        },

        animateReplaceChildNodes: function(childrenNode, childViewNodes) {
            // Stop old animations (removes old viewNodes from the DOM as well)
            if (this.animations) {
                for (var i = 0; i < this.animations.length; i++) {
                    if (this.animations[i].isAnimated) {
                        this.animations[i].stop(true);
                    }
                }
            }
            this.animations = Util.animateReplaceChildNodes(childrenNode, childViewNodes);
        },

        // Subclasses should use this method to efficiently scan for changes between 
        // this.model and newModel and apply these changes to this.viewNodes. This should
        // only be done for local changes, not for changes to child controllers.
        // Must return true if the this.viewNodes array has changed.
        updateModelLocal: function(newModel) {
            return false;
        },

        // Determine which childControllers were removed and added, updates all others.    
        updateChildren: function(oldModels, newModels) {
            if (oldModels.length != this.children.length) { throw new Error('model/children mismatch'); }
            var result = false;
            var oldIndex = 0;
            var newIndex = 0;
            var i;
            while (newIndex < newModels.length) {
                var oldModel = (oldIndex < oldModels.length) ? oldModels[oldIndex] : {};
                var newModel = newModels[newIndex];
                if (!newModel.id) {throw new Error("submodel without id with type "+newModel.type);}
                if (oldModel.id != newModel.id) {
                    result = true;
                    var findOldIndex = indexOfModelWithId(oldModels, newModel.id, oldIndex + 1);
                    if (findOldIndex >= 0) {
                        // remove child controllers
                        for (i = newIndex; i < newIndex + findOldIndex - oldIndex; i++) {
                            this.children[i].destroy();
                        }
                        this.children.splice(newIndex, findOldIndex - oldIndex);
                        oldIndex = findOldIndex + 1;
                        var childResult = this.children[newIndex].update(newModel);
                        if (childResult !== true && childResult !== false) { 
                            throw new Error('invalid return value from ' + this.children[newIndex] + '.update()'); 
                        }
                    } else {
                        // New child controller
                        var child = this.createChild(newModel, [newIndex], this);
                        child.parent = this;
                        this.children.splice(newIndex, 0, child);
                        child.init(newModel);
                    }
                } else {
                    var childResult = this.children[newIndex].update(newModel);
                    if (childResult !== true && childResult !== false) { throw new Error('invalid return value from ' + this.children[newIndex] + '.update()'); }
                    result = result || childResult;
                    oldIndex++;
                }
                newIndex++;
            }
            if (this.children.length > newIndex) {
                // Remove child controllers
                result = true;
                for (i = newIndex; i < this.children.length; i++) {
                    this.children[i].destroy();
                }
                this.children.length = newIndex;
            }
            return result;
        },

        // Delegates to all children
        destroy: function() {
            for (var i = 0; i < this.children.length; i++) {
                this.children[i].destroy();
            }
        },

        // Delegates to all children
        submit: function(values) {
            for (var i = 0; i < this.children.length; i++) {
                this.children[i].submit(values);
            }
        }
    });
    
    // GroupController
    // Simpelest ContentController which does not render any HTML Elements of its own,
    // it just uses the HTML Elements from its children
    // This class is not suitable as a baseclass.
    var GroupController = aquima.mvc.GroupController =
        Util.extend(ContentController, {
            createViewNodes: function() {
                this.viewNodes = this.getChildrenViewNodes();
            },
            replaceChildrenViewNodes: function() {
                this.viewNodes = this.getChildrenViewNodes();
                return true;
            },

            createOuterAnimDiv: function() {}
        });

    // FieldController
    // This controller baseclass is used for inputs. 
    // It renders the questiontext, explaintext, errormessages. The rendering of the input
    // itself is delegated to a Input.
    // Subclasses must implement createViewNodes and updateMessages.
    var FieldController = aquima.mvc.FieldController =
        Util.extend(aquima.mvc.Controller, {

            init: function(model) {
                this.model = model;
                this.input = this.createInput(model, [], this);
                this.input.fieldController = this;
                this.input.init(this.model);
                this.labelElement = this.createLabelElement();
                this.createViewNodes();
                this.createOuterAnimDiv();
                if (this.model.messages && this.model.messages.length !== 0) {
                    this.updateMessages(this.model.messages || []);
                }
            },

            // Subclasses should use this method to add nodes to this.viewNodes.
            // They can use this.input.viewNode and this.labelElement
            createViewNodes: function() {
                throw new Error('Subclasses should implement createViewNodes');
            },

            // Subclasses should implement this method and replace the error/warning messages
            // with the supplied messages. This method is called automatically from the init
            // method if there are messages.
            // messages is an array of {type:'error/warning', display:'text'} objects
            updateMessages: function(messages) {
                throw new Error('Subclasses should implement updateMessages');
            },

            // Subclasses should implement this method to update the required flag
            updateRequired: function(required) {
                throw new Error('Subclasses should implement updateRequired');
            },
            
            updateQuestion: function(question) {
                this.questionTextNode.nodeValue = question;
            },

            // Subclasses should implement this method to update the explain text
            updateExplain: function(explain) {
                throw new Error('Subclasses should implement updateExplain');
            },

            // Subclasses can implement this method to update the readonly status
            updateReadonly: function(readonly) {
            },

            // Delegates to different other methods
            update: function(newModel) {
                var result = false;
                if (this.model.question != newModel.question) {
                    this.updateQuestion(newModel.question);
                }
                if (Util.messagesUpdated(this.model.messages, newModel.messages)) {
                    result = this.updateMessages(newModel.messages || []) || result;
                }
                if (this.model.explain != newModel.explain) {
                    this.updateExplain(newModel.explain);
                }
                if (this.model.required != newModel.required) {
                    this.updateRequired(newModel.required);
                }
                if (this.model.readonly != newModel.readonly) {
                    this.updateReadonly(newModel.readonly);
                }
                this.model = newModel;
                var oldViewNode = this.input.viewNode;
                this.input.update(newModel);
                if (this.input.viewNode != oldViewNode) {
                    oldViewNode.parentNode.replaceChild(this.input.viewNode, oldViewNode);
                    return true; // This may cause a false positive, but this is not a problem
                }
                return result;
            },

            // We 'copy' this method from ContentController
            createInput: ContentController.prototype.createInput,

            // Creates the label html node
            createLabelElement: function() {
                var text = this.model.question ? this.model.question : '[' + this.model.name + ']';

                return label({ htmlFor: this.model.id },
                            span(
this.questionTextNode =         document.createTextNode(text)
                            )
                       );
            },

            // Delegates to the input
            destroy: function() {
                this.input.destroy();
            },

            // Delegates to the input
            submit: function(values) {
                this.input.submit(values);
            },

            // Called by the input when the user changed the value
            valueChanged: function(event) {
            }
        });

    // A FieldController which displays only the input, no question text and no errormessages
    var BareFieldController = aquima.mvc.BareFieldController =
        Util.extend(aquima.mvc.FieldController, {
            createViewNodes: function() {
            	this.viewNodes = [div({className: 'aq-answer-holder'}, this.input.viewNode)];
            },
            update: function(newModel) {
                var result = BareFieldController.superclass.update.call(this, newModel);
                if (result) {
                    this.viewNodes = [this.input.viewNode];
                }
                return result;
            },
            updateMessages: function(messages) {
            },
            updateRequired: function(newRequired) {
            },
            updateExplain: function(newExplain) {
            }
        });

    // Input
    // Responsible for displaying a control to the user, which displays a value that the user
    // can change. Inputs are contained within a FieldController.
    // Subclasses should implement the methods:
    // createViewNode, updateValue, updateReadonly, getValue
    // Subclasses should also call valueChanged whenever the user has changed the value.
    var Input = aquima.mvc.Input = function(config) {
        this.config = config || {};
        YAHOO.lang.augmentObject(this.config, Settings.defaultInputConfig);
        this.viewNode = null;
        this.model = null;
        this.engine = null;
        this.fieldController = null;
    };

    Input.prototype = {

        // Stores the model and delegates to this.createViewNode
        init: function(model) {
            this.model = model;
            this.createViewNode();
        },
        
        sameValue: function(a, b) {
            if (YAHOO.lang.isArray(a) && YAHOO.lang.isArray(b)) {
                return Util.arrayEquals(a, b);
            }
            if (YAHOO.lang.isArray(a) && !YAHOO.lang.isArray(b)) {
            	return a.length==0;
            }
            if (!YAHOO.lang.isArray(a) && YAHOO.lang.isArray(b)) {
            	return b.length==0;
            }
            return a == b;
        },

        // The update function updates this.viewNode to reflect the new model.
        update: function(newModel) {
            if (!YAHOO.lang.isUndefined(newModel.value)) {
                var oldValue = YAHOO.lang.isUndefined(this.submittedValue) ? this.model.value : this.submittedValue;
                if (!this.sameValue(oldValue, newModel.value)) {
                    this.updateValue(newModel.value, newModel.display);
                }
            }
            delete this.submittedValue;
            if (this.model.readonly != newModel.readonly) {
                this.updateReadonly(newModel.readonly);
            }
            this.model = newModel;
        },

        // Subclasses MUST call this method when the user changes the value
        valueChanged: function(event) {
            var value = this.getValue();
            if ((typeof value === 'string') && !this.model.domain && (value == this.model.display)) { return; }
            if (this.sameValue(this.model.value, value)) { return; }
            this.engine.inputChanged.fire(this); // Co-browsing, rec/play
            this.fieldController.valueChanged(event);
            if (this.model.refresh || this.model.messages) {
                this.engine.refresh(event, this);
            }
        },

        // Submits the value, if it has changed
        submit: function(values) {
            if (this.model.readonly === true) { return; }
            var value = this.getValue();
            if (!Settings.engine.submitUnchangedValues) {
	            if (value == this.model.value) { return; }
	            if (YAHOO.lang.isArray(value) && Util.arrayEquals(value, this.model.value)) {return;}
	            if ((typeof value === 'string') && !this.model.domain && (value === this.model.display)) { return; }
            }
            this.submittedValue = value;
            value = (value===''?'':value); //http://blogs.msdn.com/b/jscript/archive/2009/06/23/serializing-the-value-of-empty-dom-elements-using-native-json-in-ie8.aspx
            values.push({ id: this.model.id, value: value, display: this.formatText(value, null) });
        },

        // Use this function to present the text in a readable format to the user
        formatText: function(value, display) {
            if (value === null || value === undefined) { return display || ''; }
            if (this.config.formatter) {
                return this.config.formatter.format(value, this);
            }
            if (display === null || display === undefined) {
                return '' + value;
            }
            return display;
        },
        
        parseText: function(text) {
            if (text === null || text === undefined || text === '') { return null; }
            if (this.config.formatter) {
                return this.config.formatter.parse(text, this);
            }
            return text;
        },

        // Should be used to perform a cleanup
        destroy: function() {
            if (this.viewNode && YAHOO.env.ua.ie && YAHOO.env.ua.ie<7) {
                Event.purgeElement(this.viewNode, true);
            }
        },

        // Subclasses must implement this method.
        // Use this method to create the viewNode and store it under this.viewNode
        createViewNode: function() {
            throw new Error('Subclasses should implement Input.createViewNode');
        },

        // Subclasses must implement this method.
        // This method gets called when the server updates the value
        updateValue: function(newValue, newDisplay) {
            throw new Error('Subclasses should implement Input.updateValue');
        },

        // Subclasses should implement this method.
        // This method is called when the server updates readonly
        updateReadonly: function(newReadonly) {
            throw new Error('This input cannot handle updates to readonly');
        },

        // Subclasses must implement this method.
        // This method should return the current value. When the user has not changed the
        // value, this method should return exactly the same value as provided in the model.
        getValue: function() {
            throw new Error('Subclasses should implement Input.getValue');
        },

        // Nicer debugging
        toString: function() {
            var result = ''+this['package']+'.'+this['class'];
            return result;
        }
    };
    
    // Formatters are used by inputs to translate json to text and vice versa
    var Formatter = aquima.mvc.Formatter = function(config) {
        this.config = config || {};
    };
    
    Formatter.prototype = {
        format: function(data, input) { // Json -> Text
            return ''+data;
        },
        parse: function(text, input) { // Text -> Json
            return text;
        },
        toString: function() {
            var result = ''+this['package']+'.'+this['class'];
            return result;
        }
    };

    // Creates a span with config.attributes as attributes and config.text as inner text
    // Used for displaying error messages
    var StaticTextInput = aquima.mvc.StaticTextInput =
        Util.extend(Input, {
            createViewNode: function() {
                this.viewNode = span(this.config.attributes, '' + this.config.text);
            },
            updateValue: function() { },
            updateReadonly: function() { },
            getValue: function() {
                return this.model.value;
            }
        });

    // States of the Engine
    var State = aquima.mvc.EngineState = { STARTING: 'Starting', IDLE: 'Idle', REFRESHING: 'Refreshing', SUBMITTING: 'Submitting', TERMINATING: 'Terminating', ERROR: 'Error' };

    // Constructs and configures an Aquima MVC Engine
    // The engine can be started by calling 'start' on it.
    // Parameters:
    // - div: The div in which the engine is displayed on the page. The initial contents of this div 
    //      is removed when the first page is loaded. (You can put a spinner in here)
    // - rootFactory: The factory that is used to create controllers and inputs based on the page model.
    // - config: Extra optional parameters, which will be stored as this.config
    //    - warnBeforeUnload: Set to false to disable the feature that a warning is raised if the user leaves the page and 'hasChanges' is set to true.
    aquima.Engine = function(div, rootFactory, config) {
        this.config = config || {};
        this.aquimaDiv = Dom.get(div);
        if (!this.aquimaDiv) { throw new Error('Could not find div ' + div); }
        if (!rootFactory) { throw new Error('RootFactory was not specified'); }
        this.rootFactory = rootFactory;
        this.rootController = null;
        this.aquimaSessionId = null;
        this.hasChanges = false;
        this.language = null;
    	this.dateFormat = null;
    	this.dateTimeFormat = null;
    	this.booleanFormat = null;
    	this.currencyFormat = null;
    	this.integerFormat = null;
    	this.numberFormat = null;
    	this.percentageFormat = null;
        this.commaDecimalSeparator = null;
        this.state = {
            state: State.STARTING,
            refreshing: false,
            refreshQueued: null,
            submitQueued: null,
            scrollToTopAfterSubmit: false
        };
        this.initEvents();
    };

    aquima.Engine.prototype = {

        // Called during construction    
        initEvents: function() {
            // An input has changed its value (the input is supplied as the argument)
            this.inputChanged = new YAHOO.util.CustomEvent('inputChanged', this);
            // Data is ready to be submitted to the server (data is passed as the argument)
            this.beforeSubmit = new YAHOO.util.CustomEvent('beforeSubmit', this);
            // The view has been updated
            this.viewUpdated = new YAHOO.util.CustomEvent('viewUpdated', this);
            // The engine will terminate
            this.terminating = new YAHOO.util.CustomEvent('terminating', this);
            // The user clicks a button
            this.buttonClicked = new YAHOO.util.CustomEvent('buttonClicked', this);
            // The engine state has changed (idle/refreshing/submitting/etc)
            this.stateChanged = new YAHOO.util.CustomEvent('stateChanged', this);
            this.aquimaCallback = { // Used for processing page-models from the server
                success: this.processNewPage,
                failure: this.serverError,
                scope: this
            };
        },

        // Start the engine
        startFlow: function(application, version, startFlow, extraQueryString) {
            var querystring = this.determineQueryString();
            if (extraQueryString) {
                if (querystring) { querystring += '&'; }
                querystring += extraQueryString;
            }
            this.prepare();
            this.applicationdata = { application: application, version: version, startFlow: startFlow, queryString: querystring };
            this.beforeSubmit.fire(this.applicationdata);
            var postData = JSON.stringify(this.applicationdata);
            postData = 'start=' + encodeURIComponent(postData);
            YUC.asyncRequest(Settings.engine.aquimaUrlMethod, Settings.baseUrl + Settings.engine.aquimaUrl, this.aquimaCallback, postData);
            this.inputChanged.subscribe(this.onInputChanged, null, this);
            var me = this;
            if (this.config.warnBeforeUnload !== false) {
                window.onbeforeunload = function() { return me.onWindowBeforeUnload.call(me); };
            }
            // Terminate the session that we started if the user navigates away
            Event.on(window, 'unload', this.terminateSession, null, this);
        },
        
        continueFlow: function(aquimaSessionId) {
        	this.prepare();
        	this.aquimaSessionId = aquimaSessionId;
        	YUC.initHeader('X-Aquima-Session', this.aquimaSessionId, true);
        	var data = {};
            this.beforeSubmit.fire(data);
            var postData = JSON.stringify(data);
            postData = 'event=' + encodeURIComponent(postData);
            YUC.asyncRequest(Settings.engine.aquimaUrlMethod, Settings.baseUrl + Settings.engine.aquimaUrl, this.aquimaCallback, postData);
        },
        
        // Processes the responses from the server (refreshes and submits)
        processNewPage: function(o) {
            var newModel;
            try {
                newModel = JSON.parse(o.responseText);
                Log.info('New page received', newModel.page);
            } catch (e) {
                this.serverError(o, e);
                return;
            }
            if (!this.rootController) {
            	if (!this.aquimaSessionId) {
	                this.aquimaSessionId = o.getResponseHeader['X-Aquima-Session'];
	                if (this.aquimaSessionId) {
	                    YUC.initHeader('X-Aquima-Session', this.aquimaSessionId, true);
	                }
	            }
            }
            this.processNewPageData(newModel.page);
        }, 
        
        processNewPageData: function(page) {
            var oldPageId;
            if (!this.rootController) {
                // Process the initial page
                this.language = page.language;
            	this.dateFormat = page.params.dateformat;
            	this.dateTimeFormat = page.params.datetimeformat;
            	this.booleanFormat = page.params.booleanformat;
            	this.currencyFormat = page.params.currencyformat;
            	this.integerFormat = page.params.integerformat;
            	this.numberFormat = page.params.numberformat;
            	this.percentageFormat = page.params.percentageformat;
                this.commaDecimalSeparator = Util.isCommaDecimalSeparator(this.language);
                this.createRootController(page);
                this.rootController.init(page);
            } else {
                // Process Refresh/submit
                oldPageId = this.rootController.model.id;
                this.rootController.update(page);
            }
            Util.replaceChildNodes(this.aquimaDiv, this.rootController.viewNodes);
            this.viewUpdated.fire();
            if (this.state.state == State.STARTING) {
                this.checkFocus();
                this.setState(State.IDLE);
            } else if (this.state.state == State.REFRESHING) {
                // A refresh occurred
                if (this.state.refreshQueued) {
                    this.post({ refresh: this.state.refreshQueued });
                    this.state.refreshQueued = null;
                } else if (this.state.submitQueued) {
                    this.setState(State.SUBMITTING);
                    this.post({ submit: this.state.submitQueued.id, flow: this.state.submitQueued.flow });
                    this.state.submitQueued = null;
                } else {
                    this.setState(State.IDLE);
                }
            } else if (this.state.state == State.SUBMITTING) {
                // A submit occurred
                this.state.submitQueued = null;
                this.state.refreshQueued = null;
                this.setState(State.IDLE);
                if (this.state.scrollToTopAfterSubmit) {
                    this.scrollToTop(oldPageId==this.rootController.model.id);
                    this.checkFocus();
                    this.state.scrollToTopAfterSubmit = false;
                }
            }
            if (aquima.mvc.Settings.engine.singlePage) {
                this.terminateSession();
            }
        },
        
        terminateSession: function() {
            this.terminating.fire();
            if (this.interval) {
                clearInterval(this.interval);
                this.interval = null;
            }
            if (this.state.state!=State.STARTING && this.state.state!=State.ERROR) {
                var postData = '{}';
                postData = 'terminate=' + encodeURIComponent(postData);
                if (YAHOO.env.ua.webkit) {
                    // Webkit browsers need the httprequest to be synchronous, otherwise it won't be sent
                    var xhr = new XMLHttpRequest();
                    xhr.open(Settings.engine.aquimaUrlMethod, Settings.baseUrl + Settings.engine.aquimaUrl, false);
                    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
                    if (this.aquimaSessionId) {
                        xhr.setRequestHeader('X-Aquima-Session', this.aquimaSessionId);
                    }
                    xhr.send(postData);
                } else {
                    YUC.asyncRequest(Settings.engine.aquimaUrlMethod, Settings.baseUrl + Settings.engine.aquimaUrl, {}, postData);
                }
            }
            this.setState(State.TERMINATING);
            this.destroy();
        },
        
        // Called during startFlow and continueFlow
        prepare: function() {
            aquima.mvc.engineStarting.fire(this);
            aquima.mvc.runningEngines.push(this);
            this.makeDocumentModifications();
            // Listen to enter keystrokes
            Event.on(this.aquimaDiv, 'keydown', this.onKeydown, null, this);
            this.startInterval();
        },
        
        // Called during startFlow and continueFlow, creates some neccessary modifications to the main document.
        makeDocumentModifications: function() {
            // Div which can contain tooltips, should have the higher z-index
            this.tooltipDiv = document.getElementById('aquima-engine-tooltips');
            if (!this.tooltipDiv) {
                this.tooltipDiv = div({ id: 'aquima-engine-tooltips', className: 'AquimaMVC' });
                document.body.appendChild(this.tooltipDiv);
            }
            // Div which can contain tooltips, should have the high z-index, below tooltips
            this.popupsDiv = document.getElementById('aquima-engine-popups');
            if (!this.popupsDiv) {
                this.popupsDiv = div({ id: 'aquima-engine-popups', className: 'AquimaMVC' });
                document.body.appendChild(this.popupsDiv);
            }
            // Inside iframes we need an alternative to window.scroll()
            if (window != top) {
                var topAnchor = Util.createElementFactory('a')({ name: 'toTop' });
                topAnchor.style.position = 'absolute';
                topAnchor.style.top = '0px';
                topAnchor.style.left = '0px';
                document.body.appendChild(topAnchor);
            }
        },

        determineQueryString: function() {
            var querystring = (document.location.search).substring(1);
            if (querystring === null || querystring === undefined) {
                querystring = '';
            }
            return querystring;
        },

        searchHighestEnterPriorityButton: function(controller, search) {
            if (controller.onClick && controller.getEnterPriority && controller.viewNodes.length>0) {
                var priority = controller.getEnterPriority();
                if (priority >= search.enterPriority && !controller.model.readonly && Util.isVisible(controller.viewNodes[0])) {
                    Log.debug('Enter candidate', controller);
                    if (priority == search.enterPriority) {
                        search.controller = null;
                    } else if (priority>search.enterPriority) {
                        search.enterPriority = priority;
                        search.controller = controller;
                    }
                }
            }
            if (controller.children) {
                for (var i = 0;i<controller.children.length; i++) {
                    this.searchHighestEnterPriorityButton(controller.children[i], search);
                }
            }
        },
        
        onKeydown: function(e) {
            var charCode = Event.getCharCode(e);
            var target = Event.getTarget(e);
            var enter = charCode == 13;
            var spacebar = charCode == 32;
            if ((enter || spacebar) && target && target.tagName.toLowerCase() == 'a') {
                // Click the button(link) that has the focus
                Event.stopEvent(e);
                if (target.onclick) {
                    target.onclick();
                } 
                if (target.click) {
                    target.click();
                } else {
                    var listeners = Event.getListeners(target, 'click');
                    for (var i=0;i<listeners.length;i++) {
                        listeners[i].fn.call(listeners[i].scope, e, listeners[i].obj);
                    }
                }
            } else if (enter && this.rootController && ((!target) || target.tagName.toLowerCase() != 'textarea')) {
                var search = { enterPriority: 0, controller:null };
                this.searchHighestEnterPriorityButton(this.rootController, search);
                Log.debug('Search results for a button which may handle enter yielded', search);
                if (search.controller) {
                    target.blur();
                    search.controller.onClick(e);
                }
                Event.preventDefault(e);
            }
        },

        setState: function(state) {
            this.state.state = state;
            this.stateChanged.fire();
        },

        onWindowBeforeUnload: function() {
            if (this.hasChanges === true) {
                return Settings.texts.warnUnload;
            }
        },

        // After this method is called, there will be no warning-dialog if the user tries to leave the application.
        resetHasChanges: function() {
            this.hasChanges = false;
        },

        onInputChanged: function() {
            this.hasChanges = true;
        },

        // Set a 1-minute timer
        startInterval: function() {
            var thisEngine = this;
            this.keepAliveMinutesAgo = 0;
            this.interval = setInterval(function() { thisEngine.onceEveryMinute(); }, MINUTE_IN_MS);
        },

        destroy: function() {
            if (this.rootController) {
                this.rootController.destroy();
            }
            for (var i=0;i<aquima.mvc.runningEngines.length;i++) {
                if (aquima.mvc.runningEngines[i]==this) {
                    aquima.mvc.runningEngines.splice(i,1);
                    return;
                }
            }
        },

        serverError: function(o, exception) {
            aquima.mvc.Log.warn("Server error", exception);
            this.setState(State.ERROR);
            if (this.interval) {
                clearInterval(this.interval);
                this.interval = null;
            }
            if (!this.rootController || !this.rootController.serverError || !this.rootController.viewNodes) {
                this.showServerError(o);
            } else {
                this.rootController.serverError(o);
            }
            this.scrollToTop(true);
        },

        // Can be overridden
        showServerError: function(o, exception) {
            Util.setText(this.aquimaDiv, Settings.texts.serverError);
        },

        focusable: { button: true, select: true, textarea: true, input: true },

        isFocusable: function(element) {
            return (element.focus &&
                element.type != 'hidden' &&
                !element.disabled &&
                this.focusable[element.tagName.toLowerCase()]);
        },

        // Tries to focus the element or one of its childnodes
        focusFirst: function(element) {
            if (element.nodeType == 3 || !Dom.getXY(element) || element.readOnly) { return false; }
            if (this.isFocusable(element)) {
                this.focus(element);
                return true;
            }
            var childNodes = element.childNodes;
            for (var i = 0; i < childNodes.length; i++) {
                if (this.focusFirst(childNodes[i])) { return true; }
            }
            return false;
        },

        focus: function(element) {
            try {
                if (element.select) { element.select(); }
                setTimeout(function() { try { element.focus(); if (element.select) { element.select(); } } catch (error) { /* Do nothing */ } }, 0);
                Log.debug('Focussed', element);
            } catch (error) {
                /*
                Do nothing, if field is in a div that has visibility: hidden and in ie6 en ie7 the focus
                is trying to be set on the field ie throws an error  
                */
            }
        },

        // If nothing is focussed, focus the first field
        checkFocus: function() {
            if ((document.activeElement == document.body) || (document.activeElement == document.documentElement)) {
                Log.debug('Setting focus to first field');
                var result = this.focusFirst(this.aquimaDiv);
                if (!result) { // Only focus a link as a last resort
                    var link = Dom.getElementBy(function() { return true; }, 'a', this.aquimaDiv);
                    if (link) {
                        this.focus(link);
                    }
                }
            }
            return false;
        },

        createRootController: function(model) {
            this.rootController = this.rootFactory.createController(model, [0]);
            if (!this.rootController) { throw new Error('Factory could not create root controller'); }
            if (!this.rootController.config.factory) {
                this.rootController.config.factory = this.rootFactory;
            } else {
                this.rootController.config.factory = Util.mergeFactories(this.rootController.config.factory, this.rootFactory);
            }
            this.rootController.engine = this;
        },

        // Simple timer method to prevent session timeouts
        onceEveryMinute: function() {
            this.keepAliveMinutesAgo++;
            if (this.keepAliveMinutesAgo >= Settings.engine.keepAliveMinutes && this.state.state == State.IDLE && !this.sendingKeepAlive) {
                this.sendingKeepAlive = true;
                var data = { sessionId: this.aquimaSessionId };
                this.beforeSubmit.fire(data);
                var postData = JSON.stringify(data);
                postData = 'keepAlive=' + encodeURIComponent(postData);
                YUC.asyncRequest(Settings.engine.aquimaUrlMethod, Settings.baseUrl + Settings.engine.aquimaUrl, {
                    success: this.noopReceived,
                    failure: this.serverError,
                    scope: this
                }, postData);
                this.keepAliveMinutesAgo = 0;
            }
        },

        noopReceived: function() {
            this.sendingKeepAlive = false;
        },

        // Appends the changed values to the data parameter and submits the data to the server
        post: function(data) {
            // Verzamel alle waarden
            data.values = [];
            this.rootController.submit(data.values);
            data.sessionId = this.aquimaSessionId;
            this.beforeSubmit.fire(data);
            var postData = JSON.stringify(data);
            postData = 'event=' + encodeURIComponent(postData);
            YUC.asyncRequest(Settings.engine.aquimaUrlMethod, Settings.baseUrl + Settings.engine.aquimaUrl, this.aquimaCallback, postData);
            this.keepAliveMinutesAgo = 0;
        },

        // Scrolls to the top
        scrollToTop: function(mayUseAnimation) {
            if (window != top) {
                // Inside iframes
                document.location = '#toTop';
            } else {
                if (mayUseAnimation && Settings.defaultControllerConfig.animate) {
                    var element = document.documentElement;
                    if (YAHOO.env.ua.webkit) {
                        element = document.body;
                    }
                    var attributes = {
                        scroll: {to: [0,0]}
                    };
                    new YAHOO.util.Scroll(element, attributes, Settings.animationSeconds, ANIMATION_EASING).animate();
                } else {
                    window.setTimeout(function() {window.scroll(0, 0);});
                }
            }
        },

        // Causes the changed values to be posted to the server, because a
        // user has changed an input for which refresh=true was specified
        refresh: function(event, input) {
            var id = input ? input.model.id : null;
            if (this.state.state == State.REFRESHING) {
                this.state.refreshQueued = id;
            } else if (this.state.state == State.IDLE) {
                this.setState(State.REFRESHING);
                this.post({ refresh: id });
            }
        },

        // Causes the changed values to be posted to the server, because a
        // user has pressed a button
        submit: function(event, controller, scrollToTop) {
            if (event) { Event.preventDefault(event); } // Do not navigate to '#'
            var id = controller.model.id;
            var flow = controller.model.flowName; // Used to switch to another flow
            scrollToTop = (scrollToTop !== false);
            if (this.state.state == State.REFRESHING) {
                this.state.scrollToTopAfterSubmit = scrollToTop;
                this.state.submitQueued = {id:id, flow:flow};
            } else if (this.state.state == State.IDLE) {
                this.state.scrollToTopAfterSubmit = scrollToTop;
                this.setState(State.SUBMITTING);
                this.post({ submit: id, flow: flow });
            } else {
                Log.warn('Could not process submit at this time, ignoring. Enginestate=', this.state.state);
            }
        },
        
        toString: function() {
            var result =  'aquima.Engine';
            if (this.state) {result += '('+this.state.state+')';}
            return result;
        }
    };
    
    // For debugging purposes
    Util.addClassNames(aquima.mvc, 'aquima.mvc');
})();