define({
    queryTable: '<div id="{{=it.id}}" class="{{=it.cls || ""}}">' 
        + '<table class="query_table">'
        + '{{~it.list :val }}'
            + '<tr>'
            + '<td>{{= val.first || ""}}</td>'
            + '<td>{{= val.second || ""}}</td>'
            + '</tr>'
        + '{{~}}'
        + '</table></div>',
    result: '<div id="{{=it.resultId || ""}}" class="{{=it.resultCls || "result_container"}}">'
        + '<div class="show_data">'
        + '<table id="{{=it.tableId || ""}}" class="data_table" ><thead>'
        + '<tr>'
        + '{{~it.thead :val}}'
        + '<th>{{=val}}</th>'
        + '{{~}}'
        + '</tr>'
        + '</thead><tbody>'
        + '</tobdy></table></div></div>',
    inputTd : '<span>{{=it.name}}</span><input id="{{=it.id}}" class="{{=it.cls}}" type="text"></input>',
    selectTd: '<span>{{=it.name}}</span><select id="{{=it.id}}" class="{{=it.cls}}">'
        + '<option selected="selected" value="">{{=it.pleaseSel}}</option></select>',
    norBut: '<div id="{{=it.id}}" class="normal_But">{{=it.name}}</div>',
    manageContainer: '<div id="{{=it.mcId || ""}}" class="{{=it.mcCls || "" }}">'
        + '{{#def.top}}'
        + '{{#def.mid}}'
        + '</div>',
    search : '<div id="search_container">' +
        '<div class="search_top"></div>' +
        '<div class="search_mid">{{#def.search}}</div>' +
        '<div class="search_bottom"></div>' +
        '</div>',
    dataTbody : '{{~it.data :val}}'
        + '<tr data_id="{{=val["id"]}}">'
        + '{{~it.model :mod :seq}}'
        + '{{? mod == "operate"}}'
        + '<td>'
        + '{{~it.operate :op }}'
        + '<span class="opreate" >{{=op || ""}}</span>'
        + '{{~}}'
        + '</td>'
        + '{{??}}'
        + '<td>{{=val[mod]}}</td>'
        + '{{?}}'
        + '{{~}}'
        + '</tr>'
        + '{{~}}'
        + '<tr><td colspan="{{=it.model.length}}">'
        + '{{#def.page}}'
        + '</td></tr>',
    page : '<div id="{{=it.page.id || ""}}" class="page">'
        + '<span class="previous">{{=it.page.previous}}</span>'
        + '<span class="current">0</span>&nbsp;&nbsp;/&nbsp;&nbsp;<span class="total">0</span>'
        + '<span class="next">{{=it.page.next}}</span>'
        + '</div>',
    form: '<div id={{=it.id || ""}} class="form"> '
    	+ ''
    	+ '</div>'
});