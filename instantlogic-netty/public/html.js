YUI.add('html', function(Y) {
	
    // Internet explorer 6 or 7?
    var ie67mode = Y.UA.ie >= 6 && Y.UA.ie < 8;

    // Private utility functions

    // Adds attributes to an HTML Element
    var setAttributes = function(element, attributes) {
        for (var attribute in attributes) {
            if (attributes.hasOwnProperty(attribute)) {
                var value = attributes[attribute];
                if (value !== null && value !== undefined) {
                    element[attribute] = value;
                }
            }
        }
    };

    // IE does not implement the standard way of creating elements and adding attributes like 'name'
    var createIE67Element = function(tagName, attributes) {
        var string = '<' + tagName + ' ';
        for (var attribute in attributes) {
            if (attributes.hasOwnProperty(attribute)) {
                var value = attributes[attribute];
                if (value !== null && value !== undefined) {
                    var attName = attribute;
                    if (attName == 'className') { attName = 'class'; }
                    if (attName == 'htmlFor') { attName = 'for'; }
                    if (attName == 'checked' && value === false) { continue; }
                    string += attName + '="' + value + '" ';
                }
            }
        }
        string += '>';
        return Y.Node.create(document.createElement(string));
    };

    // Recursive function which adds attributes and childnodes to an HTML Element
    var addChildNodes = function(element, content, isRoot) {
        for (var i = 0; i < content.length; i++) {
            var child = content[i];
            if (child === null || child === undefined) {
                // Nothing
            } else if (Y.Lang.isString(child)) { // Textnode
                element.appendChild(document.createTextNode(child));
            } else if (Y.Lang.isArray(child)) { // Recursion
                addChildNodes(element, child, false);
            } else if (i === 0 && !child.nodeName && isRoot) { // Attributes object
                if (ie67mode) {
                    element = createIE67Element(element.tagName.toLowerCase(), child);
                } else {
                    setAttributes(element, child);
                }
            } else if (child instanceof Y.Node) {
            	element.appendChild(child);
            } else if (child.nodeName) { // HTMLElement
                element.appendChild(child);
            } else {
                throw new Error('Cannot create child node from "' + child + '"');
            }
        }
        return element;
    };
	
	Y.html = {
        // Returns a function which can be used to create elements with a specific tagName.
        // See generic.js for examples. The returned function can handle the following:
        // - (Optional first argument) object containing attributes for the element
        //       Note: Use 'className' instead of 'class'. Also use 'htmlFor' instead of 'for'
        // - Other HTMLElements
        // - String, will be converted to a textNode
        // - Array, will be recursed
        createElementFactory: function(tagName) {
            return function() {
            	debugger
                var result = Y.Node.create(document.createElement(tagName));
                result = addChildNodes(result, arguments, true);
                return result;
            };
        }
	};
	
	var attributeNames = ['a','abbr','acronym','address','area','b','base','bdo','big','blockquote','body','br','button','caption','cite','code','col','colgroup','dd','del','dfn','div','dl','dt','em','fieldset','form','frame','frameset','h1','head','hr','html','i','iframe','img','input','ins','kbd','label','legend','li','link','map','meta','noframes','noscript','object','ol','optgroup','option','p','param','pre','q','samp','script','select','small','span','strong','style','sub','sup','table','tbody','td','textarea','tfoot','th','thead','title','tr','tt','u','ul','var'];
	
	for (var i=0;i<attributeNames.length;i++) {
		var name = attributeNames[i];
		Y.html[name] = Y.html.createElementFactory(name);
	}
	
}, '3.4.1', {requires: ['node']});