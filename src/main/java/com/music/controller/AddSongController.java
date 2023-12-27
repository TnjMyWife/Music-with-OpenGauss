package com.music.controller;

import com.music.pojo.User;
import com.music.service.songService;
import com.music.service.userService;
import com.music.service.playListService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Transactional
public class AddSongController{
    @Autowired
    private userService u;
    @Autowired
    private playListService p;
    @Autowired
    private songService s;
    @RequestMapping("/addsong")
    public String test(@RequestParam("page") String page,
                       @RequestParam("user_id") int id,
                       @RequestParam("addName") String addName,
                       @RequestParam("song_id") Integer song_id,
                       HttpSession session,
                       Model model){
        System.out.println(page);
        System.out.println(id);
        User user=u.findUserById(id);
        if(!addName.isEmpty()) {
            Integer list_id = p.playListExist(user, addName).getListId();
            p.addSongByListIdAndSongId(list_id, song_id);
            return "redirect:"+page ;
        }
        else{
            model.addAttribute("errorInfo", "请选择歌单!");
            return "redirect:"+page ;
        }

    }

}