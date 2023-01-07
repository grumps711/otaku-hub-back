package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AnimeInfo {
    @JsonProperty(value = "id")
    private Long anilistId;
    @JsonProperty(value = "title")
    private Title title;
}
