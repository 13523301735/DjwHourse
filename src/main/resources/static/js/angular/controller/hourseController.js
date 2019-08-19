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
    $scope.statusArr = ["未上架","已上架"];
    $scope.selectIds = [];


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
            if ($scope.hoursePicList.length != 4){
                alert("请上传4张图片");
                return
            }
            $scope.hourse.picture = $scope.hoursePicList.join(",");
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
                    $scope.hoursePicList = $scope.hourse.picture.split(",");
                    $scope.hourse.type = $scope.hourse.type + "";
                    $scope.hourse.form = $scope.hourse.form + "";
                } else if (resp.indexOf("登陆") >= 0){
                    window.location.href = "/admin/shoplogin.html";
                }
            })
        } else {
            adminIndexService.findLoginUserManager().success(function (resp) {
                if (resp.code != 0){
                    if (resp.indexOf("登陆") >= 0){
                        window.location.href = "/admin/shoplogin.html";
                    }
                }
            })
        }
    };

    //房源列表页面点击修改按钮跳转到房源编辑页面并且将id传递过去。
    $scope.update = function (hourseId) {
        window.location.href = "/admin/hourse_edit.html?hourseId=" + hourseId;
    };

    //勾选或取消每条房源前面的复选框更新选中房源的id数组。
    $scope.updateSelection = function ($event, id) {
        var checkbox = $event.target;
        var action = (checkbox.checked ? 'add' : 'remove');
        updateSelected(action, id);
        updateSelall();

    };
    //根据复选框的状态判断数组的操作。
    var updateSelected = function (action, id) {
        if (action == 'add' && $scope.selectIds.indexOf(id) == -1) {
            $scope.selectIds.push(id);
        }
        if (action == 'remove' && $scope.selectIds.indexOf(id) != -1) {
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);
        }
    };
    //每次勾选下面的复选框时判断全选复选框的状态。
    var updateSelall = function () {
        var checkboxs = document.getElementsByName("selevery");
        var checked = true;
        for (var i = 0; i < checkboxs.length; i++) {
            if (!checkboxs[i].checked) {
                checked = false;
            }
        }
        if (checked) {
            $("#selall").prop("checked", true);
        } else {
            $("#selall").prop("checked", false);
        }
    };

    //复选框的全选。
    $scope.changeAll=function($event){
        if($event.target.checked){
            //如果是被选中,则增加全部id到数组
            $scope.selectIds=[];
            angular.forEach($scope.hourseList, function (entity) {
                $scope.selectIds.push(entity.hourseid);
            });
            $("input:checkbox").prop("checked", true);
        }else{
            $scope.selectIds=[];
            $("input:checkbox").prop("checked", false);
        }
    };

    //删除所选的房源。
    $scope.deleteHourse = function () {
        if ($scope.selectIds.length === 0){
            alert("请先选择要删除的房源。");
            return
        }
        if (confirm("确定要删除所选房源吗？")){
            hourseService.deleteHourse($scope.selectIds).success(function (resp) {
                if (resp.code === 0){
                    window.location.reload();
                } else {
                    alert(resp.msg);
                }
            })
        }
    };

    //上架所选的房源
    $scope.putaway = function () {
        if ($scope.selectIds.length === 0){
            alert("请先选择要上架的房源。");
            return
        }
        hourseService.putaway($scope.selectIds).success(function (resp) {
            if (resp.code === 0){
                window.location.reload();
            } else {
                alert(resp.msg);
            }
        })
    };

    //下架所选的房源
    $scope.soldOut = function () {
        if ($scope.selectIds.length === 0){
            alert("请先选择要下架的房源。");
            return
        }
        hourseService.soldOut($scope.selectIds).success(function (resp) {
            if (resp.code === 0){
                window.location.reload();
            } else {
                alert(resp.msg);
            }
        })
    };

});