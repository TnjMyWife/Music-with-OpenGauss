package com.music.service.impl;

import com.music.dao.playListDao;
import com.music.dao.songDao;
import com.music.pojo.PlayList;
import com.music.pojo.Song;
import com.music.pojo.User;
import com.music.service.playListService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class playListServiceImpl implements playListService {
    @Resource
    private playListDao p;
    @Resource
    private songDao s;
    @Override
    public List<PlayList> findAllPlayList() {
        return p.findAll();
    }
    @Override
    public PlayList playListExist(User user, String ListName) {
        return p.findPlayListByUserAndListName(user,ListName);
    }

    @Override
    public Set<Integer> findSongIdByListId(Integer listId){
        PlayList listAll = p.findPlayListByListId(listId);
        Set<Song> songs=listAll.getSongs();
        return songs.stream().map(Song::getSongId).collect(Collectors.toSet());
    }
    @Override
    public void deleteSongByListIdAndSongId(Integer listId,Integer songId){
        PlayList listAll = p.findPlayListByListId(listId);
        Set<Song> songs=listAll.getSongs();
        Iterator<Song> iterator = songs.iterator();
        Song deletesong = new Song();
        for (int i=0;i<songs.size();i++) {
            Song element = iterator.next();
            if(Objects.equals(songId, element.getSongId())){
                deletesong=element;
                break;
            }
        }
        listAll.getSongs().remove(deletesong);
    }
    @Override
    public void addSongByListIdAndSongId(Integer listId,Integer songId){
        PlayList listAll = p.findPlayListByListId(listId);
        Song addsong = s.findSongBySongId(songId);
        listAll.getSongs().add(addsong);
    }
    @Override
    public List<PlayList> findPlayListByUserId(Integer id){
        return p.findPlayListByUserId(id);
    }

    @Override
    public int findPlayListMaxId(){return p.findMaxList();}

    @Override
    public void addPlayList(Integer id, String playListName, Integer userId, String listData){
        p.AddPlayListByUserId(id,playListName,userId,listData);}

    @Override
    public void deletePlayListById(Integer id,String name){
        p.deletePlayListById(id,name);
    }
}
