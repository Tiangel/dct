/**
 * Created by hanley on 2016/7/30.
 */


(function (angular) {
    'use strict';

    angular.module( 'treeView', [] ).directive( 'treeModel', [ '$compile', function ( $compile ) {
        
        return {
            
            restrict: 'A',
            link: function ( scope, elemnt, attrs ) {

                console.log(attrs);

            }
            
        }
        
    } ])
    
})( angular )