package com.music.pojo;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "album")
public class Album implements Serializable {
    @Id
    @Column(name = "album_id")
    private Integer albumId;
    @Column(name = "album_name")
    private String albumName;
    @Column(name = "type")
    private String type;
    @Column(name = "album_date")
    private Integer albumDate;
    @Column(name = "album_publisher")
    private String albumPub;
    @Column(name = "album_count")
    private Integer albumCount;
    @Column(name = "album_cover")
    private String albumCover;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAlbumDate() {
        return albumDate;
    }

    public void setAlbumDate(Integer albumDate) {
        this.albumDate = albumDate;
    }

    public String getAlbumPub() {
        return albumPub;
    }

    public void setAlbumPub(String albumPub) {
        this.albumPub = albumPub;
    }

    public Integer getAlbumCount() {
        return albumCount;
    }

    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }

    public String getAlbumCover() {
        return albumCover;
    }

    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", albumName='" + albumName + '\'' +
                ", type='" + type + '\'' +
                ", albumDate='" + albumDate + '\'' +
                ", albumPub='" + albumPub + '\'' +
                ", albumCount=" + albumCount +
                ", albumCover='" + albumCover + '\'' +
                ", artist=" + artist +
                '}';
    }
}
