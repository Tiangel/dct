/**
 * Created by hanley on 2016/6/20.
 */
'use strict';

app.factory('adminService', function ($http, permissionService) {

    var server = {};

    server.login = function (name, password) {
        return httpPost($http, "100001", { "loginName" : name, "pwd": password }, "123" );
    }
    
    server.getMenu = function () {
        return httpPost($http, '100014', { "id": permissionService.getUserId(), "orgId": permissionService.getOrgId()})
    }

    server.getOrg = function () {
        return httpPost($http, '100007', permissionService.getUserId() );
    }

    return {

        login: function ( name, password ) {
            return server.login(name, password)
        },

        //获取后台菜单
        getMenu: function () {
            return server.getMenu();
        },

        getOrg: function ( memberId ) {
            return server.getOrg( memberId );
        }

    }
    
})