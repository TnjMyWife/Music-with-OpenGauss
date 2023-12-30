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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
public class RegisterController {
    @Resource
    private userService u;
    @Resource
    private playListService p;
    @RequestMapping("/user/regist")
    public String regist(@RequestParam("username") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("email") String email,
                        @RequestParam("gender") String gender,
                        Model model){
        User user = new User();
        user.setUserId(u.findAllUser().size());
        user.setUserName(userName);
        user.setPassword(password);
        user.setAvatar("/opt/musicfile/user_img/default.jpg");
        user.setEmail(email);
        user.setGender(gender);
        user.setSignature("这个用户似乎有点懒");

        User flag = u.isUserUnique(userName);
        if(flag != null){
            model.addAttribute("userRepeat","Username already exists");
            return "register";
        }

        if(!gender.equals("男") && !gender.equals("女")){
            model.addAttribute("genderWrong","Gender should be \"男\" or \"女\"");
            return "register";
        }

        int ret = u.save(user);
        List<PlayList> playList=p.findAllPlayList();
        int num=0;
        for (PlayList list : playList) {
            if (num < list.getListId()) {
                num = list.getListId();
            }
        }

        System.out.println(num);
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentTime.format(formatter);
        p.addPlayList(num+1,"我喜欢",user.getUserId(),formattedDateTime);


        return "redirect:/index";
    }
}
