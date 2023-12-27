package com.music.pojo;

import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "playlist") // 指定关联的数据库的表名
public class PlayList implements Serializable {

    @Id
    @Column(name = "list_id")
    private Integer listId;

    @Column(name = "list_name")
    private String listName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "list_date")
    private Timestamp listDate;

    @ManyToMany
    @JoinTable(
            name = "included",    // 自动生成的第三方表名
            joinColumns = @JoinColumn(name = "list_id"),       // 将本表id，存储到第三方表
            inverseJoinColumns = @JoinColumn(name = "song_id")       // 将对方表id，存储到第三方表
    )
    private Set<Song> songs=new HashSet<>();

    public Set<Song> getSongs(){
        return songs;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getListDate() {
        return listDate;
    }

    public void setListDate(Timestamp listDate) {
        this.listDate = listDate;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "listId=" + listId +
                ", listName='" + listName + '\'' +
                ", user=" + user +
                ", listDate=" + listDate +
                '}';
    }
}
