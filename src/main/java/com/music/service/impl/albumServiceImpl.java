package com.music.service.impl;

import com.music.dao.albumDao;
import com.music.pojo.Album;
import com.music.service.albumService;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class albumServiceImpl implements albumService {
    @Resource
    albumDao albumdao;

    @Override
    public List<Album> findAllAlbum() { return albumdao.findAll(Sort.by(Sort.Direction.ASC,"albumId")); }

    @Override
    public Album findAlbumById(Integer albumId) { return albumdao.getReferenceById(albumId); }

    public List<Album> findAlbumByArtistID(Integer artistId) { return albumdao.findByArtist(artistId); }
    @Override
    public List<Album> searchAlbums(String keyWords){ return albumdao.findAlbumByAlbumNameContaining(keyWords);}
}
