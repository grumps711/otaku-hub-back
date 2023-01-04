package com.ironhack.otakuhub.proxy;

import com.ironhack.otakuhub.model.Quote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name ="QuoteProxy", url = "https://animechan.vercel.app/api")
@Component
public interface QuoteProxy {

    @GetMapping("/random")
    Quote getRandomQuote();

    @GetMapping("/random/anime")
    Quote getRandomQuoteByAnimeTitle(@RequestParam(name = "title") String title);

    @GetMapping("/random/character")
    Quote getRandomQuoteByAnimeCharacter(@RequestParam(name = "name") String name);

    @GetMapping("/quotes")
    List<Quote> get10RandomQuotes();

    @GetMapping("/quotes/anime")
    List<Quote> get10QuotesByAnimeTitle(@RequestParam(name = "title") String title);

    @GetMapping("/quotes/character")
    List<Quote> get10QuotesByAnimeCharacter(@RequestParam(name = "name") String name);
}
