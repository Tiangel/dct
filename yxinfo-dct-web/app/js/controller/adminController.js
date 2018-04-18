/**
 * Created by hanley on 2016/6/20.
 */
'use strict';
app.controller('adminController', function ($scope, $state, $timeout, permissionService, $mdSidenav, $mdMedia, $log ) {

    $log.debug('adminController');  

    if ( !permissionService.isLoggedIn() ) {
        $state.go('login');
    }

    $scope.leftNav = $mdMedia('gt-sm') && true;

    $scope.leftToggle = buildDelayedToggler('left-sidenav');

    function debounce( fun, wait, context ) {

        var timer;
        return function debounced() {
            var context = $scope,
                args = Array.prototype.slice.call(arguments);
            $timeout.cancel(timer);
            timer = $timeout(function () {
                timer = undefined;
                fun.apply(context, args);
            }, wait || 10);
        };

    }

    function buildDelayedToggler(navId) {
        return debounce(function () {
            $scope.leftNav ? $mdSidenav(navId).close() : $mdSidenav(navId).open();
            $scope.leftNav = !$scope.leftNav;
        }, 200)
    }

    $scope.loginOut = function () {
        permissionService.setAuthToken(null);
        $state.go('login');
    }
})

