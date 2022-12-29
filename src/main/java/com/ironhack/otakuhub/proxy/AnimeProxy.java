package com.ironhack.otakuhub.proxy;

import com.ironhack.otakuhub.model.Anime;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name ="AnimeProxy", url = "https://gogoanime.consumet.org")
@Component
public interface AnimeProxy {

    @GetMapping("/anime-details/{anime-id}")
    @RequestMapping(method = RequestMethod.GET)
    List<Anime> getAnimeByName(@RequestParam(name = "filter[text]") String animeTitle);

    @RequestMapping(method = RequestMethod.GET)
    List<Anime> getAnimeByGenre(@RequestParam(name = "filter[category]") String genre);

    @RequestMapping(method = RequestMethod.GET)
    Anime getAnimeById(@RequestParam(name = "filter[id]") Long id);


}
