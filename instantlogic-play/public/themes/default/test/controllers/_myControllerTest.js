(function() {

    var Assert = YAHOO.util.Assert;

    var myControllerTest = {
        name: 'myControllerTest',
        model: {
            "type": "dummy",
            "id": "id"
        }
    };

    YAHOO.lang.augmentObject(myControllerTest, aquima.mvc.test.controllerTestMethods);

    aquima.mvc.test.Tests.addTest(['myproject', 'controllers'],myControllerTest);
    
})();