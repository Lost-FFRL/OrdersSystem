define({
    ordQueTable :'<div id="{ordersQueryId}" class="{ordersCls}">'
        + '<table class="{tableCls}">'
        + '<tr>'
        + '<td class="{tdCls}"><span>{name}</span></td>'
        + '<td><input id="{nameId}" class="{inputCls}" type="text"></input></td>'
        + '<td class="{tdCls}"><span>{phone}</span></td>'
        + '<td><input id="{phoneId}" class="{inputCls}" type="text"></input></td>'
        + '</tr><tr>'
        + '<td class="{tdCls}"><span>{startTime}</span></td>'
        + '<td></td>'
        + '<td class="{tdCls}"><span>{endTime}</span></td>'
        + '<td></td>'
        + '</tr><tr>'
        + '<td class="{tdCls}"><span>{orderNum}</span>'
        + '</td>'
        + '<td><input id="orderNumId" class="{inputCls}" type="text"></input></td>'
        + '<td class="{tdCls}"><span>{status}</span></td>'
        + '<td><select id="{statusId}" class="{selCls}"><option selected="selected" value="">{pleaseSel}</option></select></td>'
        + '</tr><tr>'
        + '<td class="{tdCls}"><span>{customer}</span></td>'
        + '<td><select id="{customerId}" class="{selCls}"><option selected="selected" value="">{pleaseSel}</option></select></td>'
        + '<td class="{tdCls}"><span>{product}</span></td>'
        + '<td><select id="{productId}" class="{selCls}"><option selected="selected" value="">{pleaseSel}</option></select></td>'
        + '</tr><tr>'
        + '<td class="{tdCls}"><span>{expressType}</span></td>'
        + '<td><select id="{expressId}" class="{selCls}"><option selected="selected" value="">{pleaseSel}</option></select></td>'
        + '<td class="{tdCls}"><span>{payType}</span></td>'
        + '<td><select id="{payTypeId}" class="{selCls}"><option selected="selected" value="">{pleaseSel}</option></select></td>'
        + '</tr><tr><td></td>'
        + '<td ><div id="{ordAdd}" class="{normalBut}">{addBut}</div></td>'
        + '<td colspan="2"><div id="{ordQuery}" class="{normalBut}">{queryBut}</div></td>'
        + '</tr></table></div>',
    desktop : '<div id="content_area" class="content_area">' +
            '<div id="content_left">' +
                '<div id="content_left_top"></div>' +
                '<div id="content_left_mid"></div>' +
                '<div id="content_left_bottom"></div>' +
            '</div>' +
            '<div id="content_right">' +
                '<div id="content_right_top"></div>' +
                '<div id="content_right_mid"></div>' +
                '<div id="content_right_bottom"></div>' +
            '</div>' +
            '<div class="cleaner"></div>' +
            '</div>',
    nvgMenu : '<div id ="{id}" class="{cls}"><span>{name}</span></div>',
    search : '<div id="search_container">' +
            '<div id="search_top" class="search_top"></div>' +
            '<div id="search_mid" class="search_mid">{search}</div>' +
            '<div id="search_bottom" class="search_bottom"></div>' +
            '</div>',
    div : '<div id ="{id}"class="{cls}">{html}</div>',
    userQueTable: '<div id="{queryId}" class="{queryCls}">'
        + '<table class="{tableCls}">'
        + '<tr>'
        + '<td class="{tdCls}"><span>{name}</span></td>'
        + '<td><input id="{nameId}" class="{inputCls}" type="text"></input></td>'
        + '<td class="{tdCls}"><span>{phone}</span></td>'
        + '<td><input id="{phoneId}" class="{inputCls}" type="text"></input></td>'
        + '</tr><tr><td></td>'
        + '<td ><div id="{userAdd}" class="{normalBut}">{addBut}</div></td>'
        + '<td colspan="2"><div id="{userQuery}" class="{normalBut}">{queryBut}</div></td>'
        + '</tr></table></div>',
    proQueTable :  '<div id="{queryId}" class="{queryCls}">'
        + '<table class="{tableCls}">'
        + '<tr>'
        + '<td class="{tdCls}"><span>{name}</span></td>'
        + '<td><input id="{nameId}" class="{inputCls}" type="text"></input></td>'
        + '<td class="{tdCls}"><span>{proNum}</span></td>'
        + '<td><input id="{proId}" class="{inputCls}" type="text"></input></td>'
        + '</tr><tr><td></td>'
        + '<td ><div id="{proAdd}" class="{normalBut}">{addBut}</div></td>'
        + '<td colspan="2"><div id="{proQuery}" class="{normalBut}">{queryBut}</div></td>'
        + '</tr></table></div>',
    buyerQueTable: '<div id="{queryId}" class="{queryCls}">'
        + '<table class="{tableCls}">'
        + '<tr>'
        + '<td class="{tdCls}"><span>{name}</span></td>'
        + '<td><input id="{nameId}" class="{inputCls}" type="text"></input></td>'
        + '<td class="{tdCls}"><span>{phone}</span></td>'
        + '<td><input id="{phoneId}" class="{inputCls}" type="text"></input></td>'
        + '</tr><tr><td></td>'
        + '<td ><div id="{buyerAdd}" class="{normalBut}">{addBut}</div></td>'
        + '<td colspan="2"><div id="{buyerQuery}" class="{normalBut}">{queryBut}</div></td>'
        + '</tr></table></div>',
    expQueTable :  '<div id="{queryId}" class="{queryCls}">'
        + '<table class="{tableCls}">'
        + '<tr>'
        + '<td class="{tdCls}"><span>{name}</span></td>'
        + '<td><input id="{nameId}" class="{inputCls}" type="text"></input></td>'
        + '<td class="{tdCls}"><span>{proNum}</span></td>'
        + '<td><input id="{proId}" class="{inputCls}" type="text"></input></td>'
        + '</tr><tr><td></td>'
        + '<td ><div id="{expAdd}" class="{normalBut}">{addBut}</div></td>'
        + '<td colspan="2"><div id="{expQuery}" class="{normalBut}">{queryBut}</div></td>'
        + '</tr></table></div>',
    showData : '<div id="{id}" class="{cls}"><table></table></div>',
    artDiv: '<div id="<%=id%>" class="<%=cls%>"><%include("id")%></div>',
    queryTable: '<div id="<%=id%>" class="<%=cls%>">' 
        + '<table class="<%=tableCls%>">'
        + '<% for (i = 0; i < list.length; i++){ %>'
        + '<%   if (i != list.length - 1){ %>'
                + '<tr>'
                + '<td class="<%=list[i].nameCls%>"><span><%=list[i].showName%></span></td>'
                + '<%switch (list[i].type){ case 1:%>'
                + '<td><select id="<%=list[i].valId%>" class="<%=list[i].valCls%>">'
                + '<option selected="selected" value=""><%=list[i].defShow%></option></select></td>'
                + '<%break; case 2: break;%>'
                + '<%default:%>'
                + '<td><input id="<%=list[i].valId%>" class="<%=list[i].valCls%>" type="text"></input></td>'
                + '<%break;}%>'
                + '<td class="<%=list[i][5]%>"><span><%=list[i][6]%></span></td>'
                + '<td><input id="<%=list[i][7]%>" class="<%=list[i][8]%>" type="text"></input></td>'
                + '</tr>'
        + '<%   } else { %>'
                    + '<tr><td></td>'
                    + '<td><div id="<%=list[i][0]%>" class="<%=list[i]["1"]%>"><%=list[i]["2"]%></div></td>'
                    + '<td colspan="2"><div id="<%=list[i][3]%>" class="<%=list[i]["4"]%>"><%=list[i][5]%></div></td>'
                    + '</tr>'
        + '<% }}%>'
        + '</table></div>'
});