package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Title {
    @JsonProperty(value = "romaji")
    private String romajiTitle;
    @JsonProperty(value = "english")
    private String englishTitle;
}
