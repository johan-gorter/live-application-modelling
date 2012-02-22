// This library can be dynamically loaded onto sites running the Aquima MVC Engine.
// This can be accomplished by adding a favorite/bookmark to your browser containing
// the bookmarklet below and clicking on it. (does not work when Aquima runs in an iframe)
//
// javascript:(function(){var%20mvc='http://www.johangorter.com/goodies/aquima';var%20debugScript=document.createElement('script');debugScript.setAttribute('src',mvc+'/debug/debug.js?cachekiller='+new%20Date().getTime());document.body.appendChild(debugScript);})()
 
(function() {
    // Quit if loaded twice
    if (window.debugjsloaded) return;
    if (!window.YAHOO || !window.aquima || !aquima.mvc || !aquima.mvc.Util) {
        alert('Aquima engine not available');
        return;
    }   
    window.debugjsloaded = true;
 
    var FIXED = 'fixed';
    if (YAHOO.env.ua.ie && (YAHOO.env.ua.ie<8)) {
        FIXED='absolute';
    }
    
    var showImmediately = document.body !=null;
 
    // Imports
    var Event = YAHOO.util.Event;
    var Dom = YAHOO.util.Dom;
    var Util = aquima.mvc.Util;
    var a = Util.createElementFactory('a');
 
    var Settings = aquima.mvc.Settings;
   
    var div = Util.createElementFactory('div');
    var span = Util.createElementFactory('span');
    var button = Util.createElementFactory('button');
    var textarea = Util.createElementFactory('textarea');
   
    var inspectSetVisible = null; // function will be set later
    var inspectSetController = null; // function will be set later
   
    // Enables console logging for command-line interface
    function enableLogging() {
        if (window.console && window.console.debug && window.console.debug.apply) aquima.mvc.Log.debug = function() { window.console.debug.apply(window.console, arguments) };
        if (window.console && window.console.info && window.console.info.apply) aquima.mvc.Log.info = function() {window.console.info.apply(window.console, arguments)};
        if (window.console && window.console.warn && window.console.warn.apply) aquima.mvc.Log.warn = function() { window.console.warn.apply(window.console, arguments) };
        aquima.mvc.Log.info("Aquima MVC Command line interface enabled, type 'help' for a list of commands");
    }
    enableLogging();
 
    // Start logging response times   
    var roundTripTime = null;
    var oldPost = aquima.Engine.prototype.post;
    aquima.Engine.prototype.post = function() {
        oldPost.apply(this, arguments);
        aquima.mvc.Log.debug('requesting new page');
        roundTripTime = new Date().getTime();
    }
   
    var oldProcessNewPage = aquima.Engine.prototype.processNewPage;
    aquima.Engine.prototype.processNewPage = function() {
        var time = new Date().getTime();
        if (roundTripTime!=null) {
            roundTripTime = new Date().getTime() - roundTripTime;
            aquima.mvc.Log.debug('new page received after '+roundTripTime+'ms');
            roundTripTime = null;
        } else {
            aquima.mvc.Log.debug('new page received');
        }
        oldProcessNewPage.apply(this, arguments);
        time = new Date().getTime() - time ;
        aquima.mvc.Log.debug('new page processed in '+time+'ms');
    }
    
    // Hack to obtain where controllers were created from, 
    // accessable in Firefox from aController.config.createdFrom
    var oldControllerConstructor = aquima.mvc.Controller.prototype.constructor;
    aquima.mvc.Controller.prototype.constructor = function (config) {
        config = config || {};
        try { i.dont.exist++; } catch (e) {
            if (e.stack) {
                var match = /\/[\w-]+factories.js[^:]*:\d+/.exec(e.stack);
                if (match) {
                    config['createdfrom'] = match[0];
                }
            }
        }
        return oldControllerConstructor.call(this, config)
    }

    // Hack to obtain where inputs were created from, 
    // accessible in Firefox from aController.input.config.createdFrom (not visible in mvc tools, use the javascript console)
    var oldInputConstructor = aquima.mvc.Input.prototype.constructor;
    aquima.mvc.Input.prototype.constructor = function (config) {
        config = config || {};
        try { i.dont.exist++; } catch (e) {
            if (e.stack) {
                var match = /\/[\w-]+factories.js[^:]*:\d+/.exec(e.stack);
                if (match) {
                    config['createdfrom'] = match[0];
                }
            }
        }
        return oldInputConstructor.call(this, config)
    }
   
    // Utility functions
    function setStyle(el, style) {
        for(var att in style) {
            el.style[att]=style[att];
            if (att=='cssFloat') {
                el.style['styleFloat']=style[att];
            }
        }
    }
   
    // Initializes Main UI
    function initUI() {
   
        // UI
        var ui = {tabs:{}, pages:{}}
       
ui.main =       div(
ui.header =         div(
ui.show =               div('<<'),
ui.title =              div('Aquima MVC tools'),
ui.hide =               div('>>')
                    ),
ui.tabHeaders =     div(
ui.tabs.inspect =       div('Inspect'),
ui.tabs.recplay =       div('Rec/Play'),
ui.tabs.more =          div('More'),
ui.tabsBottomLine =     div()
                    ),
ui.tabArea =        div(
ui.pages.inspect =      initInspect(),
ui.pages.recplay =      initRecPlay(),
ui.pages.more =         initMore()
                    )
                );
       
        setStyle(ui.main, {
            position: FIXED, overflow:'hidden', textAlign:'left',
            top:'10px', right:'0px', width: '300px', height: '500px',
            border: 'solid 1px #00ABC4', backgroundColor: 'white', zIndex: '500010',
            fontFamily: 'Arial, Helvetica', fontSize: '12px', lineHeight: '16px'
        });
        setStyle(ui.header, {color: 'white', backgroundColor: '#00ABC4', fontWeight: 'bold', height: '18px'});
        setStyle(ui.show, {cssFloat: 'left', paddingLeft: '2px', display: 'none', cursor: 'pointer'});
        setStyle(ui.title, {cssFloat: 'left', paddingLeft: '3px'});
        setStyle(ui.hide, {cssFloat: 'right', paddingRight: '2px', cursor: 'pointer'});
        setStyle(ui.tabHeaders, {height: '20px', textAlign: 'center', overflow:'hidden', position:'relative', lineHeight: '14px'});
        setStyle(ui.tabs.inspect, {left: '5px',   top: '2px', width: '60px', height:'17px', color: '#00ABC4', backgroundColor: 'white', position:'absolute', overflow:'hidden', border: 'solid 2px #00ABC4'})
        setStyle(ui.tabs.recplay, {left: '75px',  top: '2px', width: '60px', height:'17px', color: '#00ABC4', backgroundColor: 'white', position:'absolute', overflow:'hidden', border: 'solid 2px #00ABC4'})
        setStyle(ui.tabs.more,    {left: '145px', top: '2px', width: '60px', height:'17px', color: '#00ABC4', backgroundColor: 'white', position:'absolute', overflow:'hidden', border: 'solid 2px #00ABC4'})
        setStyle(ui.tabsBottomLine, {height: '0px', width: '100%', borderBottom: 'solid 2px #00ABC4', left:'0px', top:'18px', position:'absolute', zIndex:1});
        setStyle(ui.tabArea, {width:'300px', height: '461px', overflow: 'hidden'});
       
        // Attributes and functions
        var tabs = [ui.tabs.inspect, ui.tabs.recplay, ui.tabs.more];
        var pages = [ui.pages.inspect, ui.pages.recplay, ui.pages.more];
        var activeTab;
       
        function hide() {
            ui.show.style.display='block';
            ui.title.style.display='none';
            ui.hide.style.display='none';
            ui.main.style.width='20px';
            ui.main.style.height='17px';
            ui.tabArea.style.display='none';
            inspectSetVisible(false);
        };
 
        function show() {
            ui.show.style.display='none';
            ui.title.style.display='block';
            ui.hide.style.display='block';
            ui.main.style.width='300px';
            ui.main.style.height='500px';
            ui.tabArea.style.display='block';
            inspectSetVisible(activeTab == ui.tabs.inspect);
        };
 
        function setActiveTab(event, tab) {
            activeTab = tab;
            for (var i=0;i<tabs.length;i++) {
                var t = tabs[i];
                var p = pages[i];
                if (t==tab) {
                    t.style.cursor = 'default';
                    t.style.zIndex = 2;
                    p.style.display = 'block';
                } else {
                    t.style.cursor = 'pointer';
                    t.style.zIndex = 0;
                    p.style.display = 'none';
                }
            }
            inspectSetVisible(activeTab == ui.tabs.inspect);
        }
       
        // Initialization
        setActiveTab(null, ui.tabs.inspect);
       
        Event.on(ui.hide, 'click', hide);
        Event.on(ui.show, 'click', show);
        Event.on(ui.tabs.inspect, 'click', setActiveTab, ui.tabs.inspect);
        Event.on(ui.tabs.recplay, 'click', setActiveTab, ui.tabs.recplay);
        Event.on(ui.tabs.more, 'click', setActiveTab, ui.tabs.more);
        window.showMVCTools = show;
        document.body.appendChild(ui.main);
        if (showImmediately) {
            show();
        } else {
            hide();
        }
        // Load the YUI Get utility to enable loading external scripts later
        if (!YAHOO.util.Get) {
            var getScript=document.createElement('script');
            getScript.setAttribute('src','http://yui.yahooapis.com/2.8.0r4/build/get/get-min.js');
            document.body.appendChild(getScript);
        }
    }
   
    // Initializes Inspect tab
    function initInspect() {
   
        // UI
        var ui = {};
ui.main =       div(
ui.parentLabel =    div('Parent:',
ui.parent =             div('')
                    ),
ui.selectedLabel =  div('Selected:',
ui.selected =           div('')
                    ),
ui.showDetails =    button({disabled:true},'Details'),
ui.childrenLabel =  div('Children:',
ui.children =           div()
                    )
                );
       
        setStyle(ui.parentLabel,    {color:'#AAAAAA', height:'40px'});
        setStyle(ui.parent,         {border: '1px dashed white', display:'block', color:'black', cursor: 'pointer', textDecoration: 'underline', whiteSpace:'nowrap'});
        setStyle(ui.selectedLabel,  {color:'#AAAAAA', height:'40px'});
        setStyle(ui.selected,       {border: '2px dashed #00ABC4', display:'none', color:'black', whiteSpace:'nowrap'});
        setStyle(ui.childrenLabel,  {color:'#AAAAAA'});
        setStyle(ui.children,       {display:'block', color:'black', textDecoration: 'underline', overflow: 'auto', height:'140px'});
       
        // Selection border
        var borderTop = div(span());
        var borderRight = div();
        var borderBottom = div(span());
        var borderLeft = div();
        setStyle(borderTop,     {zIndex:'500009', borderBottom: '2px dashed #00ABC4', position: 'absolute', display: 'none', height:'15px', 
                                 color:'#00ABC4', fontFamily: 'Arial, Helvetica', fontSize: '12px', lineHeight: '16px'});
        setStyle(borderRight,   {zIndex:'500009', borderRight:  '2px dashed #00ABC4', position: 'absolute', display: 'none', width:'0px'});
        setStyle(borderBottom,  {zIndex:'500009', borderTop:    '2px dashed #00ABC4', position: 'absolute', display: 'none', height:'15px', 
                                 color:'#00ABC4', fontFamily: 'Arial, Helvetica', fontSize: '12px', lineHeight: '16px'});
        setStyle(borderLeft,    {zIndex:'500009', borderLeft:   '2px dashed #00ABC4', position: 'absolute', display: 'none', width:'0px'});
        setStyle(borderTop.firstChild, {backgroundColor:'white', lineHeight:'1'});
        setStyle(borderBottom.firstChild, {backgroundColor:'white', lineHeight:'1'});
        document.body.appendChild(borderTop);
        document.body.appendChild(borderRight);
        document.body.appendChild(borderBottom);
        document.body.appendChild(borderLeft);
       
        // Details panel
        ui.details = {};
ui.details.main =   div(
                        'Controller: ',
ui.details.title =      span(),
ui.details.close =      button('close'),
                        div('Config:'),
ui.details.config =     textarea({readOnly:true}),
                        div('Model:'),
ui.details.model =      textarea({readOnly:true}),
ui.details.input =      span()
                    );
       
        setStyle(ui.details.main, {
            position:FIXED, zIndex: '500011',
            right:'350px', top:'10px', width: '500px', height:'496px',
            fontFamily: 'Arial, Helvetica', fontSize: '12px', lineHeight: '16px',
            backgroundColor:'#00ABC4', color: 'white', display:'none', padding: '3px'
        });
        setStyle(ui.details.close, {cssFloat:'right'});
        setStyle(ui.details.config, {position:'relative', left:'10px', height:'150px', width:'480px'});
        setStyle(ui.details.model,  {position:'relative', left:'10px', height:'272px', width:'480px'});
        document.body.appendChild(ui.details.main);
       
        // attributes and functions
        var visible = false;
        var controller = null;
        var childrenDivs = [];
        var oldChildren = [];
        var oldParent = null;
       
        function setVisible(newVisible) {
            if (visible==newVisible) return;
            visible = newVisible;
            updateBorder();
        }
        
        function setController(newController) {
            controller = newController;
            hideDetails();
            updateBorder();
        }
       
        function selectParent() {
            setController(controller.parent);
            logClickedController(controller);
        }
       
        function selectChild(event, controller) {
            setController(controller);
            logClickedController(controller);
        }
       
        function showDetails() {
            if (controller) {
                var config = window.stringify(controller.config);
                var model = window.stringify(controller.model);
                Util.setText(ui.details.title, controller.toString());
                ui.details.config.value = config;
                ui.details.model.value = model;
                ui.details.main.style.display = 'block';
                if (controller.input) {
                    Util.setText(ui.details.input, 'Input: '+controller.input);
                } else {
                    Util.setText(ui.details.input,'');
                }
            }
        }
       
        function hideDetails() {
            ui.details.main.style.display = 'none';
        }
       
        function createChildDiv(childController) {
            var result = div(childController.toString());
            Event.on(result, 'click', selectChild, childController);
            setStyle(result, {cursor: 'pointer', whiteSpace:'nowrap'});
            return result;
        }
 
        function destroyChildDivs(divs) {
            for (var i=0;i<divs.length;i++) {
                destroyChildDiv(divs[i]);
            }
        }
       
        function destroyChildDiv(div) {
            Event.removeListener(div, 'click', selectChild);
        }
        
        function hideBorder() {
            borderTop.style.display = 'none';
            borderRight.style.display = 'none';
            borderBottom.style.display = 'none';
            borderLeft.style.display = 'none';
        }
        
        function showBorder(region) {
            setStyle(borderTop,    {'display':'block', 'left':region.left+'px', 'top':(region.top-15)+'px', 'width': region.width+'px'});
            setStyle(borderRight,  {'display':'block', 'left':(region.left+region.width)+'px', 'top':region.top+'px', 'height': region.height+'px'});
            setStyle(borderBottom, {'display':'block', 'left':region.left+'px', 'top':(region.top+region.height)+'px', 'width': region.width+'px'});
            setStyle(borderLeft,   {'display':'block', 'left':region.left+'px', 'top':region.top+'px', 'height': region.height+'px'});
        }
       
        function updateBorder() {
            if (visible && controller!=null && controller.viewNodes.length>0) {
                ui.showDetails.disabled = false;
                Util.setText(ui.selected, controller.toString());
                if (oldParent != controller.parent) {
                    oldParent = controller.parent;
                    if (controller.parent) {
                        Util.setText(ui.parent, controller.parent.toString());
                    } else {
                        Util.setText(ui.parent, '');
                    }
                }
                var newChildDivs = [];
                if (controller.children) {
                    if (!Util.arrayEquals(controller.children, oldChildren)) {
                        oldChildren = [];
                        for (var i=0;i<controller.children.length;i++) {
                            oldChildren.push(controller.children[i]);
                            newChildDivs.push(createChildDiv(controller.children[i]));
                        }
                        Util.removeAllChildren(ui.children);
                        Util.replaceChildNodes(ui.children, newChildDivs);
                        destroyChildDivs(childrenDivs);
                        childrenDivs = newChildDivs;
                    }
                } else {
                    oldChildren = [];
                    Util.removeAllChildren(ui.children);
                }
                if (Dom.getXY(controller.viewNodes[0])) {
                    var regions = Dom.getRegion(controller.viewNodes);
                    var union = null;
                    for (var i=0;i<regions.length;i++) {
                        var region = regions[i];
                        if (region) {
                            if (!union) {
                                union = region;
                            } else {
                                union = union.union(region);
                            }
                        }
                    }
                    ui.selected.style.display = 'block';
                    union.left = union.left-4;
                    union.top = union.top-4;
                    union.width = union.width+4;
                    union.height = union.height+4;
                    var top = '';
                    
                    if (controller.model.name) {top = controller.model.name;};
                    if (controller.model.id && controller.model.name) {top=top+' @ ';}
                    if (controller.model.id) {top = top+controller.model.id;}
                    Util.setText(borderTop.firstChild, top);
                    var bottom = controller['package']+'.'+controller['class'];
                    if (controller.input) {bottom += ' + '+controller.input;}
                    Util.setText(borderBottom.firstChild, bottom);
                    showBorder(union);
                    setTimeout(updateBorder, 250);
                } else {
                    hideBorder();
                }
            } else {
                hideDetails();
                ui.details.disabled = true;
                ui.selected.style.display = 'none';
                hideBorder();
                Util.setText(ui.parent, '');
                Util.setText(ui.selected, '');
                Util.removeAllChildren(ui.children);
                destroyChildDivs(childrenDivs);
                childrenDivs=[];
            }
        }
       
        // Initialization
        Event.on(ui.parent, 'click', selectParent);
        Event.on(ui.showDetails, 'click', showDetails);
        Event.on(ui.details.close, 'click', hideDetails);
        inspectSetController = setController;
        inspectSetVisible = setVisible;
        return ui.main;
    }
   
    // Initializes Rec/Play tab
    function initRecPlay() {
 
        // UI
        var ui = {buttons:{}};
ui.main =       div(
ui.buttonsBar =     div(
ui.buttons.rec =        button('Rec'),
ui.buttons.walk =       button('Walk'),
ui.buttons.run =        button('Run'),
ui.buttons.stop =       button({disabled: true}, 'Stop')
                    ),
ui.messages =       div(),
ui.area =           div(
ui.highlight =          div(),
ui.script =             textarea({wrap:'off'})
                    )
                );
 
        setStyle(ui.buttonsBar, {height: '23px', overflow:'hidden', position:'relative'});
        setStyle(ui.messages, {height: '18px', color: 'red', overflow: 'hidden', whiteSpace: 'nowrap', overflow:'hidden', position:'relative'});
        setStyle(ui.area, {width: '100%', height: '420px', fontSize:'10px', overflow:'hidden', position:'relative'})
        setStyle(ui.highlight, {position:'absolute', top:'0px', left:'0px', width:'100%', marginTop:'2px', height:'15px', backgroundColor:'yellow'});
        setStyle(ui.script, {position:'absolute', width:'296px', height: '418px', overflow:'scroll', lineHeight:'15px', fontFamily: 'Arial, Helvetica', color:'black', backgroundColor:'transparent', zIndex:'1'});
 
        if (!textarea().wrap) { // firefox bug
            ui.script.setAttribute('wrap', 'off');
        }
       
        // attributes and functions
        var highlightLine=0;
        var PlayState = {IDLE:'Idle', RECORDING:'Recording', WALKING:'Playing', Running:'Running'}
        var playState = PlayState.IDLE;
        var recordEngine = null;
        var lastPageName = null;
        var playTimeout = null;
   
        function highlight(line, color) {
            highlightLine = line;
            ui.highlight.style.backgroundColor=color;
            positionHighlight();
        }
       
        function showMessage(message) {
            var messages = ui.messages;
            while (messages.firstChild) { messages.removeChild(messages.firstChild) };
            messages.appendChild(document.createTextNode('' + message));
            messages.title = '' + message;
        }
       
        function positionHighlight() {
            var scroll = ui.script.scrollTop;
            ui.highlight.style.top=(highlightLine*15-scroll)+'px';
        }
       
        function addLine(line) {
            if (ui.script.value=='') {
                ui.script.value = line;
            } else {
                ui.script.value += '\n'+line;
            }
        }
       
        function setPlayState(state) {
            switch (state) {
                case PlayState.RECORDING:
                case PlayState.RUNNING:
                case PlayState.WALKING:
                    ui.buttons.rec.disabled = true;
                    ui.buttons.walk.disabled = true;
                    ui.buttons.run.disabled = true;
                    ui.buttons.stop.disabled = false;
                    break;
                case PlayState.IDLE:
                    ui.buttons.rec.disabled = false;
                    ui.buttons.walk.disabled = false;
                    ui.buttons.run.disabled = false;
                    ui.buttons.stop.disabled = true;
                    break;
            };
            playState = state;
        }
       
        function recordClick() {
            recordEngine = getEngine();
            lastPageName = null;
            startRecording();
            engineStateChanged();
        }

        function startRecording() {
            recordEngine.inputChanged.subscribe(engineInputChanged);
            recordEngine.buttonClicked.subscribe(engineButtonClicked);
            recordEngine.stateChanged.subscribe(engineStateChanged);
            recordEngine.terminating.subscribe(engineTerminating);
            setPlayState(PlayState.RECORDING);
            addLine('open '+location.pathname+location.search);
        }
 
        function walkClick() {
            prepareRun(PlayState.WALKING)
            executeFirstStep();
        }
 
        function runClick() {
            prepareRun(PlayState.RUNNING)
            executeFirstStep();
        }
       
        function stopClick() {
            if (playState == PlayState.RECORDING) {
                recordEngine.inputChanged.unsubscribe(engineInputChanged);
                recordEngine.buttonClicked.unsubscribe(engineButtonClicked);
                recordEngine.stateChanged.unsubscribe(engineStateChanged);
                recordEngine.terminating.unsubscribe(engineTerminating);
                recordEngine = null;
            }
            if (playState == PlayState.WALKING || playState == PlayState.RUNNING) {
                if (playTimeout!=null) {
                    clearTimeout(playTimeout);
                    playTimeout = null;
                }
            }
            setPlayState(PlayState.IDLE);
        }
       
        function prepareRun(state) {
            if (getEngine().state.state!='Idle') {
                return;
            }   
            showMessage('');
            highlightLine=0;
            setPlayState(state);
        }
       
        function executeFirstStep() {
            executeStep();
        }
       
        function executeNextStep() {
            var state = getEngine().state.state;
            if (state!='Idle') {
                if (state == 'Refreshing' || state == 'Submitting') {
                    playTimeout = setTimeout(executeNextStep, 50);
                } else {
                    stopClick();
                }
            } else {
                highlightLine++;
                executeStep();
            }
        }

        var commandRegex = /^\s*(\w+)(\s+((\S+?)(#(\d+))?(\s+(.+))?))?$/;

        function parse(command) {
            var match = commandRegex.exec(command);
            if (!match) {
                throw new Error('Could not parse command: '+ command);
            }
            return {
                commandName: match[1],
                arg1: match[3],
                elementName: match[4],
                index: match[6] || 1,
                arg2: match[8]
            };
        }

        function run(parsedCommand) {
            switch (parsedCommand.commandName) {
                case 'setValue':
                    set(parsedCommand.elementName, (parsedCommand.index-1), eval(parsedCommand.arg2));
                    return
                case 'click':
                    buttonClick(parsedCommand.elementName, (parsedCommand.index-1));
                    return
                case 'open':
                    return
                case 'assertPage':
                    var pageName = getEngine().rootController.model.name;
                    if (pageName!=parsedCommand.arg1) {
                        throw new Error('Expected page '+parsedCommand.arg1+' but was '+pageName);
                    }
                    return
            }
            throw new Error('commandName not understood: '+parsedCommand.commandName)
        }

        function executeStep() {
            var script = ui.script.value;
            var commands = ui.script.value.split('\n');
            var command = commands[highlightLine];
            command = /^\s*(.*?)\s*$/.exec(command)[1]; // trim
            try {
                if (command) {
                    var parsedCommand = null;
                    try {
                        parsedCommand = parse(command);
                    } catch (e) {
                        eval(command); // Backwards compatibility: execute as javascript
                    }
                    if (parsedCommand) {
                        run(parsedCommand);
                    }
                }
            } catch (e) {
                showMessage(''+(e.message || e));
                highlight(highlightLine, 'red');
                playTimeout = null;
                stopClick();
                return;
            }
            highlight(highlightLine, 'lightgreen');
            if (highlightLine<commands.length-1) {
                playTimeout = setTimeout(executeNextStep, playState==PlayState.WALKING?1000:50);
            } else {
                playTimeout = null;
                setPlayState(PlayState.IDLE);
                showMessage('Script is succesvol uitgevoerd');
            }
        }
       
        function engineInputChanged(type, args) {
            var input = args[0];
            addLine(createInputChangedScriptLine(recordEngine, type, input));
        }

        function valueAsString(value) {
            if (typeof value == 'string') {
                return '"'+value.replace('"','\\"')+'"';
            }
            return ''+value;
        }

        function createInputChangedScriptLine(engine, type, input) {
            var index = indexOfController(engine, input.fieldController || input.inputController); // inputcontroller:pre-8.0
            var value = input.getValue();
            if (YAHOO.lang.isArray(value)) {
                var valueString = '[';
                for (var i = 0; i < value.length; i++) {
                    if (i != 0) { valueString = valueString + ','; }
                    valueString += valueAsString(value[i]);
                }
                valueString += ']';
                value = valueString;
            } else {
                value = valueAsString(value);
            }
            var name = input.model.name;
            if (index>0) {
                name = name + '#'+(index+1);
            }
            return 'setValue ' + name + ' ' + value;
        }

        function engineStateChanged(type, args) {
            if (recordEngine.state.state == 'Idle') {
                var pageName = recordEngine.rootController.model.name;
                if (pageName != lastPageName) {
                    addLine('assertPage '+pageName);
                    lastPageName = pageName;
                }
            }
        }

        function engineButtonClicked(type, args) {
            var button = args[0];
            var index = indexOfController(recordEngine, button);
            var name = button.model.name;
            if (index>0) {
                name = name + '#'+(index+1);
            }
            addLine('click ' + name);
        }
       
        function engineTerminating() {
            stopClick();
            setPlayState(PlayState.IDLE);
        }
       
        // Initialization
        if (window.aquima.mvc.runningEngines.length == 1) {
            recordEngine = window.aquima.mvc.runningEngines[0];
            startRecording();
        } else {
            aquima.mvc.engineStarting.subscribe(
                function (type, args) {
                    if (window.aquima.mvc.runningEngines.length == 0) {
                        if (playState == PlayState.IDLE) {
                            recordEngine = args[0];
                            startRecording();
                        }
                    }
                }
            );
        }

        Event.on(ui.buttons.rec, 'click', recordClick);
        Event.on(ui.buttons.walk, 'click', walkClick);
        Event.on(ui.buttons.run, 'click', runClick);
        Event.on(ui.buttons.stop, 'click', stopClick);
        Event.on(ui.script, 'scroll', positionHighlight);
 
        return ui.main;
    }
   
    // Initializes More tab
    function initMore() {
   
        var reloadStylesheetInterval = null;
        
        // UI
        var ui = {};
ui.main =   div(
ui.cliText =    div('Command line interface',
ui.cli =            button('Re-enable')
                ),
ui.animText =   div('Animations',
ui.anim =           button(Settings.defaultControllerConfig.animate?'Disable':'Enable')
                ),
ui.styleText =  div('Stylesheets auto reload',
ui.styleReload =    button('Start')
                ),
ui.pageText =   div('Page',
ui.reload =         button('Reload'),
ui.rebuild =        button('Rebuild')
                ),
ui.externText = div('External tools'),
ui.firebug =    a({href: '#'}, 'Firebug lite'),
ui.fuzz =       a({href: '#'}, 'Fuzz testing')
            );
        setStyle(ui.main, {paddingLeft:'3px',paddingTop:'3px',paddingRight:'3px', position:'relative'});
        setStyle(ui.cliText, {height:'25px', paddingTop:'2px', position:'relative'});
        setStyle(ui.cli, {position:'absolute', right:'0px', top: '0px'});
        setStyle(ui.animText, {height:'25px', paddingTop:'2px', position:'relative'});
        setStyle(ui.anim, {position:'absolute', right:'0px', top: '0px'});
        setStyle(ui.styleText, {height:'25px', paddingTop:'2px', position:'relative'});
        setStyle(ui.styleReload, {position:'absolute', right:'0px', top: '0px'});
        setStyle(ui.pageText, {height:'25px', paddingTop:'2px', position:'relative'});
        setStyle(ui.reload, {position:'absolute', right:'80px', top: '0px'});
        setStyle(ui.rebuild, {position:'absolute', right:'0px', top: '0px'});
        setStyle(ui.externText, {clear:'both', fontWeight:'bold'});
        setStyle(ui.firebug, {display:'block', paddingLeft: '25px', paddingTop:'4px', paddingBottom:'4px', background:'url("http://getfirebug.com/releases/lite/1.2/firebug.gif") no-repeat scroll left 5px transparent'});
        setStyle(ui.fuzz,    {display:'block', paddingLeft: '25px', paddingTop:'4px', paddingBottom:'4px', marginTop:'4px'});
       
        // attributes and functions
        function reEnableCli() {
            enableLogging();
        }
       
        function toggleAnim() {
            Settings.defaultControllerConfig.animate = !Settings.defaultControllerConfig.animate;
            Util.setText(ui.anim, Settings.defaultControllerConfig.animate?'Disable':'Enable');
            rebuildPage();
        }
        
        function reload() {
            getEngine().refresh(null, null);
        }
        
        function toggleReloadStylesheets() {
            if (reloadStylesheetInterval) {
                clearInterval(reloadStylesheetInterval);
                reloadStylesheetInterval = null;
                Util.setText(ui.styleReload, 'Start');
            } else {
                reloadStylesheetInterval = setInterval(reloadStylesheets, 1000);
                Util.setText(ui.styleReload, 'Stop');
            }
        }

        function reloadStylesheets() {
            var stylesheets = document.getElementsByTagName('link');
            for (var i=0;i<stylesheets.length;i++) {
                var stylesheet = stylesheets[i];
                if (stylesheet.rel && stylesheet.rel.indexOf('style')>=0) {
                    var href = stylesheet.href;
                    if (href.indexOf('timestamp')>=0) {
                        href = href.substr(0, href.indexOf('timestamp')-1);
                    }
                    if (href.indexOf('?')>=0) {
                        href = href+'&';
                    } else {
                        href = href+'?';
                    }
                    href = href+'timestamp='+new Date().getTime();
                    stylesheet.href = href;
                }
            }
        }
       
        var fuzzTestScriptLoaded = false;
        var firebugLoaded = false;
        var fuzztestConfig = { baseUrl: 'http://www.johangorter.com/goodies'};
        // Allow this config to be changed using javascript
        window.fuzztestConfig = fuzztestConfig;
        try { top.fuzztestConfig = fuzztestConfig; } catch (ex) {}
        
        var engine = null;
       
        function firebugLite(e) {
            if (!firebugLoaded) {
                YAHOO.util.Get.script('http://getfirebug.com/releases/lite/1.2/firebug-lite-compressed.js', {
                    onSuccess: function() {firebugLoaded=true; firebug.init(); reEnableCli();}
                });
            }
            Event.preventDefault(e);
        }
       
        function fuzztest(e) {
            if (!fuzzTestScriptLoaded) {
                YAHOO.util.Get.script([
                        fuzztestConfig.baseUrl+'/fuzztester/fuzztester.js?cachekiller='+new Date().getTime(),
                        fuzztestConfig.baseUrl+'/aquima/fuzztester/aquimafuzztester.js?cachekiller='+new Date().getTime()
                    ],{
                        onSuccess: function() {fuzzTestScriptLoaded=true;}
                    }
                );
            }
            Event.preventDefault(e);
        }
       
        // Initialization
        Event.on(ui.cli, 'click', reEnableCli);
        Event.on(ui.anim, 'click', toggleAnim);
        Event.on(ui.styleReload, 'click', toggleReloadStylesheets);
        Event.on(ui.reload, 'click', reload);
        Event.on(ui.rebuild, 'click', function() {rebuildPage();});
        Event.on(ui.firebug, 'click', firebugLite);
        Event.on(ui.fuzz, 'click',fuzztest);
        return ui.main;
    }
   
 
    // Initialize UI as soon as the DOM is ready
    Event.onDOMReady(initUI);
   
    function findControllerByName(engine, name, index) {
        function find(controller) {
            if (controller.model.name == name) {
                if (index>0) {
                    index--;
                } else {
                    return controller;
                }
            }
            if (controller.children) {
                for (var i = 0; i<controller.children.length; i++) {
                    var child = controller.children[i];
                    var result = find(child);
                    if (result!=null) return result;
                }
            }
            return null;
        }
        return find(engine.rootController)
    }
   
    function indexOfController(engine, controller) {
        var tryIndex = 0;
        while(true) {
            var result = findControllerByName(engine, controller.model.name, tryIndex);
            if (result == null) throw new Error('controller not found');
            if (result == controller) return tryIndex;
            tryIndex++;
        }
    }
   
    function selectController(ev) {
        var target = YAHOO.util.Event.getTarget(ev);
        try {
            while (target!=document.body && target!=null) {
                var controller = findControllerFrom(target);
                if (controller!=null) {
                    logClickedController(controller)
                    inspectSetController(controller);
                    return true;
                }
                target = target.parentNode;
            }
        } catch (e) {}
        return true;
    }
   
    function logClickedController(controller) {
        aquima.mvc.Log.debug('Selected controller (sc=):', controller);
        window.sc = controller;
        if (top!=window) {
            try {
                top.sc = controller;
            } catch (e) {}
        }
    }

    // Search for a controller with the specified id
    // The fromController parameter is optional
    function findControllerFrom(node, fromController) {
        if (fromController!=null) {
            if (fromController.children!=null) {
                for (var i = 0; i < fromController.children.length;i++) {
                    var result = findControllerFrom(node, fromController.children[i]);
                    if (result!=null) return result;
                }
            }
            if (YAHOO.lang.isString(node)) {
                if (fromController.model.id==node) return fromController;
            } else {
                for (var i = 0; i<fromController.viewNodes.length; i++) {
                    if (fromController.viewNodes[i]==node) return fromController;
                }
            }
        } else {
            for (var i = 0; i < aquima.mvc.runningEngines.length;i++) {
                var engine = aquima.mvc.runningEngines[i];
                if (engine.rootController == null) return null;
                var result = findControllerFrom(node, engine.rootController);
                if (result!=null) return result;
            }
        }
    }
    
    // Global functions which can be used from a console for debugging
    var globals = {
        help:'\n'+ 
            'getEngine()                      - returns the Aquima MVC Engine\n'+
            'findController(id)               - Returns the controller which has the specified id\n'+
            'rebuildPage()                    - Recreates all controllers\n'+
            'select(controller)               - Selects the specified controller\n'+
            'stringify(data)                  - Converts an object to JSON\n'+
            'set(name, indexOrValue[, value]) - Used in rec/play\n'+
            'buttonClick(name[, index])       - Used in rec/play\n'+
            'sc                               - The currently selected controller\n',
        
        // Gets the only Engine
        getEngine: function() {
            var engines = aquimaFrame.aquima.mvc.runningEngines;
            if (engines.length!=1) throw new Error('No engine found');
            return engines[0];
        },
        
        // Search for a controller with the specified id
        findController: function(node) {
            return findControllerFrom(node);
        },
        
        // Will be called from the rec/play functionality
        // index is 0-based.
        'set': function (attributeName, indexOrValue, value) {
            var index;
            if (value==null) {
                value = indexOrValue;
                index = 0;
            } else {
                index = indexOrValue;
            }
            var controller = findControllerByName(getEngine(), attributeName, index);
            if (controller==null || controller.input==null)
                throw new Error('Input with attribute name '+attributeName+' at index '+(index+1)+' not found');
            controller.input.updateValue(value);
            controller.input.valueChanged(null);
        },
        
        // Will be called from the rec/play functionality
        // index is 0-based.
        buttonClick: function (buttonName, index) {
            if (index == null) {
                index = 0;
            }
            var controller = findControllerByName(getEngine(), buttonName, index);
            if (controller == null) {
                throw new Error('Button with name ' + buttonName + ' at index ' + (index + 1) + ' not found');
            }
            controller.onClick(null);
        },
        
        // Display in JSON format        
        stringify: function(data) {
            return YAHOO.lang.JSON.stringify(data, null, 2);
        },
        
        // Recreates all controllers        
        rebuildPage: function() {
            var engine = getEngine();
            var model = engine.rootController.model;
            engine.createRootController(model);
            engine.rootController.init(model);
            Util.replaceChildNodes(engine.aquimaDiv, engine.rootController.viewNodes);
        },
        
        select: function(controller) {
            logClickedController(controller)
            inspectSetController(controller);
        },
        
        aquimaFrame: window
    }
    
    YAHOO.lang.augmentObject(window, globals);
    if (top!=window) { // We are inside a frame
        try {
            YAHOO.lang.augmentObject(top, globals);
        } catch (e) {}
    }
   
    // Register onclick handler which logs the selected controller   
    YAHOO.util.Event.onDOMReady(function() {
        YAHOO.util.Event.on(document.body,'click', selectController);
    });
   
    // Make Aquima return indented json for pages requested from the server
    function includeExtraInfo(type, args) {
        args[0].debug = true;
    }
   
    function subscribe(engine) {
        engine.beforeSubmit.subscribe(includeExtraInfo);
        engine.aquimaCallback.success = aquima.Engine.prototype.processNewPage; // We changed this function in this library
    }
   
    // Initialization
    for (var i=0; i< aquima.mvc.runningEngines.length; i++) {
        var engine = aquima.mvc.runningEngines[i];
        subscribe(engine);
        try { engine.refresh(null, null); } catch(e) {}
    }
    aquima.mvc.engineStarting.subscribe(function(type, args) {subscribe(args[0]);});
})()