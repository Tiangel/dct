app.controller('warnDetailController', function ($scope, $log, $q, $timeout, $mdSidenav, $location, $controller, $mdDialog, $state, NgTableParams, $stateParams, httpService, permissionService) {

    $controller('baseController', {$scope: $scope});

    $log.debug('Created warnDetailController');

    $scope.ftype = $location.search().ftype;
    $scope.from = $location.search().from;
    var warnRow = $location.search().row;
    warnRow = $.parseJSON(warnRow);
    var itemNo = warnRow.itemNo;
    var reagentId = warnRow.relMsgId;
    //显示预警的信息
    $scope.fcontext = warnRow.fcontext;
    if (itemNo == $scope.warnItemNoForReceiveTime || itemNo == $scope.warnItemNoForRecoveryUsed) { //是领用预警中超出时间的预警或是回库预警
        if (reagentId != null) {
            reagentId = reagentId.substr(reagentId.lastIndexOf("-") + 1, reagentId.length);
        }
    } else if (itemNo == $scope.warnItemNoForRecovery) {    //是回收预警而且没有明细信息
        if (warnRow.extraMsg == null || warnRow.extraMsg == "" || warnRow.extraMsg == [] || warnRow.extraMsg == -1) {
            itemNo = 2;
            $scope.recoveryShowBtn = true;
            $scope.recoveryShowTable = false;
        } else {
            $scope.recoveryShowBtn = false;
            $scope.recoveryShowTable = true;
        }
    }

    //判断搁置关闭框是否隐藏
    if ($scope.from == 2) {
        $scope.showForm = false;
    } else {
        $scope.showForm = true;
    }

    /**
     * 查询列表
     */
    if (warnRow.itemNo == $scope.warnItemNoForReceiveNum || warnRow.itemNo == $scope.warnItemNoForReceiveTime) {
        $scope.ftype = 1;
        httpService.post(buiderPostParam($.parseJSON(warnRow.extraMsg), '108036'))
            .then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    $scope.receiveData = data.data;
                }
            })
    } else if (itemNo != 2 && warnRow.itemNo == $scope.warnItemNoForRecovery) {
        $scope.ftype = 2;
        $scope.recoveryTableParams = new NgTableParams({}, {
            getData: function (params) {
                return httpService.post(buiderPostParam(buiderPage(params, {
                    orgId: $scope.orgId,
                    id: warnRow.extraMsg
                }), 108020)).then(function (response) {
                    var data = response.data;
                    if (isSuccess(data)) {
                        params.total(data.data.total);
                        return data.data.data;
                    }
                });
            }
        });
    } else if (warnRow.itemNo == $scope.warnItemNoForCheck) {
        $scope.ftype = 3;
        $scope.checkTableParams = new NgTableParams({}, {
            getData: function (params) {
                return httpService.post(buiderPostParam(warnRow.relMsgId, 114010))
                    .then(function (response) {
                        var data = response.data;
                        if (isSuccess(data)) {
                            if (!angular.isUndefined(data.data.checkChemList)) {
                                params.total(data.data.checkChemList.length);
                                return data.data.checkChemList;
                            }
                        }
                    })
            }
        });
    } else if (warnRow.itemNo == $scope.warnItemNoForRecoveryUsed) {
        $scope.ftype = 4;
        $scope.reagentUsed = $.parseJSON(warnRow.extraMsg);
    } else if (warnRow.itemNo == $scope.warnItemNoForMixInfo) {
        $scope.ftype = 5;
        $scope.mixChemTableParams = new NgTableParams({}, {
            getData: function (params) {
                return httpService.post(buiderPostParam(buiderPage(params, {
                    reagent: {orgId: $scope.orgId},
                    ids: $.parseJSON(warnRow.extraMsg)
                }), 108041))
                    .then(function (response) {
                        var data = response.data;
                        console.log(toJson(data));
                        if (isSuccess(data)) {
                            params.total(data.data.total);
                            return data.data.data;
                        }
                    })
            }
        });
    } else if (warnRow.itemNo == $scope.warnItemNoForEnviron) {
        $scope.ftype = 6;
        $scope.environ = $.parseJSON(warnRow.extraMsg);
    } else if (warnRow.itemNo == $scope.warnItemNoForReceiveIllegal) {
        $scope.ftype = 7;
    }

    /**
     * 关闭预警
     */
    $scope.closeWarn = function () {
        if ($scope.closeNote == null || $scope.closeNote == "") {
            $scope.showActionToast("请正确填写信息！");
            return false;
        }
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认关闭？")
            .ok('确认').cancel('取消')
        ).then(function () {
            httpService.post(buiderPostParam({
                id: warnRow.id,
                status: 2,
                warnRecordLogDTO: {
                    note: $scope.closeNote,
                    memberId: permissionService.getUserId()
                },
            }, 114011)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    $scope.showActionToast("操作成功");
                    $scope.goBack();
                }
            });

        });
    };

    /**
     * 搁置预警
     */
    $scope.delayWarn = function () {
        if ($scope.delayNote == null || $scope.delayNote == "") {
            $scope.showActionToast("请输入搁置原因！");
            return false;
        }
        if ($scope.shelveTime == null || $scope.shelveTime == "") {
            $scope.showActionToast("请输入合法的搁置时间！");
            return false;
        }
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认搁置？")
            .ok('确认').cancel('取消')
        ).then(function () {
            httpService.post(buiderPostParam({
                id: warnRow.id,
                status: 3,
                warnRecordLogDTO: {
                    note: $scope.delayNote,
                    memberId: permissionService.getUserId(),
                    shelveTime: $scope.shelveTime
                },
            }, 114011)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    $scope.showActionToast("操作成功");
                    $scope.goBack();
                }
            });

        });
    };

    /**
     * 返回
     */
    $scope.goBack = function (from) {
        httpService.post(buiderPostParam({orgId: $scope.orgId}, 114013)).then(function (response) {
            var data = response.data;
            if (isSuccess(data)) {
                var data1 = data.data;
                var tabFlag = 0;
                var itemNoFlag = warnRow.itemNo;
                if ($scope.warnItemNoForReceive2.indexOf(warnRow.itemNo) >= 0) {
                    itemNoFlag = $scope.warnItemNoForReceive1;
                }
                for (var i = 0; i < data1.length; i++) {
                    if (itemNoFlag.indexOf(data1[i].itemNo) >= 0) {
                        tabFlag = i;
                    }
                }
                if (from == 2) {
                    $state.go("admin.warning_history", {selectedIndex: tabFlag});
                } else {
                    $state.go("admin.warning_manager", {selectedIndex: tabFlag});
                }
            }
        });
    };

    /**
     * 查看轨迹详情
     */
    $scope.toReceiveDetail = function (w) {
        if (itemNo == $scope.warnItemNoForReceiveNum || itemNo == $scope.warnItemNoForReceiveTime) {
            $mdSidenav('right').toggle().then(function () {
                httpService.post(buiderPostParam({orgId: $scope.orgId, reagentId: w.reagentId}, 108031))
                    .then(function (response) {
                        var chemLists = response.data.data;
                        dealTrajList(chemLists);
                    });
            });
        } else if (warnRow.itemNo == $scope.warnItemNoForRecovery || itemNo == $scope.warnItemNoForRecoveryUsed) {
            $mdSidenav('right').open().then(function () {
                httpService.post(buiderPostParam({orgId: $scope.orgId, reagentId: reagentId}, 108031))
                    .then(function (response) {
                        var chemLists = response.data.data;
                        dealTrajList(chemLists);
                    });
            });
        } else if (warnRow.itemNo == $scope.warnItemNoForMixInfo) {
            $mdSidenav('right').toggle().then(function () {
                httpService.post(buiderPostParam({orgId: $scope.orgId, reagentId: w.id}, 108031))
                    .then(function (response) {
                        var chemLists = response.data.data;
                        dealTrajList(chemLists);
                    });
            });
        }
    };

    /**
     * 盘点查看详情
     */
    $scope.toCheckDetail = function (row) {
        $mdSidenav('check').toggle().then(function () {
            httpService.post(buiderPostParam({checkChemId: row.id}, 115002))
                .then(function (response) {
                    $scope.chemReagentList = response.data.data;
                });
        });
    };

    /**
     * 查看盘点中的轨迹详情
     * @param row
     */
    $scope.toCheckTraj = function (row) {
        $mdSidenav('check').close().then(function () {
            $mdSidenav('right').toggle().then(function () {
                dealTrajList(row.chemTrajDTO);
            });
        });
    };

    /**
     * 转化list为时间轴
     *
     * @param chemTrajList
     */
    function dealTrajList(chemTrajList) {
        var list = [];
        if (chemTrajList != null) {
            for (var i = 0; i < chemTrajList.length; i++) {
                var arr = {
                    badgeClass: 'timeline-badge',
                    badgeIconClass: 'glyphicon-record',
                    title: chemTrajList[i].fname + '   ' + getLocalTime(chemTrajList[i].createAt),
                    content: (chemTrajList[i].inChargeMember == "") ? "" : chemTrajList[i].inChargeMember.realName + "  " + chemTrajList[i].inChargeMember.mobile
                };
                list.push(arr);
            }
        }
        $scope.events = list;
    }

    function getLocalTime(nS) {
        var myDate = new Date(nS);
        var year = myDate.getFullYear();
        var month = myDate.getMonth() + 1;
        var day = myDate.getDate();
        var hours = myDate.getHours();
        var minutes = myDate.getMinutes();
        return year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;
    }

    //处理时间
    function toDate(w) {
        if (w.createAt != null && w.createAt != "") {
            w.createAt = new Date(w.createAt);
        }
        if (w.appointAt != null && w.appointAt != "") {
            w.appointAt = new Date(w.appointAt);
        }
        return w;
    };
    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close().then(function () {
            $scope.btnDisabled = false;
            $scope.list = '';
        });
    };
    //关闭右侧
    $scope.closeCheck = function () {
        $mdSidenav('check').close();
    };
});

app.filter("warn_chem_manager", function ($sce) {
    return function (input) {
        if (input != null && input != []) {
            var html = input.chem.fname + "</br> " + input.chem.cas;
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});
app.filter("warn_member_group", function ($sce) {
    return function (input) {
        if (input != null && input != "" && input != [] && input.length > 0) {
            var html = "";
            for (var i = 0; i < input.length; i++) {
                html = html + input[i].fname;
            }
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});
app.filter("get_address", function ($sce) {
    return function (input) {
        if (input.wh != null && input.wh != "") {
            return input.wh.whName;
        } else if (input.lab != null && input.lab != "") {
            return input.lab.labName;
        } else {
            return "";
        }
    }
});
