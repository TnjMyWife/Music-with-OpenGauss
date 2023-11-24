package com.music.service;


import com.music.pojo.User;

import java.util.List;

public interface userService {
    List<User> findAllUser();

    User findUserById(Integer Cid);

    User userExist(String userName, String password);
}
