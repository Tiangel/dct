/**
 * Created by cy on 2016/7/21.
 */
'use strict';
app.controller('warningRuleController', function ($scope, $q, $mdSidenav, NgTableParams, $controller, $log, $mdDialog, httpService, permissionService) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created warningRuleController');

    //一览数据
    $scope.tableParams = new NgTableParams({count:5}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                itemNo: $scope.warnItemNoForReceive
            }), 114003)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            });
        }
    });

    $scope.delete = function(row) {
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
            var html = "";
            if (input.itemNo == "100001" || input.itemNo == 100001) {
                if (input.chemChemicalDTO != null && input.chemChemicalDTO != "") {
                    html = input.chemChemicalDTO.fname + "(" + input.chemChemicalDTO.cas + ")限一个人领用" + input.limitRight;
                }
            } else if (input.itemNo == "100002" || input.itemNo == 100002) {
                html = "所有试剂不在监控范围内" + input.limitRight + "小时预警";
            }
            return html;
        } else {
            return "";
        }
    }
    $scope.saveWarnRule = function () {
        var chemId = "";
        var beyondNum = "";
        var beyondTime = $scope.beyondTime;
        if ($scope.selectedChem != null) {
            chemId = $scope.selectedChem.id;
            beyondNum = $scope.beyondNum;
        }
        var createFlag = true;
        if ((beyondNum != "" && beyondNum == 0) || (beyondTime != "" && beyondTime == 0)) {
            $scope.showActionToast("数据不可为0");
            return false;
        }
        if (!angular.isUndefined(beyondNum) && !angular.isUndefined(chemId) && beyondNum != "" && chemId != "") {
            createFlag = false;
            var warnRule = {
                flag:1,
                warnFor: chemId,
                limitRight: beyondNum,
                itemNo: $scope.warnItemNoForReceiveNum,
                orgId: permissionService.getOrgId(),
                memberId: permissionService.getUserId()
            };
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(warnRule), 114001));
        }
        if (!angular.isUndefined(beyondTime) && beyondTime != "") {
            createFlag = false;
            var warnRule = {
                flag:1,
                limitRight: beyondTime,
                itemNo: $scope.warnItemNoForReceiveTime,
                orgId: permissionService.getOrgId(),
                memberId: permissionService.getUserId()
            }
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(warnRule), 114001));
        }
        if (createFlag) {
            $scope.showActionToast("请输入正确内容");
        }
    };
});

//获取实验室安全员或负责人信息
app.filter("rule_msg", function ($sce) {
    return function (input) {
        if (input != null && input != "") {
            var html = "";
            if (input.itemNo == "100001" || input.itemNo == 100001) {
                if (input.chemChemicalDTO != null && input.chemChemicalDTO != "") {
                    html = input.chemChemicalDTO.fname + "(" + input.chemChemicalDTO.cas + ")限一个人领用" + input.limitRight;
                }
            } else if (input.itemNo == "100002" || input.itemNo == 100002) {
                html = "所有试剂不在监控范围内" + input.limitRight + "小时预警";
            }
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});