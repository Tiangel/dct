/**
 * Created by hanley on 2016/6/14.
 */


app.directive('toggleSubmenu', function () {
    return {
        restrict: 'A',
        link: function (scope, element) {
            jQuery(element).click(function() {
                element.parent().toggleClass('toggled');
                var ul = jQuery(this).parent().find('ul');
                ul.stop(true, false).slideToggle(200); //TODO jquery
            })
        }
    }
});

app.directive('noEqual', function () {
    return {
        restrict: 'A',
        require: 'ngModel',
        link: function (scope, element, attributes, ngModel) {
            ngModel.$validators.noEqual = function (modelValue) {
                return scope[attributes.noEqual] === modelValue;
            }
        }
    }
})

app.directive('searchBtn', function () {
    return {
        restrict: 'AE',
        template: ' <md-input-container layout-margin> <md-button class="md-raised md-mini" ng-disabled="btnDisabled" ng-click="clickSearch()"> <md-icon md-font-icon="zmdi zmdi-search"></md-icon> <md-tooltip>搜索</md-tooltip> </md-button> </md-input-container>',
        link: function (scope, element, attrs) {
            scope.clickSearch = function() {
                if (!angular.isUndefined(scope.tableParams)) {
                    scope.tableParams.parameters({page: 1});
                    scope.tableParams.reload();
                }
            };
        }
    }
});

app.directive('chemAutocomplete', function () {
    return {
        restrict: 'AE',
        template: '<md-autocomplete md-floating-label="试剂名称"'
                                  +'md-selected-item="selectedChem"'
                                  +'md-search-text-change="querySearchChem(searchChem)"'
                                  +'md-search-text="searchChem"'
                                  +'md-selected-item-change="querySearchChem(ch)"'
                                  +'md-items="ch in querySearchChem(searchChem)"'
                                  +'md-item-text="ch.fname"'
                                  +'md-min-length="0">'
                         +'<md-item-template>'
                                 +'<span md-highlight-text="searchChem" md-highlight-flags="^i">{{ch.fname}}</span>'
                         +'</md-item-template>'
                         +'<md-not-found>未检索到 "{{searchChem}}"</md-not-found>'
                 +'</md-autocomplete>'

    }
});

app.directive('labAutocomplete', function () {
    return {
        restrict: 'AE',
        template: '<md-autocomplete md-floating-label="实验室"'
                                  +'md-selected-item="selectedLab"'
                                  +'md-search-text-change="querySearchLab(searchLab)"'
                                  +'md-search-text="searchLab"'
                                  +'md-selected-item-change="querySearchLab(LAB)"'
                                  +'md-items="la in querySearchLab(searchLab)"'
                                  +'md-item-text="la.labName"'
                                  +'md-min-length="0">'
                        +'<md-item-template>'
                                +'<span md-highlight-text="searchLab" md-highlight-flags="^i">{{la.labName}}</span>'
                        +'</md-item-template>'
                        +'<md-not-found>未检索到 "{{searchLab}}"</md-not-found>'
                +'</md-autocomplete>'
    }
});

app.directive('whAutocomplete', function () {
    return {
        restrict: 'AE',
        template: '<md-autocomplete md-floating-label="仓库"'
                                  +'md-selected-item="selectedWh"'
                                  +'md-search-text-change="querySearchWh(searchWh)"'
                                  +'md-search-text="searchWh"'
                                  +'md-selected-item-change="querySearchWh(wh)"'
                                  +'md-items="wh in querySearchWh(searchWh)"'
                                  +'md-item-text="wh.whName"'
                                  +'md-min-length="0">'
                        +'<md-item-template>'
                                +'<span md-highlight-text="searchWh" md-highlight-flags="^i">{{wh.whName}}</span>'
                        +'</md-item-template>'
                        +'<md-not-found>未检索到 "{{searchWh}}"</md-not-found>'
                +'</md-autocomplete>',
    }
});

app.directive('vmonLabAutocomplete', function () {
    return {
        restrict: 'AE',
        template: '<md-autocomplete md-floating-label="实验室"'
        +'md-selected-item="mon.laboratoryDTO"'
        +'md-search-text-change="querySearchLab(searchLab)"'
        +'md-search-text="searchLab"'
        +'md-selected-item-change="querySearchLab(LAB)"'
        +'md-items="la in querySearchLab(searchLab)"'
        +'md-item-text="la.labName"'
        +'md-min-length="0">'
        +'<md-item-template>'
        +'<span md-highlight-text="searchLab" md-highlight-flags="^i">{{la.labName}}</span>'
        +'</md-item-template>'
        +'<md-not-found>未检索到 "{{searchLab}}"</md-not-found>'
        +'</md-autocomplete>'
    }
});

