/**
 * Created by cy on 2016/7/13.
 */
'use strict';
app.controller('warningPersonController', function ($log, $controller, $q, $mdSidenav, NgTableParams, $scope, $element, httpService) {
    $controller('baseController', {$scope: $scope});

    $log.debug('Created warningPersonController');

    //列表
    $scope.tableParams = new NgTableParams({}, {
        getData: function (params) {
            var memberName = "";
            if($scope.selectedMember!=null){
                memberName=$scope.selectedMember.realName;
            }
            return httpService.post(buiderPostParam(buiderPage(params, {
                orgId: $scope.orgId,
                fname: memberName
            }), 114018 )).then(function (response) {
                var data = response.data;
                if (isSuccess(data)) {
                    params.total(data.data.total);
                    return data.data.data;
                }
            })
        }
    });


    //新增或编辑保存
    $scope.save = function () {
        var warnSelected = $scope.warnSelected;
        var itemNoList = [];
        for (var i=0 ; i< warnSelected.length ; i++) {
            var itemNo = {
                itemNo:warnSelected[i]
            };
            itemNoList.push(itemNo);
        }
        var realName= $scope.memberSelected.realName;
        var mobile = $scope.memberSelected.mobile;
        var memberId =$scope.memberSelected.id;
        var id = $scope.list.id;
        if (angular.isUndefined(id)) {
            httpService.post(buiderPostParam({
                fname: realName,
                mobile: mobile,
                memberId:memberId,
                orgId: $scope.orgId,
                warnPersonItemDTOList:itemNoList},114015)).success(function (response) {
                if(isSuccess(response)){
                    $scope.reflashHandler();
                    $scope.close();
                    $scope.showActionToast('保存成功');
                }
            })
        } else {
            httpService.post(buiderPostParam({
                id:id,
                fname: realName,
                mobile: mobile,
                memberId:memberId,
                orgId: $scope.orgId,
                warnPersonItemDTOList:itemNoList},114016)).success(function (response) {
                if(isSuccess(response)){
                    $scope.reflashHandler();
                    $scope.close();
                    $scope.showActionToast('保存成功');
                }
            })
        }

    };

    //删除一行数据
    $scope.delete = function (row) {
        $scope.deleteHandler(httpService.post, buiderPostParam(row.id, 114017), '#delete' + row.id);
    };

    //添加页面
    $scope.toggleRightAdd = function () {
        $mdSidenav('right').toggle();
        $scope.getWarnItemList();
        $scope.list="";
    }

    //修改页面
    $scope.toggleRightUpdate = function (w) {
        $mdSidenav('right').toggle().then(function () {
            $scope.getWarnItemList();
            $scope.list=w;
            var warnSelected = w.warnPersonItemDTOList;
            var str = [];
            if (warnSelected != null) {
                var warnNoFlag = true;
                for (var i = 0 ; i < warnSelected.length; i++){
                    if (warnSelected[i].itemNo != 100001 && warnSelected[i].itemNo != 100002) {
                        str.push(
                             warnSelected[i].itemNo
                        );
                        continue;
                    }
                    if (warnNoFlag && (warnSelected[i].itemNo == 100001 || warnSelected[i].itemNo == 100002)) {
                        warnNoFlag = false;
                        str.push(
                             "100001-100002"
                        );
                    }
                }
                $scope.warnPersonItemDTOList = str;
            }
        });
    }


    //关闭右侧
    $scope.close = function () {
        $mdSidenav('right').close();
    };

});

app.filter("warn_item", function ($sce) {
    return function (input) {
        if (input != null && input != [] && input.length > 0) {
            var flag = true;
            var html = "";
            for (var i = 0; i < input.length; i++) {
                if (flag || (input[i].itemNo != 100001 && input[i].itemNo != 100002)) {
                    html = html + input[i].itemName +  "</br> ";
                }
                if (input[i].itemNo == 100001 || input[i].itemNo == 100002) {
                    flag = false;
                }
            }
            return $sce.trustAsHtml(html);
        } else {
            return "";
        }
    }
});