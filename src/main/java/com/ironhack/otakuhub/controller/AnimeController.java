package com.ironhack.otakuhub.controller;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.dto.EpisodeUrlDTO;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.EpisodeStreamingUrl;
import com.ironhack.otakuhub.proxy.AnimeProxy;
import com.ironhack.otakuhub.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/anime") //TODO eliminar public una vez que configuremos la security
public class AnimeController {
    private final AnimeService animeService;
    private final AnimeProxy animeProxy;

    @GetMapping ("/search")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Anime> getAnimesByTitle(@RequestParam String keyw){
        return animeService.getAnimesByTitle(keyw);
    }

    @GetMapping ("/anime-details")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnimeDTO getAnimeDetails (@RequestParam String id) {
        return animeService.getAnimeDetails (id);
    }

    @GetMapping ("/popular")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AnimeDTO> getPopularAnimes (@RequestParam int page) {
        return animeService.getPopularAnimes (page);
    }

    @GetMapping ("/genre")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<AnimeDTO> getAnimesByGenre (@RequestParam String genre) {
        return animeService.getAnimesByGenre(genre);
    }

   @GetMapping ("/watch")
   @ResponseStatus(HttpStatus.ACCEPTED)
   public EpisodeStreamingUrl getEpisodeStreamingUrl (@RequestParam String episodeId) {
        return animeService.getEpisodeStreamingUrl (episodeId);
   }





    private String getRandomPage(){
        return Integer.toString(new Random().nextInt(500-1) + 1);
    }


}
