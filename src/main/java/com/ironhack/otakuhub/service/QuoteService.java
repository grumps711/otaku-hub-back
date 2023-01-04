package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.proxy.QuoteProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuoteService {
    private final QuoteProxy quoteProxy;

    public Quote getRandomQuote() {
        return quoteProxy.getRandomQuote();
    }

    public Quote getRandomQuoteByAnimeTitle(String title) {
        return quoteProxy.getRandomQuoteByAnimeTitle(title);
    }

    public Quote getRandomQuoteByAnimeCharacter(String name) {
        return quoteProxy.getRandomQuoteByAnimeCharacter(name);
    }

    public List<Quote> get10RandomQuotes() {
        return quoteProxy.get10RandomQuotes();
    }

    public List<Quote> get10QuotesByAnimeTitle(String title) {
        return quoteProxy.get10QuotesByAnimeTitle(title);
    }

    public List<Quote> get10QuotesByAnimeCharacter(String name) {
        return quoteProxy.get10QuotesByAnimeCharacter(name);
    }
}
