package com.pokemonapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.*;

/**
 * Maps baseStats, evs, ivs to trained stats values for a pokemon
 */
@Data
public class PokemonTrainedStats {

    public static int DEFAULT_IV = 31;
    public static int DEFAULT_EV = 0;


    private PokemonStat trainedStats = new PokemonStat();
    private PokemonStat evs = new PokemonStat();
    private PokemonStat ivs = new PokemonStat();
    private PokemonStat baseStats = new PokemonStat();

    @JsonIgnore
    private List<String> statNames = new ArrayList<>(Arrays.asList("hp", "attack", "defense", "specialAttack",
            "specialDefense", "speed"));


    public PokemonTrainedStats(int pokemonLevel, String nature, Map<String, Integer> baseStats) {

        for (String statName : this.statNames) {
            this.evs.setStat(statName, DEFAULT_EV); //
            this.ivs.setStat(statName, DEFAULT_IV);

            this.baseStats.setStat(statName, baseStats.get(statName));

            if (statName.equals("hp")) {
                this.trainedStats.setStat(statName,hpCalculation(pokemonLevel, baseStats));
            } else {
                this.trainedStats.setStat(statName,nonHPCalculation(pokemonLevel,nature,baseStats,statName));
            }
        }
    }

    /*
     * calculates hp stat of a pokemon with formula
     */
    private int hpCalculation(int pokemonLevel, Map<String, Integer> baseStats) {
        return ((this.ivs.getStat("hp") + 2 * baseStats.get("hp") + (this.evs.getStat("hp") / 4)) * pokemonLevel / 100)
                + 10 + pokemonLevel;
    }

    private int nonHPCalculation(int pokemonLevel, String nature, Map<String, Integer> baseStats, String statName) {
        return (int) ((((this.ivs.getStat(statName) + 2 * baseStats.get(statName) + (this.evs.getStat(statName) / 4))
                * pokemonLevel / 100) + 5) * this.natureMultiplier(nature,statName));
    }

    private double natureMultiplier(String nature,String statName) {
        Map<String,NatureEffect> natureEffects = new HashMap<>();
        NatureEffect natureEffect = natureEffects.get(nature);
        if (natureEffect == null){
            return 1;
        } else if (natureEffect.getPositiveStat()==statName){
            return 1.1;
        } else {
            return 0.9;
        }
    }

    private Map<String,NatureEffect> setNatureEffects(HashMap<String,NatureEffect> natureEffects){
        natureEffects.put("hardy", new NatureEffect(null, null));
        natureEffects.put("docile", new NatureEffect(null, null));
        natureEffects.put("serious", new NatureEffect(null, null));
        natureEffects.put("bashful", new NatureEffect(null, null));
        natureEffects.put("quirky", new NatureEffect(null, null));

        natureEffects.put("lonely", new NatureEffect("attack", "defense"));
        natureEffects.put("brave", new NatureEffect("attack", "speed"));
        natureEffects.put("adamant", new NatureEffect("attack", "specialAttack"));
        natureEffects.put("naughty", new NatureEffect("attack", "specialDefense"));

        natureEffects.put("bold", new NatureEffect("defense", "attack"));
        natureEffects.put("relaxed", new NatureEffect("defense", "speed"));
        natureEffects.put("impish", new NatureEffect("defense", "specialAttack"));
        natureEffects.put("lax", new NatureEffect("defense", "specialDefense"));

        natureEffects.put("timid", new NatureEffect("speed", "attack"));
        natureEffects.put("hasty", new NatureEffect("speed", "defense"));
        natureEffects.put("jolly", new NatureEffect("speed", "specialAttack"));
        natureEffects.put("naive", new NatureEffect("speed", "specialDefense"));

        natureEffects.put("modest", new NatureEffect("specialAttack", "attack"));
        natureEffects.put("mild", new NatureEffect("specialAttack", "defense"));
        natureEffects.put("quite", new NatureEffect("specialAttack", "speed"));
        natureEffects.put("rash", new NatureEffect("specialAttack", "specialDefense"));

        natureEffects.put("calm", new NatureEffect("specialDefense", "attack"));
        natureEffects.put("gentle", new NatureEffect("specialDefense", "defense"));
        natureEffects.put("sassy", new NatureEffect("specialDefense", "speed"));
        natureEffects.put("careful", new NatureEffect("specialDefense", "specialAttack"));

        return natureEffects;
    }
}
