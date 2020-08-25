package com.pokemonapi.model;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Data
public class PokemonStat {

    private static Logger log = LoggerFactory.getLogger(PokemonStat.class);

    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public void setStat(String statName, Integer statValue) {
        switch (statName){
            case "hp":
                this.setHp(statValue);
                break;
            case "attack":
                this.setAttack(statValue);
                break;
            case "defense":
                this.setDefense(statValue);
                break;
            case "specialAttack":
                this.setSpecialAttack(statValue);
                break;
            case "specialDefense":
                this.setSpecialDefense(statValue);
                break;
            case "speed":
                this.setSpeed(statValue);
                break;
            default:
                break;
        }
    }

    public int getStat(String statName){
        switch (statName){
            case "hp":
                return this.getHp();
            case "attack":
                return this.getAttack();
            case "defense":
                return this.getDefense();
            case "specialAttack":
                return this.getSpecialAttack();
            case "specialDefense":
                return this.getSpecialDefense();
            case "speed":
                return this.getSpeed();
            default:
                log.info("was not able to get stat for stat:{}",statName);
                return 0;
        }
    }

}
