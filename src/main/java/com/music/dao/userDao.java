package com.music.dao;

import com.music.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface userDao extends JpaRepository<User, Integer>, Serializable {

    User findUserByUserNameAndPassword(String userName, String password);

}
