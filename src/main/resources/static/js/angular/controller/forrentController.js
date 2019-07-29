app.controller("forrentController",function ($scope,$location){

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

    $scope.searchHourse = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?queryVo=") > 0){
            var urlValue = href.substr(href.indexOf("?queryVo=") + "?queryVo=".length);
            $scope.queryVo = JSON.parse(decodeURIComponent(urlValue));
        }
    };
});