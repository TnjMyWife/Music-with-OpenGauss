package com.music.dao;

import com.music.pojo.Album;
import com.music.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface albumDao extends JpaRepository<Album, Integer>, Serializable {

    @Transactional
    @Modifying
    @Query(value = "select * from album where artist_id = :artistId", nativeQuery = true)
    List<Album> findByArtist(@Param("artistId")Integer artistId);

    List<Album> findAlbumByAlbumNameContaining(String keyWords);
}
