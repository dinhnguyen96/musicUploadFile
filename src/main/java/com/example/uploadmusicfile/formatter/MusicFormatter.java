package com.example.uploadmusicfile.formatter;

import com.example.uploadmusicfile.model.Music;
import com.example.uploadmusicfile.service.MusicService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class MusicFormatter implements Formatter<Music>
{
    private MusicService musicService;


    public MusicFormatter(MusicService musicService)
    {
        this.musicService = musicService;
    }

    @Override
    public Music parse(String text, Locale locale) throws ParseException
    {
        return musicService.findMusicById(Long.parseLong(text));
    }

    @Override
    public String print(Music object, Locale locale) {
        return null;
    }
}
