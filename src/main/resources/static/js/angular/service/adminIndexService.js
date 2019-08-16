app.service("adminIndexService",function ($http) {

    this.findLoginUserManager = function () {
        return $http.get("/userManager/findLoginUserManager");
    };

});