package com.ironhack.otakuhub.proxy;

import com.ironhack.otakuhub.model.Anime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name ="AnimeProxy", url = "https://gogoanime.consumet.org")
@Component
public interface AnimeProxy {


    //url de un anime
    @GetMapping("/search")
    List<Anime> getAnimeUrl(@RequestParam String keyw);

    //url de un episodio específico y datos del anime
    @GetMapping("/anime-details")
    List<Anime> getAnimeDetails(@RequestParam String animeTitle);

    //Ultimos lanzamientos. Filtrado por type 1: japanese with subtitle.
    // type 2: english dub with no subtitles. type 3: chinese with english subtitles
    @GetMapping("/recent-release/{type}")
    List<Anime> getRecentReleases(@PathVariable("type") int type);

    //Lista de episodios por género
    @GetMapping("/genre/{genre}")
    List<Anime> getAnimeByGenre(@PathVariable("genre") String genre);

}
