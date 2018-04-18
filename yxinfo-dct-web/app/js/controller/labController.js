/**
 * Created by cy on 2016/7/1.
 */
'use strict';

app.controller('labController', function ($scope, $q, $mdSidenav, $sce, Upload, $controller, $log, httpService, $timeout, $filter, NgTableParams, $mdDialog, permissionService, $state) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created labController');
    //一览数据
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            var memberId = "";
            if ($scope.selectedMember != null) {
                memberId = $scope.selectedMember.id;
            }
            var labName = "";
            if ($scope.selectedLab != null) {
                labName = $scope.selectedLab.labName;
            }
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId(),
                labName: labName,
                memberId: memberId,
                purpose: $scope.purpose,
                labStatus: $scope.labStatus
            }), 104003)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            });
        }
    });

    //状态动态刷新
    $scope.$watchGroup(['labStatus', 'purpose'], function (newValue, oldValue) {
        if (newValue != oldValue) {
            $scope.reflashHandler();
        }
    });
    //删除一行数据
    $scope.delete = function (row) {
        $scope.deleteHandler(httpService.post, buiderPostParam({labId: row.labId}, 104004), '#delete' + row.labId);
    };

    //新增或编辑保存
    $scope.save = function () {
        var beans = $scope.labManaMemberList;
        var manaList = [];
        if (beans != null && beans.length > 0) {
            for (var i = 0; i < beans.length; i++) {
                manaList.push({
                    memberId: beans[i].id
                });
            }
        }
        var beans2 = $scope.labSafetyMemberList;
        var safeList = [];
        if (beans2 != null && beans2.length > 0) {
            for (var i = 0; i < beans2.length; i++) {
                safeList.push({
                    memberId: beans2[i].id
                });
            }
        }
        var beans3 = $scope.labTechMemberList;
        var techList = [];
        if (beans3 != null && beans3.length > 0) {
            for (var i = 0; i < beans3.length; i++) {
                techList.push({
                    memberId: beans3[i].id
                });
            }
        }
        if ($scope.lab == undefined || $scope.lab == "") {
            $scope.showActionToast("验证未通过！");
            return;
        }
        if (!angular.isUndefined($scope.lab) && !angular.isUndefined($scope.lab.memberList)) {
            $scope.lab.memberList = [];
        }
        if (!$scope.labForm.$valid) {
            $scope.showActionToast("验证未通过！");
            return;
        }
        //设置默认的时间
        if (angular.isUndefined($scope.lab.openStartAt) || $scope.lab.openStartAt == null || $scope.lab.openStartAt == "") {
            $scope.lab.openStartAt = new Date();
        }
        if (angular.isUndefined($scope.lab.openEndAt) || $scope.lab.openEndAt == null || $scope.lab.openEndAt == "") {
            $scope.lab.openEndAt = new Date("2036-01-01 00:00:00");
        }
        var labBean = $scope.lab;
        angular.extend(labBean, {
            labManaMemberList: manaList,
            labSafetyMemberList: safeList,
            labTechMemberList: techList,
            orgId: permissionService.getOrgId()
        });

        if (angular.isUndefined($scope.lab.labId)) {
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(labBean), 104001));
        } else {
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(labBean), 104006));
        }

    };

    //关闭右侧窗口
    $scope.close = function () {
        if ($scope.lab && $scope.lab.labId) {
            $scope.lab = "";//清除框中的数据
            $scope.labSafetyMemberList = "";
            $scope.labManaMemberList = "";
            $scope.labTechMemberList = "";
        }
        $mdSidenav('right').close();
        $mdSidenav('detail').close();
        $scope.readonly = false;
        $scope.disabled = false;
    };
    //打开新增页面
    $scope.toggleRightAdd = function (row) {
        $mdSidenav('right').toggle().then(function () {
            $scope.labManaMemberList = [];
            $scope.labSafetyMemberList = [];
            $scope.labTechMemberList = [];
            // $scope.lab = row;
        });
    };
    //打开编辑页面
    $scope.toggleRightUpdate = function (row) {
        $mdSidenav('right').toggle().then(function () {
            row = getMemberList(row);
            $scope.lab = row;
        });
    };
    //打开详情页面
    $scope.toggleRightDetail = function (row) {
        $mdSidenav('detail').toggle().then(function () {
            row = getMemberList(row);
            $scope.lab = row;
            $scope.memberList = row.memberList;
            $scope.disabled = true;
            $scope.readonly = true;
        });
    };
    //打开导入页面
    $scope.toggleImport = function () {
        $mdSidenav('import').toggle().then(function () {
        });
    };
    //关闭右侧窗口
    $scope.closeImport = function () {
        $mdSidenav('import').close();
    };
    /**
     * 查看详情或编辑时转化数据的格式
     *
     * @param row
     * @returns {*}
     */
    function getMemberList(row) {
        if (row.openStartAt != null && row.openStartAt != "") {
            row.openStartAt = new Date(row.openStartAt);
        }
        if (row.openEndAt != null && row.openEndAt != "") {
            row.openEndAt = new Date(row.openEndAt);
        }
        var memberList = row.labSafetyMemberList;
        if (memberList != null) {
            var list = [];
            for (var i = 0; i < memberList.length; i++) {
                list.push(memberList[i].memberDTO);
            }
            $scope.labSafetyMemberList = list;
        }
        memberList = row.labManaMemberList;
        if (memberList != null) {
            var list = [];
            for (var i = 0; i < memberList.length; i++) {
                list.push(memberList[i].memberDTO);
            }
            $scope.labManaMemberList = list;
        }
        memberList = row.labTechMemberList;
        if (memberList != null) {
            var list = [];
            for (var i = 0; i < memberList.length; i++) {
                list.push(memberList[i].memberDTO);
            }
            $scope.labTechMemberList = list;
        }
        return row;
    }

    /**
     * 打开文件浏览页面
     */
    $scope.openFileSelect = function () {
        $("#labLile").click();
    };
    $scope.$watch('file', function (newValue, oldValue) {
        if (newValue != oldValue) {
            if ($scope.file) {
                $scope.fileName = $scope.file.name;
            }
        }
    });
    /**
     * 导入文件
     */
    $scope.submit = function () {
        // && $scope.form.file.$valid
        if ($scope.file) {
            var fileName = $scope.file.name;
            var suffix = fileName.substr(fileName.lastIndexOf("."), fileName.length);
            if (suffix == null || (suffix.toLocaleLowerCase() != ".xls" && suffix.toLocaleLowerCase() != ".xlsx")) {
                $scope.showActionToast("请正确选择文件");
                return;
            }
            httpService.baseUpLoadFileHttpPost({files: $scope.file, code: '100003'}).then(function (resp) {
                if (isSuccess(resp.data)) {
                    var url = resp.data.data[0].url;
                    httpService.post(buiderPostParam({
                        url: url,
                        orgId: permissionService.getOrgId()
                    }, 104009)).then(function (response) {
                        if (isSuccess(response.data)) {
                            showAlert($mdDialog, response.data.data.importRtnMsg);
                            $scope.reflashHandler();
                            $scope.closeImport();
                        }
                    });
                }
            });
        } else {
            $scope.showActionToast("请正确选择文件");
        }
    };

    /**
     * 导出文件
     */
    $scope.exportLab = function () {
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认导出符合条件的数据？")
            .ok('确认').cancel('取消')
        ).then(function () {
            httpService.post(buiderPostParam({
                orgId: permissionService.getOrgId(),
                labName: $scope.labName,
                labCode: $scope.labCode
            }, 104010)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    if (!angular.isUndefined(response.data.data.url)) {
                        var url = response.data.data.url;
                        window.location.href = url;
                    } else {
                        $scope.showActionToast("下载失败");
                    }

                }
            });
        });
    }
});

//获取实验室安全员或负责人信息
app.filter("lab_manager", function ($sce) {
    return function (input, flag) {
        if (input != null && input != [] && input.length > 0) {
            var html = "";
            for (var i = 0; i < input.length; i++) {
                if (flag == 1) {
                    html = html + input[i].memberName + "</br> ";
                } else if (flag == 2) {
                    html = html + input[i].phone + "</br> ";
                }
            }
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});
