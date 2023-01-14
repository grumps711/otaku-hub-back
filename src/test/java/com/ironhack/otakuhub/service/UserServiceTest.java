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
    void getUser() {
        var newUserDTO = new UserDTO ("pepe","pepe");
        var newUser = userService.createUser(newUserDTO);

        assertEquals("pepe",userService.getUser("pepe").getUsername());
    }
}