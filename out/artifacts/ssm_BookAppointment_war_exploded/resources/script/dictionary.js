function Dictionary(){//字典类
    var items={};//存储在一个Object的实例中

    this.has=function(key){//验证一个key是否是items对象的一个属性
        return key in items;
    };
    this.set=function(key,value){//设置属性
        items[key]=value;
    };
    this.remove=function(key){//移除key属性
        if(this.has(key)){
            delete items[key];
            return true;
        }
        return false;
    };
    this.get=function(key){//查找特定属性
        return this.has(key) ? items[key]:undefined;
    };
    this.values=function(){//返回所有value实例的值
        var values=new Array();//存到数组中返回
        for(var k in items){
            if(this.has(k)){
                values.push(items[k]);
            }
        }
        return values;
    };
    this.getItems=function(){//获取
        return items;
    };
    this.clear = function () {//清除
        items = {};
    };
    this.size = function () {//获取属性的多少
        return Object.keys(items).length;
    };
}