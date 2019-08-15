app.service("hourseService",function ($http) {

    this.searchHourseWithVillage = function (status,currPage,village) {
        return $http.get("/hourse/searchHourseWithVillage?" +
            "status=" + status + "&currPage=" + currPage + "&village=" + village);
    };

    this.uploadFile = function () {
        var formData = new FormData();
        formData.append('file', file.files[0]);//file.files[0]是document.getElementById('file').files[0]的简写,后台接收时变量名必须是file
        return $http({
            method:'post',
            url:'/hourse/upload',
            data:formData,
            headers:{'Content-type':undefined},
            transformRequest: angular.identity
        })
    };

    this.deletePicture = function (picName) {
        return $http.get("/hourse/deletePicture?picName=" + picName)
    };

    this.savaHourse = function (hourse) {
        return $http.post("/hourse/add",hourse)
    };

    this.searchById = function (hourseId) {
        return $http.get("/hourse/searchById?hourseId=" + hourseId);
    };

});