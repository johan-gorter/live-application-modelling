prototype.mvc.input = {};

(function(){
    
    // Aliases
    var Dom = YAHOO.util.Dom;
    var Event = YAHOO.util.Event;

    var Settings = aquima.mvc.Settings;
    var Util = aquima.mvc.Util;
    var hasFormat = Util.hasFormat;
    
    var div = Util.createElementFactory('div');
    var span = Util.createElementFactory('span');
    var a = Util.createElementFactory('a');
    var input = Util.createElementFactory('input');
    
    // Add your project-specific inputs here
    
    // var SpecialInput = myProject.mvc.input.SpecialInput = 
    //     Util.extend(aquima.mvc.TextInput, {
    //     });

    
    // For debugging purposes
    Util.addClassNames(prototype.mvc.input, 'prototype.mvc.input');
}());