package com.music.controller;

import com.music.pojo.Album;
import com.music.pojo.Artist;
import com.music.pojo.Song;
import com.music.service.albumService;
import com.music.service.artistService;
import com.music.service.songService;
import com.music.service.userService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    @Resource
    private userService u;

    @Resource
    private songService s;
    @Resource
    private albumService alb;
    @Resource
    private artistService art;
    @RequestMapping("/search")
    public String login(@RequestParam("user_id") int id,
                        @RequestParam("query_string") String queryString,
                        HttpSession session){
        List<Album> albums = alb.searchAlbums(queryString);
        List<Artist> artists = art.searchArtists(queryString);
        List<Song> songs = s.searchSongs(queryString);
        session.setAttribute("albums", albums);
        session.setAttribute("artists", artists);
        session.setAttribute("songList", songs);
        return "redirect:/searchPage?user_id="+id;   /* 登录成功，跳转到dashboard.html页面 */
    }
}
