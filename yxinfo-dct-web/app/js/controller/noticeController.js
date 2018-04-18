/**
 * Created by sxd on 2016/8/10.
 */
'use strict';

app.controller('noticeController', function ($controller, $q, $mdSidenav, $mdDialog, NgTableParams, $scope, $element, httpService, permissionService) {

    $controller( 'baseController', { $scope: $scope});

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: permissionService.getOrgId()
            }), 110009)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });

    //删除一行数据
    $scope.delete = function (nid) {
        $scope.deleteHandler(httpService.post, buiderPostParam({id: nid}, 110007), '#delete' + nid);
    };

    //发布
    $scope.show = function (notice) {
        if(notice.isShow){
            showAlert($mdDialog, "该公告已发布");
            return false;
        }
        var area = "#show" + notice.id;
        $mdDialog.show($mdDialog.confirm().clickOutsideToClose(true).title("是否确认发布？")
                .ok('确认').cancel('取消').openFrom(area).closeTo(area)
        ).then(function () {
                httpService.post(buiderPostParam({id: notice.id}, 110008)).then(function (response) {
                    var data = response.data;
                    if (isSuccess(data)) {
                        $scope.showActionToast("发布成功");
                        $scope.reflashHandler();
                    }
                });
            });
    };

    //编辑页面
    $scope.toEdit = function (notice) {
        if(notice == -1){
            notice = {};
        }
        $scope.notice = notice;
        $mdSidenav('edit').toggle();
    }

    //关闭右侧
    $scope.close = function (page) {
        $mdSidenav(page).close();
    };

    $scope.save = function() {
        var notice = $scope.notice;
        var code = 110005;
        if(notice.id > 0){
            code = 110006;
        }
        if ($scope.editForm.$valid) {
            angular.extend(notice, {orgId: permissionService.getOrgId(), memberId: permissionService.getUserId()});
            httpService.post(buiderPostParam(toJson(notice), code)).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    $scope.showActionToast("操作成功");
                    $scope.close('edit');
                    $scope.reflashHandler();
                }
            });
        } else {
            $scope.showActionToast("验证未通过！");
        }
    }

    $scope.detail = function(notice){
        $scope.notice = notice;
        $mdSidenav('detail').toggle();
    }

})
