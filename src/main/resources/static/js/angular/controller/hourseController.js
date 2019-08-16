app.controller("hourseController",function ($scope,hourseService,adminIndexService){

    $scope.currPage = 0;
    $scope.village = "";
    $scope.status = "";
    $scope.hourseList = [];
    $scope.hoursePicList = [];
    $scope.imageSrc = "";
    $scope.hourse = {
        hourseid:""
    };


    $scope.searchHourseWithVillage = function () {
        hourseService.searchHourseWithVillage($scope.status,$scope.currPage,$scope.village).success(function (resp) {
            if (resp.code === 0){
                $scope.hourseList = resp.data.hourseList;
            }  else if (resp.indexOf("登陆") >= 0){
                window.location.href = "/admin/shoplogin.html";
            }
        })
    };

    //点击上传按钮进行图片上传。
    $scope.uploadFile = function () {
        if (document.getElementById("file").value == ""){
            return
        }
        hourseService.uploadFile().success(function (resp) {
            if (resp.code === 0){
                $scope.imageSrc = resp.data;
            }
        })
    };

    //上传窗口保存此次上传的图片
    $scope.savaPicture = function () {
        if (!$scope.imageSrc == ""){
            $scope.hoursePicList.push($scope.imageSrc);
            picListToString();
        }
    };

    picListToString = function () {
        $scope.hourse.pictures = "";
        for (var i = 0; i < $scope.hoursePicList.length; i++) {
            if (i == ($scope.hoursePicList.length - 1)){
                $scope.hourse.pictures += $scope.hoursePicList[i];
            } else {
                $scope.hourse.pictures += $scope.hoursePicList[i] + ",";
            }
        }
    };

    //点击新增按钮弹出上传窗口之前先清空上一次上传的图片。
    $scope.clearImage = function () {
        $scope.imageSrc = "";
        var element = document.getElementById("file");
        element.value = null;
    };

    //图片列表页面删除图片
    $scope.deletePicture = function (picName) {
        if (picName === "") {
            return;
        }
        var index = -1;
        for (var i = 0; i < $scope.hoursePicList.length; i++) {
            if ($scope.hoursePicList[i] === picName){
                index = i;
            }
        }
        if (index > -1){
            $scope.hoursePicList.splice(index,1);
        }
        picListToString();
        hourseService.deletePicture(picName);
    };

    //保存房源信息到数据库。
    $scope.savaOrUpdateHourse = function () {
        if ($scope.hourse.hourseid == ""){
            //save
            hourseService.savaHourse($scope.hourse).success(function (resp) {
                if (resp.code === 0){
                    location.href = "/admin/hourse.html";
                } else {
                    alert(resp.msg);
                }
            })
        } else {
            //update
        }

    };

    //点击返回列表按钮返回到房源列表页面，如果是新增的话则需要删除已经上传的图片。
    $scope.backToHourseList = function () {
        if ($scope.hourse.hourseid == "") {
            for (var i = 0; i < $scope.hoursePicList.length; i++) {
                hourseService.deletePicture($scope.hoursePicList[i])
            }
        }
        window.location.href = "/admin/hourse.html";
    };

    //房源编辑页面加载出来之后查看有没有id，有则为修改，没有则为新增。
    $scope.searchById = function () {
        var href = location.href; //取得整个地址栏
        if (href.indexOf("?hourseId=") > 0) {
            var hourseId = href.substr(href.indexOf("?hourseId=") + "?hourseId=".length);
            hourseService.searchById(hourseId).success(function (resp) {
                if (resp.code === 0){
                    $scope.hourse = resp.data;
                } else if (resp.indexOf("登陆") >= 0){
                    window.location.href = "/admin/shoplogin.html";
                }
            })
        } else {
            adminIndexService.findLoginUserManager().success(function (resp) {
                if (resp.indexOf("登陆") >= 0){
                    window.location.href = "/admin/shoplogin.html";
                }
            })
        }

    };

    //房源列表页面点击修改按钮跳转到房源编辑页面并且将id传递过去。
    $scope.update = function (hourseId) {
        window.location.href = "/admin/hourse_edit.html?hourseId=" + hourseId;
    }

});