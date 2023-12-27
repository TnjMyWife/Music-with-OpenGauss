package com.music.dao;

import com.music.pojo.Album;
import com.music.pojo.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface songDao extends JpaRepository<Song, Integer>, Serializable {
    Song findSongBySongId(Integer id);
    List<Song> findSongsByAlbumOrderBySongNumAsc(Album album);
    List<Song> findSongBySongNameContaining(String keyWords);
}