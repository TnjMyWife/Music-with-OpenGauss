package com.music.dao;

import com.music.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public interface userDao extends JpaRepository<User, Integer>, Serializable {

    User findUserByUserNameAndPassword(String userName, String password);
    User findUserByUserName(String userName);


    @Transactional
    @Modifying
    @Query(value = "insert into music_user values(:#{#user.userId},:#{#user.userName},:#{#user.password},:#{#user.gender},:#{#user.avatar},:#{#user.email},:#{#user.signature})",nativeQuery = true)
    int saveOne(User user);

    @Transactional
    @Modifying
    @Query(value = "select count(*) from music_user",nativeQuery = true)
    int userCount();

}
