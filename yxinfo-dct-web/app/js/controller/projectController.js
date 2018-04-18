/**
 * Created by ZH on 2016/7/13.
 */
"use strict";

app.controller('projectController', function ($log, $controller,$mdSidenav, NgTableParams, $scope, httpService) {
    $controller( 'baseController', { $scope: $scope});

    $log.debug( 'Created projectController' );

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params){
            return httpService.post(buiderPostParam(buiderPage(params,{
                orgId: $scope.orgId,
                status: $scope.status,
                fname: $scope.fname}),120002))
                .then(function (response) {
                    var data = response.data;
                    if ( isSuccess(data) ) {
                        params.total(data.data.total);
                        return data.data.data;
                    }
                })
        }
    });
    //状态动态刷新
    $scope.$watch('status', function (newValue, oldValue) {
        if (newValue != oldValue) {
            $scope.reflashHandler();
        }
    });
    //新增或编辑保存
    $scope.addOrUpdate = function () {
        var projectBean = $scope.list;
        angular.extend(projectBean, {
            orgId: $scope.orgId,});
        if (angular.isUndefined($scope.list.id)) {
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(projectBean), 120003));
        } else {
            $scope.addOrUpdateHandler(httpService.post, buiderPostParam(toJson(projectBean), 120004));
        }
    };

    //至查看页面
    $scope.toUpdate = function (w) {
        $mdSidenav('right')
            .toggle()
            .then(function () {
                $scope.list = w;
            });
    };

    //至添加页面
    $scope.toadd = function () {
        $mdSidenav('right')
            .toggle()
            .then(function () {
                $scope.list = "";
            });
    };

    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close()
            .then(function () {
                $scope.btnDisabled=false;
                $scope.list='';
            });

    };

    //删除一行数据
    $scope.delete = function (row) {
        $scope.deleteHandler(httpService.post, buiderPostParam({id: row.id, status: 2}, 120004), '#delete' + row.id);
    };
});

