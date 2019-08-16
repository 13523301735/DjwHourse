app.controller("userManagerController",function ($scope,userManagerService){

    $scope.userManager = {
        username:"",
        password:""
    };

    $scope.login = function () {
        if($scope.userManager.username == '') {
            return;
        }
        if($scope.userManager.password == '') {
            return;
        }
        userManagerService.login($scope.userManager).success(function (resp) {
            console.log(resp);
            if (resp.code == 0) {
                window.location.href = "/admin/index.html"
            } else {
                $("#errorMsg").text(resp.msg);
                $("#submit").attr("disabled","disabled");
                $("#submit").css("background-color","#8aa4af");
                //1秒后清除登陆失败所提示的内容。
                window.setTimeout(function () {
                    $("#errorMsg").text("");
                    $("#submit").removeAttr("disabled","disabled");
                    $("#submit").css("background-color","#ff730e");
                },1000);
            }
        })
    }
});