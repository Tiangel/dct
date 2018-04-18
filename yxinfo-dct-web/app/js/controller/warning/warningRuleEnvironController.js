/**
 * Created by cy on 2016/7/21.
 */
'use strict';
app.controller('warningRuleEnvironController', function ($scope, $q, $mdSidenav, NgTableParams, $controller, $log, $mdDialog, httpService, permissionService) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created warningRuleEnvironController');

    //一览数据
    $scope.tableParams = new NgTableParams({count: 5}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                itemNo: $scope.warnItemNoForMixInfo
            }), 114022)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    console.log(toJson(data));
                    if (!angular.isUndefined(data.data)) {
                        params.total(data.data.total);
                        return data.data.data;
                    } else {
                        params.total(0);
                        return [];
                    }

                }
            });
        }
    });

    $scope.delete = function (row) {
        httpService.post(buiderPostParam({id: row.id}, 114004)).then(function (response) {
            var data = response.data;
            if (isSuccess(data)) {
                $scope.showActionToast("预警规则" + getWarnInfo(row) + "删除成功");
                $scope.reflashHandler();
            }
        });
    }
    /**
     * 关闭弹出框
     *
     */
    $scope.close = function () {
        $mdDialog.cancel();
    };

    /**
     * 获取预警信息
     *
     * @returns {*}
     */
    function getWarnInfo(input) {
        if (input != null && input != "") {
            var html = input.labName + '的预警规则';
            return html;
        } else {
            return "";
        }
    }

    $scope.saveWarnRule = function () {
        var warnRule = $scope.environ;
        var labId = "";
        if ($scope.selectedLab != null) {
            labId = $scope.selectedLab.labId;
        }
        if (!$scope.warnRuleForm.$valid) {
            $scope.showActionToast("验证未通过！");
            return;
        }
        if (toJson(warnRule) == "null" || toJson(warnRule) == "" || $scope.labId == "") {
            $scope.showActionToast("请填写完整信息！");
            return;
        }
        angular.extend(warnRule, {memberId: permissionService.getUserId(), orgId: permissionService.getOrgId(), labId: labId});
        $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(warnRule), 114021));
    }
});