package com.ironhack.otakuhub.proxy;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;


//@FeignClient(name ="CurrencyChangeProxy", url = "https://api.api-ninjas.com/v1/convertcurrency")
//@Component
//public interface CurrencyChangeProxy {
//
//    @RequestMapping(method = RequestMethod.GET)
//    CurrencyChange getCurrencyChange(@RequestParam("app_id") String appId, @RequestParam String want, @RequestParam String have, @RequestParam Double amount );

//}
