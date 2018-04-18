/**
 * Created by cy on 2016/7/26.
 */
'use strict';
app.controller('monitorDeviceController', function ($log, $controller, $q, $mdSidenav, NgTableParams, $scope, $element, httpService) {
    $controller('baseController', {$scope: $scope});

    $log.debug('Created monitorDeviceController');

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            var addrId = "";
            if ($scope.selectedAddr != null) {
                addrId = $scope.selectedAddr.id;
            }
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: $scope.orgId,
                placeId: addrId,
                username: $scope.username,
                ip:$scope.ip
            }), 116009)).then(function (response) {
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
        $mdSidenav('right').toggle();
    };
    //编辑页面
    $scope.toggleRightUpdate = function (row) {
        $mdSidenav('right').toggle().then(function () {
            $scope.device = row;
            $scope.selectedAddress = row.vmonPlaceDTO;
        });
    };
    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close().then(function () {
            $scope.device = "";
        });
    };

    //添加保存数据
    $scope.save = function () {
        var device = $scope.device;
        var address = $scope.selectedAddress;
        if (device == undefined) {
            $scope.showActionToast("验证未通过！");
            return;
        }
        angular.extend(device, {orgId: $scope.orgId});
        if (address != null) {
            angular.extend(device, {placeId: address.id});
        }
        if(device.channel != null){
            var channel=device.channel.replace(/，/ig,",")
            var newArr = [];
            var array = channel.split(",");
            for (var i = 0; i < array.length; i++) {
                if (array[i] != null && $.trim(array[i]) != "") {
                    newArr.push($.trim(array[i]));
                }
            }
            device.channel=newArr.join(",");
        }
        if ($scope.deviceForm.$valid) {
            if (angular.isUndefined($scope.device.id)) {
                $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(device), 116006));
            } else {
                $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(device), 116007));
            }
        } else {
            $scope.showActionToast("验证未通过！");
        }
    };

    //删除一行数据
    $scope.delete = function (row) {
        $scope.deleteHandler(httpService.post, buiderPostParam({id: row.id}, 116008), '#delete' + row.id);
    };

    //查询地址-1
    $scope.getAddressList = function(term) {
        var deferred = $q.defer();
        httpService.post(buiderPostParam({numPerPage: 10, pageNum: 1, data: {orgId:$scope.orgId,address:term}},116001))
            .then(function(response){
                var allName = response.data.data.data;
                deferred.resolve(allName);
            });
        return deferred.promise;
    };

    //查询地址-2
    $scope.querySearchAddress=function (query) {
        var deferred = $q.defer();
        var results =$scope.getAddressList(query);
        if (angular.isUndefined(results)) {
            deferred = $q.defer();
            $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
            return deferred.promise;
        } else {
            return results;
        }
    };
});
