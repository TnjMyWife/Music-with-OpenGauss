package com.music.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "artist") // 指定关联的数据库的表名
public class Artist implements Serializable {
    @Id
    @Column(name = "artist_id")
    private Integer artistId;
    @Column(name = "artist_name")
    private String artistName;
    @Column(name = "brief")
    private String brief;
    @Column(name = "artist_img_path")
    private String artistImg;

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getArtistImg() {
        return artistImg;
    }

    public void setArtistImg(String artistImg) {
        this.artistImg = artistImg;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                ", brief='" + brief + '\'' +
                ", artistImg='" + artistImg + '\'' +
                '}';
    }
}
