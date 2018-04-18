/**
 * Created by ZH on 2016/7/13.
 */
'use strict';

app.controller('topicLogController', function ( $log, $controller, $mdDialog,$mdSidenav, NgTableParams, $scope, httpService) {
    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created topicLogController' );

    //定义用途
    $scope.purposelist = [
        { purpose: null, name: '不限' },
        { purpose: 1, name: '教学' },
        { purpose: 2, name: '科研'}
    ];

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params){
            if($scope.selectedTopicLog != null){
                var topicLogid=$scope.selectedTopicLog.logId;
            }
            if($scope.selectedMember != null){
                var memberid=$scope.selectedMember.id;
            }
            if($scope.selectedLab != null){
                var labid=$scope.selectedLab.labId;
            }
            return httpService.post(buiderPostParam(buiderPage(params,{
                orgId:$scope.orgId,
                logId:topicLogid,
                purpose:$scope.purposename,
                labId:labid,
                memberId:memberid,
                teacherName:$scope.teacherName,
                exptAtBegin:$scope.exptAtBegin,
                exptAtEnd:$scope.exptAtEnd}),105005))
                .then(function (response) {
                    var data = response.data;
                    if ( isSuccess(data) ) {
                        params.total(data.data.total);
                        return data.data.data.map(function (list) {
                            list.exptLength=list.exptLength/3600;
                            return list;
                        });
                    }
                })
        }
    });

    /**
     * 导出文件
     */
    $scope.exportTopicLog = function () {
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认导出符合条件的数据？")
            .ok('确认').cancel('取消')
        ).then(function () {
            if($scope.selectedTopicLog != null){
                var topicLogid=$scope.selectedTopicLog.logId;
            }
            if($scope.selectedMember != null){
                var memberid=$scope.selectedMember.id;
            }
            if($scope.selectedLab != null){
                var labid=$scope.selectedLab.labId;
            }
            return httpService.post(buiderPostParam({
                orgId:$scope.orgId,
                logId:topicLogid,
                purpose:$scope.purposename,
                labId:labid,
                memberId:memberid,
                teacherName:$scope.teacherName,
                exptAtBegin:$scope.exptAtBegin,
                exptAtEnd:$scope.exptAtEnd},105006))
                .then(function (response) {
                    var data = response.data;
                    if ( isSuccess(data) ) {
                        if (!angular.isUndefined(response.data.data)) {
                            var url = response.data.data;
                            window.location.href = url;
                        } else {
                            $scope.showActionToast("下载失败");
                        }
                    }
                })
        });
    }

    //至查看页面
    $scope.tocheck = function (w) {
        $mdSidenav('right')
            .toggle()
            .then(function () {
                $scope.list = todate(w);
                $scope.btnDisabled=true;
            });
    };

    //处理时间
    function todate(w) {
        if (w.exptAt != null && w.exptAt != "") {
            w.exptAt= new Date(w.exptAt);
        }
        return w;
    }

    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close()
            .then(function () {
                $scope.btnDisabled=false;
                $scope.list='';
            });

    };
});

