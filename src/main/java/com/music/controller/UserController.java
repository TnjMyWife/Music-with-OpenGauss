package com.music.controller;

import com.music.pojo.Song;
import com.music.pojo.User;
import com.music.service.songService;
import com.music.service.userService;
import com.music.pojo.PlayList;
import com.music.service.playListService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {
    @Resource
    private userService u;
    @Resource
    private playListService p;
    @Resource
    private songService s;
    @RequestMapping("/home")
    public String test(@RequestParam(name="user_id") int user_id,
                       ModelMap model,
                       Model Like_list,
                       HttpSession session){
        User user=u.findUserById(user_id);
        List<User> userList= u.findAllUser();
        System.out.println(userList);
        PlayList temp=p.playListExist(user,"我喜欢");
        System.out.println(temp);
        Set<Integer> songId=p.findSongIdByListId(temp.getListId());
        System.out.println(songId);
        List<Song> songs = new ArrayList<>();
        for(Integer id:songId){
            songs.add(s.findSongbySongId(id));
        }
        System.out.println(songs);
        List<PlayList> playList=new ArrayList<>();
        playList=p.findPlayListByUserId(user_id);
        System.out.println((playList));
        session.setAttribute("myList",playList);
        model.addAttribute("user",user);
        session.setAttribute("listLike",songs);
        return "user" ;
    }

}
