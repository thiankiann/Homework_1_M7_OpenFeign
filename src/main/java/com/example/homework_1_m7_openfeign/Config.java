package com.example.homework_1_m7_openfeign;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }
}
