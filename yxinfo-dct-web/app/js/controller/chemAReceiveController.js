/**
 * Created by ZH on 2016/7/8.
 */
'use strict';

app.controller('chemAReceiveController', function ($sce, $log, $controller, $mdDialog, $mdSidenav, NgTableParams, $scope, httpService) {
    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created chemAReceiveController' );

    //定义状态
    $scope.statuslist = [
        { status: null, name: '不限' },
        { status: 1, name: '审核中' },
        { status: 2, name: '待领用'},
        { status: 3, name: '已领完'},
        { status: 4, name: '已驳回'},
        { status: 5, name: '已逾期'}
    ];

    //定义用途
    $scope.purposelist = [
        { purpose: null, name: '不限' },
        { purpose: 1, name: '教学' },
        { purpose: 2, name: '科研'}
    ];

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params){
            if($scope.selectedChem!=null){
                var chemid=$scope.selectedChem.id;
            }
            if($scope.selectedTopicLog!=null){
                var issuesname=$scope.selectedTopicLog.issuesName;
            }
            if($scope.selectedMember!=null){
                var memberid=$scope.selectedMember.id;
            }
            return httpService.post(buiderPostParam(buiderPage(params,{
                applyReceive:{orgId:$scope.orgId,
                              issuesName:issuesname,
                              purpose:$scope.purposename,
                              receiveSta:$scope.statusname,
                              memberId:memberid},
                member:{fcode:$scope.fcode,
                        mobile:$scope.mobile},
                reagent:{chemId:chemid},
                appointAtFrom:$scope.appointAtFrom,
                appointAtTo:$scope.appointAtTo}),108019))
                .then(function (response) {
                    var data = response.data;
                    if ( isSuccess(data) ) {
                        params.total(data.data.total);
                        return data.data.data;
                    }
                })
        }
    });


    /**
     * 导出文件
     */
    $scope.exportAReceive = function () {
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认导出符合条件的数据？")
            .ok('确认').cancel('取消')
        ).then(function () {
            if($scope.selectedChem!=null){
                var chemid=$scope.selectedChem.id;
            }
            if($scope.selectedTopicLog!=null){
                var issuesname=$scope.selectedTopicLog.issuesName;
            }
            if($scope.selectedMember!=null){
                var memberid=$scope.selectedMember.id;
            }
            httpService.post(buiderPostParam({
                applyReceive:{orgId:$scope.orgId,
                    issuesName:issuesname,
                    purpose:$scope.purposename,
                    receiveSta:$scope.statusname,
                    memberId:memberid},
                member:{fcode:$scope.fcode,
                    mobile:$scope.mobile},
                reagent:{chemId:chemid},
                appointAtFrom:$scope.appointAtFrom,
                appointAtTo:$scope.appointAtTo}, 108029)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    if (!angular.isUndefined(data.data)) {
                        var url =$scope.downLoadUrl+data.data;
                        window.location.href = url;
                    } else {
                        $scope.showActionToast("下载失败");
                    }
                }
            });
        });
    }

    //至查看页面
    $scope.toCheck = function (w) {
        $mdSidenav('right')
            .toggle()
            .then(function () {
                httpService.post(buiderPostParam({applyReceiveId:w.id},108002)).then(function(response){
                    $scope.chemList = response.data.data.applyReceive;
                });
                $scope.list = toDate(w);
                $scope.btnDisabled=true;
            });
    };

    //处理时间
    function toDate(w) {
        if (w.createAt != null && w.createAt != "") {
            w.createAt= new Date(w.createAt);
        }
        if (w.appointAt != null && w.appointAt != "") {
            w.appointAt= new Date(w.appointAt);
        }
        return w;
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

app.filter("chem_manager", function ($sce) {
    return function (input) {
        if (input != null && input != [] && input.length > 0) {

            var html = "";
            for (var i = 0; i < input.length; i++) {
                html = html + input[i].chem.fname +  "</br> ";
            }
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});

