// Adds generic fallbacks and/or baseclasses for Inputs. Formatters for inputs are also included here 

// Voor Intellisense in Visual Studio
/// <reference path="~/lib/yui/yahoo/yahoo.js" />
/// <reference path="~/lib/yui/dom/dom.js" />
/// <reference path="~/lib/yui/event/event.js" />
/// <reference path="~/lib/yui/json/json.js" />
/// <reference path="~/mvc/core.js" />
/// <reference path="~/mvc/generic-controllers.js" />

aquima.mvc.generic.formatter = {};
aquima.mvc.generic.input = {};

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
    var ul = Util.createElementFactory('ul');
    var li = Util.createElementFactory('li');
    var br = Util.createElementFactory('br');
    var input = Util.createElementFactory('input');
    var select = Util.createElementFactory('select');
    var option = Util.createElementFactory('option');
    var label = Util.createElementFactory('label');
    var textarea = Util.createElementFactory('textarea');
    
    // Private helper functions
    function isDomainChanged(oldDomain, newDomain) {
        if (oldDomain.length!=newDomain.length) return true;
        for (var i=0;i<oldDomain.length;i++) {
            if (oldDomain[i].value != newDomain[i].value) return true;
            if (oldDomain[i].valid != newDomain[i].valid) return true;
            if (oldDomain[i].display != newDomain[i].display) return true;
        }
        return false;
    }

    // Formatters
    // When no config is provided, the number format settings provided by the engine will be used.
    
    // optional config:
    // commaDecimalSeparator:  True if a , is used as decimal separator, false if a . is used. null/undefined means auto detect from langage
    // numberOfDecimals:       Use number of decimals (default 0)
    // useThousandSeparator:   True if thousand separator is used
    var NumberFormatter = aquima.mvc.generic.formatter.NumberFormatter = 
        Util.extend(aquima.mvc.Formatter, {
        
            format: function(data, input) {
                if (data===null || data===undefined || data==='') {
                    return '';
                }
                return Util.formatNumber(data, this.numberOfDecimals(input), this.isCommaDecimalSeparator(input), this.useThousendSeperator(input) );
            },
            
            parse: function(text, input) {
                if (typeof text != 'string') { throw new Error('Can only parse strings'); }
                if (text==null || text=='') {
                    return null;
                }
                // Remove thousand separators
                if (this.isCommaDecimalSeparator(input)) {
                    text = text.replace(/\./g,'');
                    text = text.replace(/\,/g,'.');
                } else {
                    text = text.replace(/\,/,'');
                }
                if (text=='') {
                    return null;
                }
                return parseFloat(text);
            },
        
         	// Use Comma(,) instead of Dot(.) as the decimal separator?
            isCommaDecimalSeparator: function(input) {
                var result = this.config.commaDecimalSeparator;
                if ((result===null || result===undefined) && input && input.engine) {
                    result = input.engine.commaDecimalSeparator;
                }
                if (result===null || result===undefined) {
                    result = false;
                }
                return result;
            },

        	useThousendSeperator: function(input) {
        		var result = this.config.useThousandSeparator;
                if ((result===null || result===undefined) && input && input.engine) {
                    result = this.getPattern(input).indexOf(',') != -1;
                }
                if (result===null || result===undefined) {
                    result = false;
                }
                return result;
        	},
        	
        	numberOfDecimals: function(input) {
        		var result = this.config.numberOfDecimals;
                if ((result===null || result===undefined) && input && input.engine) {
                	var pattern = this.getPattern(input);
                	if( pattern.indexOf('.') != -1 ) {
                		result = pattern.length - pattern.indexOf('.') - 1;
                	}
                }
                if (result===null || result===undefined) {
                    result = 0;
                }
        		return result;
        	},
        	
        	getPattern: function(input) {
        		if( input.model.datatype == 'integer' ) {
        			return input.engine.integerFormat;
        		}
        		if( input.model.datatype == 'number' ) {
        			return input.engine.numberFormat;
        		}
        		if( input.model.datatype == 'currency' ) {
        			return input.engine.currencyFormat;
        		}
        		if( input.model.datatype == 'percentage' ) {
        			return input.engine.percentageFormat;
        		}
        		throw new Error('Unexpected datatype "' + input.model.datatype + '"');
        	}
            
        });
        
    // Formatter that removes everything that config.stripRegex matches, 
    // example: /[^0-9]/g removes all nondigits
    var StripRegexFormatter = aquima.mvc.generic.formatter.StripRegexFormatter =
        Util.extend(aquima.mvc.Formatter, {
            format: function(data, input) { // Json -> Text
                if(!data) return data;
                if (!this.config.stripRegex) {throw new Error('stripRegex not configured')}
                data = (''+data).replace(this.config.stripRegex, '');
                return data;
            }
        });
        

    // Translates 'tje' to 'T.J.E'
    // config:
    // maxLength: trim at maximum length
    aquima.mvc.generic.formatter.InitialsFormatter = 
        Util.extend(aquima.mvc.Formatter, {
            format: function(value, input) {
                if (value.indexOf('.')==-1) {
                    value = value.toUpperCase();
                    var index = 0;
                    while (index<value.length) {
                        var c = value.charAt(index);
                        if (c>='A' && c<='Z') {
                            value = value.substr(0,index+1) + '.'+ value.substr(index+1);
                            index++;
                        }
                        index++;
                    }
                }
                if (this.config.maxLength && value.length>this.config.maxLength) {
                    value = value.substr(0, this.config.maxLength);
                }
                return value;
            }
        });
    
    
    // TextInput
    // Simple text input field
    // Configuration options:
    // - formatter: Formatter
    // - password: creates a password input if true
    var TextInput = aquima.mvc.generic.input.TextInput = 
        Util.extend(aquima.mvc.Input, {

            createViewNode: function() {
                this.viewNode = this.inputText = input({ 
                    id: this.model.id, 
                    name: this.model.id, 
                    type: (this.config.password?'password':'text'), 
                    className: this.config.className,
                    value: this.formatText(this.model.value, this.model.display)
                });
                if (this.config.size) {
                    this.inputText.size = this.config.size;
                }
                this.updateReadonly(this.model.readonly);
                Event.on(this.inputText, 'change', this.valueChanged, null, this);
                Event.on(this.inputText, 'mousedown', this.onMousedown, null, this);
                Event.on(this.inputText, 'click', this.onClick, null, this); // Select all text
                if(this.model.length>0) {
                    this.inputText.maxLength=this.model.length;
                }
            },
            
            valueChanged: function() {
                // Do a parse + format to reformat the text
                if (this.config.formatter) {
                    var value = this.getValue();
                    this.inputText.value = this.formatText(value, null);
                }
                TextInput.superclass.valueChanged.call(this); // super.valueChanged
            },

            onMousedown: function(evt) {
                this.selectAllText = (document.activeElement && document.activeElement!=this.inputText);
            },

            onClick: function(evt) {
                if (this.selectAllText) {
                    this.inputText.focus();
                    this.inputText.select();
                }
            },

            updateValue: function(newValue, newDisplay) {
                this.inputText.value = this.formatText(newValue, newDisplay);
            },

            getValue: function() {
                return this.parseText(this.inputText.value);
            },

            updateReadonly: function(newReadonly) {
            	this.inputText.readOnly = newReadonly;
            	if (newReadonly) {
            		Dom.addClass(this.inputText, 'readonly');
            	} else {
            		Dom.removeClass(this.inputText, 'readonly');
            	}
                //this.inputText.disabled = newReadonly;
            }
        });

    // TextAreaInput
    // Textarea input field
    // Configuration options:
    // - rows: number of rows
    // - cols: number of columns
    var TextAreaInput = aquima.mvc.generic.input.TextAreaInput = 
        Util.extend(aquima.mvc.Input, {

            createViewNode: function() {
                this.viewNode = this.textarea = textarea({ 
                    id: this.model.id, 
                    name: this.model.id, 
                    className: Util.strcat(this.config.className,' aq-textarea'),
                    value: this.model.value,
                    rows: this.config.rows,
                    cols: this.config.cols
                });
                this.updateReadonly(this.model.readonly);
                Event.on(this.textarea, 'change', this.valueChanged, null, this);
            },

            getValue: function() {
                return this.textarea.value;
            },

            updateValue: function (newValue, newDisplay) {
                this.textarea.value = this.formatText(newValue, newDisplay);
            },
			
            updateReadonly: function(newReadonly) {
                this.textarea.disabled = newReadonly;
            }
        });
    
    // DropdownInput
    // Renders a dropdown box
    // Configuration options:
    // - includeUnknown: An 'unknown' option is included if true
    // - listSize: creates a list instead of a dropdown with the specified size
    var DropdownInput = aquima.mvc.generic.input.DropdownInput = 
        Util.extend(aquima.mvc.Input, {

            createViewNode: function() {
                this.viewNode = this.dropdownViewNode = select({ 
                    id: this.model.id, name: this.model.id, 
                    className: this.config.className,
                    disabled: this.model.readonly
                }, this.createOptions(this.model.domain, this.model.value));
                if (this.config.listSize) {
                	this.dropdownViewNode.size=this.config.listSize;
                }
                this.updateValue(this.model.value);
                Event.on(this.dropdownViewNode, 'change', this.valueChanged, null, this);
            },

            createOptions: function(domain) {
                var result = [];
                if (this.config.includeUnknown!=false) {
                    result.push(option({value: ''}, '---'));
                }
                for (var i=0;i<domain.length;i++) {
                    var entry = domain[i];
                    if (!domain[i].valid) continue;
                    result.push(option({value: entry.value}, entry.display));
                }
                return result;
            },

            update: function (newModel) {
                if( !newModel.domain ) {
            		return false;
            	}
                if (isDomainChanged(this.model.domain, newModel.domain)) {
                    Util.replaceChildNodes(this.dropdownViewNode, this.createOptions(newModel.domain, newModel.value));
                    this.updateValue(newModel.value);
                    this.model.value = newModel.value; // don't trigger updateValue again
                }
                DropdownInput.superclass.update.call(this, newModel); //super.update(newModel)
            },

            updateValue: function (newValue) {
                if (newValue!==null && newValue!==undefined) {
                    for (var i = 0; i < this.dropdownViewNode.options.length; i++) {
                        if (this.dropdownViewNode.options[i].value === newValue.toString()) {
                            this.dropdownViewNode.selectedIndex = i;
                            return;
                        }
                    }
                }
                this.dropdownViewNode.selectedIndex = 0;
            },

            getValue: function () {
                if (this.dropdownViewNode.selectedIndex >= 0) {
                    var option = this.dropdownViewNode.options[this.dropdownViewNode.selectedIndex];
                    return option.formattedvalue || option.value;
                }
                return null;
            },

            getDisplay: function () {
                if (this.dropdownViewNode.selectedIndex >= 0) {
                    var option = this.dropdownViewNode.options[this.dropdownViewNode.selectedIndex];
                    return Util.getText(option);
                }
                return null;
            },

            updateReadonly: function (newReadonly) {
                this.dropdownViewNode.disabled = newReadonly;
            }

        });
    
    // RadioInput
    // Renders a radio button
    var RadioInput = aquima.mvc.generic.input.RadioInput = 
        Util.extend(aquima.mvc.Input, {
        
            createViewNode: function() {
                this.radios=[];
                this.className = this.config.className;
                this.viewNode = ul({ 
                    id: this.model.id,
                    className:this.className
                }, this.createRadios());
                for (var i=0;i<this.radios.length;i++) {
                    Event.on(this.radios[i], 'click', this.valueChanged, null, this);
                }
            },
            
            createRadios: function() {
                var result = [];
                for (var i=0;i<this.model.domain.length;i++) {
                    var entry = this.model.domain[i];
                    if (!this.model.domain[i].valid) continue;
                    var checked = (this.model.value === entry.value);
                    var radio=input({
                        type: 'radio', 
                        name: this.model.id,
                        className: 'aq-radio',
                        id: this.model.id+'-'+i,
                        value: entry.value,
                        disabled: this.model.readonly,
                        checked: checked,
                        defaultChecked: checked
                    });
                    this.radios.push(radio);
                    var option =
	                    li(
	                        radio,
	                        label({className:'aq-radioLabel', htmlFor:this.model.id+'-'+i}, entry.display)
	                    )
	                result.push(option);
                }
                return result;
            },
            
            getValue: function() {
                for(var i=0; i<this.radios.length;++i) {
                    if(this.radios[i].checked) return this.radios[i].value;
                }
                return null;
            },
            
            updateValue: function(newValue) {
                for (var i=0;i<this.radios.length;i++) {
                    this.radios[i].checked = this.radios[i].value == newValue;
                }
            },
            
            updateReadonly: function(newReadonly){
                for(var i=0;i<this.radios.length;++i) {
                    this.radios[i].disabled = newReadonly;
                }
            }
        });

    // CheckboxInput
    // Renders a checkbox
    var CheckboxInput = aquima.mvc.generic.input.CheckboxInput = 
        Util.extend(aquima.mvc.Input, {

            createViewNode: function() {
                this.viewNode = input({ 
                    type: 'checkbox',
                    id: this.model.id, name: this.model.id, 
                    className: Util.strcat(this.config.className,' aq-checkbox'),
                    defaultChecked: this.model.value, //IE hack
                    checked: this.model.value,
                    disabled: this.model.readonly
                });
                Event.on(this.viewNode, 'click', this.valueChanged, null, this);
            },

            updateValue: function(newValue) {
                this.viewNode.checked = (''+newValue=='true');
            },

            getValue: function() {
                return this.viewNode.checked;
            },

            updateReadonly: function(newReadonly) {
                this.viewNode.disabled = newReadonly;
            }
        });
    
    // Creates a readonly input containing the value. (the user cannot change the value)
    var SpanInput = aquima.mvc.generic.input.SpanInput = 
        Util.extend(aquima.mvc.Input, {

            createViewNode: function() {
                this.viewNode = span({className: this.config.className},
                    this.formatText(this.model.value, this.model.display)
                );
            },

            getValue: function() { // will not be called if readonly==true
                return Util.getText(this.viewNode);
            },

            updateValue: function(newValue, newDisplay) {
                Util.setText(this.viewNode, this.formatText(newValue, newDisplay));
            },

            updateReadonly: function(newReadonly){
            }
        });
    
    // Input for dates that enables a consistent date format dd-MM-yyyy and
    // rewrites 202020 to 10-10-2020 or 10-10-1920
    // Configuration properties:
    // - future: Date will be rewritten to a date in the future if true
    // - past: Date will be rewritten to a date in the past if true
    var DateInput = aquima.mvc.generic.input.DateInput = 
        Util.extend(aquima.mvc.generic.input.TextInput, {
        
            createViewNode: function() {
                DateInput.superclass.createViewNode.call(this);
                this.inputText.maxLength=10;
                Event.on(this.inputText, 'blur', this.blur, null, this);
                Event.on(this.inputText, 'keyup', this.keyUp, null, this);
                Event.on(this.inputText, 'keydown', this.keyDown, null, this);
            },
            
            blur: function(e) {
            	if( (this.engine.dateFormat != 'dd-MM-yyyy') &&  (this.engine.dateFormat != 'MM-dd-yyyy') ) {
            		return; // We cannot handle other date formats
            	}
                var text = this.inputText.value;
                if (/^\d\d?-\d\d?-\d\d$/.test(text)) {
                    // prepend 19 or 20 to the 2-digit year
                    var prefix = text.substr(0, text.length-2);
                    var shortYear = text.substr(text.length-2)
                    var year = 2000 + new Number(shortYear);
                    var now = new Date().getFullYear();
                    if (this.config.past === true) {
                        if (year > now) {
                            year = year - 100;
                        }
                    } else if (this.config.future !== true) {
                        if (year > 2040) {
                            year = year - 100;
                        }
                    }
                    this.inputText.value = prefix+year;
                }
            },
            
            keyUp: function(e) {
            	if( this.engine.dateFormat != 'dd-MM-yyyy' ) {
            		return; //TODO handle other date formats and datetime format
            	}
                var code = Event.getCharCode(e);
                var caretPos = this.getCaretPos();
                var text = this.inputText.value;
                if (caretPos == text.length) {
                    // We only aid the user if the cursor is at the end
                    if (this.isDateSeparator(code)) {
                        if (text.length>0 && text.charAt(text.length-1) != '-') {
                            this.inputText.value = text+'-';
                        }
                    } 
                    if (this.isDigit(code)) {
                        if (/^\d\d$/.test(text) || /^\d\d?-\d\d$/.test(text)) {
                            this.inputText.value = text+'-';
                        }
                    }
                }
            },
            
            keyDown: function(e) {
            	if( this.engine.dateFormat != 'dd-MM-yyyy' ) {
            		return; //TODO handle other date formats and datetime format
            	}
                var code = Event.getCharCode(e);
                var key = String.fromCharCode(code)
                // allow only digits and date separators
                if (!this.isDigit(code) && code>'9'.charCodeAt(0) && (code<112 || code>123) && e.ctrlKey!=1)
                {
                    var caretPos = this.getCaretPos(this.inputText);
                    if (caretPos == this.inputText.value.length) { 
                        // We only aid the user if the cursor is at the end
                        Event.preventDefault(e);
                    }
                }
            },

            // This method is overridden to make sure blur() is called first            
            valueChanged: function() {
                this.blur();
                DateInput.superclass.valueChanged.call(this);
            },
            
            // private utility functions
            getCaretPos: function() {
                if(typeof this.inputText.selectionStart=='number') {
                    return this.inputText.selectionStart;
                } else if (document.selection && this.inputText.createTextRange){
                    var rng=document.selection.createRange();
                    rng.collapse(true);
                    rng.moveStart('character', -this.inputText.value.length);
                    return rng.text.length;
                }
                return -1;
            },
            
            // 0-9 (numpad or normal)
            isDigit: function(keyCode) {
                return ((keyCode>=48 && keyCode<=57) || (keyCode>=96 && keyCode<=105));
            },
            
            // '-', '.' or '/' (numpad or normal)
            isDateSeparator: function(keyCode) {
                return (keyCode == 189 || keyCode == 190 || keyCode == 191 || keyCode == 109 || keyCode == 110 || keyCode == 111)
            }
        });
        
    // Renders a multi-value domain as a list of checkboxes
    var CheckboxesInput = aquima.mvc.generic.input.CheckboxesInput =
        Util.extend(aquima.mvc.Input, {
 
            createOptions: function (domain, values) {
                if (values == null) values = [];
                var result = [];
                for (var i = 0; i < this.inputs.length; i++) {
                    Event.removeListener(this.inputs[i], 'click', this.inputClicked, null, this);
                }
                this.inputs = [];
                for (var i = 0; i < domain.length; i++) {
                    if (domain[i].valid!==false) {
                        var option = domain[i];
                        var checked = Util.indexOf(values, option.value) >= 0;
                        var id = this.model.id + '#' + option.value;
                        var checkbox =
                            input({
                                type: 'checkbox',
                                id: id,
                                name: id,
                                defaultChecked: checked,
                                checked: checked,
                                disabled: this.model.readonly
                            });
                        var option =
                            li(
                                checkbox,
                                label({ htmlFor: id }, option.display)
                            )
                        Event.on(checkbox, 'click', this.inputClicked, null, this);
                        this.inputs.push(checkbox);
                        result.push(option);
                    }
                }
                return result;
            },
 
            refreshOptions: function (domain, values) {
                Util.replaceChildNodes(this.viewNode, this.createOptions(domain, values));
            },
 
            inputClicked: function (event) {
                this.valueChanged();
            },
 
            update: function (newModel) {
                if (isDomainChanged(this.model.domain, newModel.domain)) {
                    this.refreshOptions(newModel.domain, newModel.value);
                    this.disableUpdateValue=true; // don't trigger updateValue again
                }
                CheckboxesInput.superclass.update.call(this, newModel); //super.update(newModel)
                this.disableUpdateValue = false;
            },
 
            createViewNode: function () {
                this.inputs = [];
                this.viewNode = ul(this.createOptions(this.model.domain, this.model.value));
            },
 
            updateValue: function (newValue) {
                if (!this.disableUpdateValue) {
                    this.refreshOptions(this.model.domain, newValue);
                }
            },
 
            updateReadonly: function (newReadonly) {
                this.refreshOptions(this.model.domain, this.model.value);
            },
 
            getValue: function () {
                var result = [];
                var inputIndex = 0;
                for (var i = 0; i < this.model.domain.length; i++) {
                    var domain = this.model.domain[i];
                    if (domain.valid!==false) {
                        var input = this.inputs[inputIndex++];
                        if (input.checked) {
                            result.push(domain.formattedvalue || domain.value);
                        }
                    }
                }
                return result;
            }
        });

    // For debugging purposes
    Util.addClassNames(aquima.mvc.generic.formatter, 'aquima.mvc.generic.formatter');
    Util.addClassNames(aquima.mvc.generic.input, 'aquima.mvc.generic.input');
}());