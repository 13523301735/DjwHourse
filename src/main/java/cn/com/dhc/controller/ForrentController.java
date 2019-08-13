package cn.com.dhc.controller;

import cn.com.dhc.domain.Hourse;
import cn.com.dhc.domain.SearchEntity;
import cn.com.dhc.domain.SearchResult;
import cn.com.dhc.service.ForrentService;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/forrent")
public class ForrentController {

    @Resource
    private ForrentService forrentService;

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    @ResponseBody
    public Result<SearchResult> searchHourse(@RequestBody SearchEntity searchEntity) throws DJWRuntimeException {
        return forrentService.searchHourse(searchEntity);
    }

}
