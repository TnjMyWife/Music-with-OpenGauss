package com.music.dao;

import com.music.pojo.PlayList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface playListDao extends JpaRepository<PlayList, Integer>, Serializable {
}
