package com.example.homework_1_m7_openfeign.mappers;

import com.example.homework_1_m7_openfeign.Song;
import com.example.homework_1_m7_openfeign.dto.GetAllSongsResponseDto;

import java.util.Map;

public class SongMapper {
    public static GetAllSongsResponseDto mapFromSongToGetAllSongsResponseDto(Map<Integer, Song> database){
        return new GetAllSongsResponseDto(database);
    }
}
