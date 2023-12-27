package com.music.controller;

import com.music.pojo.Album;
import com.music.service.albumService;
import com.music.service.artistService;
import com.music.pojo.Artist;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


@Controller
public class ArtistController {
    @Resource
    private artistService a;
    @Resource
    private albumService al;

    @RequestMapping("/browser_artist")
    public String listArtist(Model model) {
        List<Artist> artists = a.findAllArtist();
        model.addAttribute("artists", artists);
        return "browserArtist"; // 返回Thymeleaf模板的名称
    }

    @RequestMapping("/one_artist")
    public String oneArtist(@RequestParam(name="user_id") int user_id,
                            @RequestParam(name="artist_id") int artist_id,
                            Model model,
                            HttpSession session) {
        int id = artist_id;
        Artist artist = a.findArtistById(id);
        List<Album> albums = al.findAlbumByArtistID(id);
        //String filePath = "E:\\privat" + artist.getBrief();
        String filePath = artist.getBrief();
        String fileContent = readFileContent(filePath);
        session.setAttribute("artist", artist);
        session.setAttribute("albums", albums);
        session.setAttribute("brief", fileContent);
        return "redirect:/artistPage?user_id=" + user_id;
    }

    private String readFileContent(String filePath) {
        try {
            // 读取文本文件的内容
            byte[] encoded = Files.readAllBytes(Paths.get(filePath));
            return new String(encoded);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading the file";
        }
    }
}
