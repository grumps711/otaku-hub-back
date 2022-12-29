package com.ironhack.otakuhub.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    //TODO registro nuevo user
    // editar user general (solo de él mismo y menos variables rol, nivel, isAccountNonLocked)
    // borrar user (solo admin --> request DELETE, /admin)
    // editar cualquier user todos los campos (solo admin --> request PUT, /admin)}
}