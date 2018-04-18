/**
 * Created by ZH on 2016/7/1.
 */
'use strict';

app.controller('chemReagentController', function ( $log, $controller, $mdDialog, $mdSidenav, NgTableParams, $scope, httpService) {
    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created chemReagentController' );


    //定义状态
    $scope.statuslist = [
        { status: null, name: '不限' },
        { status: 1, name: '未领用' },
        { status: 2, name: '已领用'},
        { status: 3, name: '待回收'},
        { status: 4, name: '已回收'},
        { status: 5, name: '回收但未扫码'},
        { status: 6, name: '扫码但未回收'}
    ];

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params){
            if($scope.selectedWh != null){
                var whid=$scope.selectedWh.whId;
            }
            if($scope.selectedLab != null){
                var labid=$scope.selectedLab.labId;
            }
            if($scope.selectedChem != null){
                var chemid=$scope.selectedChem.id;
            }
            return httpService.post(buiderPostParam(buiderPage(params,{
                createAtFrom:$scope.createAtFrom,
                createAtTo:$scope.createAtTo,
                reagent:{
                orgId:$scope.orgId,
                rfFcode:$scope.rfname,
                capacity:$scope.capacity,
                status:$scope.statusname,
                whId:whid,
                labId:labid,
                spec:{fname:$scope.sfname},
                chemId:chemid,
                unit:{unit:$scope.unit}}}),108016))
                .then(function (response) {
                var data = response.data;
                if ( isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });
    
    $scope.exportReagent = function () {
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认导出符合条件的数据？")
            .ok('确认').cancel('取消')
        ).then(function () {
            if($scope.selectedWh != null){
                var whid=$scope.selectedWh.whId;
            }
            if($scope.selectedLab != null){
                var labid=$scope.selectedLab.labId;
            }
            if($scope.selectedChem != null){
                var chemid=$scope.selectedChem.id;
            }
            return httpService.post(buiderPostParam({
                createAtFrom:$scope.createAtFrom,
                createAtTo:$scope.createAtTo,
                reagent:{
                    orgId:$scope.orgId,
                    rfFcode:$scope.rfname,
                    capacity:$scope.capacity,
                    status:$scope.statusname,
                    whId:whid,
                    labId:labid,
                    spec:{fname:$scope.sfname},
                    chemId:chemid,
                    unit:{unit:$scope.unit}}},108032))
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
    
    //添加
    $scope.add=function (list) {
        httpService.post(buiderPostParam({
            orgId:$scope.orgId,
            chemId:$scope.list.chem.id,
            specId:$scope.specSelected,
            capacity:list.capacity,
            unitId:$scope.unitSelected,
            rfFcodes:list.rfFcode},108014)).success(function (response) {
            if(isSuccess(response)){
                $scope.reflashHandler();
                $scope.close();
                $scope.showActionToast('保存成功');
            }
        })
    };

    //至查看页面
    $scope.toCheck = function (w) {
        $mdSidenav('right')
            .toggle()
            .then(function () {
                httpService.post(buiderPostParam({orgId: $scope.orgId, reagentId:w.id}, 108031))
                    .then(function (response) {
                        $scope.chemTrajList = response.data.data;
                    });
                $scope.list = w;
                $scope.btnDisabled=true;
                $scope.getUnitList();
                $scope.getSpecList();
            });
    };

    //至添加页面
    $scope.toadd = function () {
        $mdSidenav('right')
            .toggle()
            .then(function () {
                $scope.list = "";
                $scope.getUnitList();
                $scope.getSpecList();
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
});


