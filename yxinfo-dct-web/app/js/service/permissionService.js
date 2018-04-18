/**
 * Created by hanley on 2016/6/20.
 */
'use strict';

app.factory('permissionService', function ($http, $log, configService, localStorageService) {

    var server = {};

    return {

        isLoggedIn: function () {

            if ( this.getUserId() != null && this.getUserName() != null && this.getOrgId() != null && this.getorgName() != null && this.getAuthToken() != null ) {
                return true;
            }
            return false;

        },
        
        setUserId: function (userId) {
            localStorageService.set("USER_ID", userId)
        },

        getUserId: function () {
            return   localStorageService.get('USER_ID');
        },

        setUserName: function (userName) {
            localStorageService.set("USER_NAME", userName)
        },

        getUserName: function () {
            return   localStorageService.get('USER_NAME');
        },

        setAuthToken: function ( authToken ) {
            localStorageService.set( "ADMIN_AUTH_TOKEN", authToken );
        },

        getAuthToken: function () {
            return localStorageService.get('ADMIN_AUTH_TOKEN');
        },

        setOrgId: function (orgId) {
            localStorageService.set("ORG_ID", orgId)
        },

        getOrgId: function () {
          return localStorageService.get('ORG_ID');
        },

        setorgName: function (orgName) {
            localStorageService.set("ORG_NAME", orgName)
        },

        getorgName: function () {
            return   localStorageService.get('ORG_NAME');
        },

        clearLogin: function () {
            localStorageService.clearAll();
        },

        setOrgLogo: function (logo) {
            localStorageService.set("ORG_LOGO", logo)
        },

        getOrgLogo: function () {
            return localStorageService.get('ORG_LOGO');
        }
    }


})