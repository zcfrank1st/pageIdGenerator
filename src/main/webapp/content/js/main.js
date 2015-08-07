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

function transferDepartmentId2Department (id) {
    if (1 === id) {
        return "9k9";
    } else if (2 === id) {
        return "超级返";
    } else if (3 === id) {
        return "基础返";
    } else if (4 === id) {
        return "布兜妈妈";
    } else if (5 === id) {
        return "一元购";
    } else if (6 === id) {
        return "全局";
    }
}

var app = angular.module('myapp',['ngResource', 'ui.bootstrap']);

app.controller('myController',function ($scope, $resource, $modal) {
    var generateAndSavePage = $resource('/generatepage');
    var getPageIdInfos = $resource('/getinfos');
    var generateAndSaveModule = $resource('/generatemodule');

    var showPages = $resource('/pages/:departmentId', {departmentId: '@did'});
    var showModules = $resource('/modules/:departmentId/:pageId', {departmentId: '@did', pageId: '@pid'});
    var showAllPages = $resource('/pages');
    var showAllModules = $resource('/modules');

    var delPage = $resource('/page/:id', {id: '@id'});
    var delModule = $resource('/module/:id', {id: '@id'});

    getPageIdInfos.query({}, function (data) {
        $scope.pageIds = data;
        $scope.currentPageId = $scope.pageIds[0];
    });

    $scope.generatePageId = function () {
        $scope.InfoShow = false;
        var pageIdAll = {
            pageIdName: $scope.pageIdName || "",
            pageId: "",
            pageIdDesc: $scope.pageIdDesc || "",
            owner: "",
            typeId: $scope.currentTypeId.id,
            deptId : $scope.currentBusinessId.id,
            isValid : 1,
            urlReg: $scope.urlReg || ""
        };

        if ("" === pageIdAll.pageIdName) {
            alert("page name 不能为空! 生成page失败");
        } else {
            generateAndSavePage.save(pageIdAll, function (data) {
                console.log(data);
                if (data.returnCode !== -1) {
                    $scope.pageIdShow = true;
                } else {
                    alert("page name重复，生成page失败！");
                }
                getPageIdInfos.query({}, function (data) {
                    $scope.pageIds = data;
                    $scope.currentPageId = $scope.pageIds[0];
                });
            });
        }
    };
    $scope.saveClick = function () {
        $scope.pageIdShow = false;
        var indexInfoAll = {
            index : $scope.indexIdName || "",
            desc : $scope.allDesc || "",
            pageId : $scope.currentPageId.pageId,
            deptId : $scope.currentBusinessId.id || "",
            typeId: $scope.currentTypeId.id,
            owner : "",
            isValid : 1
        };

        if ("" === indexInfoAll.index) {
            alert("module name不能为空! 生成module失败");
        } else {
            generateAndSaveModule.save(indexInfoAll, function (data) {
                if (data.returnCode !== -1) {
                    $scope.InfoShow = true;
                } else {
                    alert("module name重复，生成module失败！");
                }
            });
        }
    };

    // 业务类型定死
    $scope.businessIds = [
        {name:'9k9', id:'1'},
        {name:'超级返', id:'2'},
        {name:'基础返', id:'3'},
        {name:'布兜妈妈', id:'4'},
        {name:'一元购', id:'5'},
        {name:'全局', id: '6'}
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
        $scope.p_department = false;
        showPages.query({departmentId: $scope.currentBusinessId.id}, function(data) {
            var results = [];
            for (var i = 0; i <= data.length - 1; i++) {
                data[i].type = transferTypeId2Type(data[i].typeId);
                results.push(data[i]);
            }
            $scope.pages = results;
        });
    };

    $scope.viewAllPages = function () {
        $scope.p_department = true;
        showAllPages.query({}, function (data) {
            var results = [];
            for (var i = 0; i <= data.length - 1; i++) {
                data[i].type = transferTypeId2Type(data[i].typeId);
                data[i].department = transferDepartmentId2Department(data[i].deptId);
                results.push(data[i]);
            }
            $scope.pages = results;
        });
    };

    $scope.viewAllModules = function () {
        $scope.m_department = true;
        showAllModules.query({}, function (data) {
            var results = [];
            for (var i = 0; i <= data.length - 1; i++) {
                data[i].type = transferTypeId2Type(data[i].typeId);
                data[i].department = transferDepartmentId2Department(data[i].deptId);
                results.push(data[i]);
            }
            $scope.modules = results;
        });
    };

    $scope.viewModules = function () {
        $scope.m_department = false;
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
        {name:'一元购', id:'5'},
        {name:'全局', id: '6'}
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
        {name:'一元购', id:'5'},
        {name:'全局', id: '6'}
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