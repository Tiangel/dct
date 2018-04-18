/**
 * Created by hanley on 2016/6/14.
 */
'use strict';

app.controller('navBarController', function ($scope, $controller, $log, adminService, $state) {

    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created navBarController' );

    adminService.getMenu().success(function (response) {
        if ( isSuccess(response) ) {
            $scope.menus = response.data;
        }
    });

    $scope.isActiveState = function (name) {
        if ( !angular.isUndefined(name) ) {
            var newName = name.replace("/", ".");
            return $state.includes(newName);
        }
        return false;
    }
    
})
