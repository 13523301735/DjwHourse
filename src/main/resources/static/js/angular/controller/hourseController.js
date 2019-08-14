app.controller("hourseController",function ($scope,hourseService){

    $scope.currPage = 0;
    $scope.village = "";
    $scope.status = "";
    $scope.hourseList = [];

    $scope.searchHourseWithVillage = function () {
        hourseService.searchHourseWithVillage($scope.status,$scope.currPage,$scope.village).success(function (resp) {
            if (resp.code === 0){
                $scope.hourseList = resp.data.hourseList;
            }
        })
    };

});