package com.pokemonapi.model;

import com.pokemonapi.dto.Type;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class PokemonMatchups {

    private static Logger log = LoggerFactory.getLogger(PokemonMatchups.class);

    private Map<String,Double> defensiveMatchups = new HashMap<>();

    public PokemonMatchups(List<Type> types){
        this.setDefensiveMatchups(types);
    }

    private void setDefensiveMatchups(List<Type> types){
        for (Type type : types){
            switch (type.getName()){
                case "normal":
                    this.setImmunityDefensiveMatchup("ghost");

                    this.setSEDefensiveMatchup("fighting");
                    break;

                case "fire":
                    this.setNEDefensiveMatchup("fire");
                    this.setNEDefensiveMatchup("grass");
                    this.setNEDefensiveMatchup("ice");
                    this.setNEDefensiveMatchup("bug");
                    this.setNEDefensiveMatchup("steel");
                    this.setNEDefensiveMatchup("fairy");

                    this.setSEDefensiveMatchup("water");
                    this.setSEDefensiveMatchup("ground");
                    this.setSEDefensiveMatchup("rock");
                    break;

                case "water":
                    this.setNEDefensiveMatchup("fire");
                    this.setNEDefensiveMatchup("water");
                    this.setNEDefensiveMatchup("ice");
                    this.setNEDefensiveMatchup("steel");

                    this.setSEDefensiveMatchup("electric");
                    this.setSEDefensiveMatchup("grass");
                    break;

                case "electric":
                    this.setNEDefensiveMatchup("electric");
                    this.setNEDefensiveMatchup("flying");
                    this.setNEDefensiveMatchup("steel");

                    this.setSEDefensiveMatchup("ground");
                    break;

                case "grass":
                    this.setNEDefensiveMatchup("water");
                    this.setNEDefensiveMatchup("electric");
                    this.setNEDefensiveMatchup("grass");
                    this.setNEDefensiveMatchup("ground");

                    this.setSEDefensiveMatchup("fire");
                    this.setSEDefensiveMatchup("ice");
                    this.setSEDefensiveMatchup("poison");
                    this.setSEDefensiveMatchup("flying");
                    this.setSEDefensiveMatchup("bug");
                    break;

                case "ice":
                    this.setNEDefensiveMatchup("ice");

                    this.setSEDefensiveMatchup("fire");
                    this.setSEDefensiveMatchup("fighting");
                    this.setSEDefensiveMatchup("rock");
                    this.setSEDefensiveMatchup("steel");
                    break;

                case "fighting":
                    this.setNEDefensiveMatchup("bug");
                    this.setNEDefensiveMatchup("rock");
                    this.setNEDefensiveMatchup("dark");

                    this.setSEDefensiveMatchup("flying");
                    this.setSEDefensiveMatchup("psychic");
                    this.setSEDefensiveMatchup("fairy");
                    break;

                case "poison":
                    this.setNEDefensiveMatchup("grass");
                    this.setNEDefensiveMatchup("fighting");
                    this.setNEDefensiveMatchup("poison");
                    this.setNEDefensiveMatchup("bug");
                    this.setNEDefensiveMatchup("fairy");

                    this.setSEDefensiveMatchup("ground");
                    this.setSEDefensiveMatchup("psychic");
                    break;

                case "ground":
                    this.setImmunityDefensiveMatchup("electric");

                    this.setNEDefensiveMatchup("poison");
                    this.setNEDefensiveMatchup("rock");

                    this.setSEDefensiveMatchup("water");
                    this.setSEDefensiveMatchup("grass");
                    this.setSEDefensiveMatchup("ice");
                    break;

                case "flying":
                    this.setImmunityDefensiveMatchup("ground");

                    this.setNEDefensiveMatchup("grass");
                    this.setNEDefensiveMatchup("fighting");
                    this.setNEDefensiveMatchup("bug");

                    this.setSEDefensiveMatchup("electric");
                    this.setSEDefensiveMatchup("ice");
                    this.setSEDefensiveMatchup("rock");
                    break;

                case "psychic":
                    this.setNEDefensiveMatchup("fighting");
                    this.setNEDefensiveMatchup("psychic");

                    this.setSEDefensiveMatchup("bug");
                    this.setSEDefensiveMatchup("ghost");
                    this.setSEDefensiveMatchup("dark");
                    break;

                case "bug":
                    this.setNEDefensiveMatchup("grass");
                    this.setNEDefensiveMatchup("fighting");
                    this.setNEDefensiveMatchup("ground");

                    this.setSEDefensiveMatchup("fire");
                    this.setSEDefensiveMatchup("flying");
                    this.setSEDefensiveMatchup("rock");
                    break;

                case "rock":
                    this.setNEDefensiveMatchup("normal");
                    this.setNEDefensiveMatchup("fire");
                    this.setNEDefensiveMatchup("poison");
                    this.setNEDefensiveMatchup("flying");

                    this.setSEDefensiveMatchup("water");
                    this.setSEDefensiveMatchup("grass");
                    this.setSEDefensiveMatchup("fighting");
                    this.setSEDefensiveMatchup("ground");
                    this.setSEDefensiveMatchup("steel");
                    break;

                case "ghost":
                    this.setImmunityDefensiveMatchup("normal");
                    this.setImmunityDefensiveMatchup("fighting");

                    this.setNEDefensiveMatchup("poison");
                    this.setNEDefensiveMatchup("bug");

                    this.setSEDefensiveMatchup("ghost");
                    this.setSEDefensiveMatchup("dark");
                    break;

                case "dragon":
                    this.setNEDefensiveMatchup("fire");
                    this.setNEDefensiveMatchup("water");
                    this.setNEDefensiveMatchup("electric");
                    this.setNEDefensiveMatchup("grass");

                    this.setSEDefensiveMatchup("ice");
                    this.setSEDefensiveMatchup("dragon");
                    this.setSEDefensiveMatchup("fairy");
                    break;

                case "dark":
                    this.setImmunityDefensiveMatchup("psychic");

                    this.setNEDefensiveMatchup("ghost");
                    this.setNEDefensiveMatchup("dark");

                    this.setSEDefensiveMatchup("fighting");
                    this.setSEDefensiveMatchup("bug");
                    this.setSEDefensiveMatchup("fairy");
                    break;

                case "steel":
                    this.setImmunityDefensiveMatchup("poison");

                    this.setNEDefensiveMatchup("normal");
                    this.setNEDefensiveMatchup("grass");
                    this.setNEDefensiveMatchup("ice");
                    this.setNEDefensiveMatchup("flying");
                    this.setNEDefensiveMatchup("psychic");
                    this.setNEDefensiveMatchup("bug");
                    this.setNEDefensiveMatchup("rock");
                    this.setNEDefensiveMatchup("dragon");
                    this.setNEDefensiveMatchup("steel");
                    this.setNEDefensiveMatchup("fairy");

                    this.setSEDefensiveMatchup("fire");
                    this.setSEDefensiveMatchup("fighting");
                    this.setSEDefensiveMatchup("ground");
                    break;

                case "fairy":
                    this.setImmunityDefensiveMatchup("dragon");

                    this.setNEDefensiveMatchup("fighting");
                    this.setNEDefensiveMatchup("bug");
                    this.setNEDefensiveMatchup("dark");

                    this.setSEDefensiveMatchup("poison");
                    this.setSEDefensiveMatchup("steel");
                    break;

                default:
                    log.info("type:{} doesn't exist",type);
                    break;
            }
        }
    }

    private void setSEDefensiveMatchup(String type){
        if(defensiveMatchups.containsKey(type)){
            defensiveMatchups.put(type, defensiveMatchups.get(type)*2);
        } else {
            defensiveMatchups.put(type,2.0);
        }
    }

    private void setNEDefensiveMatchup(String type){
        if(defensiveMatchups.containsKey(type)){
            defensiveMatchups.put(type, defensiveMatchups.get(type)*0.5);
        } else {
            defensiveMatchups.put(type,0.5);
        }
    }

    private void setImmunityDefensiveMatchup(String type){
        if(defensiveMatchups.containsKey(type)){
            defensiveMatchups.put(type, defensiveMatchups.get(type)*0);
        } else {
            defensiveMatchups.put(type,0.0);
        }
    }

}
