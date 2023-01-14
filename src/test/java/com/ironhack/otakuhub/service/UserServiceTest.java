package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.dto.UserDTO;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.AnimeSceneImage;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.repository.AnimeRepository;
import com.ironhack.otakuhub.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private AnimeService animeService;

    @AfterEach
    void deleteAnimeSceneImages(){
        userRepository.deleteAll();
    }

    @Test
    void createUser() {
        var userDTO = new UserDTO("pepe", "pepe");
        var newUser = userService.createUser(userDTO);
        var allUsers = userRepository.findAll();
        assertEquals(3, allUsers.size());


    }

    @Test
    void deleteUserByUsername() {
        var user1 = new UserDTO("pepe", "pepe");
        var user2 = new UserDTO ("paco","paco");
        var newUser1 = userService.createUser(user1);
        var newUser2 = userService.createUser(user2);

        var allUsers = userRepository.findAll();
        assertEquals(4, allUsers.size());
        userRepository.deleteUserByUsername("paco");
        var allUsers2 = userRepository.findAll();
        assertEquals(3, allUsers2.size());
    }

   // @Test
   // void updateUserByAdmin() {
   //     var userDTO = new UserDTO("pepe", "pepe");
   //     var newUser = userService.createUser(userDTO);
   //     userRepository.save(newUser);
   //     userService.updateUserByAdmin("pepe",
   //             Optional.of("pepeUpdated"),
   //             Optional.empty(),
   //             Optional.empty(),
   //             Optional.empty(),
   //             Optional.of(10),
   //             Optional.empty(),
   //             Optional.empty(),
   //             Optional.empty());
   //     userRepository.save(newUser);
   //     assertEquals(10,newUser.getPoints());
   //     assertEquals("pepeUpdated",newUser.getUsername());
//
   // }

    @Test
    void updateUserByUser() {
    }

    @Test
    void findAll() {
        var userDTO = new UserDTO("pepe", "pepe");
        var newUser = userService.createUser(userDTO);
        var allUsers = userRepository.findAll();
        assertEquals(3, allUsers.size());
    }

    @Test
    void addPoints() {
        var userDTO = new UserDTO("pepe", "pepe");
        var newUser = userService.createUser(userDTO);
        newUser.addPoints();
        assertEquals(1,newUser.getPoints());
    }

    @Test
    void userExist() {
        var userDTO = new UserDTO("pepe", "pepe");
        var newUser = userService.createUser(userDTO);

        assertEquals(true, userService.userExist("pepe"));
    }

    @Test
    void addAnimeToUser() {
        var userDTO = new UserDTO("pepe", "pepe");
        var newUser = userService.createUser(userDTO);
        var animeList = newUser.getAnimeList();

        var newAnimeDTO = animeService.getAnimeDetails("Naruto");
        var newAnime = Anime.fromAnimeDTO(newAnimeDTO);
        newAnime.setAnimeId(newAnime.getAnimeTitle());
        animeList.add(newAnime);

        assertEquals(newAnime.getAnimeId(),newUser.getAnimeList().get(0).getAnimeId());

    }

    @Test
    void getUser() {
        var newUserDTO = new UserDTO ("pepe","pepe");
        var newUser = userService.createUser(newUserDTO);

        assertEquals("pepe",userService.getUser("pepe").getUsername());
    }
}