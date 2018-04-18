/**
 * Created by hanley on 2016/6/20.
 */
'use strict';

app.factory('configService', function ($location) {

    return {
        getServerUrl: function () {
            return '//localhost:8080/dct-web/kernel'
        }
    }
    
})