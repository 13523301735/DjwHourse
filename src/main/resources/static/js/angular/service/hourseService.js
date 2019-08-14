app.service("hourseService",function ($http) {

    this.searchHourseWithVillage = function (status,currPage,village) {
        return $http.get("/hourse/searchHourseWithVillage?" +
            "status=" + status + "&currPage=" + currPage + "&village=" + village);
    }

});