package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.exception.UserNotFoundException;
import com.ironhack.otakuhub.exception.UsernameNotFoundException;
import com.ironhack.otakuhub.model.*;
import com.ironhack.otakuhub.proxy.AnimeProxy;
import com.ironhack.otakuhub.proxy.TraceMoeProxy;
import com.ironhack.otakuhub.repository.AnimeSceneImageRepository;
import com.ironhack.otakuhub.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeSceneImageRepository animeSceneImageRepository;
    private final AnimeProxy animeProxy;
    private final TraceMoeProxy traceMoeProxy;

    private final UserRepository userRepository;

    public List<Anime> getAnimesByTitle(String keyw) {
        return animeProxy.getAnimesByTitle(keyw);
    }

    public AnimeDTO getAnimeDetails(String animeId) {
        return animeProxy.getAnimeDetails(animeId);
    }

    public List<AnimeDTO> getPopularAnimes (int randomPage) {
        return animeProxy.getPopularAnimes(randomPage);
    }

    public List<AnimeDTO> getAnimesByGenre(String genre) {
        return animeProxy.getAnimesByGenre(genre);
    }

    public EpisodeStreamingUrl getEpisodeStreamingUrl(String episodeId) {
        return animeProxy.getEpisodeStreamingUrl(episodeId);
    }

    public AnimesByScene getAnimesByScene(String url) {
        return traceMoeProxy.getAnimesByScene(url);
    }

    public AnimeSceneImage getRandomAnimeSceneImage() {
        var allAnimeSceneImages = animeSceneImageRepository.findAll();
        return allAnimeSceneImages.get(new Random().nextInt(allAnimeSceneImages.size()));
    }
}
