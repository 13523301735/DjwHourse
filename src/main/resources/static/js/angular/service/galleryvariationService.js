app.service("galleryvariationServie",function ($http) {

    this.searchById = function (hourseId) {
        return $http.get("/galleryvariation/searchById?hourseId=" + hourseId);
    }

});