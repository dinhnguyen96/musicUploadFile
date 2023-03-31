package com.example.uploadmusicfile.model;

public class MusicCategories {

    private Long id;

    private String musicCategoriesName;


    public MusicCategories(Long id, String musicCategoriesName) {
        this.id = id;
        this.musicCategoriesName = musicCategoriesName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMusicCategoriesName() {
        return musicCategoriesName;
    }

    public void setMusicCategoriesName(String musicCategoriesName) {
        this.musicCategoriesName = musicCategoriesName;
    }
}
