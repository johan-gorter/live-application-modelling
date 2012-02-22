(function() {

    var Assert = YAHOO.util.Assert;

    var popupTest = {
        name: 'popupTest',
        model: {
		  "type": "popup",
		  "name": "popupwidget1",
		  "id": "P123-C0-C2",
		  "display": "Profile Tools",
		  "content": [
		    {
		      "type": "button",
		      "name": "closeWidgetwidget1",
		      "id": "P123-C0-C2-B0",
		      "display": "Close widget",
		      "presentationStyles": [
		        "hidden"
		      ],
		      "format": "hidden",
		      "actions": []
		    },
		    {
		      "type": "container",
		      "name": "c3684c1a-a7b1-4ec1-9e98-969bfda40a28",
		      "id": "P123-C0-C2-C1",
		      "display": "Profile Tools",
		      "content": [
		        {
		          "type": "tabs",
		          "name": "selector",
		          "id": "P123-C0-C2-C1-C0",
		          "content": [
		            {
		              "type": "button",
		              "name": "c3684c1a-a7b1-4ec1-9e98-969bfda40a28widget0",
		              "id": "P123-C0-C2-C1-C0-B0",
		              "display": "Profile Explorer",
		              "presentationStyles": [
		                "active"
		              ],
		              "format": "active",
		              "actions": []
		            },
		            {
		              "type": "button",
		              "name": "c3684c1a-a7b1-4ec1-9e98-969bfda40a28widget1",
		              "id": "P123-C0-C2-C1-C0-B1",
		              "display": "Profile editor",
		              "actions": []
		            },
		            {
		              "type": "button",
		              "name": "c3684c1a-a7b1-4ec1-9e98-969bfda40a28widget2",
		              "id": "P123-C0-C2-C1-C0-B2",
		              "display": "Profile view",
		              "actions": []
		            },
		            {
		              "type": "button",
		              "name": "c3684c1a-a7b1-4ec1-9e98-969bfda40a28widget3",
		              "id": "P123-C0-C2-C1-C0-B3",
		              "display": "Profile Import/Export",
		              "actions": []
		            }
		          ]
		        },
		        {
		          "type": "container",
		          "name": "main",
		          "id": "P123-C0-C2-C1-C1",
		          "presentationStyles": [
		            "profile-explorer"
		          ],
		          "format": "profile-explorer",
		          "content": [
		            {
		              "type": "container",
		              "name": "leftColumn",
		              "id": "P123-C0-C2-C1-C1-C0",
		              "presentationStyles": [
		                "leftColumn"
		              ],
		              "format": "leftColumn",
		              "content": [
		                {
		                  "type": "node",
		                  "name": "root",
		                  "id": "P123-C0-C2-C1-C1-C0-C0",
		                  "display": "root",
		                  "content": [
		                    {
		                      "type": "button",
		                      "name": "expand",
		                      "id": "P123-C0-C2-C1-C1-C0-C0-B0",
		                      "display": "+",
		                      "readonly": true,
		                      "actions": []
		                    },
		                    {
		                      "type": "button",
		                      "name": "collapse",
		                      "id": "P123-C0-C2-C1-C1-C0-C0-B1",
		                      "display": "-",
		                      "actions": []
		                    },
		                    {
		                      "type": "button",
		                      "name": "toggleSelection",
		                      "id": "P123-C0-C2-C1-C1-C0-C0-B2",
		                      "display": "ToggleSelection",
		                      "actions": []
		                    },
		                    {
		                      "type": "container",
		                      "name": "childNodes",
		                      "id": "P123-C0-C2-C1-C1-C0-C0-C3",
		                      "content": [
		                        {
		                          "type": "node",
		                          "name": "Singletons",
		                          "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0",
		                          "display": "Singletons",
		                          "content": [
		                            {
		                              "type": "button",
		                              "name": "expand",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-B0",
		                              "display": "+",
		                              "readonly": true,
		                              "actions": []
		                            },
		                            {
		                              "type": "button",
		                              "name": "collapse",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-B1",
		                              "display": "-",
		                              "actions": []
		                            },
		                            {
		                              "type": "button",
		                              "name": "toggleSelection",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-B2",
		                              "display": "ToggleSelection",
		                              "actions": []
		                            },
		                            {
		                              "type": "container",
		                              "name": "childNodes",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3",
		                              "content": [
		                                {
		                                  "type": "node",
		                                  "name": "Driver",
		                                  "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C0",
		                                  "display": "Driver",
		                                  "content": [
		                                    {
		                                      "type": "button",
		                                      "name": "expand",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C0-B0",
		                                      "display": "+",
		                                      "actions": []
		                                    },
		                                    {
		                                      "type": "button",
		                                      "name": "collapse",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C0-B1",
		                                      "display": "-",
		                                      "readonly": true,
		                                      "actions": []
		                                    },
		                                    {
		                                      "type": "button",
		                                      "name": "toggleSelection",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C0-B2",
		                                      "display": "ToggleSelection",
		                                      "actions": []
		                                    },
		                                    {
		                                      "type": "container",
		                                      "name": "childNodes",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C0-C3",
		                                      "content": []
		                                    }
		                                  ]
		                                },
		                                {
		                                  "type": "node",
		                                  "name": "system",
		                                  "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C1",
		                                  "display": "system",
		                                  "content": [
		                                    {
		                                      "type": "button",
		                                      "name": "expand",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C1-B0",
		                                      "display": "+",
		                                      "actions": []
		                                    },
		                                    {
		                                      "type": "button",
		                                      "name": "collapse",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C1-B1",
		                                      "display": "-",
		                                      "readonly": true,
		                                      "actions": []
		                                    },
		                                    {
		                                      "type": "button",
		                                      "name": "toggleSelection",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C1-B2",
		                                      "display": "ToggleSelection",
		                                      "actions": []
		                                    },
		                                    {
		                                      "type": "container",
		                                      "name": "childNodes",
		                                      "id": "P123-C0-C2-C1-C1-C0-C0-C3-C0-C3-C1-C3",
		                                      "content": []
		                                    }
		                                  ]
		                                }
		                              ]
		                            }
		                          ]
		                        },
		                        {
		                          "type": "node",
		                          "name": "Static instances",
		                          "id": "P123-C0-C2-C1-C1-C0-C0-C3-C1",
		                          "display": "Static instances",
		                          "content": [
		                            {
		                              "type": "button",
		                              "name": "expand",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C1-B0",
		                              "display": "+",
		                              "actions": []
		                            },
		                            {
		                              "type": "button",
		                              "name": "collapse",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C1-B1",
		                              "display": "-",
		                              "readonly": true,
		                              "actions": []
		                            },
		                            {
		                              "type": "button",
		                              "name": "toggleSelection",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C1-B2",
		                              "display": "ToggleSelection",
		                              "actions": []
		                            },
		                            {
		                              "type": "container",
		                              "name": "childNodes",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C1-C3",
		                              "content": []
		                            }
		                          ]
		                        },
		                        {
		                          "type": "node",
		                          "name": "Entity types",
		                          "id": "P123-C0-C2-C1-C1-C0-C0-C3-C2",
		                          "display": "Entity types",
		                          "content": [
		                            {
		                              "type": "button",
		                              "name": "expand",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C2-B0",
		                              "display": "+",
		                              "actions": []
		                            },
		                            {
		                              "type": "button",
		                              "name": "collapse",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C2-B1",
		                              "display": "-",
		                              "readonly": true,
		                              "actions": []
		                            },
		                            {
		                              "type": "button",
		                              "name": "toggleSelection",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C2-B2",
		                              "display": "ToggleSelection",
		                              "actions": []
		                            },
		                            {
		                              "type": "container",
		                              "name": "childNodes",
		                              "id": "P123-C0-C2-C1-C1-C0-C0-C3-C2-C3",
		                              "content": []
		                            }
		                          ]
		                        }
		                      ]
		                    }
		                  ]
		                }
		              ]
		            },
		            {
		              "type": "container",
		              "name": "rightColumn",
		              "id": "P123-C0-C2-C1-C1-C1",
		              "presentationStyles": [
		                "rightColumn"
		              ],
		              "format": "rightColumn",
		              "content": [
		                {
		                  "type": "container",
		                  "name": "Details",
		                  "id": "P123-C0-C2-C1-C1-C1-C0",
		                  "content": []
		                }
		              ]
		            }
		          ]
		        }
		      ]
		    }
		  ]
       	}
    };

    YAHOO.lang.augmentObject(popupTest, aquima.mvc.test.controllerTestMethods);

    aquima.mvc.test.Tests.addTest(['jsonTools', 'controllers'], popupTest);
    
})()