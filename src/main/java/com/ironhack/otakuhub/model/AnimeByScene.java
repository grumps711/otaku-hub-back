package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnimeByScene {
    @JsonProperty(value = "anilist")
    private AnimeInfo animeInfo;
//    private String episode;
    private Double similarity;
    private String image;
}

