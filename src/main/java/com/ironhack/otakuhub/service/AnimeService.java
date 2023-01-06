package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.dto.EpisodeUrlDTO;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.proxy.AnimeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeProxy animeProxy;
    public List<Anime> getAnimesByTitle(String keyw) {
        return animeProxy.getAnimesByTitle(keyw);
    }

    public AnimeDTO getAnimeDetails(String id) {
        return animeProxy.getAnimeDetails(id);
    }

    public List<AnimeDTO> getPopularAnimes (int randomPage) {
        return animeProxy.getPopularAnimes(randomPage);
    }

    public List<AnimeDTO> getAnimesByGenre(String genre) {
        return animeProxy.getAnimesByGenre(genre);
    }

   // public EpisodeUrlDTO getUrlEpisode(String episodeId) {
   //     return animeProxy.getUrlEpisode(episodeId);
   // }
}
