package com.ironhack.otakuhub.controller;

import com.ironhack.otakuhub.service.TrivialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trivial")
@RequiredArgsConstructor
public class TrivialController {
    private final TrivialService trivialService;

    @GetMapping("/quote")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getTrivialQuoute () {
        return trivialService.getTrivialQuote ();
    }

    @GetMapping("/sceneImage")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<String> getTrivialSceneImage () {
        return trivialService.getTrivialSceneImage ();
    }

}
