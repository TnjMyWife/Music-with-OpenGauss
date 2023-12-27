package com.music.service;

import com.music.pojo.Album;

import java.util.List;

public interface albumService {
    List<Album> findAllAlbum();

    Album findAlbumById(Integer albumId);

    List<Album> findAlbumByArtistID(Integer artistId);

    List<Album> searchAlbums(String keyWords);
}
