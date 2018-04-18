/**
 * Created by cy on 2016/7/26.
 */
'use strict';
app.controller('vmonMonitorController', function ($log, $controller,$location, $q, $mdSidenav, NgTableParams, $scope, $element, httpService) {
    $controller('baseController', {$scope: $scope});

    $log.debug('Created vmonMonitorController');

    var placeId=$location.search().placeId;

    httpService.post(buiderPostParam({id:placeId},116002)).then(function(response) {
        var deviceList = response.data.data;
        if(deviceList == null ||  deviceList == "") {
            $scope.show=true;
        }else $scope.show=false;
         if(!angular.isUndefined(deviceList)&& deviceList != "" ){
             for(var i = 0 ; i < deviceList.length ; i++){
                 var channels =deviceList[i].channel.split(",").sort();
                 if(channels != null ||  channels != ""){
                     $scope.show=false;
                     for( var y = 0; y < channels.length ; y++ ){
                         if(deviceList[i].supplierId==1){
                             $("#deviceMonitor").append("<object type='application/x-vlc-plugin' " +
                                 "pluginspage='http://static.yuanxininfo.com/assets/manage/vlc_2.2.3.0.exe' " +
                                 " events='false' width='720' height='410'>  <param name='mrl' " +
                                 "value='rtsp://"+deviceList[i].username+":"+deviceList[i].pwd+"@"+deviceList[i].ip+":"+deviceList[i].rtspPort+
                                 "/h264/ch"+channels[y]+"/main/av_stream' />" +
                                 "<param name='fullscreen' value='true' /> </object>");
                         }else if(deviceList[i].supplierId==2){
                             $("#deviceMonitor").append("<object type='application/x-vlc-plugin' " +
                                 "pluginspage='http://static.yuanxininfo.com/assets/manage/vlc_2.2.3.0.exe' " +
                                 " events='false' width='720' height='410'>  <param name='mrl' " +
                                 "value='rtsp://"+deviceList[i].username+":"+deviceList[i].pwd+"@"+deviceList[i].ip+":"+deviceList[i].rtspPort+
                                 "/cam/realmonitor?channel="+channels[y]+"&subtype=0' />" +
                                 "<param name='fullscreen' value='true' /> </object>");
                         }
                     }
                 }else{
                     $scope.show=true;
                 }
             }
         }
    });

    $scope.goBack =function () {
        $location.path('/admin/monitor_place_list')
    }
    
});
