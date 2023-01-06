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
    private final QuoteService quoteService;

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

    //Para obtener una pregunta del Trial Quote.
    //Una pregunta consta de un Quote + 3 posibles respuestas.
    // 1. quoteString: frase de anime que el usuario debe adivinar a que anime corresponde.  Es un campo de la clase Quote
    // 2. correctAnswer: anime al que corresponde quoteString. Se obtiene del objeto de la clase Quote
    // 3. wrongAnswer1: un anime aleatorio que se obtienen de la API "gogoanime.../popular"
    // 4. wrongAnswer2: un anime aleatorio que se obtienen de la API "gogoanime.../popular"
    // @return list  de String con quoteString, correctAnswer,wrongAnswer1, wrongAnswwer2
    public List <String> getTrivialQuoute () {
        String wrongAnswer1="";
        String wrongAnswer2="";

        //Creo un objeto quote que será la pregunta del trivial
        var quoteObject = quoteService.getRandomQuote();
        var quoteString = quoteObject.getQuote();
        var correctAnswer = quoteObject.getAnime();

        //Creo numero random para enviárselo a la API "popular"
        var randomNumber =  (int)((Math.random() * ((504 - 1) + 1)) + 1);

        //Llamo a la API "popular" con page=numero random
        var animeList = getPopularAnimes(randomNumber);

        //Elijo los dos primero animes de la lista que me devuelve popular y los guardo
        //Me aseguro que no sean el mismo que el de quoteObject

        //Obtengo el primer anime
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

        return List.of( quoteString,
                        correctAnswer,
                        wrongAnswer1,
                        wrongAnswer2
                        );
    }

}
