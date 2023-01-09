package com.ironhack.otakuhub.demo;

import com.ironhack.otakuhub.model.AnimeSceneImage;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.repository.AnimeSceneImageRepository;
import com.ironhack.otakuhub.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log
@Profile("demo")
public class DataLoader {
    private final AnimeSceneImageRepository animeSceneImageRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void storeUser(){
       try {
            log.info("Starting demo user loading...");
            User user1 = new User("user", passwordEncoder.encode("user"), "ROLE_USER");
            userRepository.save(user1);
            log.info("User " + user1.getUsername() + " was created successfully");

            User user2 = new User("admin", passwordEncoder.encode("admin"), "ROLE_USER, ROLE_ADMIN");
            userRepository.save(user2);
            log.info("User " + user2.getUsername() + " was created successfully");
            log.info("Finished demo user loading.");
        } catch (Exception e){
           System.out.println("Users exist already in the database");
           System.out.println(e.getMessage());
           System.out.println(e.getCause());

       }
    }
    @EventListener(ApplicationReadyEvent.class)
    public void loadAnimeSceneImages(){
        try{
            var animeSceneImages = new ArrayList<AnimeSceneImage>(List.of(
//                ONEPIECE urls
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
                    new AnimeSceneImage("https://qph.cf2.quoracdn.net/main-qimg-ab9dd5ca38bd7cfaa39eece4e4c0118a-lq"),
                    new AnimeSceneImage("https://pbs.twimg.com/media/C03gpV-WQAAqxXf.jpg"),

                //boku no hero
                    new AnimeSceneImage("http://www.heypoorplayer.com/wp-content/uploads/2016/05/MyHeroAcademia8.jpg"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/UQeVkEJ19a4/maxresdefault.jpg"),
                    new AnimeSceneImage("https://static.wikia.nocookie.net/bokunoheroacademia/images/1/1f/Episode_90.png/revision/latest?cb=20210403040340"),
                    new AnimeSceneImage("https://i0.wp.com/100wordanime.blog/wp-content/uploads/2017/09/hero34.jpg?resize=648%2C363&ssl=1"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/oZJ-DTduQsA/maxresdefault.jpg"),

                //haikyuu
                    new AnimeSceneImage("https://static.wikia.nocookie.net/haikyuu/images/1/14/BokutoKuroo1.png/revision/latest?cb=20151126062054"),
                    new AnimeSceneImage("https://static.wikia.nocookie.net/haikyuu/images/c/ca/Hinata_VS_Kageyama.PNG/revision/latest/scale-to-width-down/1200?cb=20140407073702"),
                    new AnimeSceneImage("http://4.bp.blogspot.com/-oK8HepDmGVg/U3bQ50ocYiI/AAAAAAAAAEA/Thk6zF72A8E/s1600/vlcsnap-2014-05-16-22h42m43s186.png"),
                    new AnimeSceneImage("https://static.wikia.nocookie.net/haikyuu/images/1/14/S4E14.png/revision/latest?cb=20200928112808"),
                    new AnimeSceneImage(""),

                //run with the wind
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),

                //kaiji
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),

                //inazuma eleven
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),

                //aku no hana
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),

                //flcl
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage(""),
                    new AnimeSceneImage("")


                    ));
            animeSceneImageRepository.saveAll(animeSceneImages);
        } catch (Exception e){
            System.out.println("Users exist already in the database");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }

    }

}
