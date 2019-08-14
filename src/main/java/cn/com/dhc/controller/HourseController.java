package cn.com.dhc.controller;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.service.HourseService;
import cn.com.dhc.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/hourse")
public class HourseController {

    @Resource
    private HourseService hourseService;

    @RequestMapping("/searchHourseWithVillage")
    @ResponseBody
    public Result<SearchResult> searchHourseWithVillage(String status,String currPage, String village){
        return hourseService.searchHourseWithVillage(status,currPage,village);
    }

}
