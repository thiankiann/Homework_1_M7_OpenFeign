package com.example.homework_1_m7_openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "songify-client")
@Service
public interface SongifyProxy {

    // GET http://localhost:8080/songs
    @GetMapping("/songs")
    public String fetchAllSongs();
}
