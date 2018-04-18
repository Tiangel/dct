/**
 * Created by cy on 2016/7/13.
 */
'use strict';
app.controller('whManagerController', function ($log, $controller, $q, $mdSidenav, NgTableParams, $scope, $element, httpService, permissionService) {
    $controller('baseController', {$scope: $scope});

    $log.debug('Created whManagerController');

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            var whName = "";
            if ($scope.selectedWh != null) {
                whName = $scope.selectedWh.whName;
            }
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                whName: whName,
            }), 106005)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });

    //删除一行数据
    $scope.delete = function (row) {
        $scope.deleteHandler(httpService.post, buiderPostParam({whId: row.whId}, 106003), '#delete' + row.whId);
    };

    //添加页面
    $scope.toggleRightAdd = function () {
        $mdSidenav('right').toggle();
    }


    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close();
    };

    //添加保存数据
    $scope.save = function () {
        var wh = $scope.wh;
        if ($scope.whForm.$valid) {
            angular.extend(wh, {orgId: permissionService.getOrgId()});
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(wh), 106001));
        } else {
            $scope.showActionToast("验证未通过！");
        }
    };
});
