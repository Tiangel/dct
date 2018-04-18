/**
 * Created by cy on 2016/7/1.
 */

'use strict';

app.factory('httpService', function ($http, Upload) {

    var server = {};

    server.post = function (code, param) {
        return httpPost($http, code, param);
    };
    server.baseUpLoadFileHttpPost = function (params) {
        return baseUpLoadFileHttpPost(Upload, params);
    };
    
    server.getTablePage = function ( page, param, code ) {

        return this.post(code, buiderPage(page, param)).then(function (response) {
            var data = response.data;
            if (isSuccess(data)) {
                page.total(data.data.total);
                return data.data.data;
            }
        });

    }

    return {
        post: function (params) {
            return server.post(params.code, params.param);
        },

        baseUpLoadFileHttpPost: function (params) {
            return server.baseUpLoadFileHttpPost(params);
        },

        getTablePage: function (page, param, code) {
            return server.getTablePage( page, param, code);
        }
    }
});
