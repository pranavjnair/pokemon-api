package com.pokemonapi.model;

import com.pokemonapi.dto.StatInfo;
import lombok.Data;

@Data
public class PokemonStats {
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public void setStat(StatInfo statInfo) {
        switch (statInfo.getStat().getName()) {
            case "hp":
                this.setHp(statInfo.getBaseStat());
                break;
            case "attack":
                this.setAttack(statInfo.getBaseStat());
                break;
            case "defense":
                this.setDefense(statInfo.getBaseStat());
                break;
            case "special-attack":
                this.setSpecialAttack(statInfo.getBaseStat());
                break;
            case "special-defense":
                this.setSpecialDefense(statInfo.getBaseStat());
                break;
            case "speed":
                this.setSpeed(statInfo.getBaseStat());
                break;
            default:
                break;
        }
    }
}
