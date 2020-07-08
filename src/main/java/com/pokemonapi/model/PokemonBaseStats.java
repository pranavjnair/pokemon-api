package com.pokemonapi.model;

import com.pokemonapi.dto.StatInfo;
import lombok.Data;

import java.util.*;

@Data
public class PokemonBaseStats {


    private Map<String, Integer> baseStats = new HashMap<>();

    public void setStat(StatInfo statInfo) {
        switch (statInfo.getStat().getName()) {
            case "special-attack":
                this.baseStats.put("specialAttack", statInfo.getBaseStat());
                break;
            case "defense":
                this.baseStats.put("defense", statInfo.getBaseStat());
                break;
            case "attack":
                this.baseStats.put("attack", statInfo.getBaseStat());
                break;
            case "hp":
                this.baseStats.put("hp", statInfo.getBaseStat());
                break;
            case "special-defense":
                this.baseStats.put("specialDefense", statInfo.getBaseStat());
                break;
            case "speed":
                this.baseStats.put("speed", statInfo.getBaseStat());
            default:
                break;
        }
    }
}
