package com.example.uploadmusicfile.service.MusicImpl;

import com.example.uploadmusicfile.model.Music;
import com.example.uploadmusicfile.model.MusicCategories;
import com.example.uploadmusicfile.service.MusicService;

import java.util.ArrayList;
import java.util.List;

public class MusicServiceImpl implements MusicService
{

    private static final List<Music> musicList;


    private static final List<MusicCategories> musicCategoriesList;


    static
    {
        musicList = new ArrayList<>();
        musicCategoriesList = new ArrayList<>();
        musicCategoriesList.add(new MusicCategories(1L,"Nhạc trẻ"));
        musicCategoriesList.add(new MusicCategories(2L,"Nhạc cách mạng"));
        musicCategoriesList.add(new MusicCategories(3L,"Nhạc đỏ"));
        musicCategoriesList.add(new MusicCategories(4L,"Nhạc xanh"));
    }
    @Override
    public List<Music> findAllMusic()
    {
        return musicList;
    }

    @Override
    public List<MusicCategories> findAllMusicCategories() {
        return musicCategoriesList;
    }

    @Override
    public List<MusicCategories> findMusicByMusicCategoriesName(List<String> musicCategoriesName)
    {
        List<MusicCategories> result = new ArrayList<>();

        for (MusicCategories musicCategories : musicCategoriesList)
        {
           for (String value : musicCategoriesName)
           {
               if (musicCategories.getMusicCategoriesName().equals(value))
               {
                   result.add(musicCategories);
                   break;
               }
           }
        }
        return result;
    }

    @Override
    public Music findMusicById(Long id)
    {
        for (Music music : musicList)
        {
            if (music.getId().equals(id))
            {
                return music;
            }

        }
        return null;
    }

    @Override
    public void addMusic(Music music)
    {
        music.setId((long)musicList.size()+1);
        musicList.add(music);
    }

    @Override
    public void updateMusic(Music music)
    {
        musicList.set(musicList.indexOf(music), music);
    }

    @Override
    public void removeMusic(Music music) {
            musicList.remove(music);
    }
}
