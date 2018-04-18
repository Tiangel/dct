app.controller('instrumentController', function ($scope, $mdSidenav, NgTableParams, $controller, $log, $state, httpService, permissionService ) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created instrumentController');

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                fname: $scope.fname,
                status: $scope.status
            }), 130008)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });
    //状态动态刷新
    $scope.$watch('status', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $scope.reflashHandler();
        }
    });
    //添加页面
    $scope.toggleRightAdd = function () {
        $mdSidenav('right').toggle().then(function () {
            $scope.showStatus = false;
        });
    };
    //编辑页面
    $scope.toggleRightUpdate = function (row) {
        $mdSidenav('right').toggle().then(function () {
            $scope.showStatus = true;
            $scope.device = row;
        });
    };

    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close().then(function() {
            $scope.device = "";
        });
    };

    //添加保存数据
    $scope.save = function () {
        var device = $scope.device;
        if (device == undefined) {
            $scope.showActionToast("验证未通过！");
            return;
        }
        angular.extend(device, {orgId: permissionService.getOrgId()});
        if ($scope.deviceForm.$valid) {
            if (angular.isUndefined($scope.device.id)) {
                $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(device), 130009));
            } else {
                $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(device), 130010));
            }
        } else {
            $scope.showActionToast("验证未通过！");
        }
    };
});