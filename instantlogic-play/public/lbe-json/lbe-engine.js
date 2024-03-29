var lbe = {};

// Within this function, variables will be local instead of global
(function() {

    // Aliases
    var Dom = YAHOO.util.Dom;
    var Event = YAHOO.util.Event;
    var YUC = YAHOO.util.Connect;
    var JSON = YAHOO.lang.JSON;

    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;

    var LbeEngine = lbe.LbeEngine = function(div, rootFactory, config) {
    	LbeEngine.superclass.constructor.call(this, div, rootFactory, config);
    }

    aquima.mvc.Settings.engine.aquimaUrl = 'StartFlow/submit';
    aquima.mvc.Settings.engine.submitUnchangedValues = false;
    
    YAHOO.lang.extend(LbeEngine, aquima.Engine, {
    	
    	start: function() {
    		this.prepare();
    	},
    	
    	update: function(pageData) {
    		LbeEngine.superclass.processNewPageData.call(this, pageData);
    	},
    	
    	processNewPageData: function() {
    	},
    	
    	post: function(data) {
    		var pageCoordinates = this.rootController.model.id;
    		var oldAquimaUrl = Settings.engine.aquimaUrl;
    		Settings.engine.aquimaUrl = Settings.engine.aquimaUrl + '&pageCoordinates='+pageCoordinates;
    		LbeEngine.superclass.post.call(this, data);
    		Settings.engine.aquimaUrl= oldAquimaUrl;
    	}
    });

    Util.addClassNames(lbe, 'lbe');
})();