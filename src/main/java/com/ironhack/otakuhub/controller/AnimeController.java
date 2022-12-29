package com.ironhack.otakuhub.controller;

import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.proxy.AnimeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/anime")
public class AnimeController {

    @GetMapping
    public List<Anime> getAnimeByTitle(){
        return null;
    }


}
