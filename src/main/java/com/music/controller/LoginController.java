package com.music.controller;


import com.music.pojo.PlayList;
import com.music.pojo.User;
import com.music.service.playListService;
import com.music.service.userService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class LoginController {
    @Resource
    private userService u;
    @Resource
    private playListService p;
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        Model model,
                        Model myFavourite,
                        HttpSession session){
        User user = u.userExist(userName, password);
        /* 获取到提交的表单的username、password后，验证用户名密码是否正确 */
        if(user != null){/*修改name换为id*/
            List<PlayList> playList=new ArrayList<>();
            playList=p.findPlayListByUserId(user.getUserId());
            System.out.println((playList));
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("myList",playList);
            return "redirect:/homepage?user_id="+user.getUserId();   /* 登录成功，跳转到dashboard.html页面 */
        }else{
            /* 显示登陆失败,通过model向页面传递值 */
            model.addAttribute("msg","Invalid username or password.");
            return "index";
        }
    }
}
