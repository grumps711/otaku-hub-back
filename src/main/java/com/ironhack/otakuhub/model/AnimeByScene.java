package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnimeByScene {
    @JsonProperty(value = "id")
    private Long anilistId;
    @JsonProperty(value = "romaji")
    private String romajiTitle;
    @JsonProperty(value = "english")
    private String englishTitle;
    private Long episode;
    private Double similarity;
    private String image;
}
