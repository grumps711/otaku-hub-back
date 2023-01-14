package com.ironhack.otakuhub.proxy;

import com.ironhack.otakuhub.model.AnimesByScene;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="trace-moe", url = "https://api.trace.moe/search?anilistInfo&")
public interface TraceMoeProxy {


//    https://api.trace.moe/search?anilistInfo&url=https://images.plurk.com/32B15UXxymfSMwKGTObY5e.jpg
    @GetMapping()
    AnimesByScene getAnimesByScene(@RequestHeader(name = "x-trace-key") String apikey,
                                   @RequestParam String url);
}
