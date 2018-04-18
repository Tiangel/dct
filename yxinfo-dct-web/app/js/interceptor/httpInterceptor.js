/**
 * Created by hanley on 2016/7/1.
 */

'use strict';

angular.module('appHttpInterceptor', [])
    .config(['$httpProvider', function ($httpProvider) {

        var $state; var $mdDialog; var permissionService;
        var interceptor = function ($injector) {
            return {
                request: function (config) {

                    permissionService = $injector.get('permissionService');
                    var token = permissionService.getAuthToken();

                    if ("POST" == config.method && !angular.isUndefined(config.data) && !angular.isUndefined(token)) {
                        var data = angular.fromJson(config.data);
                        angular.extend( data, { token: token});
                        config.data = data;
                    }
                    return config;
                },
                response: function (response) {

                    $state = $injector.get('$state');
                    $mdDialog = $injector.get('$mdDialog');
                    permissionService = $injector.get('permissionService');

                    var code = response.data.code;

                    if ( !angular.isUndefined(code )) {
                        if ( "0" != code ) {
                            var alert = $mdDialog.alert().textContent(response.data.msg).ok(OK);
                            $mdDialog.show(alert).finally(function () {
                                alert = undefined;
                                if ( "001008" == code ) {
                                    permissionService.clearLogin();
                                    $state.go('login');
                                }
                            })
                        }
                    }
                    return response;

                }
            }
        }

        $httpProvider.interceptors.push(interceptor);

    }])
