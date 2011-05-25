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
    
    YAHOO.lang.extend(LbeEngine, aquima.Engine, {
    	
    	start: function() {
    		this.prepare();
    	},
    	
    	update: function(pageData) {
    		this.processNewPageData(pageData);
    	}
    });

    Util.addClassNames(lbe, 'lbe');
})();