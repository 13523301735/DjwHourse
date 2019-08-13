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

    //$scope.hourseList = [];

    $scope.search = function () {
        forrentService.searchHourse($scope.queryVo).success(function (resp) {
            if (resp.code === 0){
                var s = "";
                if (resp.data.hourseList.length === 0){
                    s +=    "<h2 class='text-center'>抱歉，没有符合您搜索条件的房源。</h2>";
                }
                for (var i = 0;i < resp.data.hourseList.length;i++){
                    s  +=   "<a href='/galleryvariation.html?hourseId=" + resp.data.hourseList[i].hourseid + "'>" +
                                "<div class=\"col-md-4 forsale-grid1\"'>" +
                                    "<img src=\"" + resp.data.hourseList[i].picture.split(",")[0] + "\" class=\"img-responsive\" alt=\"/\">" +
                                    "<div class=\"sale-info\">" +
                                        "<span >大 经 伟</span>" +
                                    "</div>" +
                                    "<h5>" + resp.data.hourseList[i].area + "m²  " + resp.data.hourseList[i].village + "  " + resp.data.hourseList[i].unit + "</h5>" +
                                    "<p>" + resp.data.hourseList[i].description + "</p>" +
                                    "<h6>￥：" + resp.data.hourseList[i].price + " 元</h6>" +
                                    "<br />" +
                                    "<br />" +
                                "</div>" +
                            "</a>";
                    //resp.data.hourseList[i].picture = resp.data.hourseList[i].picture.split(",");
                }
                $(".forsale-grids1").html(s);
                //$scope.hourseList = resp.data.hourseList;
            } else {
                alert(resp.msg);
            }
            console.log(resp)
        }).error(function (resp) {
            console.log(resp)
        });
    };

    $scope.searchHourse = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?queryVo=") > 0){
            var urlValue = href.substr(href.indexOf("?queryVo=") + "?queryVo=".length);
            $scope.queryVo = JSON.parse(decodeURIComponent(urlValue));
        }
        $scope.search();
    };
});