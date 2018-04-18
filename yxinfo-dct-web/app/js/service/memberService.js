/**
 * Created by hanley on 2016/7/1.
 */
'use strict';

app.factory('memberService', function ($http) {

    var server = {};
    
    server.getData = function ( param ) {
        return httpPost($http, 100015, param )
    }

    server.getGroupByOrg = function(param){
        return httpPost($http, 100017, param);
    }

    server.getGroup = function( param ){
        return httpPost($http, 100018, param);
    }

    server.getMemberDetail = function(param){
        return httpPost($http, 100019, param)
    }

    server.editGroup = function(code, param){
        return httpPost($http, code, param);
    }

    server.deleteMember = function(memberId){
        return httpPost($http, 100023, memberId);
    }

    server.editMember = function(code, param){
        return httpPost($http, code, param);
    }

    server.deleteGroup = function(groupId){
        return httpPost($http, 100022, groupId);
    }

    server.clickEditMemberTree = function($mdDialog, groups, treeNode){
        for(var i in groups){
            var group = groups[i];
            if(group.id == treeNode.id){
                showAlert($mdDialog, "不能重复选择成员组");
                return groups;
            }
        }
        if(groups == null || groups == ""){
            groups = [{id: treeNode.id, fname: treeNode.fname}];
        }else{
            groups.push({id: treeNode.id, fname: treeNode.fname});
        }
        return groups;
    }

    return {

        getData: function (param) {
            return server.getData(param);
        },
        getGroupByOrg: function(param){
            return server.getGroupByOrg(param);
        },
        getGroup: function(param){
            return server.getGroup(param);
        },
        getMemberDetail: function(param){
            return server.getMemberDetail(param);
        },
        editGroup: function(code,param){
            return server.editGroup(code,param);
        },
        deleteMember: function(memberId){
            return server.deleteMember(memberId);
        },
        editMember: function(code, param){
            return server.editMember(code, param);
        },
        deleteGroup: function(groupId){
            return server.deleteGroup(groupId);
        },
        clickEditMemberTree: function($mdDialog, groups, treeNode){
            return server.clickEditMemberTree($mdDialog, groups, treeNode);
        }
    }
    
})