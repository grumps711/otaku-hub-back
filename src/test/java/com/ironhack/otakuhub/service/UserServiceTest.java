package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.UserDTO;
import com.ironhack.otakuhub.model.AnimeSceneImage;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

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

    }

    @Test
    void updateUserByAdmin() {
    }

    @Test
    void updateUserByUser() {
    }

    @Test
    void findAll() {
    }

    @Test
    void addPoints() {
    }

    @Test
    void userExist() {
    }

    @Test
    void addAnimeToUser() {
    }

    @Test
    void getUser() {
    }
}