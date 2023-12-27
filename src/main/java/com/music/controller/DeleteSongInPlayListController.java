package com.music.controller;


import com.music.dao.playListDao;
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
public class DeleteSongInPlayListController {
    @Resource
    private userService u;
    @Resource
    private playListService p;
    @Resource
    playListDao pDao;
    @Resource
    private songService s;
    @RequestMapping("/delete")
    public String login(@RequestParam("user_id") int id,
                        @RequestParam("listId") int listId,
                        @RequestParam("songId") int songId,
                        HttpSession model,
                        HttpSession Name,
                        HttpSession Id,
                        HttpSession session,
                        HttpSession userId){
        PlayList playList=pDao.findPlayListByListId(listId);
        System.out.println(playList);
        System.out.println(id);
        System.out.println(listId);
        System.out.println(songId);
        p.deleteSongByListIdAndSongId(listId,songId);
        Set<Integer> songIdList =  p.findSongIdByListId(playList.getListId());
        System.out.println(songId);
        Iterator<Integer> iterator = songIdList.iterator();
        List<Song> songs=new ArrayList<>();
        for (int i=0;i<songIdList.size();i++) {
            Integer element = iterator.next();
            songs.add(s.findSongbySongId(element));
        }
        List<PlayList> playListAll=p.findPlayListByUserId(id);
        model.setAttribute("songList",songs);
        session.setAttribute("myList",playListAll);
        Name.setAttribute("Name",playList.getListName());
        Id.setAttribute("Id",playList.getListId());
        userId.setAttribute("user_id",id);
        /* 获取到提交的表单的username、password后，验证用户名密码是否正确 */
        return "redirect:/listSong?user_id="+id;   /* 登录成功，跳转到dashboard.html页面 */
    }
}
