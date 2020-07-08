package com.pokemonapi.service;

import com.pokemonapi.dto.*;
import com.pokemonapi.model.Pokemon;
import com.pokemonapi.model.PokemonBaseStats;
import com.pokemonapi.restclient.PokemonRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService{

    private static Logger log = LoggerFactory.getLogger(PokemonServiceImpl.class);

    @Autowired
    private PokemonRestClient pokemonRestClient;

    @Override
    public Pokemon getPokemon(String pokemonName) {

        PokemonResponse pokemonResponse = pokemonRestClient.getPokemonByName(pokemonName);

        List<AbilityInfo> abilityInfos = pokemonResponse.getAbilities();
        List<Ability> abilities = new ArrayList<>();
        for (AbilityInfo info : abilityInfos){
            abilities.add(info.getAbility());
        }

        List<TypeInfo> typeInfos = pokemonResponse.getTypes();
        List<Type> types = new ArrayList<>();

        for (TypeInfo info : typeInfos){
            types.add(info.getType());
        }

        log.info("pokemon:{} abilities:{}",pokemonName, abilities);
        log.info("pokemon:{} types:{}",pokemonName, types);

        List<StatInfo> statInfos = pokemonResponse.getStats();
        PokemonBaseStats pokemonBaseStats = new PokemonBaseStats();
        for (StatInfo info : statInfos){
            pokemonBaseStats.setStat(info);
        }

        log.info("pokemon:{} pokemonStats:{}",pokemonName, pokemonBaseStats);


        return new Pokemon(pokemonName, abilities,types, pokemonBaseStats);
    }
}
