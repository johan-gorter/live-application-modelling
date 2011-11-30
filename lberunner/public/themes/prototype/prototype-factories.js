// Specifies which controllers and inputs to use.

(function(){
    
    // Aliases
    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;
    var hasFormat = Util.hasFormat;
    
    prototype.mvc.PrototypeFactory = {
    
        createController: function(model, childIndexPath) {
            
        	switch (model.type) {
	            case 'link': 
                    return new prototype.mvc.controller.LinkController({
            			className:Util.concatCssClasses('link', model.presentationStyles),
            			createOuterAnimDiv: true // Links are placed vertically for now
            		});
	        }
	    	return aquima.mvc.generic.genericFactory.createController(model, childIndexPath); 
        },
        
        createInput: function(model, childIndexPath) {
            
            // Add your project specific logic here
        
            return aquima.mvc.generic.genericFactory.createInput(model, childIndexPath); 
        },
        
    	postProcessControllerConfig: function(model, childIndexPath, controller) {

    	    if (Util.hasPresentationStyle(model, 'column')) {
    	        controller.config.createOuterAnimDiv = false;
    	    }
            // Add your project specific logic here
    		
    		aquima.mvc.generic.genericFactory.postProcessControllerConfig(model, childIndexPath, controller);
        }
    };

    // For debugging purposes
    Util.addClassNames(prototype.mvc, 'prototype.mvc');
})();