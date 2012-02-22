var prototype = {};
prototype.mvc = {};
prototype.mvc.controller = {};

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
    
    // var SpecialController = prototype.mvc.controller.SpecialController =         
    //    Util.extend(aquima.mvc.ContentController, {
    //    });
    
    var LinkController = prototype.mvc.controller.LinkController =
        Util.extend(aquima.mvc.generic.controller.ButtonController, {

            // This method can be overridden by subclasses.
            // This method is responsible for populating this.viewNodes 
            // and setting this.actionElement to the element receiving clicks.
            createViewNodes: function() {
                this.actionElement = this.inputButtonViewNode = 
                	a({
                		href: '#', id: this.model.id, 
                		title: this.model.display,
                		className: this.config.className
                	}, this.config.display || this.model.display);
                if (this.model.readonly) {
                    this.updateReadonly(true);
                }
                this.viewNodes = [this.actionElement];
            },
            
            updateDisplay: function(newDisplay) {
            	Util.setText(this.inputButtonViewNode, this.config.display || newDisplay);
            	this.inputButtonViewNode.title=newDisplay;
            }
        });

    
    
    // For debugging purposes
    Util.addClassNames(prototype.mvc.controller, 'prototype.mvc.controller');
} ());