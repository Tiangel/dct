/**
 * Created by hanley on 2016/6/13.
 */
'use strict';

app.controller('baseController', function ($scope, $q , $rootScope, $timeout ,$log, $mdToast, $state, $mdDialog, httpService, permissionService) {

    $log.debug('baseController loaded');

    /**
     * 定义全局的参数
     */
    $scope.orgId = permissionService.getOrgId();
    $scope.userName = permissionService.getUserName();
    $scope.orgName = permissionService.getorgName();
    $rootScope.logo = permissionService.getOrgLogo();
    $scope.warnItemNoForReceiveNum = '100001';
    $scope.warnItemNoForReceiveTime = '100002';
    $scope.warnItemNoForReceiveIllegal = '100008';
    $scope.warnItemNoForReceive = '100001,100002';
    $scope.warnItemNoForReceive2 = '100001,100002,100008';
    $scope.warnItemNoForReceive1 = '100000';
    $scope.warnItemNoForRecovery = '100003';
    $scope.warnItemNoForCheck = '100004';
    $scope.warnItemNoForRecoveryUsed = '100005';
    $scope.warnItemNoForMixInfo = '100006';
    $scope.warnItemNoForEnviron = '100007';
    $scope.downLoadUrl='http://api.yuanxininfo.com/dct-web/assets/';

    /**
     * 右上角弹出吐司
     *
     * @type {{msg: 弹出信息}}
     */
    $scope.showActionToast = function (msg) {
        $mdToast.show($mdToast.simple()
            .textContent(msg)
            // .hideDelay(500)
            .position('top right')
        );
    };

    /**
     * 删除选中的记录
     *
     * @type {{action: 调用处理方法，param:参数, area：提示框出现位置, flag:是否刷新（默认刷新）}}
     */
    $scope.deleteHandler = function (action, param, area, flag) {
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认删除？")
            .ok('确认').cancel('取消').openFrom(area).closeTo(area)
        ).then(function () {
            action(param).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    $scope.showActionToast("删除成功");
                    if (angular.isUndefined(flag)) {
                        $scope.reflashHandler();
                    }
                }
            });
        });
    };

    /**
     * 新增或编辑
     *
     * @type {{action: 调用处理方法, param: 传递的参数, flag:是否刷新（默认刷新）}}
     */
    $scope.addOrUpdateHandler = function (action, param, flag) {
        action(param).then(function (response) {
            var data = response.data;
            if (isSuccess(data)) {
                $scope.showActionToast("操作成功");
                $scope.close();
                if (angular.isUndefined(flag)) {
                    $scope.reflashHandler();
                }
            }
        });
    };

    /**
     * 公共的刷新
     */
    $scope.reflashHandler = function() {
        if (!angular.isUndefined($scope.tableParams)) {
            $scope.tableParams.parameters({page: 1});
            $scope.tableParams.reload();
        }
    };

    //查询试剂-1
    $scope.getChemList = function(term) {
        var deferred = $q.defer();
        httpService.post(buiderPostParam({numPerPage: 10, pageNum: 1, data: {fname:term}},108003))
            .then(function(response){
                var allName = response.data.data.data;
                deferred.resolve(allName);
            });
        return deferred.promise;
    };

    //查询试剂-2
    $scope.querySearchChem=function (query) {
        var deferred = $q.defer();
        var results =$scope.getChemList(query);
        if (angular.isUndefined(results)) {
            deferred = $q.defer();
            $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
            return deferred.promise;
        } else {
            return results;
        }
    };

    //查询仓库-1
    $scope.getWhList = function(term) {
        var deferred = $q.defer();
        httpService.post(buiderPostParam({numPerPage: 10, pageNum: 1, data: {orgId:$scope.orgId,whName:term}},106005))
            .then(function(response){
                var allName = response.data.data.data;
                deferred.resolve(allName);
            });
        return deferred.promise;
    };

    //查询仓库-2
    $scope.querySearchWh=function (query) {
        var deferred = $q.defer();
        var results =$scope.getWhList(query);
        if (angular.isUndefined(results)) {
            deferred = $q.defer();
            $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
            return deferred.promise;
        } else {
            return results;
        }
    };

    //查询实验室信息-1
    $scope.getLabList = function(query) {
        var deferred = $q.defer();
        httpService.post(buiderPostParam({numPerPage: 10, pageNum: 1, data: {orgId:$scope.orgId,labName:query}},104003))
            .then(function(response){
                var allName = response.data.data.data;
                deferred.resolve(allName);
            });
        return deferred.promise;
    };

    //查询实验室信息-2
    $scope.querySearchLab=function (query) {
        var deferred = $q.defer();
        var results =$scope.getLabList(query);
        if (angular.isUndefined(results)) {
            deferred = $q.defer();
            $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
            return deferred.promise;
        } else {
            return results;
        }
    };

    //查询人员-1
    $scope.getMemberList = function (query) {
        var deferred = $q.defer();
        httpService.post(buiderPostParam({numPerPage: 10, pageNum: 1, data: {orgId:$scope.orgId,realName: query}},100015))
            .then(function (flights) {
                var allName = [];
                if (!angular.isUndefined(flights.data.data.data)) {
                    allName = flights.data.data.data;
                }
                deferred.resolve(allName);
            });
        return deferred.promise;
    };

    //查询人员-2
    $scope.querySearchMember = function (query) {
        var deferred = $q.defer();
        var results = $scope.getMemberList(query);
        if (angular.isUndefined(results)) {
            deferred = $q.defer();
            $timeout(function () {deferred.resolve(results);}, Math.random() * 1000, false);
            return deferred.promise;
        } else {
            return results;
        }
    };

    //查询课题日志-1
    $scope.getTopicLog = function(query) {
        var deferred = $q.defer();
        httpService.post(buiderPostParam({numPerPage: 10, pageNum: 1, data: {orgId:$scope.orgId,issuesName:query}},105005))
            .then(function(response){
                var allName = response.data.data.data;
                deferred.resolve(allName);
            });
        return deferred.promise;
    };

    //查询课题日志-2
    $scope.querySearchTopicLog=function (query) {
        var deferred = $q.defer();
        var results =$scope.getTopicLog(query);
        if (angular.isUndefined(results)) {
            deferred = $q.defer();
            $timeout(function () { deferred.resolve( results ); }, Math.random() * 1000, false);
            return deferred.promise;
        } else {
            return results;
        }
    };

    //获取计量单位
    $scope.getUnitList = function () {
        return httpService.post(buiderPostParam(null,108012)).success(function (response) {
            $scope.unitlist=response.data;
        })
    };

    //获取纯度
    $scope.getSpecList = function () {
        return httpService.post(buiderPostParam(null,108013)).success(function (response) {
            $scope.speclist=response.data;
        })
    };

    //获取预警项目列表
    $scope.getWarnItemList = function () {
        return httpService.post(buiderPostParam(null,114019)).success(function (response) {
            $scope.warnitemlist=response.data;
        })
    };
});

//拼接试剂信息用于一览页面试剂列的显示
app.filter("chem_name", function ($sce) {
    return function (input) {
        if (input != null && input != []) {
            var html = "";
            html = html + input.chem.fname +  "</br>"+ "CAS号：" +input.chem.cas+input.spec.fname+input.capacity+input.unit.unit;
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});

