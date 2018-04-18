/**
 *  Created by cy on 2016/7/26.
 */
'use strict';
app.controller('monitorPlaceController', function ($log, $controller, $q, $mdSidenav, NgTableParams, $scope, $element, httpService) {
    $controller('baseController', {$scope: $scope});

    $log.debug('Created monitorPlaceController');

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: $scope.orgId,
                address: $scope.address
            }), 116001)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });

    //添加页面
    $scope.toggleRightAdd = function () {
        $mdSidenav('right').toggle().then(function () {
            $scope.show = false;
        });

    };
    //编辑页面
    $scope.toggleRightUpdate = function (mon) {
        $mdSidenav('right').toggle().then(function () {
            $scope.mon = mon;
            $scope.show = true;
        });
    };
    $scope.toggleRightDetail = function (row) {
        $mdSidenav('detail').toggle().then(function () {
            httpService.post(buiderPostParam({id: row.id},116002)).then(function(response) {
                $scope.deviceList = response.data.data;
                $scope.place = row;
            });
        });
    };

    //关闭右侧
    $scope.closeDetail = function () {
        $mdSidenav('detail').close().then(function() {
            $scope.place = "";
        });
    };

    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close().then(function() {
            $scope.mon = "";
        });
    };

    //添加保存数据
    $scope.save = function () {
        var mon = $scope.mon;
        var siteId = null;
        if (mon == undefined) {
            $scope.showActionToast("验证未通过！");
            return;
        }
        if ( $scope.mon.laboratoryDTO != null ) {
            siteId = $scope.mon.laboratoryDTO.labId;
        }
        if ( $scope.mon.whDTO != null ){
            siteId = $scope.mon.whDTO.whId;
        }
        angular.extend(mon, {orgId: $scope.orgId});
        if ($scope.monForm.$valid) {
            if (angular.isUndefined($scope.mon.id)) {
                $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(mon), 116003));
            } else {
                if($scope.mon.purposeNo == null || $scope.mon.purposeNo =='' ){
                    angular.extend(mon, {siteId: 0});
                    $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(mon), 116004));
                }else {
                    if ( $scope.mon.laboratoryDTO != null || $scope.mon.whDTO != null ){
                        angular.extend(mon, {siteId: siteId});
                        $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(mon), 116004));
                    }else {
                        $scope.showActionToast("验证未通过！");
                        return;
                    }
                }
            }
        } else {
            $scope.showActionToast("验证未通过！");
        }
    };

    //删除一行数据
    $scope.delete = function (row) {
        $scope.deleteHandler(httpService.post, buiderPostParam({id: row.id}, 116005), '#delete' + row.id);
    };
});
