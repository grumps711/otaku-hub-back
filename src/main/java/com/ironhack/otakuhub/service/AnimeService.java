package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.proxy.AnimeProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private final AnimeProxy animeProxy;
    public List<Anime> getAnimeByTitle(String keyw) {
        return animeProxy.getAnimeUrl(keyw);
    }
}
