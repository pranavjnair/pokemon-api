package com.pokemonapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pokemonapi.dto.Ability;
import com.pokemonapi.dto.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pokemon {

    public static int DEFAULT_LEVEL = 50;
    public static String DEFAULT_NATURE = "hardy";

    private String name;
    private List<Ability> abilities;
    private List<Type> types;
    private PokemonTrainedStats pokemonTrainedStats;
    private PokemonMatchups pokemonMatchups;
    private String nature = DEFAULT_NATURE;


    public Pokemon (String name, List<Ability> abilities, List<Type> types, PokemonBaseStats pokemonBaseStats){
        this.name = name;
        this.abilities = abilities;
        this.types = types;
        this.pokemonMatchups = new PokemonMatchups(this.types);
        this.pokemonTrainedStats = new PokemonTrainedStats(DEFAULT_LEVEL,this.nature,pokemonBaseStats.getBaseStats());
    }



}
