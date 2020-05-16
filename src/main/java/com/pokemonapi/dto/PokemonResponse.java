package com.pokemonapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonResponse {
    List<AbilityInfo> abilities;
    List<TypeInfo> types;
    List<StatInfo> stats;
}
