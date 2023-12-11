package com.music.dao;

import com.music.pojo.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface artistDao extends JpaRepository<Artist, Integer>, Serializable {
}
