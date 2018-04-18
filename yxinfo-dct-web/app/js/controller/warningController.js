/**
 * Created by cy on 2016/7/1.
 */
'use strict';
app.controller('warningController', function ($scope, $mdSidenav, $stateParams, $sce,NgTableParams, $location, $controller, $log,httpService, $state) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created warningController');

    var selectedIndex = 0;
    if(!angular.isUndefined($stateParams.selectedIndex) && $stateParams.selectedIndex != null && $stateParams.selectedIndex != '') {
        selectedIndex = $stateParams.selectedIndex;
    }
    $scope.selectedIndex = selectedIndex;

    //显示对应对应的预警项目
    httpService.post(buiderPostParam({orgId: $scope.orgId}, 114013)).then(function (response) {
        var data = response.data;
        if (isSuccess(data)) {
            if (angular.isArray(data.data)) {
                $scope.warnList = data.data;
                var obj = $scope.warnList[selectedIndex];
                var itemNo = obj.itemNo;
                $scope.loadWarnInfo(itemNo);
            }
        }
    });
    $scope.loadWarnInfo = function (itemNo) {
        var tableParams = 'tableParams' + itemNo;
        $scope[tableParams] = new NgTableParams({}, {
            getData: function (params){
                return httpService.post(buiderPostParam(buiderPage(params,{
                    orgId:$scope.orgId,
                    status:"2,3",
                    itemNo: itemNo}),114007))
                    .then(function (response) {
                        var data = response.data;
                        if ( isSuccess(data) ) {
                            if (!angular.isUndefined(data.data)) {
                                params.total(data.data.total);
                                return data.data.data;
                            } else {
                                params.total(data.data);
                                return [];
                            }
                        }
                    })
            }
        });
    };
    //至查看页面
    $scope.toCheck = function (w) {
        $mdSidenav('right')
            .toggle()
            .then(function () {
                httpService.post(buiderPostParam({recordId:w.id},114009)).then(function(response){
                    $scope.operationList =response.data.data
                });
                $scope.list = w;
                $scope.btnDisabled=true;
            });
    };

    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close()
            .then(function () {
                $scope.btnDisabled=false;
                $scope.list='';
            });

    };
    //跳转到预警详情
    $scope.toDetail = function (row) {
        $location.path('/admin/warning').search({ from: 2, row: toJson(row)});
    };
});