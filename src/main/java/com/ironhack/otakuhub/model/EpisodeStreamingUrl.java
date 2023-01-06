package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EpisodeStreamingUrl {
    @JsonProperty(value = "Referer")
    private String streamingUrl;
}
