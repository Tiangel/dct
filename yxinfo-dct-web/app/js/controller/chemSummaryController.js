/**
 * Created by ZH on 2016/7/13.
 */
"use strict";

app.controller('chemSummaryController', function ($log, $controller, NgTableParams, $scope, httpService) {
    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created chemSummaryController' );

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params){
            if($scope.selectedWh != null){
                var whid=$scope.selectedWh.whId;
            }
            if($scope.selectedChem != null){
                var chemid=$scope.selectedChem.id;
            }
            return httpService.post(buiderPostParam(buiderPage(params,{
                orgId:$scope.orgId,
                whId:whid,
                chemId:chemid}),108021))
                .then(function (response) {
                    var data = response.data;
                    if ( isSuccess(data) ) {
                        params.total(data.data.total);
                        return data.data.data;
                    }
                })
        }
    });

});

