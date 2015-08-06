/**
 * Created by zcfrank1st on 7/7/15.
 */
function transferTypeId2Type (id) {
    if (1 === id) {
        return "web";
    } else if (2 === id) {
        return "h5";
    } else if (3 === id) {
        return "native";
    }
}

var app = angular.module('myapp',['ngResource', 'ui.bootstrap']);

app.controller('myController',function ($scope, $resource, $modal) {
    var generateAndSavePage = $resource('/generatepage');
    var getPageIdInfos = $resource('/getinfos');
    var generateAndSaveModule = $resource('/generatemodule');

    var showPages = $resource('/pages/:departmentId', {departmentId: '@did'});
    var showModules = $resource('/modules/:departmentId/:pageId', {departmentId: '@did', pageId: '@pid'});

    var delPage = $resource('/page/:id', {id: '@id'});
    var delModule = $resource('/module/:id', {id: '@id'});

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
            isValid : 1,
            urlReg: $scope.urlReg || ""
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

    //操作
    $scope.delModule = function(id) {
        delModule.delete({id: id}, function() {
            $scope.viewPages();
            alert("删除module成功！");
        });
    };

    $scope.delPage = function(id) {
        delPage.delete({id: id}, function() {
            $scope.viewPages();
            $scope.viewModules();
            alert("删除page成功！");
        });
    };


    $scope.modifyModule = function(id) {
        $modal.open({
            animation: true,
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            size: 'lg',
            resolve: {
                id: function () {
                    return id;
                }
            }
        });
    };

    $scope.modifyPage = function(id) {
        $modal.open({
            animation: true,
            templateUrl: 'myModalContent1.html',
            controller: 'ModalInstanceCtrl1',
            size: 'lg',
            resolve: {
                id: function () {
                    return id;
                }
            }
        });
    };
});

app.controller('ModalInstanceCtrl', function ($scope, $modalInstance, id, $resource) {
    var getPageIdInfos = $resource('/getinfos');
    getPageIdInfos.query({}, function (data) {
        $scope.pageIds = data;
        $scope.currentPageId = $scope.pageIds[0];
    });

    var updateModule = $resource('/update/module');

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


    $scope.ok = function () {
        var indexInfoAll = {
            id: id,
            index : $scope.indexIdName || "(无效)",
            desc : $scope.allDesc || "",
            pageId : $scope.currentPageId.pageId,
            deptId : $scope.currentBusinessId.id || "",
            typeId: $scope.currentTypeId.id,
            owner : "",
            isValid : 1
        };
        updateModule.save(indexInfoAll, function () {
            alert("更新成功");
            location.reload();
            $modalInstance.close();
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});

app.controller('ModalInstanceCtrl1', function ($scope, $modalInstance, id, $resource) {
    var updatePage = $resource('/update/page');
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


    $scope.ok = function () {
        var pageIdAll = {
            id : id,
            pageIdName: $scope.pageIdName || "(无效)",
            pageId: "",
            pageIdDesc: $scope.pageIdDesc || "",
            owner: "",
            typeId: $scope.currentTypeId.id,
            deptId : $scope.currentBusinessId.id,
            isValid : 1,
            urlReg: $scope.urlReg || ""
        };
        updatePage.save(pageIdAll, function () {
            alert("更新成功");
            location.reload();
            $modalInstance.close();
        });
    };

    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});