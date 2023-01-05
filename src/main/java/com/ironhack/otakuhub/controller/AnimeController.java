package com.ironhack.otakuhub.controller;

import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.proxy.AnimeProxy;
import com.ironhack.otakuhub.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/anime") //TODO eliminar public una vez que configuremos la security
public class AnimeController {
    private final AnimeService animeService;
    private final AnimeProxy animeProxy;

    @GetMapping ("/search")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Anime> getAnimeByTitle(@RequestParam String keyw){
        return animeService.getAnimeByTitle(keyw);
    }


}
