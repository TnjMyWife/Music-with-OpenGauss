package com.music.dao;

import com.music.pojo.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface albumDao extends JpaRepository<Album, Integer>, Serializable {
}
