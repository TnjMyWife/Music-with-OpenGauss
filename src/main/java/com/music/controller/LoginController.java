package com.music.controller;


import com.music.pojo.User;
import com.music.service.userService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
    @Resource
    private userService u;
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        User user = u.userExist(userName, password);
        /* 获取到提交的表单的username、password后，验证用户名密码是否正确 */
        if(user != null){
            session.setAttribute("loginUser", userName);
            return "redirect:/dashboard";   /* 登录成功，跳转到dashboard.html页面 */
        }else{
            /* 显示登陆失败,通过model向页面传递值 */
            model.addAttribute("msg","Invalid username or password.");
            return "index";
        }
    }
}
