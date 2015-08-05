/**
 * Created by zcfrank1st on 7/7/15.
 */
var app = angular.module('myapp',['ngResource']);

app.controller('myController',function ($scope, $resource) {
    var generateAndSavePage = $resource('/generatepage');
    var getPageIdInfos = $resource('/getinfos');
    var generateAndSaveModule = $resource('/generatemodule');

    var showPages = $resource('/pages/:departmentId', {departmentId: '@did'});
    var showModules = $resource('/modules/:departmentId/:pageId', {departmentId: '@did', pageId: '@pid'});

    getPageIdInfos.query({}, function (data) {
        $scope.pageIds = data;
        $scope.currentPageId = $scope.pageIds[0];
    });

    $scope.generatePageId = function () {
        $scope.InfoShow = false;
        var pageIdAll = {
            pageIdName: $scope.pageIdName || "(无效)",
            pageId: "",
            pageIdDesc: $scope.pageIdDesc || "",
            owner: "",
            typeId: $scope.currentTypeId.id,
            deptId : $scope.currentBusinessId.id,
            isValid : 1
        };
        generateAndSavePage.save(pageIdAll, function () {
            $scope.pageIdShow = true;
            getPageIdInfos.query({}, function (data) {
                $scope.pageIds = data;
                $scope.currentPageId = $scope.pageIds[0];
            });
        });
    };
    $scope.saveClick = function () {
        $scope.pageIdShow = false;
        var indexInfoAll = {
            index : $scope.indexIdName || "(无效)",
            desc : $scope.allDesc || "",
            pageId : $scope.currentPageId.pageId,
            deptId : $scope.currentBusinessId.id || "",
            typeId: $scope.currentTypeId.id,
            owner : "",
            isValid : 1
        };
        generateAndSaveModule.save(indexInfoAll, function () {
            $scope.InfoShow = true;
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
    // 种类定死
    $scope.typeIds = [
        {name:'web', id:'1'},
        {name:'h5', id:'2'},
        {name:'native', id:'3'}
    ];

    $scope.currentBusinessId = $scope.businessIds[0];
    $scope.currentTypeId = $scope.typeIds[0];



    $scope.viewPages = function() {
        showPages.query({departmentId: $scope.currentBusinessId.id}, function(data) {
            var results = [];
            for (var i = 0; i <= data.length - 1; i++) {
                data[i].type = transferTypeId2Type(data[i].typeId);
                results.push(data[i]);
            }
            $scope.pages = results;
        });
    };

    $scope.viewModules = function () {
        showModules.query({departmentId: $scope.currentBusinessId.id, pageId: $scope.currentPageId.pageId}, function(data) {
            var results = [];
            for (var i = 0; i <= data.length - 1; i++) {
                data[i].type = transferTypeId2Type(data[i].typeId);
                results.push(data[i]);
            }
            $scope.modules = results;
        });
    };

    function transferTypeId2Type (id) {
        if (1 === id) {
            return "web";
        } else if (2 === id) {
            return "h5";
        } else if (3 === id) {
            return "native";
        }
    }
});