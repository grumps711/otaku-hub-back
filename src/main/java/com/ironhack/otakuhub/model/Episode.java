package com.ironhack.otakuhub.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Episode {
    @Id
    private String episodeId;
    private String episodeNum;
}
