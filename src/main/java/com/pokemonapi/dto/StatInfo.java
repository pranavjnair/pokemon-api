package com.pokemonapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatInfo {
    Integer baseStat;
    Stat stat;
}
