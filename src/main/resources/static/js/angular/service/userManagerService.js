app.service("userManagerService",function ($http) {

    this.login = function (userManager) {
        return $http.post("/userManager/login",userManager);
    };

});