package cn.com.dhc.controller;

import cn.com.dhc.domain.Usermanager;
import cn.com.dhc.service.UserManagerService;
import cn.com.dhc.util.CodeMsg;
import cn.com.dhc.util.DJWRuntimeException;
import cn.com.dhc.util.Result;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/userManager")
public class UserManagerController {

    @Resource
    private UserManagerService userManagerService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public Result<Usermanager> login(@RequestBody Usermanager usermanager, HttpServletRequest request){
        Usermanager user = userManagerService.login(usermanager.getUsername(), usermanager.getPassword());
        request.getSession().setAttribute("username",user.getUsername());
        return Result.success(user);
    }

    @RequestMapping(value = "/findLoginUserManager",method = RequestMethod.GET)
    @ResponseBody
    public Result<Usermanager> findLoginUserManager(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Object username = request.getSession().getAttribute("username");
        if (username == null){
            response.sendRedirect("/admin/shoplogin.html");
        }
        Usermanager usermanager = userManagerService.findUserManagerByUsername(username.toString());
        if (usermanager == null){
            throw new DJWRuntimeException(CodeMsg.SERVER_ERROR);
        }
        return Result.success(usermanager);
    }

    @RequestMapping("/logout")
    public void logout(String username, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Object name = request.getSession().getAttribute("username");
        if (name != null && name.toString().equals(username)){
            request.getSession().removeAttribute("username");
            response.sendRedirect("/admin/shoplogin.html");
        }
    }

}
