package com.example.uploadmusicfile.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class MusicForm {

    private Long id;

    private String musicName;

    private String singlerName;

    private List<MusicCategories> musicCategory;

    private MultipartFile musicMultipart;


    public MusicForm()
    {

    }
    public MusicForm(Long id, String musicName, String singlerName,List<MusicCategories> musicCategory) {
        this.id = id;
        this.musicName = musicName;
        this.singlerName = singlerName;
        this.musicCategory = musicCategory;
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

    public MultipartFile getMusicMultipart() {
        return musicMultipart;
    }

    public void setMusicMultipart(MultipartFile musicMultipart) {
        this.musicMultipart = musicMultipart;
    }
}
