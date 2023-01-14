package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.model.TrivialResponse;
import com.ironhack.otakuhub.proxy.TraceMoeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrivialService {
    private final QuoteService quoteService;
    private final AnimeService animeService;
    private final TraceMoeProxy traceMoeProxy;

/**
 *
 *     Para obtener una pregunta del Trial Quote.
 *     Una pregunta consta de un Quote + 3 posibles respuestas.
 *      1. quoteString: frase de anime que el usuario debe adivinar a que anime corresponde.  Es un campo de la clase Quote
 *      2. correctAnswer: anime al que corresponde quoteString. Se obtiene del objeto de la clase Quote
 *      3. wrongAnswer1: un anime aleatorio que se obtienen de la API "gogoanime.../popular"
 *      4. wrongAnswer2: un anime aleatorio que se obtienen de la API "gogoanime.../popular"
 *      @return list  de String con quoteString, correctAnswer,wrongAnswer1, wrongAnswwer2
 */
    public TrivialResponse getTrivialQuote () {
        //Creo un objeto quote que será la pregunta del trivial
        var quoteObject = quoteService.getRandomQuote();
        var quoteString = quoteObject.getQuote();
        var correctAnswer = quoteObject.getAnime();
        var otherTwoAnswers = getOtherTwoAnswers(correctAnswer);

        return new TrivialResponse (null,quoteString,correctAnswer,otherTwoAnswers.get(0), otherTwoAnswers.get(1));


    }

    public List<String> getOtherTwoAnswers (String correctAnswer) {
        String wrongAnswer1="";
        String wrongAnswer2="";

        //Creo numero random para enviárselo a la API "popular"
        var randomNumber =  (int)((Math.random() * ((504 - 1) + 1)) + 1);

        //Llamo a la API "popular" con page=numero random
        var animeList = animeService.getPopularAnimes(randomNumber);

        //Elijo los dos primero animes de la lista que me devuelve popular y los guardo
        //Me aseguro que no sean el mismo que el de quoteObject
        for (int i = 0; i < animeList.size(); i++) {
            if ((!animeList.get(i).getAnimeId().equals(correctAnswer) && (!animeList.get(i+1).getAnimeId().equals(correctAnswer)))) {
                wrongAnswer1 = animeList.get(i).getAnimeTitle();
                wrongAnswer2 = animeList.get(i+1).getAnimeTitle();
                break;
            }

        }
//        for (AnimeDTO anime:animeList) {
//            if ((!anime.getAnimeId().equals(trivialQuote.get(1)))) {
//                wrongAnswer1 = anime.getAnimeId();
//                break;
//            }
//        }
//        for (AnimeDTO anime:animeList) {
//            if ((!anime.getAnimeId().equals(trivialQuote.get(1))) && (!anime.getAnimeId().equals(wrongAnswer1))) {
//                wrongAnswer2 = anime.getAnimeId();
//                break;
//            }
//        }

        return List.of(wrongAnswer1,wrongAnswer2);


    }

    public TrivialResponse getTrivialSceneImage(String apikey) {
        var imageScene = animeService.getRandomAnimeSceneImage().getUrl();
        var correctAnswer = traceMoeProxy.getAnimesByScene(apikey, imageScene).getPossibleAnimes().get(0).getAnimeInfo().getTitle().getRomajiTitle();
        var otherTwoAnswers = getOtherTwoAnswers(correctAnswer);

        return new TrivialResponse(imageScene,null,correctAnswer, otherTwoAnswers.get(0), otherTwoAnswers.get(1));
    }
}
