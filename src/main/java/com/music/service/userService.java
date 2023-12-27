package com.music.service;


import com.music.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface userService {
    List<User> findAllUser();

    User findUserById(Integer Cid);

    /* 检查用户是否存在 */
    User userExist(String userName, String password);

    /* */
    User isUserUnique(String userName);

    /* 新增用户 */
    int save(User u);

    void fixName(int id,String name);
    void fixGender(int id, String gender);


    void fixEmail(int id, String email);


    void fixSignature(int id, String signature);

    @Transactional
    void fixAvatar(int id, String avatar);
}
