package com.ironhack.otakuhub.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrivialResponse {
    private String image; //url
    private String quote;

    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;
}
