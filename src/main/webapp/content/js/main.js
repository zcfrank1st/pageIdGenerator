/**
 * Created by zcfrank1st on 7/7/15.
 */
var app = angular.module('myapp',['ngResource']);

app.controller('myController',function ($scope, $resource) {
    var generateAndSavePageId = $resource('/generatepageid');
    var getPageIdInfos = $resource('/getinfos');
    var saveInfos = $resource('/saveinfos');

    getPageIdInfos.query({}, function (data) {
        console.log(data);
        //$scope.pageIds = [
        //    {name:'超级返首页', id:'1'},
        //    {name:'布兜妈妈首页', id:'2'}
        //];
        //$scope.currentPageId = $scope.pageIds[0];
    });

    $scope.generatePageId = function () {
        $scope.InfoShow = false;
        var pageIdAll = {
            pageIdName: $scope.pageIdName || "",
            pageId: "",
            pageIdDesc: $scope.pageIdDesc || "",
            owner: ""
        };
        generateAndSavePageId.save(pageIdAll, function () {

        });
    };
    $scope.saveClick = function () {
        $scope.pageIdShow = false;
        var indexInfoAll = {
            index : $scope.indexIdName || "",
            desc : $scope.allDesc || "",
            pageId : $scope.currentPageId.pageId,
            deptId : $scope.currentBusinessId.id || "",
            owner : ""
        };
        saveInfos.save(indexInfoAll, function () {

        });
    };

    // 业务类型定死
    $scope.businessIds = [
        {name:'9k9', id:'1'},
        {name:'超级返', id:'2'},
        {name:'基础返', id:'3'},
        {name:'布兜妈妈', id:'4'},
        {name:'一元购', id:'5'}
    ];
    $scope.currentBusinessId = $scope.businessIds[0];
});