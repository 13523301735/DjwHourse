app.controller("galleryvariationController",function ($scope,galleryvariationServie) {

    $scope.searchById = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?hourseId=") > 0) {
            var hourseId = href.substr(href.indexOf("?hourseId=") + "?hourseId=".length);
            galleryvariationServie.searchById(hourseId).success(function (resp) {
                if (resp.code === 0){
                    $scope.hourse = resp.data;
                    $scope.hourse.picture = resp.data.picture.split(",");
                }
                console.log($scope.hourse);
            })
        }
    };
    
});