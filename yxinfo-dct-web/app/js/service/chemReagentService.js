/**
 * Created by ZH on 2016/7/1.
 */
'use strict';

app.factory('chemReagentService', function ($http,$filter) {

    var server = {};

    server.getData = function ( param ) {
        return httpPost($http, 107010, param)
    }

    server.delete =function (param) {
        return httpPost($http, 107007, param)
    }

    server.update =function (param) {
        return httpPost($http, 107008, param)
    }

    server.add =function (param) {
        return httpPost($http, 107006, param)
    }

    return {
        getData : function (param) {
            return server.getData(param);
        },
        delete : function (param) {
            return server.delete(param);
        },
        update : function (param) {
            return server.update(param);
        },
        add : function (param) {
            return server.add(param);
        }
    }




})