package com.music.controller;


import com.music.pojo.PlayList;
import com.music.pojo.Song;
import com.music.pojo.User;
import com.music.service.playListService;
import com.music.service.songService;
import com.music.service.userService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


@Controller
public class PlayListController {
    @Resource
    private userService u;
    @Resource
    private playListService p;
    @Resource
    private songService s;
    @RequestMapping("/list")
    public String login(@RequestParam("user_id") Integer id,
                        @RequestParam("listName") String listName,
                        HttpSession model,
                        HttpSession Name,
                        HttpSession Id,
                        HttpSession session,
                        HttpSession userId){
        User user=u.findUserById(id);
        PlayList temp=p.playListExist(user,listName);
        System.out.println(listName);
        System.out.println(temp);
        Set<Integer> songId=  p.findSongIdByListId(temp.getListId());
        System.out.println(songId);
        Iterator<Integer> iterator = songId.iterator();
        List<Song> songs=new ArrayList<>();
        for (int i=0;i<songId.size();i++) {
            Integer element = iterator.next();
            songs.add(s.findSongbySongId(element));
        }
        List<PlayList> playList=p.findPlayListByUserId(id);
        System.out.println((playList));
        System.out.println((songs));
        model.setAttribute("songList",songs);
        session.setAttribute("myList",playList);
        Name.setAttribute("Name",listName);
        Id.setAttribute("Id",temp.getListId());
        userId.setAttribute("user_id",id);
        /* 获取到提交的表单的username、password后，验证用户名密码是否正确 */
        return "redirect:/listSong?user_id="+id;
    }
}
