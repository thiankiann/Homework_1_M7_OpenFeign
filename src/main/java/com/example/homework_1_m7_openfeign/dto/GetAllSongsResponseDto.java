package com.example.homework_1_m7_openfeign.dto;

import com.example.homework_1_m7_openfeign.Song;

import java.util.Map;

public record GetAllSongsResponseDto(Map<Integer, Song > songs) {
}
