define(function(){
    /**
     * 模版转化
     * @param val
     * @returns
     */
    String.prototype.format = function(val){
        var newStr,reg = /(\{)(\w+)(\})/g;
        if (val){
            newStr = this.replace(reg,function($0,$1,$2){
                return val[$2] !== undefined ? val[$2] : $0;
            });
        }
        if (newStr.search(reg) !== -1){
            throw Error("Format not completed! string = " + newStr);
        }
        return newStr;
    };
    
    /**
     * 数组排序
     * type: 排序类型，值为1中文排序，其它默认排序
     * direct: 排序方向，正序(true)或反序(false)，默认正序。
     */
    Array.prototype.xsort = function(type, direct){
        switch(direct){
        case 1 :
            this.sort(function(a,b){
                return a.localeCompare(b);
            });
            break;
        default:
            this.sort();
        }
        if (direct === undefined){
            direct = 1;
        }
        if (!direct){
            this.reverse();
        }
    };
});