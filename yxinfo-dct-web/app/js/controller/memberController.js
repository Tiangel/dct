/**
 * Created by hanley on 2016/7/1.
 */
'use strict';

app.controller('memberController', function ($scope,$state, $controller, $mdDialog, $mdMedia, $mdSidenav, NgTableParams, memberService,httpService,$mdPanel) {

    $controller('baseController', {$scope: $scope});
    
    //初始化树形菜单
    memberService.getGroupByOrg($scope.orgId).then(function(response){
        var data = response.data;
        if ( isSuccess(data) ) {
            $scope.treeData = data.data;
            if(data.data == undefined || data.data == null){
                $scope.treeData = [];
            }
            $scope.treeData.push({id:0,pid:-1,fname:$scope.orgName});
            tree.init("groupTree", $scope.treeData);
        }
    });

    //修改成员组时点击父成员组节点初始化树形菜单
    $scope.changePNode = function(ev, type){
        var panelCtrl;
        var clickObjId;
        if(type == "editGroup"){
            clickObjId = "updatePGroup";
            panelCtrl = function($timeout){
                $timeout(function() {
                    var updateTreeObj = document.getElementById("updateGroupTree");
                    angular.element(updateTreeObj).ready(function(){
                        updateTree.init($(updateTreeObj), $scope.treeData, function(event, treeId, treeNode) {
                            if (treeNode.fname == $scope.group.fname) {
                                showAlert($mdDialog, '父成员组和子成员组不能相同！');
                            } else {
                                $scope.group.parentName = treeNode.fname;
                                $scope.group.pid = treeNode.id;
                                $("#updatePGroup").click();
                            }
                        });
                    });
                });
            }
        }else if(type == "member"){
            clickObjId = "memberGroupNames";
            panelCtrl = function($timeout){
                $timeout(function() {
                    var updateTreeObj = document.getElementById("updateGroupTree");
                    angular.element(updateTreeObj).ready(function(){
                        updateTree.init($(updateTreeObj), $scope.treeData, function (event, treeId, treeNode) {
                            if(treeNode.id == 0){
                                return false;
                            }
                            for (var i in $scope.memberGroupNames) {
                                var group = $scope.memberGroupNames[i];
                                if (group.id == treeNode.id) {
                                    showAlert($mdDialog, "不能重复选择成员组");
                                    return false;
                                }
                            }
                            if ($scope.memberGroupNames == null || $scope.memberGroupNames == "") {
                                $scope.memberGroupNames = [{id: treeNode.id, fname: treeNode.fname}];
                            } else {
                                $scope.memberGroupNames.push({id: treeNode.id, fname: treeNode.fname});
                            }
                            $("#memberGroupNames").click();
                        });
                    });
                });
            }
        }
        $scope.showMenu(ev, panelCtrl, clickObjId);
    }

    $scope.showMenu = function(event, panelCtrl, clickObjId){
        if($("#updateGroupTree").html() == undefined) {
            var position = $mdPanel.newPanelPosition()
                .relativeTo('#'+clickObjId)
                .addPanelPosition($mdPanel.xPosition.ALIGN_START, $mdPanel.yPosition.BELOW);
            var config = {
                attachTo: angular.element(document.body),
                controller: panelCtrl,
                template: '<md-card md-theme="default"><ul id="updateGroupTree" class="ztree"></ul></md-card>',
                panelClass: 'demo-menu-example',
                position: position,
                locals: {
                    'selected': this.selected,
                    'desserts': this.desserts
                },
                openFrom: event,
                clickOutsideToClose: true,
                escapeToClose: true,
                focusOnOpen: false,
                zIndex: 2
            };
            $mdPanel.open(config);
        }
    }

    $scope.tableParams = new NgTableParams({}, {
        getData: function (params){
            return memberService.getData(buiderPage(params, {orgId: $scope.orgId, mobile: $scope.mobile, loginName: $scope.loginName, realName: $scope.realName})).then(function (response) {
                var data = response.data;
                if ( isSuccess(data) ) {
                    params.total( data.data.total  );
                    return data.data.data;
                }
            })
        }
    });

    //删除成员
    $scope.deleteMember = function(id){
        $scope.deleteHandler(httpService.post, buiderPostParam(id, 100023), '#delete' + id);
    };
    //查看成员详情
    $scope.detail = function(id){
        $scope.memberDetail = memberService.getMemberDetail({id: id, orgId: $scope.orgId}).then(function(response){
            var data = response.data;
            if ( isSuccess(data) ) {
                $scope.detailMember = data.data;
                $scope.detailMemberGroupNames = data.data.groups;
            }
        });
        $mdSidenav('memberDetail').toggle();
    }

    $scope.toEditMember = function(id){
        if(id <= 0){
            $scope.member = {};
            $scope.memberGroupNames = null;
            $scope.editTitle = "添加成员";
        }else{
            memberService.getMemberDetail({id: id, orgId: $scope.orgId}).then(function(response){
                var data = response.data;
                if ( isSuccess(data) ) {
                    $scope.member = data.data;
                    $scope.memberGroupNames = data.data.groups;
                    $scope.editTitle = "修改成员";
                }
            });
        }
        $mdSidenav('editMember').toggle();
    };

    //编辑成员
    $scope.saveMember = function(){
        if(!$scope.memberForm.$valid){
            return false;
        }
        $scope.member.orgId = $scope.orgId;
        $scope.member.groups = $scope.memberGroupNames;
        var code = 100025;
        if($scope.member.id != null && $scope.member.id != ""){
            code = 100026;
        }
        memberService.editMember(code, $scope.member).then(function(response){
            var data = response.data;
            if(isSuccess(data)){
                $scope.showActionToast("操作成功");
                $mdSidenav('editMember').close();
                $scope.member = {};
                $scope.reflashHandler();
            }
        });
    }
    //添加成员组
    $scope.saveGroup = function(){
        if(!$scope.groupForm.$valid){
            return false;
        }
        var code = 100021;
        var group = $scope.group;
        if(group.id < 0){
            code = 100020;
            delete group.id;
        }
        memberService.editGroup(code,group).then(function(response){
            var data = response.data;
            if(isSuccess(data)){
                memberService.getGroupByOrg($scope.orgId).then(function(response){
                    var data = response.data;
                    if ( isSuccess(data) ) {
                        $scope.treeData = data.data;
                        $scope.treeData.push({id:0,pid:-1,fname:$scope.orgName});
                        tree.init("groupTree", $scope.treeData);
                    }
                });
                $mdSidenav('editGroup').close();
            }
        });
    }
    //关闭右侧弹窗方法
    $scope.closeSidenav = function(type){
        $mdSidenav(type).close();
    }
    //成员组树形菜单初始化
    var tree = {
        init: function(treeId, datas){
            var setting = {
                view: {
                    addHoverDom: addHoverDom,
                    removeHoverDom: removeHoverDom,
                    selectedMulti: false,
                    showTitle: false,
                    showLine: false,
                    fontCss: {"font-family":"微软雅黑"}
                },
                edit: {
                    enable: true,
                    editNameSelectAll: true,
                    showRemoveBtn: showRemove,
                    showRenameBtn: false,
                    removeTitle: "删除"
                },
                data: {
                    key: {
                        name: "fname"
                    },
                    simpleData: {
                        enable: true,
                        pIdKey: "pid"
                    }
                },
                callback: {
                    beforeRemove: beforeRemove
                }
            };

            function showRemove(treeId, treeNode){
                if(treeNode.id == 0){
                    return false;
                }
                return true;
            }

            //TODO 删除成员组请求
            function beforeRemove(treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj(treeId);
                zTree.selectNode(treeNode);
                $mdDialog.show(
                    $mdDialog.confirm()
                        .title('删除成员组')
                        .textContent('确定要删除' + treeNode.fname + "吗！")
                        .ok('确定')
                        .cancel('取消')
                ).then(function(){
                        memberService.deleteGroup(treeNode.id).then(function(response){
                            var data = response.data;
                            if(isSuccess(data)){
                                var result = data.data;
                                if(result == 1){
                                    $scope.showActionToast("删除成功");
                                    memberService.getGroupByOrg($scope.orgId).then(function(response){
                                        var data = response.data;
                                        if ( isSuccess(data) ) {
                                            $scope.treeData = data.data;
                                            $scope.treeData.push({id:0,pid:-1,fname:$scope.orgName});
                                            tree.init("groupTree", $scope.treeData);
                                        }
                                    });
                                }else if(result == - 1){
                                    showAlert($mdDialog, "有成员的成员组不能删除！");
                                }else if(result == -2){
                                    showAlert($mdDialog, "有子成员组的成员组不能删除！");
                                }
                            }
                        });
                    },function(){
                    });
                return false;
            }

            //弹出添加/修改成员组窗口
            function addHoverDom(treeId, treeNode) {
                var sObj = $("#" + treeNode.tId + "_span");
                if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
                var str = "<span class='button add' id='addBtn_" + treeNode.tId+ "' title='添加子成员组' onfocus='this.blur();'></span>" +
                    "<span class='button edit' id='editBtn_" + treeNode.tId+ "' title='重命名' onfocus='this.blur();'></span>";

                if(treeNode.id == 0){
                    str = "<span class='button add' id='addBtn_" + treeNode.tId+ "' title='添加子成员组' onfocus='this.blur();'></span>";
                }

                sObj.after(str);
                $("#addBtn_"+treeNode.tId).unbind().bind("click",function(){
                    $scope.group = {id:-1,pid: treeNode.id, orgId: $scope.orgId};
                    $scope.editGroupTitle = "添加成员组";
                    $mdSidenav('editGroup').toggle();
                });
                $("#editBtn_"+treeNode.tId).unbind().bind("click",function(){
                    $scope.group = {id: treeNode.id, orgId: $scope.orgId, fname: treeNode.fname, pid: treeNode.getParentNode() == null ? 0 : treeNode.getParentNode().id};
                    $scope.group.parentName = treeNode.getParentNode() == null ? "无父成员组" : treeNode.getParentNode().fname;
                    $scope.editGroupTitle = "修改成员组";
                    $mdSidenav('editGroup').toggle();
                });
                $("#"+treeNode.tId + "_span").unbind().bind("click",function(){
                    memberService.getData({numPerPage: 10, pageNum: 1, data: {orgId: $scope.orgId, groupId: treeNode.id}}).then(function (response) {
                        var data = response.data;
                        if ( isSuccess(data) ) {
                            $scope.tableParams = new NgTableParams({}, { dataset: data.data.data});
                        }
                    });
                });
            }
            //删除添加和删除按钮
            function removeHoverDom(treeId, treeNode) {
                $("#addBtn_"+treeNode.tId).unbind().remove();
                $("#editBtn_"+treeNode.tId).unbind().remove();
            }

            $.fn.zTree.init($("#"+treeId), setting, datas);
        }
    }
    //修改成员组树形菜单初始化
    var updateTree = {
        init: function(treeId, datas, clickFn){
            var setting = {
                view: {
                    selectedMulti: false,
                    showTitle: false,
                    showLine: false,
                    fontCss: {"font-family":"微软雅黑"}
                },
                data: {
                    key: {
                        name: "fname"
                    },
                    simpleData: {
                        enable: true,
                        pIdKey: "pid"
                    }
                },
                callback: {
                    onClick: clickFn
                }
            };
            $.fn.zTree.init(treeId, setting, datas);
        }
    }

    /**
     * 关闭修改密码框
     *
     */
    $scope.closeDialog = function () {
        $mdDialog.cancel();
    };

    /**
     * 保存密码
     *
     */
    $scope.savePassword = function () {
        $scope.showActionToast("暂无此功能！");
    };
});

