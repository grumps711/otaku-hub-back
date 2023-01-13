package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.model.AnimeSceneImage;
import com.ironhack.otakuhub.repository.AnimeSceneImageRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TrivialServiceTest {
    @Autowired
    private TrivialService trivialService;
    @Autowired
    private AnimeSceneImageRepository animeSceneImageRepository;


    @BeforeEach
    void loadAnimeSceneImages(){
        var animeSceneImages = new ArrayList<AnimeSceneImage>(List.of(
                //               ONEPIECE urls
                new AnimeSceneImage("https://i.ytimg.com/vi/ijxqbG4_IDs/maxresdefault.jpg"),
                new AnimeSceneImage("https://qph.cf2.quoracdn.net/main-qimg-9fa6865e15516fe240dfb758b49769ed-lq"),
                new AnimeSceneImage("https://imgix.ranker.com/list_img_v2/14221/3194221/original/3194221"),
                new AnimeSceneImage("https://qph.cf2.quoracdn.net/main-qimg-973980ee97b3b79842d0b0edd0318fdf-lq"),
                new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1aJMbNkR_aXBpMIdn_1QrRSraaHbi6PPi3g&usqp=CAU"),
                new AnimeSceneImage("https://myanimefacts.com/wp-content/uploads/2022/09/one-piece-make-you-cry.jpg"),
                new AnimeSceneImage("https://mangathrill.com/wp-content/uploads/2019/09/weweweewew1280x720.png"),
                new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThzYKqtaMbHJJAukQvVdjCJRTuuC5472mnS7PKDG0ykgpeAEXJHbqrMiuC3gvSsT2Om_w&usqp=CAU"),
                new AnimeSceneImage("https://3.bp.blogspot.com/-P20fr6yvg5s/Wu6AgGwY5BI/AAAAAAAAciE/6G0vPmbMDeUybiO6kdAGmolTXSIhOl_zwCLcBGAs/s1600/1295cd2f399a2dae1dcf083261d5d6eae4287ed3_hq.jpg"),
                new AnimeSceneImage("https://static2.srcdn.com/wordpress/wp-content/uploads/2016/08/Brook-from-One-Piece.jpg"),
                new AnimeSceneImage("https://cdn.myanimelist.net/s/common/uploaded_files/1445961164-5bbabbfe592ddae176ae5417b5662a6a.png"),
                new AnimeSceneImage("https://qph.cf2.quoracdn.net/main-qimg-ab9dd5ca38bd7cfaa39eece4e4c0118a-lq")));
        animeSceneImageRepository.saveAll(animeSceneImages);
    }

    @AfterEach
    void deleteAnimeSceneImages(){
        animeSceneImageRepository.deleteAll();
    }


    @Test
    void getTrivialQuote() {
        var response = trivialService.getTrivialQuote();
        assertTrue(response != null);
    }

    @Test
    void getOtherTwoAnswers() {
        var response = trivialService.getOtherTwoAnswers("correctAnswer");
        assertTrue(response != null && !response.isEmpty());
    }

    @Test
    void getTrivialSceneImage() {
        var response = trivialService.getTrivialSceneImage();
        assertTrue(response != null);
    }
}