package com.music.service;

import com.music.pojo.Artist;

import java.util.List;

public interface artistService {
    List<Artist> findAllArtist();

    Artist findArtistById(Integer artistId);

    List<Artist> searchArtists(String keyWords);
}
