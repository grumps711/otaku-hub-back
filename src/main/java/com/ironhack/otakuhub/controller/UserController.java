package com.ironhack.otakuhub.controller;

import com.ironhack.otakuhub.dto.UserDTO;
import com.ironhack.otakuhub.enums.Level;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

/**
* Listar todos los usuarios de la base de datos
*/
    @GetMapping
    public List<User> getAllUsers () {
        return userService.findAll();
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User createUser (@RequestBody UserDTO userDTO) {
        return userService.createUser (userDTO);
    }

    /**
    Borrar usuario: accesible por usuario y admin
     */
    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser (@PathVariable ("username") String username) {
        userService.deleteUser(username);
    }

    /**
    updateUSerByAdmin puede modificar todos los campos del objeto usuario
    Este método solo es accesible por el administrador
     */
    @PutMapping("admin/udpateUser/{username}")
    public User updateUserByAdmin (@PathVariable String username,
                                    @RequestParam Optional <String> password,
                                    @RequestParam Optional <String> roles,
                                    @RequestParam Optional <Boolean> isAccountNonLocked,
                                    @RequestParam Optional <Integer> points,
                                    @RequestParam Optional <Level> level,
                                    @RequestParam Optional <Anime> anime,
                                    @RequestParam Optional <Quote> animeQuote){
        return userService.updateUserByAdmin (username, password, roles, isAccountNonLocked, points, level, anime, animeQuote);
    }

    /**
    updateUserByUser: solo actualiza el username y el password
    endpoint accesible por el usuario
     */

    @PutMapping("user/udpateUser/{id}")
    public User updateUserByUser (@PathVariable Long id,
                                   @RequestParam Optional<String> username,
                                   @RequestParam Optional <String> password,
                                   @RequestParam Optional <Anime> anime
                                   ){
        return userService.updateUserByUser (id, username,password,anime);
    }

    @PatchMapping("/{username}")
    public User addPoints (@PathVariable String username,
                           @RequestParam int points){
        return userService.addPoints(username);
    }

    /**
    comprobación si el usuario está en la base de datos: a partir del username
     */
    @GetMapping ("checkuser/{username}")
    public Boolean userExist (String username) {
        return userService.userExist (username);
    }








}