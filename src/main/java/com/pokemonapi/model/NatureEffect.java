package com.pokemonapi.model;

import lombok.Data;

@Data
public class NatureEffect {
    private String positiveStat;
    private String negativeStat;

    public NatureEffect(String positiveStat,String negativeStat){
        this.positiveStat = positiveStat;
        this.negativeStat = negativeStat;
    }
}
