app.controller("hourseController",function ($scope,hourseService,adminIndexService){

    $scope.currPage = 1;
    $scope.village = "";
    $scope.status = "";
    $scope.hourseList = [];
    $scope.hoursePicList = [];
    $scope.imageSrc = "";
    $scope.hourse = {
        hourseid:""
    };
    $scope.selectIds = [];
    $scope.totalCount = 0;
    $scope.pageList = [];
    $scope.waitForDelete = [];


    $scope.searchHourseWithVillage = function () {
        hourseService.searchHourseWithVillage($scope.status,$scope.currPage,$scope.village).success(function (resp) {
            if (resp.code === 0){
                //如果删除掉了最后一页的所有数据，则展示上一页的数据。
                if (resp.data.pageNum > 1 && resp.data.hourseList.length === 0){
                    $scope.currPage = resp.data.pageNum-1;
                    $scope.searchHourseWithVillage();
                } else {
                    $scope.hourseList = resp.data.hourseList;
                    $scope.totalCount = resp.data.totalCount;
                    draw(resp.data.pageNum,Math.ceil(resp.data.totalCount/10));
                }
                //每次重新加载列表后清空复选框的勾选状态和保存id的数组。
                $("#selall").prop("checked", false);
                $scope.selectIds = [];
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
        if ($scope.hoursePicList.length >= 4){
            alert("最多上传4张图片。");
            return;
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
        if ($scope.hourse.hourseid == ""){
            //新增房源的时候点击删除直接从磁盘上删除。
            var index = -1;
            for (var i = 0; i < $scope.hoursePicList.length; i++) {
                if ($scope.hoursePicList[i] === picName){
                    index = i;
                }
            }
            if (index > -1){
                $scope.hoursePicList.splice(index,1);
            }
            hourseService.deletePicture(picName);
        } else {
            //修改房源的时候点击删除先将要删除的图片保存在删除列表中，并从页面上删掉，在保存的时候再进行磁盘上删除删除。
            $scope.waitForDelete.push(picName);
            var index = -1;
            for (var i = 0; i < $scope.hoursePicList.length; i++) {
                if ($scope.hoursePicList[i] === picName){
                    index = i;
                }
            }
            if (index > -1){
                $scope.hoursePicList.splice(index,1);
            }
        }

    };

    //保存房源信息到数据库。
    $scope.savaOrUpdateHourse = function () {
        if ($scope.hoursePicList.length != 4){
            alert("请上传4张图片");
            return
        }
        if ($scope.hourse.hourseid == ""){
            //save
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
                    alert("删除成功。");
                    $scope.searchHourseWithVillage();
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
                alert("上架成功。");
                $scope.searchHourseWithVillage();
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
                alert("下架成功。");
                $scope.searchHourseWithVillage();
            } else {
                alert(resp.msg);
            }
        })
    };


    //点击分页栏的页码就行跳转。
    $scope.jumpPage = function (pageNum) {
        if(!isNaN(pageNum)){
            if (pageNum >= 1 && pageNum <= Math.ceil($scope.totalCount/10)) {
                $scope.currPage = pageNum;
                $scope.searchHourseWithVillage();
            }
        }
    };

    //输入页码跳转到指定分页。
    $scope.toPage = function () {
        var num = $("#toPage").val();
        if (isNaN(num)) {
            alert("请输入有效的页码。");
        } else if (num < 1 || num > Math.ceil($scope.totalCount/10)) {
            alert("请输入有效的页码。")
        } else {
            $scope.jumpPage(parseInt(num));
        }
    };

    //绘制分页栏,连续显示5个页码。
    //分页的4种情况，假设有9页，分页栏连续显示5个页码。
    //  6页以下的:
    //          1 2 3 4 5 6     totalPage <= 6
    //  6页以上的：
    //          1 2 3 4 5... 9  currPage <= 4
    //          1 ... 3 4 5 6 7 ... 9   剩下的都是这种样式。
    //          1 ... 6 7 8 9   (totalPage-currPage) <= 3
    var draw = function (currPage, totalPage) {
        if (currPage == 1){
            $("#prevPage").css("background-color","#b8c7ce");
        } else {
            $("#prevPage").css("background-color","white");
        }
        if (totalPage == currPage){
            $("#nextPage").css("background-color","#b8c7ce");
        } else {
            $("#nextPage").css("background-color","white");
        }
        //定义一个数组用来保存分页栏需要展示的元素，保存在集合中使用时在前台html页面循环遍历展示即可。
        $scope.pageList = [];
        if (totalPage <= 6){
            for (var i = 1; i <= totalPage; i++) {
                $scope.pageList.push(i);
            }
        } else {
            if ((totalPage-currPage) <= 3){
                $scope.pageList.push(1);
                $scope.pageList.push("...");
                for (var i = totalPage - 4; i <= totalPage ; i++) {
                    $scope.pageList.push(i);
                }
            } else if (currPage <= 4){
                for (var i = 1; i <= 5; i++) {
                    $scope.pageList.push(i);
                }
                $scope.pageList.push("...");
                $scope.pageList.push(totalPage);
            } else {
                $scope.pageList.push(1);
                $scope.pageList.push("...");
                for (var i = currPage - 2; i <= currPage + 2 ; i++) {
                    $scope.pageList.push(i);
                }
                $scope.pageList.push("...");
                $scope.pageList.push(totalPage);
            }
        }
    }

});