// This provider provides 'sensible defaults' in case the project-specific providers do not provide
// specific Controllers/Inputs.

(function(){
    
    // Aliases
    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;
    var hasPresentationStyle = Util.hasPresentationStyle;
    var generic = aquima.mvc.generic;
	
    function defaultCssClassName(modelType) {
    	return 'aq-'+modelType;
    }
    
    aquima.mvc.generic.genericFactory = {
    		
        createController: function(model, childIndexPath) {
            switch (model.type) {
                case 'button': 
                    return new generic.controller.ButtonController({
                    			className:Util.concatCssClasses('aq-button',model.presentationStyles),
                    			createOuterAnimDiv: false // Buttons are placed horizontally
                    		});
                case 'field': 
                    return new generic.controller.DivFieldController({className:Util.concatCssClasses('aq-field',model.presentationStyles)});
                case 'failedelement':
                	return new generic.controller.FailedElementController();
                case 'instance_selector':
                    var factory = (hasPresentationStyle(model, 'NoTable') || hasPresentationStyle(model, 'GeenTabel'))?
                        generic.genericInstanceSelectorFactory:
                        generic.genericTableFactory;
            	    return new generic.controller.InstanceSelectorController({
            		    className: Util.concatCssClasses('aq-instance_selector', model.presentationStyles),
            		    factory: factory
            	    });
                case 'breadcrumbcontainer':
                	return new generic.controller.BreadCrumbContainerController({className: Util.concatCssClasses('aq-breadcrumbcontainer', model.presentationStyles)});
                case 'breadcrumb': 
                	return new generic.controller.BreadCrumbController({className: Util.concatCssClasses('aq-breadcrumbcontainer', model.presentationStyles)});
                case 'container':
                case 'sharepoint_filter': 
                case 'instance_linker':
                case 'instance': 
                case 'instanceiterator':
                case 'worklist':
                case 'instance_iterator':
                    if (model.display!=null) {
                        return new generic.controller.HeaderDivController({
                        	className: Util.concatCssClasses(defaultCssClassName(model.type), model.presentationStyles),
                        	headClassName: 'aq-container-caption',
                        	bodyClassName: 'aq-container-content'
                        });
                    }
                    if(model.presentationStyles && model.presentationStyles.length>0) {
                        return new generic.controller.DivController(
                            {className: Util.concatCssClasses(defaultCssClassName(model.type), model.presentationStyles)}
                        );
                    }
                    return new aquima.mvc.GroupController(); // Containers without a presentationStyle or displaytext return no html elements themselves
                case 'text':
                case 'AQ_Infobanner':
                	if (model.content) {
                        if (model.presentationStyles && model.presentationStyles.length>0) {
                            return new generic.controller.DivController({className: Util.concatCssClasses(model.presentationStyles)});
                        }
                		return new aquima.mvc.GroupController();
                	}
                    return new generic.controller.TextController({className: Util.concatCssClasses('aq-asset', model.presentationStyles, model.contenttype) , allowInnerHtml : true});
                case 'text-item':
                    return new generic.controller.TextItemController({className: Util.concatCssClasses('aq-text', model.presentationStyles)});
                case 'image':
                    return new generic.controller.ImageController({className: Util.concatCssClasses('aq-image', model.presentationStyles)});
                case 'page':
                    return new generic.controller.PageController({
                    	className: Util.concatCssClasses('aq-page', model.presentationStyles),
                    	headerClassName:'aq-page-header',
                    	captionClassName:'aq-page-caption',
                    	bodyClassName:'aq-page-content'
                    });
                case 'link':
                    return new generic.controller.DownloadController(
                        { documentType: model.params['document-type'], documentFilename: model.params['document-name'] }
                    );
                case 'task-table':
                case 'table':
                    return new generic.controller.DivController({className: Util.concatCssClasses('aq-table', model.presentationStyles), factory: generic.genericTableFactory});
            };
            return new aquima.mvc.StaticTextController({
                attributes:{className:'error'}, 
                text: "Could not create controller for model type: '" + model.type + "'" 
            });
        },
        
        createInput: function(model, childIndexPath) {
        	if (hasPresentationStyle(model, 'memo')) {
        		return new generic.input.TextAreaInput({
        			className: Util.concatCssClasses('aq-input aq-memo ', model.presentationStyles),
        			rows: 10,
        			cols: 40
        		});
        	} 
            if (hasPresentationStyle(model, 'checkbox')) {
                return new generic.input.CheckboxInput();
            }
            if (model.domain != null) {
                if (model.multivalue == true) {
                    return new generic.input.CheckboxesInput();
                }
                if (hasPresentationStyle(model, 'RadioHorizontaal') || hasPresentationStyle(model, 'RadioHorizontal')) {
                    return new generic.input.RadioInput();
                }
                if (hasPresentationStyle(model, 'RadioVerticaal') || hasPresentationStyle(model, 'RadioVertical') || model.domain.length<=3) {
                    return new generic.input.RadioInput({vertical: true});
                }
                return new generic.input.DropdownInput({includeUnknown:true}); // always include unknown, even if model.required=true
            }
            if (model.datatype == 'boolean') {
                return new generic.input.CheckboxInput();
            }
            if (model.datatype=='date' || model.datatype=='datetime')
                return new generic.input.DateInput({
                		className:'aq-input',
                        past: hasPresentationStyle(model, 'HerschrijfDatumInVerleden') || hasPresentationStyle(model, 'RewriteDateInPast'),
                        future: hasPresentationStyle(model, 'HerschrijfDatumInToekomst') || hasPresentationStyle(model, 'RewriteDateInFuture')
                    });
            if (hasPresentationStyle(model, 'password')) {
            	return new generic.input.TextInput({className:'aq-input', password: true});
            }
            var formatter = this.getFormatter(model);
            return new generic.input.TextInput({className:'aq-input', formatter: formatter});
        },
        
        // Very generic rules. This behavior can be turned off by more specific factories.
    	postProcessControllerConfig: function(model, childIndexPath, controller) {
    	    if ((hasPresentationStyle(model, 'GeenAnimatie')) || (hasPresentationStyle(model, 'NoAnimation'))) {
    	        controller.config.animate = false;
    	    }
            if (model.type=='button') {
                controller.config.scrollToTop = !(hasPresentationStyle(model, 'NietScrollen') || hasPresentationStyle(model, 'NoScroll'));
            }
    	},
        
        getFormatter: function(model) {
            switch (model.datatype) {
                case 'integer':
                case 'number':
                case 'percentage':
                case 'currency':
                    return new generic.formatter.NumberFormatter();
            }
            if (hasPresentationStyle(model, 'Voorletters') || hasPresentationStyle(model, 'Initials')) {
                if (model.length) {
                    return new generic.formatter.InitialsFormatter({maxLength: model.length});
                } else {
                    return new generic.formatter.InitialsFormatter();
                }
            }
            return null;
        }
    };
    
    // Factory which makes contained buttons inapplicable for enter presses
    aquima.mvc.generic.menuFactory = {
    	postProcessControllerConfig: function(model, childIndexPath, controller) {
	        switch (model.type) {
	            case 'button':
	                controller.config.enterPriority = 0;
	                break;
	        }
	    }
    }

    aquima.mvc.generic.noOuterAnimDivsFactory = {
        postProcessControllerConfig: function(model, childIndexPath, controller) {
            controller.config.createOuterAnimDiv = false;
        }
    }
        
    // Instance selector without a table
    aquima.mvc.generic.genericInstanceSelectorFactory = {
        createController: function(model, childIndexPath) {
	        switch (model.type) {
	            case 'buttons':
	            	return new aquima.mvc.generic.controller.DivController({animate:false});
	            case 'row':
	                return new aquima.mvc.GroupController();
	            case 'cell':
	                return new aquima.mvc.GroupController();
	        }
    	},
    	
    	postProcessControllerConfig: function(model, childIndexPath, controller) {
	        switch (model.type) {
	            case 'button':
	                controller.config.scrollToTop = false;
	                break;
	        }
    	}
    }
    
    aquima.mvc.generic.genericTableFactory = {
        createController: function(model, childIndexPath) {
	        switch (model.type) {
	            case 'header':
	            	var columnClass = 'aq-header-'+model.content.length;
	                return new generic.controller.DivController({
	                	className: Util.concatCssClasses('aq-table-header', columnClass, model.presentationStyles), 
	                	animate: false,
	                	factory: aquima.mvc.generic.noOuterAnimDivsFactory
	                });
	            case 'row':
	            	var columnClass = 'aq-column-'+model.content.length;
                    var oddEven = (childIndexPath[0]%2 == 0) ? 'aq-odd' :'';
	                return new generic.controller.RowWithAggregatedMessagesController({
	                	className: Util.concatCssClasses('aq-table-row', oddEven, columnClass, model.presentationStyles), 
	                	animate: false,
	                	factory: aquima.mvc.generic.noOuterAnimDivsFactory
	                });
	            case 'cell':
	                var colNr = childIndexPath[childIndexPath.length-1]+1;
	                if (model.colspan>1) {
	                	colNr = colNr+'colspan'+model.colspan;
	                }
	                if (model.display) {
	                    return new generic.controller.TextController({createOuterAnimDiv:false, className: Util.concatCssClasses('aq-table-cell aq-table-column-'+colNr, model.presentationStyles)});
	                } else {
	                    return new generic.controller.DivController({createOuterAnimDiv:false, className: Util.concatCssClasses('aq-table-cell aq-table-column-'+colNr, model.presentationStyles)});
	                }
	            case 'field':
	                return new aquima.mvc.BareFieldController({className: Util.concatCssClasses(model.presentationStyles), createOuterAnimDiv: false});
            }
            return generic.genericInstanceSelectorFactory.createController(model, childIndexPath);
        },
        
	    postProcessControllerConfig: function(model, childIndexPath, controller) {
	    	generic.genericInstanceSelectorFactory.postProcessControllerConfig(model, childIndexPath, controller);
	    }
    }    

    // For debugging purposes
    Util.addClassNames(aquima.mvc.generic, 'aquima.mvc.generic');
})();