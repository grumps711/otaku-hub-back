package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AnimesByScene {
    @JsonProperty(value = "result")
    private List<AnimeByScene> possibleAnimes;
}
