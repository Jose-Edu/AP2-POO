package br.ulbra.AP2.Repositories;

import br.ulbra.AP2.Models.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {
    private List<Pokemon> pokemons;

    public PokemonRepository() {
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public Pokemon getPokemonById(int idPokemon) {
        return this.pokemons.get(idPokemon);
    }

    public void setPokemon(Pokemon pokemon, int idPokemon) {
        this.pokemons.set(idPokemon, pokemon);
    }

    public void deletePokemon(int idPokemon) {
        this.pokemons.remove(idPokemon);
    }
    
}
