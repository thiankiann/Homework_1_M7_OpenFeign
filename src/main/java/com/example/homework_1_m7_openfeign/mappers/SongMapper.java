package com.example.homework_1_m7_openfeign.mappers;

import com.example.homework_1_m7_openfeign.Song;
import com.example.homework_1_m7_openfeign.dto.SongifyServerResponseDto;

import java.util.Map;

public class SongMapper {
    public static SongifyServerResponseDto mapFromSongToGetAllSongsResponseDto(Map<Integer, Song> database){
        return new SongifyServerResponseDto(database);
    }
}
