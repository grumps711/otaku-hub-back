package com.ironhack.otakuhub.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class QuoteServiceTest {
    @Autowired
    private QuoteService quoteService;

    @Test
    void getRandomQuote() {
        var response = quoteService.getRandomQuote();
        assertTrue(response != null);
    }

    @Test
    void getRandomQuoteByAnimeTitle() {
        var response = quoteService.getRandomQuoteByAnimeTitle("one piece");
        assertTrue(response != null);
    }

    @Test
    void getRandomQuoteByAnimeCharacter() {
        var response = quoteService.getRandomQuoteByAnimeCharacter("luffy");
        assertTrue(response != null);
    }
}