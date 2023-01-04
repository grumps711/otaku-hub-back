package com.ironhack.otakuhub.dto;

import com.ironhack.otakuhub.config.StringListConverter;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.Episode;
import com.ironhack.otakuhub.model.User;
import jakarta.persistence.Convert;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimeDTO {

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

    private List<Episode> episodesList;

    private User users;


    public static AnimeDTO fromAnime(Anime anime){
        var AnimeDTO = new AnimeDTO();
        AnimeDTO.setAnimeId(anime.getAnimeId());
        AnimeDTO.setAnimeTitle(anime.getAnimeTitle());
        AnimeDTO.setAnimeImg(anime.getAnimeImg());
        AnimeDTO.setStatus(anime.getStatus());
        AnimeDTO.setType(anime.getType());
        AnimeDTO.setReleasedDate(anime.getReleasedDate());
        AnimeDTO.setGenres(anime.getGenres());
        AnimeDTO.setSynopsis(anime.getSynopsis());
        AnimeDTO.setTotalEpisodes(anime.getTotalEpisodes());
        AnimeDTO.setEpisodesList(anime.getEpisodesList());
        AnimeDTO.setUsers(anime.getUsers());
        return AnimeDTO;
    }
}