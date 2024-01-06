package com.example.homework_1_m7_openfeign;

import com.example.homework_1_m7_openfeign.dto.SongifyServerRequestDto;
import feign.FeignException;
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

    public Homework1M7OpenFeignApplication(SongifyProxy songifyClient) {
        this.songifyClient = songifyClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(Homework1M7OpenFeignApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeResponseToSongifyEndpoint(){

        try {
            log.info(songifyClient.fetchAllSongs());
            songifyClient.addSong(new SongifyServerRequestDto("anonim", "new song"));
            log.info(songifyClient.fetchAllSongs());
            songifyClient.deleteSong(5);
            log.info(songifyClient.fetchAllSongs());
            songifyClient.updateSong(2, new SongifyServerRequestDto("GalANonim", "updated song"));
            log.info(songifyClient.fetchAllSongs());
        } catch (FeignException.FeignClientException feignClientException) {
            log.error("client exception: " + feignClientException.status());
        } catch (FeignException.FeignServerException feignServerException) {
            log.info("server exception: " + feignServerException.status());
        } catch (FeignException feignException) {
            log.info(feignException.getMessage());
            log.info(feignException.status());
        }
    }
}
