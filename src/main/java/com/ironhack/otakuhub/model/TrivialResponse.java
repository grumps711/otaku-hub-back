package com.ironhack.otakuhub.model;

import lombok.Data;

@Data
public class TrivialResponse {

    private String image; //url
    private String quote;

    private String correctAnswer;
    private String wrongAnswer1;
    private String wrongAnswer2;

}
