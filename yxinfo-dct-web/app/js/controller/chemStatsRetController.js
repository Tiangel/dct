/**
 * Created by ZH on 2016/7/15.
 */
"use strict";

app.controller('chemStatsRetController', function ($log, $mdDialog,$controller, NgTableParams, $scope, httpService) {
    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created chemStatsRetController' );

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params){
            if($scope.selectedChem != null){
                var chemId=$scope.selectedChem.id;
            }
            return httpService.post(buiderPostParam(buiderPage(params,{
                statsDateFrom:$scope.statsDateFrom,
                statsDateTo:$scope.statsDateTo,
                stats:{orgId:$scope.orgId,msgId:chemId}}),108022))
                .then(function (response) {
                    var data = response.data;
                    if ( isSuccess(data) ) {
                        params.total(data.data.total);
                        return data.data.data;
                    }
                })
        }
    });
    
    $scope.exportStatsRet = function () {
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认导出符合条件的数据？")
            .ok('确认').cancel('取消')
        ).then(function () {
            if($scope.selectedChem != null){
                var chemId=$scope.selectedChem.id;
            }
            return httpService.post(buiderPostParam({
                statsDateFrom:$scope.statsDateFrom,
                statsDateTo:$scope.statsDateTo,
                stats:{orgId:$scope.orgId,msgId:chemId}},108033))
                .then(function (response) {
                    var data = response.data;
                    if (isSuccess(data)) {
                        if (!angular.isUndefined(data.data)) {
                            var url =$scope.downLoadUrl+data.data;
                            window.location.href = url;
                        } else {
                            $scope.showActionToast("下载失败");
                        }
                    }
                })
        });
    }
    
});

