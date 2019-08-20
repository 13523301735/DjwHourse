app.controller("galleryvariationController",function ($scope,galleryvariationServie) {

    $scope.searchById = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?hourseId=") > 0) {
            var hourseId = href.substr(href.indexOf("?hourseId=") + "?hourseId=".length);
            galleryvariationServie.searchById(hourseId).success(function (resp) {
                if (resp.code === 0){
                    $scope.hourse = resp.data;
                    $scope.hourse.picture = resp.data.picture.split(",");
                    /*var s0 = "<div class=\"thumb-image\"> <img ng-src=\"/"+$scope.hourse.picture[0]+"\" data-imagezoom=\"true\" class=\"img-responsive\"> </div>";
                    var s1 = "<div class=\"thumb-image\"> <img ng-src=\"/"+$scope.hourse.picture[1]+"\" data-imagezoom=\"true\" class=\"img-responsive\"> </div>";
                    var s2 = "<div class=\"thumb-image\"> <img ng-src=\"/"+$scope.hourse.picture[2]+"\" data-imagezoom=\"true\" class=\"img-responsive\"> </div>";
                    var s3 = "<div class=\"thumb-image\"> <img ng-src=\"/"+$scope.hourse.picture[3]+"\" data-imagezoom=\"true\" class=\"img-responsive\"> </div>";
                    $("#picture0").html(s0);
                    $("#picture1").html(s1);
                    $("#picture2").html(s2);
                    $("#picture3").html(s3);*/
                }
                console.log($scope.hourse);
            })
        }
    };
    
});