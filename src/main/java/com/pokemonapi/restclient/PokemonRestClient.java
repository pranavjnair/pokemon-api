package com.pokemonapi.restclient;

import com.pokemonapi.dto.PokemonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.pokemonapi.exception.AppException;
import com.pokemonapi.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonRestClient {
    Logger log = LoggerFactory.getLogger(PokemonRestClient.class);

    private RestTemplate restTemplate = new RestTemplate();
    private static String POKEMON_BASE_URL = "https://pokeapi.co/api/v2/pokemon";

    public PokemonResponse getPokemonByName(String pokemonName) {
        String url = POKEMON_BASE_URL + "/" + pokemonName;

        HttpHeaders headers = new HttpHeaders();
        headers.add("user-agent", "header-info");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        log.info("Calling url::{} with parameter::{}", url, pokemonName);

        ResponseEntity<String> resp;

        try {
            resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            //log.info("Response for {} is {}. HTTPstatus:{}", pokemonName, resp.getBody(), resp.getStatusCode());
        } catch (HttpClientErrorException e) {
            HttpStatus status = e.getStatusCode();
            if (status == HttpStatus.NOT_FOUND) {
                log.error("Unable to call pokemon api for pokemon name:{}", pokemonName);
                throw new NotFoundException("unable to find pokemon");
            } else {
                log.error("Unable to call pokemon api for pokemon name:{} with exception:{}", pokemonName, e);
                throw new AppException("Unable to call pokemon api", e);
            }
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
            return objectMapper.readValue(resp.getBody(), PokemonResponse.class);
        } catch (Exception e) {
            log.error("Unable to parse JSON for pokemon name {} with exception:{}",pokemonName,e);
            throw new AppException("Unable to map pokemon response to object", e);
        }
    }
}
