package cn.com.dhc.controller;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.service.HourseService;
import cn.com.dhc.util.CodeMsg;
import cn.com.dhc.util.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/hourse")
public class HourseController {

    @Resource
    private HourseService hourseService;

    @Value("${fileSavePath}")
    private String fileSavePath;

    @RequestMapping(value = "/searchHourseWithVillage",method = RequestMethod.GET)
    @ResponseBody
    public Result<SearchResult> searchHourseWithVillage(String status,String currPage, String village){
        return hourseService.searchHourseWithVillage(status,currPage,village);
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> upload(@RequestParam("file")MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        String fileName= UUID.randomUUID().toString().replace("-", "");
        String picNewName = fileName + originalName.substring(originalName.lastIndexOf("."));
        String imgRealPath = fileSavePath + picNewName;
        File imageFile=new File(imgRealPath);
        file.transferTo(imageFile);
        return Result.success(picNewName);
    }

    @RequestMapping(value = "/deletePicture",method = RequestMethod.GET)
    @ResponseBody
    public Result<String> deletePicture(String picName){
        String imgRealPath = fileSavePath + picName;
        File imageFile=new File(imgRealPath);
        if (imageFile.delete()){
            return Result.success("删除成功。");
        }
        return Result.success("删除失败。");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    public Result<String> add(@RequestBody Hourse hourse, HttpServletRequest request){
//        String username = (String) request.getSession().getAttribute("username");
        hourse.setUid(1);
        int result = hourseService.add(hourse);
        if (result == 1){
            return Result.success("保存成功。");
        } else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/searchById",method = RequestMethod.GET)
    @ResponseBody
    public Result<Hourse> searchById(String hourseId){
        Result<Hourse> result = hourseService.searchById(hourseId);
        return result;
    }

}
