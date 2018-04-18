/**
 * Created by ZH on 2016/7/20.
 */
'use strict';
app.controller('warningManagerController', function ($scope, $q, $stateParams, $mdSidenav, NgTableParams, httpService, $location, $sce, $controller, $log, $mdDialog) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created warningManagerController');

    var selectedIndex = 0;
    if (!angular.isUndefined($stateParams.selectedIndex) && $stateParams.selectedIndex != null && $stateParams.selectedIndex != '') {
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
                $scope.loadRecord(itemNo);
            }
        }
    });

    $scope.addWarnRule = function (ev) {
        $mdDialog.show({
            controller: 'warningRuleController',
            templateUrl: 'views/warning/warning_rule_add.html',
            parent: angular.element(document.body),
            targetEvent: ev
        })
    };

    $scope.showWarnRule = function (ev) {
        $mdDialog.show({
            controller: 'warningRuleController',
            templateUrl: 'views/warning/warning_rule_list.html',
            parent: angular.element(document.body),
            targetEvent: ev
        })
    };

    $scope.addWarnRuleForMix = function (ev) {
        $mdDialog.show({
            controller: 'warningRuleMixChemController',
            templateUrl: 'views/warning/warning_rule_mixChem_add.html',
            parent: angular.element(document.body),
            targetEvent: ev
        })
    };

    $scope.showWarnRuleForMix = function (ev) {
        $mdDialog.show({
            controller: 'warningRuleMixChemController',
            templateUrl: 'views/warning/warning_rule_mixChem_list.html',
            parent: angular.element(document.body),
            targetEvent: ev
        })
    };
    $scope.addWarnRuleForEnviron = function (ev) {
        $mdDialog.show({
            controller: 'warningRuleEnvironController',
            templateUrl: 'views/warning/warning_rule_environ_add.html',
            parent: angular.element(document.body),
            targetEvent: ev
        })
    };

    $scope.showWarnRuleForEnviron = function (ev) {
        $mdDialog.show({
            controller: 'warningRuleEnvironController',
            templateUrl: 'views/warning/warning_rule_environ_list.html',
            parent: angular.element(document.body),
            targetEvent: ev
        })
    };

    //获取预警记录
    $scope.loadRecord = function (itemNo) {
        //特殊预警的处理
        if (itemNo == $scope.warnItemNoForReceive1) {
            $scope.receiveRuleFlag = true;
        } else {
            $scope.receiveRuleFlag = false;
        }
        if (itemNo == $scope.warnItemNoForMixInfo) {
            $scope.mixRuleFlag = true;
        } else {
            $scope.mixRuleFlag = false;
        }
        if (itemNo == $scope.warnItemNoForEnviron) {
            $scope.environRuleFlag = true;
        } else {
            $scope.environRuleFlag = false;
        }
        var tableParams = 'tableParams' + itemNo;
        $scope[tableParams] = new NgTableParams({}, {
            getData: function (params) {
                return httpService.post(buiderPostParam(buiderPage(params, {
                    orgId: $scope.orgId,
                    status: "1",
                    itemNo: itemNo
                }), 114007))
                    .then(function (response) {
                        var data = response.data;
                        if (isSuccess(data)) {
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
    //跳转到预警详情
    $scope.toDetail = function (row) {
        $location.path('/admin/warning').search({ from: 1, row: toJson(row)});
    };
});