package com.example.uploadmusicfile.model;

import java.util.List;

public class Music {

    private Long id;

    private String musicName;

    private String singlerName;

    private List<MusicCategories> musicCategory;

    private String musicUrl;


    public Music()
    {

    }
    public Music(Long id, String musicName, String singlerName,List<MusicCategories> musicCategory, String musicUrl) {
        this.id = id;
        this.musicName = musicName;
        this.singlerName = singlerName;
        this.musicCategory = musicCategory;
        this.musicUrl = musicUrl;
    }
    public Music(String musicName, String singlerName,List<MusicCategories> musicCategory, String musicUrl) {
        this.musicName = musicName;
        this.singlerName = singlerName;
        this.musicCategory = musicCategory;
        this.musicUrl = musicUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getSinglerName() {
        return singlerName;
    }

    public void setSinglerName(String singlerName) {
        this.singlerName = singlerName;
    }

    public List<MusicCategories> getMusicCategory() {
        return musicCategory;
    }

    public void setMusicCategory(List<MusicCategories> musicCategory) {
        this.musicCategory = musicCategory;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }
}
