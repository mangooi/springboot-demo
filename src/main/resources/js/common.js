function loadNav(obj) {
    var temp = ['index',
        'Hello',
        'input_demo',
        'jsDemo',
        'ajaxDemo'
    ];
    temp.forEach(function (value) {
        var text1 = '<div class="menu" onclick="sectionLoad(';
        var text2 = "'";
        var text3 = value;
        var text4 = ')">' + value + '</div>';
        obj.innerHTML += (text1 + text2 + text3 + text2 + text4);
        console.log(value);
    })
}

function sectionLoad(name) {
    if (name === "index") {
        (function() {window.location.href = 'index.html';}());
        return;
    }
    // By Mapping
    var temp = name + '.html';
    document.getElementById('section').innerHTML =
        new TagTool().tagType('object').attr('type', 'text/html').attr('data', temp).attr('width', '100%').attr('height', '100%').endTag();
}


/*Tools Class*/

function StringBuilder() {
    this._stringArray = [];
    this.append = function (str) {
        this._stringArray.push(str);
        return this;
    };
    this.appendS = function () {
        this._stringArray.push(' ');
        return this;
    };
    this.appendE = function () {
        this._stringArray.push('=');
        return this;
    };
    this.appendDQ = function () {
        this._stringArray.push('"');
        return this;
    };
    this.toString = function () {
        return this._stringArray.join('');
    }
}

function TagTool() {
    this.text = new StringBuilder();
    this.type = null;
    this.tagType = function (type) {
        this.type = type;
        this.text.append('<').append(type);
        return this;
    };
    this.attr = function (att, value) {
        this.text.appendS().append(att).appendS().appendE().appendS().appendDQ()
            .append(value).appendDQ();
        return this;
    };
    this.endTag = function (innerText) {
        if (this.type == null) {
            console.log("please call tagType Method");
        }
        return this.text.append('>').append(innerText ? innerText : '').append('</')
            .append(this.type).append('>').toString();
    };
}

function test() {
    console.log(new TagTool().tagType('div').attr('class', 'testMethod').endTag('hello!'));
}
