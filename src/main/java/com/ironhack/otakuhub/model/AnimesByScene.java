package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AnimesByScene {
    @JsonProperty(value = "result")
    private List<AnimeByScene> possibleAnimes;
}






//{
//        "anilist": {
//        "id": 21034,
//        "idMal": 29787,
//        "title": {
//        "native": "ご注文はうさぎですか？？",
//        "romaji": "Gochuumon wa Usagi desu ka??",
//        "english": "Is the Order a Rabbit?? Season 2"
//        },
//        "synonyms": [
//        "Gochiusa"
//        ],
//        "isAdult": false
//        },
//        "filename": "[Leopard-Raws] Gochuumon wa Usagi Desu ka 2nd - 01 RAW (KBS 1280x720 x264 AAC).mp4",
//        "episode": 1,
//        "from": 288.58,
//        "to": 292.67,
//        "similarity": 0.99,
//        "video": "https://media.trace.moe/video/21034/%5BLeopard-Raws%5D%20Gochuumon%20wa%20Usagi%20Desu%20ka%202nd%20-%2001%20RAW%20(KBS%201280x720%20x264%20AAC).mp4?t=290.625&now=1673114400&token=wm7sBYdOm1xbaqJPAiW8IuMcHM",
//        "image": "https://media.trace.moe/image/21034/%5BLeopard-Raws%5D%20Gochuumon%20wa%20Usagi%20Desu%20ka%202nd%20-%2001%20RAW%20(KBS%201280x720%20x264%20AAC).mp4.jpg?t=290.625&now=1673114400&token=JU0Zj09xfiGzHfWcuD79QdWrsPo"
//        },

