package cn.com.dhc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class IndexController {

    @RequestMapping(value = "/%7B%7Bpicture%7D%7D",method = RequestMethod.GET)
    public void picture(){
        System.out.println("picture = " + "空请求。");
    }

}
