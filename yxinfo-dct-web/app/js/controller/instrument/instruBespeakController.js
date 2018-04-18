app.controller('instruBespeakController', function ($scope, $mdSidenav, NgTableParams, $controller, $log, $state, httpService, permissionService ) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created instruBespeakController');

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                proName: $scope.proName
            }), 130007)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });

    //详情页面
    $scope.toggleRightDetail = function (row) {
        $mdSidenav('right').toggle().then(function () {
            httpService.post(buiderPostParam({
                instBespeakDTO:{id : row.id}
            }, 130003)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    if (!angular.isUndefined(data.data.instBespeakDTO.instList)) {
                        $scope.instrumentList = data.data.instBespeakDTO.instList;
                        $scope.bespeak = data.data;
                    }
                }
            })
        });
    };

    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close();
    };

});