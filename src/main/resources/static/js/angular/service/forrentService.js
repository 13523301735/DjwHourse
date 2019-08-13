app.service("forrentService",function ($http) {

    this.searchHourse = function (queryVo) {
        return $http.post("/forrent/search",queryVo)
    }

});