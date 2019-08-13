app.controller("forrentController",function ($scope,$location,forrentService){

    $scope.queryVo={
        onePlace:"all",
        twoPlace:"all",
        area:"all",
        direction:"all",
        unit:"all",
        floor:"all",
        minPrice:"any",
        maxPrice:"any",
        pageNum:0
    };

    $scope.pageNum = 0;

    $scope.hourseList = [];

    $scope.searchHourse = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?queryVo=") > 0){
            var urlValue = href.substr(href.indexOf("?queryVo=") + "?queryVo=".length);
            $scope.queryVo = JSON.parse(decodeURIComponent(urlValue));
        }
        forrentService.searchHourse($scope.queryVo).success(function (resp) {
            if (resp.code == 0){
                //将picture字符串转换为list对象方便在页面进行遍历。
                for (var i = 0;i < resp.data.hourseList.length;i++){
                    resp.data.hourseList[i].picture = resp.data.hourseList[i].picture.split(",");
                }
                $scope.hourseList = resp.data.hourseList;
            } else {
                alert(resp.msg);
            }
            console.log(resp)
        }).error(function (resp) {
            console.log(resp)
        })
    };
});