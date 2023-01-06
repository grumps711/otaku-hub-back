package com.ironhack.otakuhub;

import com.ironhack.otakuhub.proxy.AnimeProxy;
import com.ironhack.otakuhub.proxy.QuoteProxy;
import com.ironhack.otakuhub.proxy.TraceMoeProxy;
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
    private final TraceMoeProxy traceMoeProxy;
    private final AnimeProxy animeProxy;

    public static void main(String[] args) {
        SpringApplication.run(OtakuHubApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println((animeProxy.getAnimesByTitle("naruto")));
//        System.out.println((quoteProxy.getRandomQuote()));
//        System.out.println((animeProxy.getAnimeDetails("naruto")));
//        System.out.println((animeProxy.getPopularAnimes(2)));
//        System.out.println((animeProxy.getAnimesByGenre("sports")));
//        System.out.println(animeProxy.getEpisodeStreamingUrl("one-piece-episode-1"));
        System.out.println(traceMoeProxy.getAnimesByScene("","https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg"));
    }
}
