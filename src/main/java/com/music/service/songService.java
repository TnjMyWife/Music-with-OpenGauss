package com.music.service;

import com.music.pojo.Album;
import com.music.pojo.Song;

import java.util.List;

public interface songService {
    List<Song> findSongByAlbum(Album album);

    List<Song> findAllSong();

    Song findSongbySongId(Integer id);

    List<Song> searchSongs(String keyWords);
}
