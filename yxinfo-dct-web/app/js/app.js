/**
 * Created by hanley on 2016/6/13.
 */
'use strict';
var app = angular.module('app', ['ngMaterial', 'angular-timeline','ngFileUpload', 'ui.router', 'ngSanitize','ngMessages', 'LocalStorageModule', 'angular-loading-bar', 'appHttpInterceptor', 'ngTable','chart.js', 'treeView' ]);

app.config(function ( $stateProvider, $urlRouterProvider, localStorageServiceProvider, $mdThemingProvider ) {

    $stateProvider
        .state('login', {
            url: '/login',
            controller: 'loginController',
            templateUrl: 'views/login.html'
        })
        .state('admin', {
            abstract: true,
            url: '/admin',
            controller: 'adminController',
            templateUrl: 'views/template.html'
        })
        .state('admin.home', {
            url: '/home',
            controller: 'homeCtrl',
            templateUrl: 'views/admin/home.html'
        })
        .state('admin.setting', {
            url: '/setting',
            templateUrl: 'views/admin/setting.html'
        })
        .state('admin.lab_list', {
            url: '/lab_list',
            controller: 'labController',
            templateUrl: 'views/lab/lab_list.html'
        })
        .state('admin.lab_edit', {
            url: '/lab_edit',
            template: 'lab_edit'
        })
        .state('admin.member_list', {
            controller: 'memberController',
            url: '/member_list',
            templateUrl: 'views/admin/member_list.html'
        })
        .state('admin.member_modify', {
            controller: 'memberController',
            url: '/member_modify',
            templateUrl: 'views/member/member_modify.html'
        })
        .state('admin.chemReagent_list', {
            url: '/chemReagent_list',
            controller:'chemReagentController',
            templateUrl: 'views/chem/chemReagent_list.html'
        })
        .state('admin.chemAReceive_list', {
            url: '/chemAReceive_list',
            controller:'chemAReceiveController',
            templateUrl: 'views/chem/chemAReceive_list.html'
        })
        .state('admin.recovery_list', {
            url: '/recovery_list',
            controller:'recoveryManageController',
            templateUrl: 'views/recoveryManage/recovery_list.html'
        })
        .state('admin.topicLog_list', {
            url: '/topicLog_list',
            controller:'topicLogController',
            templateUrl: 'views/topicLog/topicLog_list.html'
        })
        .state('admin.whManager_list', {
            url: '/whManager_list',
            controller: 'whManagerController',
            templateUrl: 'views/whManager/whManager_list.html'
        })
        .state('admin.chemSummary_list', {
            url: '/chemSummary_list',
            controller:'chemSummaryController',
            templateUrl: 'views/chemSummary/chemSummary_list.html'
        })
        .state('admin.chemStatsRet_list', {
            url: '/chemStatsRet_list',
            controller:'chemStatsRetController',
            templateUrl: 'views/chemStatsRet/chemStatsRet_list.html'
        })
        .state('admin.org_list', {
            controller: 'orgController',
            url: '/org_list',
            templateUrl: 'views/org/org_list.html'
        })
        .state('admin.warning', {
            url: '/warning',
            controller: 'warnDetailController',
            templateUrl: 'views/warning/warning_detail.html'
        })
        .state('admin.warning_history', {
            controller: 'warningController',
            url: '/warning_history',
            params: {
                selectedIndex: null
            },
            templateUrl: 'views/warning/warning_history.html'
        })
        .state('admin.warning_manager', {
            controller: 'warningManagerController',
            url: '/warning_manager',
            params: {
                selectedIndex: null
            },
            templateUrl: 'views/warning/warning_manager.html'
        })
        .state('admin.project_list', {
            controller: 'projectController',
            url: '/project_list',
            templateUrl: 'views/project/project_list.html'
        })
        .state('admin.instrument_list', {
            controller: 'instrumentController',
            url: '/instrument_list',
            templateUrl: 'views/instrument/instrument_list.html'
        })
        .state('admin.instru_bespeak_list', {
            controller: 'instruBespeakController',
            url: '/instru_bespeak_list',
            templateUrl: 'views/instrument/instru_bespeak_list.html'
        })
        .state('admin.monitor_place_list', {
            controller: 'monitorPlaceController',
            url: '/monitor_place_list',
            templateUrl: 'views/vmon/monitor_place_list.html'
        })
        .state('admin.monitor_device_list', {
            controller: 'monitorDeviceController',
            url: '/monitor_device_list',
            templateUrl: 'views/vmon/monitor_device_list.html'
        })
        .state('admin.vmon_monitor_list', {
            controller: 'vmonMonitorController',
            url: '/vmon_monitor_list',
            templateUrl: 'views/vmon/vmon_monitor_list.html'
        })
        .state('admin.warning_person', {
            controller: 'warningPersonController',
            url: '/warning_person',
            templateUrl: 'views/warning/warning_person.html'
        })
        .state('admin.chem_baseinfo', {
            controller: 'chemBaseInfoController',
            url: '/chemBaseInfo_list',
            templateUrl: 'views/chem/chemBaseInfo_list.html'
        })
        .state('admin.notice_list', {
            controller: 'noticeController',
            url: '/notice_list',
            templateUrl: 'views/notice/notice_list.html'
        })
    $urlRouterProvider.otherwise('/login');

    localStorageServiceProvider
        .setPrefix('yxinfo-web-dct')
        .setStorageType('sessionStorage')
        .setNotify(true, true);

    $mdThemingProvider.theme('blue')

})

app.run([ '$rootScope', function ($rootScope) {
    // $rootScope.logo = 'http://www.zcmu.edu.cn/Template/Default/images/logo_03.png';
  /*  $rootScope.logo = 'http://www.zhjhb.com/images/logo.png';*/
} ])


function showAlert($mdDialog, textContext) {
    $mdDialog.show(
        $mdDialog.alert()
            .textContent(textContext)
            .clickOutsideToClose(true)
            .ok(OK)
    )
}

function showConfirm($mdDialog, textContext, fromArea, closeArea) {
    return $mdDialog.show(
        $mdDialog.confirm()
            .clickOutsideToClose(true)
            .title(textContext)
            .ok(OK)
            .cancel(CANCEL)
            .openFrom(fromArea)
            .closeTo(closeArea)
    );
}

function httpPost( $http, code, param ) {

    var data = { "code" : code, data : param };

    return $http({
        url: '//api.yuanxininfo.com/dct-web/kernel',
        //url: '//192.168.0.11:8080/dct-web/kernel',
        method: 'POST',
        data: angular.toJson(data, false),
    })
}

function baseUpLoadFileHttpPost(Upload, param ) {
    return Upload.upload({
        url: '//api.yuanxininfo.com/dct-web/upload',
        data: param
    })
}

function isSuccess( response ) {
    if ( response.code == '0' ) {
        return true;
    }
    return false;
}

function buiderPage(params, data) {
   return {numPerPage: params.count(), pageNum: params.page(), data: data}
}

function buiderPostParam(param, code) {
    return {param: param, code: code}
}
function toJson(data) {
    return angular.toJson(data, false);
}