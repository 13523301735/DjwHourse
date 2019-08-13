app.controller("galleryvariationController",function ($scope,galleryvariationServie) {
    
    $scope.searchById = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?hourseId=") > 0) {
            var hourseId = href.substr(href.indexOf("?hourseId=") + "?hourseId=".length);
            galleryvariationServie.searchById(hourseId).success(function (resp) {

            })
        }
    }
    
});