package com.example.homework_1_m7_openfeign.mappers;

import com.example.homework_1_m7_openfeign.Song;
import com.example.homework_1_m7_openfeign.dto.GetAllSongResponseDto;

import java.util.Map;

public class SongMapper {
    public static GetAllSongResponseDto mapFromSongToGetAllSongsResponseDto(Map<Integer, Song> database){
        return new GetAllSongResponseDto(database);
    }
}
