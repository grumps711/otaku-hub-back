package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.dto.EpisodeUrlDTO;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.EpisodeStreamingUrl;
import com.ironhack.otakuhub.model.Quote;
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

    public EpisodeStreamingUrl getEpisodeStreamingUrl(String episodeId) {
        return animeProxy.getEpisodeStreamingUrl(episodeId);
    }

    public List <String> getTrivialQuoute () {
        String wrongAnswer1="";
        String wrongAnswer2="";

        //Creo un objeto quote que será la pregunta del trivial
        var quoteObject = new Quote();
        var quote = quoteObject.getQuote();
        var correctAnswer = quoteObject.getAnime();

        //Creo numero random para enviarselo a la API "popular"
        var randomNumber =  (int)((Math.random() * ((504 - 1) + 1)) + 1);

        //Llamo a la API "popular" con page=numero random
        var animeList = getPopularAnimes(randomNumber);

        //Elijo los dos primero animes de la lista que me devuelve popular y los guardo
        for (AnimeDTO anime:animeList) {
            if ((!anime.getAnimeId().equals(correctAnswer))) {
                wrongAnswer1 = anime.getAnimeId();
                break;
            }
        }
        for (AnimeDTO anime:animeList) {
            if ((!anime.getAnimeId().equals(correctAnswer)) && (!anime.getAnimeId().equals(wrongAnswer1))) {
                wrongAnswer2 = anime.getAnimeId();
                break;
            }
        }

        return List.of( quote,
                        quoteObject.getCharac(),
                        correctAnswer,
                        wrongAnswer1,
                        wrongAnswer2
                        );
    }

}
