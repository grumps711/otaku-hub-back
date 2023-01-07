package com.ironhack.otakuhub.model;

import com.ironhack.otakuhub.config.StringListConverter;
import com.ironhack.otakuhub.dto.AnimeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anime {
    @Id
    private String animeId;
    private String animeTitle;
    private String animeImg;
    private String status;

    private String type;
    private String releasedDate;
    @Convert(converter = StringListConverter.class)
    private List<String> genres;
    private String synopsis;
    private Integer totalEpisodes;
    @OneToMany
    private List<Episode> episodesList;
    @ManyToOne
    private User users;


    public static Anime fromAnimeDTO(AnimeDTO animeDTO){
        var Anime = new Anime();
        Anime.setAnimeId(animeDTO.getAnimeId());
        Anime.setAnimeTitle(animeDTO.getAnimeTitle());
        Anime.setAnimeImg(animeDTO.getAnimeImg());
        Anime.setStatus(animeDTO.getStatus());
        Anime.setType(animeDTO.getType());
        Anime.setReleasedDate(animeDTO.getReleasedDate());
        Anime.setGenres(animeDTO.getGenres());
        Anime.setSynopsis(animeDTO.getSynopsis());
        Anime.setTotalEpisodes(animeDTO.getTotalEpisodes());
        Anime.setEpisodesList(animeDTO.getEpisodesList());
        Anime.setUsers(animeDTO.getUsers());
        return Anime;
    }

}