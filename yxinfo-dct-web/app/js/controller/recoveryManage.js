/**
 * Created by cy on 2016/7/1.
 */
'use strict';
app.controller('recoveryManageController', function ($scope, $q, $mdSidenav, $sce, $controller, $log, httpService, $timeout, $filter, NgTableParams, $mdDialog, permissionService, $state) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created recoveryManageController');

    //定义状态
    $scope.statuslist = [
        { status: '', name: '不限'},
        { status: 1, name: '未领用' },
        { status: 2, name: '已领用'},
        { status: 3, name: '待回收'},
        { status: 4, name: '已回收'},
        { status: 5, name: '异常（回收但未扫码）'},
        { status: 6, name: '异常（扫码但未回收）'}
    ];
    //一览数据
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            var chemName = "";
            if ($scope.selectedChem != null) {
                chemName = $scope.selectedChem.fname;
            }
            var memberName = "";
            if ($scope.selectedMember != null) {
                memberName = $scope.selectedMember.realName;
            }
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                reagent: {
                    chem : {
                        fname: chemName
                    },
                    status: $scope.status,
                    rfFcode:$scope.rfCode
                },
                member: {
                    realName: memberName
                }
            }), 108020)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            });
        }
    });

    //状态动态刷新
    $scope.$watch('status',function(newValue,oldValue){
        if (newValue != oldValue) {
            $scope.reflashHandler();
        }
    });

    //打开详情页面
    $scope.toggleRightDetail = function (row) {
        $mdSidenav('right').toggle().then(function () {
            if (row.createAt != null && row.createAt != "") {
                row.createAt= new Date(row.createAt);
            }
            if (row.recycleAt != null && row.recycleAt != "") {
                row.recycleAt= new Date(row.recycleAt);
            }
            $scope.recycle = row;
            $scope.disabled = true;
        });
    };

    //关闭右侧窗口
    $scope.close = function () {
        $mdSidenav('right').close();
        $scope.disabled = false;
    };
});


//获取实验室安全员或负责人信息
app.filter("format_recycle", function ($sce) {
    return function (recycle, flag) {
        if (recycle != null && recycle != [] && recycle.chemName != null && recycle.chemName != "") {
            var html = recycle.chemName + "</br> CAS:" + recycle.cas + " " + recycle.specName + " " + recycle.capacity;
            if (!angular.isUndefined(recycle.unit.unit)) {
                html += recycle.unit.unit;
            }
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});