app.controller("indexController",function ($scope) {

    $scope.queryVo={
        onePlace:"all",
        twoPlace:"all",
        area:"all",
        direction:"all",
        unit:"all",
        floor:"all",
        minPrice:"any",
        maxPrice:"any"
    };

    $scope.search=function () {
        //在此处将参数内容进行编码。
        location.href = 'forrent.html?queryVo=' + encodeURIComponent(angular.toJson($scope.queryVo));
    };

});