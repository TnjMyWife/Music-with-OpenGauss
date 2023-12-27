package com.music.controller;


import com.music.pojo.PlayList;
import com.music.service.playListService;
import com.music.service.userService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FixUserController {
    private static final long MAX_FILE_SIZE = 10485760;
    @Resource
    private userService u;

    @Resource
    private playListService p;
    @RequestMapping("/fix")
    public String login(@RequestParam(name="user_id") int user_id,
                        @RequestParam(name="username") String username,
                        @RequestParam(name="email") String email,
                        @RequestParam(name="gender") String gender,
                        @RequestParam(name="signature") String signature,
                        @RequestPart(name="photo") MultipartFile avatar,
                        Model model,
                        HttpSession session){
        /* 获取到提交的表单的username、password后，验证用户名密码是否正确 */
            u.fixName(user_id,username);
            u.fixGender(user_id,gender);
            u.fixEmail(user_id,email);
            u.fixSignature(user_id,signature);
            String filename = avatar.getOriginalFilename();
            System.out.println(filename);
            //String filePath = "E:\\privat"+"\\opt\\musicfile\\user_img";
            String filePath = "/opt/musicfile/user_img";
            if (!new File(filePath).exists()){
                new File(filePath).mkdirs();
            }
            File dest = new File(filePath + File.separator +user_id+".jpg");
            try {
            avatar.transferTo(dest);
            }catch (Exception e){
                e.printStackTrace();
            }
            String path="/opt/musicfile/user_img/"+user_id+".jpg";
            u.fixAvatar(user_id,path);
            List<PlayList> playList=new ArrayList<>();
            playList=p.findPlayListByUserId(user_id);
            System.out.println((playList));
            session.setAttribute("myList",playList);
            return "redirect:/home?user_id="+user_id;
    }
}