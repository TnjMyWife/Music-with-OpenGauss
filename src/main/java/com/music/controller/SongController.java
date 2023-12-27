package com.music.controller;

import com.music.pojo.PlayList;
import com.music.pojo.Song;
import com.music.service.playListService;
import com.music.service.songService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class SongController {
    @Resource
    songService s;
    @Resource
    playListService p;
    @RequestMapping("/browser_song")
    public String listAlbum(@RequestParam(name="user_id") int user_id, Model model, HttpSession session) {
        List<Song> songList = new ArrayList<>();
        for (int i=200;i<1000;i+=15) {
            songList.add(s.findSongbySongId(i));
        }
        System.out.println(songList);
        model.addAttribute("songList",songList);
        List<PlayList> playList=new ArrayList<>();
        playList=p.findPlayListByUserId(user_id);
        System.out.println((playList));
        session.setAttribute("myList",playList);
        return "song";
    }
}