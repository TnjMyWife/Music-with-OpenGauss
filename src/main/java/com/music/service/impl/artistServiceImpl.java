package com.music.service.impl;

import com.music.dao.artistDao;
import com.music.pojo.Artist;
import com.music.service.artistService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class artistServiceImpl  implements artistService {
    @Resource
    private artistDao artistdao;

    @Override
    public List<Artist> findAllArtist() { return artistdao.findAll(Sort.by(Sort.Direction.ASC,"artistId")); }

    @Override
    public Artist findArtistById(Integer artistId) { return artistdao.getReferenceById(artistId); }
    @Override
    public List<Artist> searchArtists(String keyWords) { return artistdao.findArtistByArtistNameContaining(keyWords); }
}
