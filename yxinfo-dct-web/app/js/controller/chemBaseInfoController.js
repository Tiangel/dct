/**
 * Created by cy on 2016/7/13.
 */
'use strict';
app.controller('chemBaseInfoController', function ($log, $controller, $q, $mdSidenav, NgTableParams, $scope, $element, httpService, permissionService) {
    $controller('baseController', {$scope: $scope});

    $log.debug('Created chemBaseInfoController');

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                fname: $scope.chemName
            }), 108003)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });

    //打开新增页面
    $scope.toggleRightAdd = function (row) {
        $mdSidenav('right').toggle().then(function () {
        });
    };

    httpService.post(buiderPostParam({}, 108038)).then(function (response) {
        var data = response.data;
        if (isSuccess(data)) {
            $scope.chemCateList = data.data;
        }
    });
    //打开编辑页面
    $scope.toggleRightUpdate = function (row) {
        $mdSidenav('right').toggle().then(function () {
            httpService.post(buiderPostParam(row.id, 108018)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    $scope.chem = row;
                    $scope.categories = row.categories;
                    $scope.wasteCategories = row.wasteCategories;
                    if (!angular.isUndefined(data.data.disposal.content)) {
                        $scope.fcontent = data.data.disposal.content;
                    }
                }
            });
        });
    };
    //打开详情页面
    $scope.toggleRightDetail = function (row) {
        $mdSidenav('right').toggle().then(function () {
            $scope.chem = row;
            $scope.categories = row.categories;
            $scope.wasteCategories = row.wasteCategories;
        });
    };
    //关闭右侧窗口
    $scope.close = function () {
        $mdSidenav('right').close().then(function () {
            $scope.chem = "";
            $scope.categories = "";
            $scope.wasteCategories = "";
            $scope.readonlyFlag = false;
        });
    };

    //新增或编辑保存
    $scope.save = function () {
        if (!$scope.chemForm.$valid) {
            $scope.showActionToast("验证未通过！");
            return;
        }
        var chem = $scope.chem;
        if ($scope.chem == undefined || $scope.chem == "") {
            $scope.showActionToast("验证未通过！");
            return;
        }
        angular.extend(chem, {
            disposal: {content: $scope.fcontent},
            categories: $scope.categories,
            wasteCategories: $scope.wasteCategories,
            orgId: permissionService.getOrgId()
        });
        if (angular.isUndefined($scope.chem.id)) {
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(chem), 108039));
        } else {
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(chem), 108040));
        }

    };

    $scope.categories = [];
    $scope.wasteCategories = [];
    $scope.querySearch1 = function (criteria) {
        if ($scope.chemCateList.filter(createFilterFor(criteria)) == [] || ($scope.chemCateList.filter(createFilterFor(criteria))).length == 0) {
            return getObject(criteria);
        } else {
            return $scope.chemCateList.filter(createFilterFor(criteria));
        }

        return $scope.chemCateList;
    }

    function getObject(c) {
        var contact = {
            id: "",
            fname: c,
            msg: '暂无该数据,保存后自动维护'
        };
        var newDate = [];
        newDate.push(contact);
        return newDate;
    }

    function createFilterFor(query) {
        var lowercaseQuery = angular.lowercase(query);
        return function filterFn(contact) {
            return (contact.fname.indexOf(lowercaseQuery) != -1);
        };
    }

});
//列表中类别展示
app.filter("chem_cate_list", function ($sce) {
    return function (input) {
        if (input != null && input != [] && input.length > 0) {
            var html = "";
            for (var i = 0; i < input.length; i++) {
                html = html + input[i].fname + "</br> ";
            }
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});