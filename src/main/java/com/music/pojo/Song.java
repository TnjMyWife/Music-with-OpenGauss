package com.music.pojo;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "song") // 指定关联的数据库的表名
public class Song implements Serializable {
    @Id
    @Column(name = "song_id")
    private Integer songId;
    @Column(name = "song_name")
    private String songName;
    @Column(name = "song_number")
    private Integer songNum;
    @Column(name = "song_duration")
    private double songDuration;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private Album album;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id")
    private Artist artist;
    @Column(name = "type")
    private String type;
    @Column(name = "song_date")
    private Integer song_date;
    @Column(name = "song_path")
    private String songPath;
    @Column(name = "mv")
    private String mv;

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Integer getSongNum() {
        return songNum;
    }

    public void setSongNum(Integer songNum) {
        this.songNum = songNum;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSong_date() {
        return song_date;
    }

    public void setSong_date(Integer song_date) {
        this.song_date = song_date;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }

    public String getMv() {
        return mv;
    }

    public void setMv(String mv) {
        this.mv = mv;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", songNum=" + songNum +
                ", songDuration=" + songDuration +
                ", album=" + album +
                ", artist=" + artist +
                ", type='" + type + '\'' +
                ", song_date=" + song_date +
                ", songPath='" + songPath + '\'' +
                ", mv='" + mv + '\'' +
                '}';
    }
}
