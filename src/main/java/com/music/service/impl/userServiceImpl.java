package com.music.service.impl;

import com.music.dao.userDao;
import com.music.pojo.User;
import com.music.service.userService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class userServiceImpl implements userService {
    @Resource
    private userDao u;

    @Override
    public List<User> findAllUser() {
        return u.findAll();
    }

    @Override
    public User findUserById(Integer userId) {
        return u.getReferenceById(userId);
    }
    @Override
    public User userExist(String userName, String password) {
        return u.findUserByUserNameAndPassword(userName, password);
    }

    @Override
    public User isUserUnique(String userName) {
        return u.findUserByUserName(userName);
    }

    @Transactional
    @Override
    public int save(User newUser){ return u.saveOne(newUser); }
    @Transactional
    @Override
    public void fixName(int id,String name){ u.userFixName(id,name);}

    @Transactional
    @Override
    public void fixGender(int id,String gender){ u.userFixGender(id,gender);}
    @Transactional
    @Override
    public void fixEmail(int id,String email){ u.userFixEmail(id,email);}
    @Transactional
    @Override
    public void fixSignature(int id,String signature){ u.userFixSignature(id,signature);}
    @Transactional
    @Override
    public void fixAvatar(int id,String avatar){ u.userFixAvatar(id,avatar);}

}
