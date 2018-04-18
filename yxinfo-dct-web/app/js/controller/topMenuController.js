/**
 * Created by hanley on 2016/7/15.
 */
'use strict';

app.controller('topMenuController', function ($controller,$scope, $state, $mdDialog,permissionService ) {

    $controller( 'baseController', { $scope: $scope});
    /**
     * 退出登录
     */
    $scope.logout = function () {

        permissionService.clearLogin();

        $state.go('login');

    }
    
    $scope.modifyPassword = function (ev) {
        $mdDialog.show({
            controller: 'memberController',
            templateUrl: 'views/member/member_modify.html',
            parent: angular.element(document.body),
            targetEvent: ev,
        })
    }


})