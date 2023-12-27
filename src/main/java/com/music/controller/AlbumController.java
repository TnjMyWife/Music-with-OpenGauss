package com.music.controller;

import com.music.pojo.Album;
import com.music.pojo.Song;
import com.music.service.albumService;
import com.music.service.songService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumController {
    @Resource
    albumService a;
    @GetMapping("/browser_album")
    public String listAlbum(Model model) {
        List<Album> albums = a.findAllAlbum();
        model.addAttribute("albums", albums);
        return "browserAlbum";
    }

    @Resource
    songService b;
    @GetMapping("/one_album")
    public String oneAlbum(@RequestParam(name="user_id") int user_id,
                           @RequestParam(name="album_id") int album_id,
                           Model model,
                           HttpSession session) {

        int id = album_id;
        Album album = a.findAlbumById(id);
        List<Song> songs = b.findSongByAlbum(album);

        // 构建歌曲id与格式化后的时长的映射关系
        List<String> formattedDurations = new ArrayList<>();
        for (Song song : songs) {
            double songDuration = song.getSongDuration();
            String formattedDuration = formatDuration(songDuration);
            formattedDurations.add(formattedDuration);
        }

        model.addAttribute("data","SpringBoot 成功集成 Thymeleaf 模版！");
        model.addAttribute("album", album);
        model.addAttribute("songs", songs);
        model.addAttribute("formattedDurations", formattedDurations);

        return "albumpage";
    }

    private String formatDuration(double seconds) {
        int minutes = (int) seconds / 60;
        int remainingSeconds = (int) seconds % 60;
        return String.format("%d:%02d", minutes, remainingSeconds);
    }
}
