/**
 * Created by hanley on 2016/7/16.
 * 组织管理
 */
'use strict';

app.controller('orgController', function ($scope, $controller, NgTableParams , httpService) {

    $controller('baseController', { $scope: $scope })

    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            return httpService.getTablePage(params, { 'fname': $scope.fname }, 100016)
        }
    });

})