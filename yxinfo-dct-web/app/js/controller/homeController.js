app.controller('homeCtrl', function ($scope, $controller, $log, $state, httpService, $location) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created homeCtrl');

    httpService.post(buiderPostParam({orgId: $scope.orgId}, 114013)).then(function (response) {
        var data = response.data;
        if (isSuccess(data)) {
            $scope.ligthStatus = data.data;
        }
    });

    $scope.chartClick = function (tabIndex) {
        $state.go('admin.warning_manager', {selectedIndex: tabIndex});
    };
});