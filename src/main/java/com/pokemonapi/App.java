package com.pokemonapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App{

    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        log.info("[starting server]");
        ConfigurableApplicationContext app = SpringApplication.run(App.class, args);

//        PokemonService service = app.getBean(PokemonService.class);
        log.info("[server started]");

    }
}