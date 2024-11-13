package com.kian.card.config;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AppConfig {

    public AppConfig() {
        log.info("AppConfig is created...");

    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
