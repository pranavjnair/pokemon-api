package com.pokemonapi.controller;

import com.pokemonapi.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class PokemonControllerAdvice {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<Object> handleNotFound(NotFoundException exception, WebRequest request){
        Map<String,Object> response = new HashMap<>();
        response.put("code", HttpStatus.NOT_FOUND);
        response.put("timestamp", Instant.now());
        response.put("message", "Requested entity not found");
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
