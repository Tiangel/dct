/**
 * Created by hanley on 2016/6/19.
 */


'use strict';

app.controller('loginController', function ($scope, $controller, $log, adminService,$mdDialog, permissionService, $state ) {

    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created loginController' );

    if ( permissionService.isLoggedIn() ) {
        $state.go('admin.home'); //已经登录直接跳转到后台首页
    }
    
    $scope.enter = function (e) {
        var keyCode = window.event ? e.keyCode : e.which;
        if ( keyCode == 13 ) {
            $scope.login();
        }
    }

    $scope.login = function () {

        $scope.btnDisabled = true;

        if ($scope.name && $scope.password) {

            adminService.login( $scope.name, $scope.password ).success(function (response) {

                if ( !isSuccess(response) ) {
                    $scope.btnDisabled = false;
                } else {
                    var memberDTO = response.data;

                    permissionService.setAuthToken(memberDTO.accessToken.accessTok);
                    permissionService.setUserId(memberDTO.id);
                    permissionService.setUserName(memberDTO.realName);

                    adminService.getOrg().success(function (response) {

                        var org = response.data;

                        if ( org.length == 1 ) {
                            permissionService.setOrgId(org[0].id);
                            permissionService.setorgName(org[0].fname);
                            permissionService.setOrgLogo(org[0].customized.banner2);
                            $state.go('admin.home');
                            return;
                        }

                        $mdDialog.show({
                            controller: chooseOrgController,
                            templateUrl: 'views/member/choose_org.html',
                            parent: angular.element(document.body),
                            locals: {
                                items: org
                            }
                        });

                        function chooseOrgController($scope, $mdDialog, items) {
                            $scope.items = items;
                            $scope.choose = function (row) {
                                $mdDialog.hide();
                                permissionService.setOrgId(row.id);
                                permissionService.setorgName(row.fname);
                                permissionService.setOrgLogo(row.customized.banner2);
                                $state.go('admin.home');
                            }
                        }

                    })


                }

            }).error(function () {
                showAlert($mdDialog, NET_ERR);
                $scope.btnDisabled = false;
            })

        } else {
            showAlert($mdDialog, INPUT_USER_PWD);
            $scope.btnDisabled = false;

        }

    }

})