app.directive('vmonWhAutocomplete', function () {
    return {
        restrict: 'AE',
        template: '<md-autocomplete md-floating-label="仓库"'
        +'md-selected-item="mon.whDTO"'
        +'md-search-text-change="querySearchWh(searchWh)"'
        +'md-search-text="searchWh"'
        +'md-selected-item-change="querySearchWh(wh)"'
        +'md-items="wh in querySearchWh(searchWh)"'
        +'md-item-text="wh.whName"'
        +'md-min-length="0">'
        +'<md-item-template>'
        +'<span md-highlight-text="searchWh" md-highlight-flags="^i">{{wh.whName}}</span>'
        +'</md-item-template>'
        +'<md-not-found>未检索到 "{{searchWh}}"</md-not-found>'
        +'</md-autocomplete>',
    }
});

app.directive('memberAutocomplete', function () {
    return {
        restrict: 'AE',
        template: '<md-autocomplete md-floating-label="姓名"'
                                  +'md-selected-item="selectedMember"'
                                  +'md-search-text-change="querySearchMember(searchMember)"'
                                  +'md-search-text="searchMember"'
                                  +'md-selected-item-change="querySearchMember(me)"'
                                  +'md-items="me in querySearchMember(searchMember)"'
                                  +'md-item-text="me.realName"'
                                  +'md-min-length="0">'
                        +'<md-item-template>'
                                +'<span md-highlight-text="searchMember" md-highlight-flags="^i">{{me.realName}}</span>'
                        +'</md-item-template>'
                        +'<md-not-found>未检索到 "{{searchMember}}"</md-not-found>'
                +'</md-autocomplete>',
    }
});

app.directive('topicLogAutocomplete', function () {
    return {
        restrict: 'AE',
        template: '<md-autocomplete md-floating-label="课题名称"'
                                  +'md-selected-item="selectedTopicLog"'
                                  +'md-search-text-change="querySearchTopicLog(searchTopicLog)"'
                                  +'md-search-text="searchTopicLog"'
                                  +'md-selected-item-change="querySearchTopicLog(to)"'
                                  +'md-items="to in querySearchTopicLog(searchTopicLog)"'
                                  +'md-item-text="to.issuesName"'
                                  +'md-min-length="0">'
                        +'<md-item-template>'
                             +'<span md-highlight-text="searchTopicLog" md-highlight-flags="^i">{{to.issuesName}}</span>'
                        +'</md-item-template>'
                        +'<md-not-found>未检索到 "{{searchTopicLog}}"</md-not-found>'
                +'</md-autocomplete>',
    }
});

/**
 * 显示时间
 */
app.directive('myCurrentTime', function($timeout, dateFilter) {
    // return the directive link function. (compile function not needed)
    return function(scope, element, attrs) {
        var timeoutId; // timeoutId, so that we can cancel the time updates

        function updateTime() {
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth()+1;
            var day = date.getDate();
            var hour = date.getHours();
            var minutes = date.getMinutes();
            var seconds = date.getSeconds();
            //var nowDate = year + "-" + (month > 9?month:("0" + month)) + "-" + (day > 9?day:("0" + day)) + " " + (hour > 9?hour:("0" + hour)) + ":" + (minutes > 9?minutes:("0" + minutes)) + ":" + (seconds > 9?seconds:("0" + seconds));
            var nowDate =  (hour > 9?hour:("0" + hour)) + ":" + (minutes > 9?minutes:("0" + minutes)) + ":" + (seconds > 9?seconds:("0" + seconds));
            element.text(nowDate);
        }
        // schedule update in one second
        function updateLater() {
            // save the timeoutId for canceling
            timeoutId = $timeout(function() {
                updateTime(); // update DOM
                updateLater(); // schedule another update
            }, 1000);
        }
        updateLater(); // kick off the UI update process.
    }
});

app.directive('dateFormat', ['$filter',function($filter) {
    var dateFilter = $filter('date');
    return {
        require: 'ngModel',
        link: function(scope, elm, attrs, ctrl) {

            function formatter(value) {
                return dateFilter(value, 'yyyy-MM-dd HH:mm'); //format
            }

            function parser() {
                return ctrl.$modelValue;
            }

            ctrl.$formatters.push(formatter);
            ctrl.$parsers.unshift(parser);

        }
    };
}]);
