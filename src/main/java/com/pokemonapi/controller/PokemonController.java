package com.pokemonapi.controller;

import com.pokemonapi.App;
import com.pokemonapi.model.Pokemon;
import com.pokemonapi.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private static Logger log = LoggerFactory.getLogger(App.class);

    @Autowired
    private PokemonService pokemonService;

    @RequestMapping(value = "/{name}",method = RequestMethod.GET)
    public Pokemon getPokemonByName(@PathVariable("name") String name){
        return pokemonService.getPokemon(name);
    }
}
