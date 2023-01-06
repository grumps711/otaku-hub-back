package com.ironhack.otakuhub.proxy;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.dto.EpisodeUrlDTO;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.EpisodeUrl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@FeignClient(name ="anime", url = "https://gogoanime.consumet.org")
public interface AnimeProxy {

    //url de un anime
    @GetMapping ("/search")
    List<Anime> getAnimesByTitle(@RequestParam String keyw);

    //url de un episodio específico y datos del anime
   @GetMapping("/anime-details/{id}")
   AnimeDTO getAnimeDetails(@PathVariable("id") String id);

    @GetMapping("/popular")
    List<AnimeDTO> getPopularAnimes(@RequestParam (name = "page") int randomPage);

    @GetMapping("/genre/{genre}")
    List<AnimeDTO> getAnimesByGenre(@PathVariable("genre") String genre);

    //episodes url
   // @GetMapping ("/streamsb/watch/")
   //EpisodeStreamUrlDTO getUrlEpisode (@PathVariable ("episodeId") String episodeId);

//
  //  //Ultimos lanzamientos. Filtrado por type 1: japanese with subtitle.
  //  // type 2: english dub with no subtitles. type 3: chinese with english subtitles
  //  @GetMapping("/recent-release/{type}")
  //  List<Anime> getRecentReleases(@PathVariable("type") int type);
//
}
