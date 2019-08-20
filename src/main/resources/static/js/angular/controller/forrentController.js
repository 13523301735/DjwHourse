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
        pageNum:1
    };

    $scope.totalCount = 0;

    $scope.pageList = [];

    $scope.search = function () {
        forrentService.searchHourse($scope.queryVo).success(function (resp) {
            if (resp.code === 0){
                $scope.totalCount = resp.data.totalCount;
                var s = "";
                if (resp.data.hourseList.length === 0){
                    s +=    "<h2 class='text-center'>抱歉，没有符合您搜索条件的房源。</h2>";
                    $("#myPage").css("display","none");
                } else {
                    $("#myPage").css("display","");
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
                    }
                    draw(resp.data.pageNum,Math.ceil(resp.data.totalCount/12));
                }
                $(".forsale-grids1").html(s);
            } else {
                alert(resp.msg);
            }
            console.log(resp)
        }).error(function (resp) {
            console.log(resp)
        });
    };

    //页面加载出来之后进行搜索。
    $scope.searchHourse = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?queryVo=") > 0){
            var urlValue = href.substr(href.indexOf("?queryVo=") + "?queryVo=".length);
            $scope.queryVo = JSON.parse(decodeURIComponent(urlValue));
        }
        $scope.search();
    };

    //点击分页栏的页码就行跳转。
    $scope.jumpPage = function (pageNum) {
        if(!isNaN(pageNum)){
            if (pageNum >= 1 && pageNum <= Math.ceil($scope.totalCount/12)) {
                $scope.queryVo.pageNum = pageNum;
                $scope.search();
            }
        }
    };

    //输入页码跳转到指定分页。
    $scope.toPage = function () {
        var num = $("#toPage").val();
        if (isNaN(num)) {
            alert("请输入有效的页码。");
        } else if (num < 1 || num > Math.ceil($scope.totalCount/12)) {
            alert("请输入有效的页码。")
        } else {
            $scope.jumpPage(parseInt(num));
        }
    };

    //绘制分页栏,连续显示5个页码。
    //分页的4种情况，假设有9页，分页栏连续显示5个页码。
    //  6页以下的:
    //          1 2 3 4 5 6     totalPage <= 6
    //  6页以上的：
    //          1 2 3 4 5... 9  currPage <= 4
    //          1 ... 3 4 5 6 7 ... 9   剩下的都是这种样式。
    //          1 ... 6 7 8 9   (totalPage-currPage) <= 3
    var draw = function (currPage, totalPage) {
        if (currPage == 1){
            $("#prevPage").css("background-color","#b8c7ce");
        } else {
            $("#prevPage").css("background-color","white");
        }
        if (totalPage == currPage){
            $("#nextPage").css("background-color","#b8c7ce");
        } else {
            $("#nextPage").css("background-color","white");
        }
        //定义一个数组用来保存分页栏需要展示的元素，保存在集合中使用时在前台html页面循环遍历展示即可。
        $scope.pageList = [];
        if (totalPage <= 6){
            for (var i = 1; i <= totalPage; i++) {
                $scope.pageList.push(i);
            }
        } else {
            if ((totalPage-currPage) <= 3){
                $scope.pageList.push(1);
                $scope.pageList.push("...");
                for (var i = totalPage - 4; i <= totalPage ; i++) {
                    $scope.pageList.push(i);
                }
            } else if (currPage <= 4){
                for (var i = 1; i <= 5; i++) {
                    $scope.pageList.push(i);
                }
                $scope.pageList.push("...");
                $scope.pageList.push(totalPage);
            } else {
                $scope.pageList.push(1);
                $scope.pageList.push("...");
                for (var i = currPage - 2; i <= currPage + 2 ; i++) {
                    $scope.pageList.push(i);
                }
                $scope.pageList.push("...");
                $scope.pageList.push(totalPage);
            }
        }
    }

});