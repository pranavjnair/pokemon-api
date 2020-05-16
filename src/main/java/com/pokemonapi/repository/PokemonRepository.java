package com.pokemonapi.repository;

import com.pokemonapi.model.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokemonRepository extends MongoRepository<Pokemon,String> {
}
