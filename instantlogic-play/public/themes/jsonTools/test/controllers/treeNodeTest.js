(function() {

    var Assert = YAHOO.util.Assert;

    var treeNodeTest = {
        name: 'treeNodeTest',
        model: {
        	  "type": "node",
        	  "name": "Singletons",
        	  "id": "P123-C0-C1-C1-C0-C0-C3-C0",
        	  "display": "Singletons",
        	  "content": [
        	    {
        	      "type": "button",
        	      "name": "expand",
        	      "id": "P123-C0-C1-C1-C0-C0-C3-C0-B0",
        	      "display": "+",
        	      "readonly": true,
        	      "actions": []
        	    },
        	    {
        	      "type": "button",
        	      "name": "collapse",
        	      "id": "P123-C0-C1-C1-C0-C0-C3-C0-B1",
        	      "display": "-",
        	      "actions": []
        	    },
        	    {
        	      "type": "button",
        	      "name": "toggleSelection",
        	      "id": "P123-C0-C1-C1-C0-C0-C3-C0-B2",
        	      "display": "ToggleSelection",
        	      "actions": []
        	    },
        	    {
        	      "type": "container",
        	      "name": "childNodes",
        	      "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3",
        	      "content": [
        	        {
        	          "type": "node",
        	          "name": "Driver",
        	          "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C0",
        	          "display": "Driver",
        	          "content": [
        	            {
        	              "type": "button",
        	              "name": "expand",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C0-B0",
        	              "display": "+",
        	              "actions": []
        	            },
        	            {
        	              "type": "button",
        	              "name": "collapse",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C0-B1",
        	              "display": "-",
        	              "readonly": true,
        	              "actions": []
        	            },
        	            {
        	              "type": "button",
        	              "name": "toggleSelection",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C0-B2",
        	              "display": "ToggleSelection",
        	              "actions": []
        	            },
        	            {
        	              "type": "container",
        	              "name": "childNodes",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C0-C3",
        	              "content": []
        	            }
        	          ]
        	        },
        	        {
        	          "type": "node",
        	          "name": "system",
        	          "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C1",
        	          "display": "system",
        	          "presentationStyles": [
        	            "selected"
        	          ],
        	          "format": "selected",
        	          "content": [
        	            {
        	              "type": "button",
        	              "name": "expand",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C1-B0",
        	              "display": "+",
        	              "actions": []
        	            },
        	            {
        	              "type": "button",
        	              "name": "collapse",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C1-B1",
        	              "display": "-",
        	              "readonly": true,
        	              "actions": []
        	            },
        	            {
        	              "type": "button",
        	              "name": "toggleSelection",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C1-B2",
        	              "display": "ToggleSelection",
        	              "actions": []
        	            },
        	            {
        	              "type": "container",
        	              "name": "childNodes",
        	              "id": "P123-C0-C1-C1-C0-C0-C3-C0-C3-C1-C3",
        	              "content": []
        	            }
        	          ]
        	        }
        	      ]
        	    }
        	  ]
        	}
    };

    YAHOO.lang.augmentObject(treeNodeTest, aquima.mvc.test.controllerTestMethods);

    aquima.mvc.test.Tests.addTest(['jsonTools', 'controllers'], treeNodeTest);
    
})()