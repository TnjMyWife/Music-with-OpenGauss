package com.music.service.impl;

import com.music.pojo.Album;
import com.music.pojo.Song;
import com.music.dao.songDao;
import com.music.service.songService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class songServiceImpl implements songService {
    @Resource
    private songDao s;
    @Override
    public List<Song> findAllSong(){
        return s.findAll();
    }
    @Override
    public Song findSongbySongId(Integer id){
        return s.findSongBySongId(id);
    }

    @Override
    public List<Song> findSongByAlbum(Album album) { return s.findSongsByAlbumOrderBySongNumAsc(album); }

    @Override
    public List<Song> searchSongs(String keyWords){ return s.findSongBySongNameContaining(keyWords); }
}
