app.controller("adminIndexController",function ($scope,adminIndexService) {

    $scope.findLoginUserManager = function () {
        adminIndexService.findLoginUserManager().success(function (resp) {
            if (resp.code === 0){
                $scope.username = resp.data.username;
            } else if (resp.indexOf("登陆") >= 0){
                window.location.href = "/admin/shoplogin.html";
            }
        })
    };

});