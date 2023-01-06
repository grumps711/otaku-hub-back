package com.ironhack.otakuhub.repository;

import com.ironhack.otakuhub.model.AnimeSceneImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeSceneImageRepository extends JpaRepository<AnimeSceneImage, Long> {
}
