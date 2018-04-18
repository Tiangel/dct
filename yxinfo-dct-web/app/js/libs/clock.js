$(function(){
    function toDou(n){
        return n<10?"0"+n:""+n;
    }
    var oImg=document.getElementsByClassName("img");
    setInterval(clock,1000);
    clock()
    function clock(){
        var oDate=new Date();
        var oH=oDate.getHours();
        var oF=oDate.getMinutes();
        var oM=oDate.getSeconds();
        var str=toDou(oH)+toDou(oF)+toDou(oM);
        for(var i=0;i<oImg.length;i++){
            move(oImg[i],{"marginTop":-35*str.charAt(i)});
        }

    }

    function getStyle(obj,name){
        if(obj.currentStyle){
            return obj.currentStyle[name];
        }else{
            return getComputedStyle(obj,false)[name];
        }
    }

    function move(obj,json,options){
        options=options||{};
        options.duration=options.duration||700;
        options.easing=options.easing||'ease-in';

        var count=Math.floor(options.duration/30);

        var start={};
        var dis={};

        for(var name in json){
            //name  = 名称
            //json[name]= 值

            start[name]=parseFloat(getStyle(obj,name));

            dis[name]=json[name]-start[name];

        }
        var n=0;
        clearInterval(obj.timer);
        obj.timer=setInterval(function(){
            n++;
            //var cur=start+dis*n/count;

            for(var name in json){

                switch(options.easing){
                    case 'linear':
                        var cur=start[name]+dis[name]*n/count;
                        break;
                    case 'ease-in':
                        var a=Math.pow(n/count,3);
                        var cur=start[name]+dis[name]*a;
                        break;
                    case 'ease-out':
                        var a=Math.pow(1-n/count,3);
                        var cur=start[name]+dis[name]*(1-a);
                        break;
                }

                if(name=='opacity'){
                    obj.style[name]=cur;
                    obj.style.filter='alpha(opacity:'+(cur*100)+')';
                }else{
                    obj.style[name]=cur+'px';
                }

            }

            if(n==count){
                clearInterval(obj.timer);

                options.complete&&options.complete();
            }

        },30);
    }


})
