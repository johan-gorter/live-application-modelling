// Factory for the aquima style (used by the dashboard and stuff like that)

(function(){
	
    // Aliases
    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;
    var hasPresentationStyle = Util.hasPresentationStyle;
    
    aquima.mvc.jsonTools.toolsFactory = {
    
        createController: function(model, childIndexPath) {
        	if (model.type == 'aq-grid') {
        		return new aquima.mvc.generic.controller.DivController({className: 'aq-grid', factory: aquima.mvc.generic.genericTableFactory});
        	}
        	if (model.type == 'widget') {
        		return new aquima.mvc.generic.controller.HeaderDivController({className: 'widget'});
        	}
        	if (model.type == 'sessionTools') {
        		return new aquima.mvc.generic.controller.DivController({className: 'sessionTools'});
        	}
        	if (model.type == 'dashboard') {
        		return new aquima.mvc.generic.controller.DivController({className: 'dashboard'});
        	}
        	if (model.type == 'reorderable') {
        		return new aquima.mvc.generic.controller.DivController({className: 'reorderable'});
        	}
        	if (model.type == 'node') {
        		return new aquima.mvc.jsonTools.controller.TreeNodeController({
        			className: Util.concatCssClasses('aq-node', model.presentationStyles),
        			factory: treeNodeFactory
        		});
        	}
        	if( model.type == 'button' && hasPresentationStyle(model, 'aqdev-link') ) {
                return new aquima.mvc.jsonTools.controller.ButtonLinkController();
        	} else if( model.type == 'button' && hasPresentationStyle(model, 'aqdev-closePopup') ) {
                    return new aquima.mvc.generic.controller.ButtonController({
                    	className: Util.concatCssClasses(model.presentationStyles),
                    	display: 'x',
                    	createOuterAnimDiv: false
                    });
        	} else if( model.type == 'tabs' ) {
        		return new aquima.mvc.generic.controller.DivController(
                        {className: 'aq-container aq-tabs'}
                    );
        	}
        	if( model.type == 'iframe' ) {
        		return new aquima.mvc.jsonTools.controller.IFrameController({topPx:155});
        	}
        	if( model.type == 'popup' ) {
        		return new aquima.mvc.jsonTools.controller.PopupController({
        			className: 'aq-popup',
        			modal: hasPresentationStyle(model, 'modal')
        		});
        	}
            return aquimaTheme.mvc.aquimaThemeFactory.createController(model, childIndexPath); 
        },
        
        createInput: function(model, childIndexPath) {
        	if (hasPresentationStyle(model, 'LongList')) {
        		return new aquima.mvc.generic.input.DropdownInput({includeUnknown:false, listSize: 18});
        	}
            return aquimaTheme.mvc.aquimaThemeFactory.createInput(model, childIndexPath); 
        },
        
    	postProcessControllerConfig: function(model, childIndexPath, controller) {
    		if (hasPresentationStyle(model, 'column') || hasPresentationStyle(model, 'leftColumn') || hasPresentationStyle(model, 'rightColumn')) {
    			controller.config.createOuterAnimDiv = false;
    		}
    		aquimaTheme.mvc.aquimaThemeFactory.postProcessControllerConfig(model, childIndexPath, controller);
    	}
    };
    
    var treeNodeFactory = aquima.mvc.jsonTools.treeNodeFactory = {
    	createController: function(model, childIndexPath) {
        	if( model.type == 'button' ) {
        		return new aquima.mvc.generic.controller.ButtonController({
        			className: Util.concatCssClasses('aq-button', model.presentationStyles),
        			createOuterAnimDiv: false
        		});
        	}
    	}
    };

    // This default is better, because everything is a refresh
    Settings.defaultControllerConfig.animate = false;
    
    // For debugging purposes
    Util.addClassNames(aquima.mvc.jsonTools, 'aquima.mvc.jsonTools');	
})();
