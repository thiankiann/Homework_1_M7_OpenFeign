package com.example.homework_1_m7_openfeign;

import com.example.homework_1_m7_openfeign.dto.SongifyServerResponseDto;
import com.example.homework_1_m7_openfeign.dto.SongifyServerRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "songify-client")
@Service
public interface SongifyProxy {

    // GET http://localhost:8080/songs
    @GetMapping("/songs")
    public SongifyServerResponseDto fetchAllSongs();

    @PostMapping("/songs")
    public SongifyServerResponseDto addSong(@RequestBody SongifyServerRequestDto song);

    @DeleteMapping("/songs/{songId}")
    public SongifyServerResponseDto deleteSong(@PathVariable Integer songId);

    @PutMapping("songs/{songId}")
    public SongifyServerResponseDto updateSong( @PathVariable Integer songId , @RequestBody SongifyServerRequestDto newSong);

}
