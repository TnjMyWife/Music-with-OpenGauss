package com.music.service;

import com.music.pojo.PlayList;
import com.music.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface playListService {

    List<PlayList> findAllPlayList();

    PlayList playListExist(User user, String listName);



    Set<Integer> findSongIdByListId(Integer listId);

    void deleteSongByListIdAndSongId(Integer listId, Integer songId);

    void addSongByListIdAndSongId(Integer listId, Integer songId);

    List<PlayList> findPlayListByUserId(Integer id);



    int findPlayListMaxId();

    void addPlayList(Integer id, String playListName, Integer userId, String listData);


    void deletePlayListById(Integer id,String Name);
}
