package com.example.homework_1_m7_openfeign;

import com.example.homework_1_m7_openfeign.dto.GetAllSongsResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class Homework1M7OpenFeignApplication {

    @Autowired
    SongifyProxy songifyClient;

    public static void main(String[] args) {
        SpringApplication.run(Homework1M7OpenFeignApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeResponseToSongifyEndpoint(){
//      GetAllSongsResponseDto response = songifyClient.fetchAllSongs();
//        System.out.println(response);

        log.info(songifyClient.fetchAllSongs());
    }
}
