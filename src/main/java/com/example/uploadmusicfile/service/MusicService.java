package com.example.uploadmusicfile.service;

import com.example.uploadmusicfile.model.Music;
import com.example.uploadmusicfile.model.MusicCategories;

import java.util.List;

public interface MusicService {

    List<Music> findAllMusic();


    List<MusicCategories> findAllMusicCategories();


    List<MusicCategories> findMusicByMusicCategoriesName(List<String> musicCategoriesName);

    Music findMusicById(Long id);

    void addMusic(Music music);

    void updateMusic(Music music);

    void removeMusic(Music music);


}
