package com.example.homework_1_m7_openfeign;

import com.example.homework_1_m7_openfeign.dto.SongifyServerResponseDto;
import com.example.homework_1_m7_openfeign.dto.SongifyServerRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.*;

@FeignClient(value = "songify-client")
@Service
public interface SongifyProxy {

    // GET http://localhost:8080/songs
    @GetMapping("/songs")
    public SongifyServerResponseDto fetchAllSongs();

    @GetMapping("/songs/{songId}")
    public SongifyServerResponseDto getSongById(@PathVariable Integer songId);

    @PostMapping("/songs")
    public SongifyServerResponseDto addSong(@RequestBody SongifyServerRequestDto song);

    @DeleteMapping("/songs/{songId}")
    public SongifyServerResponseDto deleteSong(@PathVariable Integer songId);

    @PutMapping("songs/{songId}")
    public SongifyServerResponseDto updateSong( @PathVariable Integer songId , @RequestBody SongifyServerRequestDto newSong);

    @PatchMapping("songs/{songId}")
    public SongifyServerResponseDto partiallyUpdateSong( @PathVariable Integer songId , @RequestBody SongifyServerRequestDto newSong);

}
