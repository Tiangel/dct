/**
 * Created by cy on 2016/7/21.
 */
'use strict';
app.controller('warningRuleMixChemController', function ($scope, $q, $mdSidenav, NgTableParams, $controller, $log, $mdDialog, httpService, permissionService) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created warningRuleMixChemController');

    //一览数据
    $scope.tableParams = new NgTableParams({count: 5}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                itemNo: $scope.warnItemNoForMixInfo
            }), 114003)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            });
        }
    });

    httpService.post(buiderPostParam({}, 108038)).then(function (response) {
        var data = response.data;
        if (isSuccess(data)) {
            $scope.chemCateList = data.data;
        }
    });

    $scope.querySearchChemCate = function(criteria) {
        if (criteria == null || criteria == "") {
            return  $scope.chemCateList;
        }
        return $scope.chemCateList.filter(createFilterFor(criteria));
    };

    function createFilterFor(query) {
        var lowercaseQuery = angular.lowercase(query);

        return function filterFn(contact) {
            return (contact.fname.indexOf(lowercaseQuery) != -1);;
        };

    }

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
            var html = input.extend1Name + "和" + input.extend2Name + "不能混放(" + input.text + ")";
            return html;
        } else {
            return "";
        }
    }

    $scope.saveWarnRule = function () {
        if (toJson($scope.selectedChemCate1) == "null" || toJson($scope.selectedChemCate2) == "null" || $scope.text == null || $scope.text == "") {
            $scope.showActionToast("请填写完整信息！");
            return;
        }
        var warnRule = {
            extend1: $scope.selectedChemCate1.id,
            extend2: $scope.selectedChemCate2.id,
            text: $scope.text,
            itemNo: $scope.warnItemNoForMixInfo,
            orgId: permissionService.getOrgId(),
            memberId: permissionService.getUserId()
        };
        $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(warnRule), 114001));
    }
});

//获取实验室安全员或负责人信息
app.filter("rule_mix_msg", function ($sce) {
    return function (input) {
        if (input != null && input != "") {
            var html = input.extend1Name + "和" + input.extend2Name + "不能混放(" + input.text + ")";
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});