package com.music.dao;

import com.music.pojo.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface songDao extends JpaRepository<Song, Integer>, Serializable {
}
