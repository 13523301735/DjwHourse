package cn.com.dhc.controller;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.service.GalleryvariationService;
import cn.com.dhc.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/galleryvariation")
public class GalleryvariationController {

    @Resource
    private GalleryvariationService galleryvariationService;

    @RequestMapping(value = "/searchById",method = RequestMethod.GET)
    @ResponseBody
    public Result<Hourse> searchById(String hourseId){
        return galleryvariationService.searchById(hourseId);
    }

}
