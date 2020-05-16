package com.pokemonapi.model;

import com.pokemonapi.dto.Ability;
import com.pokemonapi.dto.Type;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Pokemon {
    private String name;
    private List<Ability> abilities;
    private List<Type> types;
    private PokemonStats pokemonStats;

}
