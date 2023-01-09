package com.ironhack.otakuhub.controller;

import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.proxy.QuoteProxy;
import com.ironhack.otakuhub.service.AnimeService;
import com.ironhack.otakuhub.service.QuoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/quote")
public class QuoteController {

    private final QuoteService quoteService;

    @GetMapping("/random")
    Quote getRandomQuote(){
        return quoteService.getRandomQuote();
    }

    @GetMapping("/random/anime")
    Quote getRandomQuoteByAnimeTitle(@RequestParam(name = "title") String title){
        return quoteService.getRandomQuoteByAnimeTitle(title);
    }

    @GetMapping("/random/character")
    Quote getRandomQuoteByAnimeCharacter(@RequestParam(name = "name") String name){
        return quoteService.getRandomQuoteByAnimeCharacter(name);
    }

    @GetMapping("/quotes")
    List<Quote> get10RandomQuotes(){
        return quoteService.get10RandomQuotes();
    }

    @GetMapping("/quotes/anime")
    List<Quote> get10QuotesByAnimeTitle(@RequestParam(name = "title") String title){
        return quoteService.get10QuotesByAnimeTitle(title);
    }

    @GetMapping("/quotes/character")
    List<Quote> get10QuotesByAnimeCharacter(@RequestParam(name = "name") String name){
        return quoteService.get10QuotesByAnimeCharacter(name);
    }


}
