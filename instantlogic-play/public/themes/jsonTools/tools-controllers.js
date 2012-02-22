aquima.mvc.jsonTools={};
aquima.mvc.jsonTools.controller={};

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
    var iframe = Util.createElementFactory('iframe');

    // ButtonLinkController
    // used to create open a link via a button
    // Configuration options:
    // - See PushButtonController
    var ButtonLinkController = aquima.mvc.jsonTools.controller.ButtonLinkController =
        Util.extend(aquima.mvc.generic.controller.ButtonController, {
            fireSubmit: function(event) {
            	window.open( this.model.actions[0], '_blank' );
            }
        });
    
    var TreeNodeController = aquima.mvc.jsonTools.controller.TreeNodeController =
    	Util.extend(aquima.mvc.generic.controller.ContainerController, {
    		
    		createViewNodes: function() {
    			this.viewNodes = [ 
    			    div({id:this.model.id, className: this.config.className},
this.displayNode =		span(this.model.display),
this.childrenNode =		div({className: 'children'})
					)
    			];
    		}
    	
    	});

    // Displays a fullscreen iframe. Configuration options:
    // - className
    // - topPx: Number of pixels from the top
    var IFrameController = aquima.mvc.jsonTools.controller.IFrameController =
    	Util.extend(aquima.mvc.generic.controller.ContainerController, {
    		
    		createViewNodes: function() {
    			this.viewNodes = [
    			];
    			this.iframe = iframe({src: this.model.src, className: this.config.className});
    			this.iframe.style.position='absolute';
    			this.iframe.style.top=this.config.topPx+'px';
    			this.iframe.style.left='0px';
    			this.iframe.style.zIndex='100';
    			this.resize();
    			document.body.appendChild(this.iframe);
    			Event.addListener(window, 'resize', this.resize, null, this);
    		},
    		
    		resize: function() {
    			var region = Dom.getClientRegion();
    			this.iframe.style.width=region.width+'px';
    			this.iframe.style.height=(region.height-this.config.topPx)+'px';
    		},
    		
    		destroy: function() {
    			Event.removeListener(window, 'resize', this.resize);
    			document.body.removeChild(this.iframe);
    		}
    	});
    
    var PopupController = aquima.mvc.jsonTools.controller.PopupController =
    	Util.extend(aquima.mvc.generic.controller.ContainerController, {
    		
    		createViewNodes: function() {
    			this.viewNodes = [];
    			this.panel = new YAHOO.widget.Panel(this.model.id, {
    				width:'800px',
    				constraintoviewport: true,
    				underlay: 'shadow',
    				close: false,
    				draggable: true,
    				zIndex: 900+(this.config.modal===true?1:0),
    				modal: this.config.modal===true
    			});
    			this.childrenNode = div({className: this.config.className});
    			this.panel.setHeader(this.model.display || '');
    			this.panel.setBody(this.childrenNode);
    			this.panel.render(this.engine.popupsDiv);
    		},
    		
    		destroy: function() {
    			if (this.panel) {
    				this.panel.destroy();
    				this.panel=null;
    			}
    		}
    	});
    
    // For debugging purposes
    Util.addClassNames(aquima.mvc.jsonTools.controller, 'aquima.mvc.jsonTools.controller');

} ());