/**
 * Created by zcfrank1st on 7/7/15.
 */
var app = angular.module('myapp',['ngResource']);

app.controller('myController',function ($scope, $resource) {
    var generateAndSavePageId = $resource('/generateAndSavePageId');
    var getPageIdInfos = $resource('/getPageIdInfos');
    var saveInfos = $resource('/saveInfos');

    //getPageIdInfos.query({}, function () {
    //    console.log("haha");
    //
    //    $scope.pageIds = [
    //        {name:'超级返首页', id:'1'},
    //        {name:'布兜妈妈首页', id:'2'}
    //    ];
    //    $scope.currentPageId = $scope.pageIds[0];
    //});

    $scope.generatePageId = function () {
        generateAndSavePageId.save({pageIdDesc: "hello"}, function () {

        });
    };
    $scope.saveInfos = function () {
        //saveInfos.save({}, function () {
        //
        //});
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