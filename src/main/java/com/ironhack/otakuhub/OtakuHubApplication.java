package com.ironhack.otakuhub;

import com.ironhack.otakuhub.proxy.AnimeProxy;
import com.ironhack.otakuhub.proxy.QuoteProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@RequiredArgsConstructor
public class OtakuHubApplication implements CommandLineRunner {
    private final QuoteProxy quoteProxy;
    private final AnimeProxy animeProxy;

    public static void main(String[] args) {
        SpringApplication.run(OtakuHubApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println((animeProxy.getAnimesByTitle("naruto")));
        System.out.println((quoteProxy.getRandomQuote()));
        System.out.println((animeProxy.getAnimeDetails("naruto")));
        System.out.println((animeProxy.getPopularAnimes(2)));
        System.out.println((animeProxy.getAnimesByGenre("sports")));

    }
}
