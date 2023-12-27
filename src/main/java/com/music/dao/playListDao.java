package com.music.dao;

import com.music.pojo.PlayList;
import com.music.pojo.Song;
import com.music.pojo.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface playListDao extends JpaRepository<PlayList, Integer>, Serializable {
    PlayList findPlayListByUserAndListName(User user,String listName);
    PlayList findPlayListByListId(Integer id);
    @Transactional
    @Modifying
    @Query(value = "select * from playlist where user_id=:#{#id}",nativeQuery = true)
    List<PlayList> findPlayListByUserId(Integer id);
    @Transactional
    @Modifying
    @Query(value = "select MAX(list_id) from playlist",nativeQuery = true)
    int findMaxList();

    @Transactional
    @Modifying
    @Query(value = "insert into playlist values(:#{#id},:#{#playListName},:#{#userId},:#{#listData})",nativeQuery = true)
    void AddPlayListByUserId(Integer id,String playListName,Integer userId,String listData);

    @Transactional
    @Modifying
    @Query(value = "delete from playlist where user_id=:#{#id} and list_name=:#{#name}",nativeQuery = true)
    void deletePlayListById(Integer id,String name);

}