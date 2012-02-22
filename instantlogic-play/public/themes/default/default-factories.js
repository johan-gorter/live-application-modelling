// Specifies which controllers and inputs to use.

(function(){
    
    // Aliases
    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;
    var hasFormat = Util.hasFormat;
    
    defaultTheme.mvc.defaultThemeFactory = {
    
        createController: function(model, childIndexPath) {
            
        	switch (model.type) {
	            case 'button': 
	                return new defaultTheme.mvc.controller.DefaultButtonController({
	                	className:Util.concatCssClasses('aq-button',model.presentationStyles),
	                	containerClassName: Util.concatCssClasses('aq-button-container',model.presentationStyles),
	        			createOuterAnimDiv: false // Buttons are placed horizontally
	        		});
	            case 'field': 
	                return new defaultTheme.mvc.controller.DefaultDivFieldController({
	                	className:Util.concatCssClasses('aq-field',model.presentationStyles)
	                });
	        }
	    	return aquima.mvc.generic.genericFactory.createController(model, childIndexPath); 
        },
        
        createInput: function(model, childIndexPath) {
            
            // Add your project specific logic here
        
            return aquima.mvc.generic.genericFactory.createInput(model, childIndexPath); 
        },
        
    	postProcessControllerConfig: function(model, childIndexPath, controller) {

            // Add your project specific logic here
    		
    		aquima.mvc.generic.genericFactory.postProcessControllerConfig(model, childIndexPath, controller);
        }
    };

    // For debugging purposes
    Util.addClassNames(defaultTheme.mvc, 'defaultTheme.mvc');
})();