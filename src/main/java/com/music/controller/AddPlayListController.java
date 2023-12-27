package com.music.controller;

import com.music.pojo.Song;
import com.music.pojo.User;
import com.music.service.songService;
import com.music.service.userService;
import com.music.pojo.PlayList;
import com.music.service.playListService;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class AddPlayListController{
    @Autowired
    private userService u;
    @Autowired
    private playListService p;
    @Autowired
    private songService s;
    @RequestMapping("/user/playlist")
    public String test(@RequestParam("page") String page,
                       @RequestParam("user_id") int id,
                       @RequestParam("listName") String listName,
                       @RequestParam("delName") String deleteName,
                       HttpSession session){
        System.out.println(page);
        System.out.println(id);
        System.out.println(listName);
        System.out.println(deleteName);
        User user=u.findUserById(id);
        // 将时间格式化为数据库可接受的格式
        if (listName != null && !listName.isEmpty()) {
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
            p.addPlayList(num+1,listName,id,formattedDateTime);
        }
        if(deleteName!=null && !deleteName.isEmpty()){
            p.deletePlayListById(id,deleteName);
        }
        List<PlayList> playListAll=p.findPlayListByUserId(id);
        System.out.println(playListAll);
        session.setAttribute("myList",playListAll);
        return "redirect:"+page ;
    }

}