package com.example.uploadmusicfile.controller;

import com.example.uploadmusicfile.model.Music;
import com.example.uploadmusicfile.model.MusicCategories;
import com.example.uploadmusicfile.model.MusicForm;
import com.example.uploadmusicfile.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/music")
public class MusicController
{

    @Autowired
    private Environment environment;
    @Autowired
     private MusicService musicService;
     @GetMapping("/")
     public String home(Model model)
     {
         model.addAttribute("musics", musicService.findAllMusic());
         return "/index";
     }
     @GetMapping("/show/{id}")
     public ModelAndView musicShow(@PathVariable("id") Music music)
     {
         MusicForm musicForm = new MusicForm(music.getId(),music.getMusicName(), music.getSinglerName(), music.getMusicCategory());
         ModelAndView modelAndView = new ModelAndView();
         modelAndView.addObject("musicForm", musicForm);
         modelAndView.addObject("musicCategories", musicService.findAllMusicCategories());
         modelAndView.addObject("status",1);
         modelAndView.setViewName("/edit");
         return modelAndView;
     }

    @GetMapping("/addMusic")
    public ModelAndView addMusic()
    {
        ModelAndView model = new ModelAndView();
        model.addObject("musicForm", new MusicForm());
        model.addObject("musicCategories", musicService.findAllMusicCategories());
        model.addObject("status",0);
        model.setViewName("/edit");
        return model;
    }
    @PostMapping("/updateMusic")
    public String updateMusic(@ModelAttribute("musicForm") MusicForm musicForm, HttpServletRequest request,@RequestParam("musicCategoriesName") String[] musicCategories)
    {
        MultipartFile multipartMusicFile = musicForm.getMusicMultipart();
        Music music = musicService.findMusicById(musicForm.getId());

        if (multipartMusicFile != null)
        {
                String regex = "^[a-zA-Z0-9]+[-\\sa-zA-Z0-9]*(\\.(wav|mp3|mp4))$";
                List<String> musicCategoriesName = Arrays.stream(musicCategories).collect(Collectors.toList());
                String pathFile = "/musicFile/"+ multipartMusicFile.getOriginalFilename();
                List<MusicCategories> musicCategoriesOfMusic= musicService.findMusicByMusicCategoriesName(musicCategoriesName);
                if (music == null)
                {
                    if (!multipartMusicFile.getOriginalFilename().equals(""))
                    {
                        if (!multipartMusicFile.getOriginalFilename().matches(regex))
                        {
                            request.setAttribute("message", "File không hợp lệ !");
                            request.setAttribute("musicForm",musicForm);
                            request.setAttribute("musicCategories", musicService.findAllMusicCategories());
                            request.setAttribute("status", 0);
                            return "/edit";
                        }
                    }
                    music = new Music(musicForm.getMusicName(),musicForm.getSinglerName(),musicCategoriesOfMusic, pathFile);
                    musicService.addMusic(music);
                }
                else
                {
                    if (!multipartMusicFile.getOriginalFilename().equals(""))
                    {
                        if (!multipartMusicFile.getOriginalFilename().matches(regex))
                        {
                            request.setAttribute("message", "File không hợp lệ !");
                            request.setAttribute("musicForm",musicForm);
                            request.setAttribute("musicCategories", musicService.findAllMusicCategories());
                            request.setAttribute("status", 0);
                            return "/edit";
                        }
                        music.setMusicUrl(pathFile);
                    }
                    else
                    {
                        music.setMusicUrl(music.getMusicUrl());
                    }
                    music.setSinglerName(musicForm.getSinglerName());
                    music.setMusicName(musicForm.getMusicName());
                    music.setMusicCategory(musicCategoriesOfMusic);
                    musicService.updateMusic(music);
                }
                try
                {
                    FileCopyUtils.copy(multipartMusicFile.getBytes(),new File(environment.getProperty("uploadFileLocation")+multipartMusicFile.getOriginalFilename()));
                }
                catch (IOException e)
                {
                    System.out.println("File Save Error");
                }
                return "redirect:/music/";
        }

        return "/edit";
    }
}
