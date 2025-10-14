package br.ulbra.AP2.Services;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Repositories.PokemonRepository;

import java.util.List;

public class PokemonService {
    private PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.getPokemons();
    }

    public Pokemon getPokemonById(int idPokemon) {
        return pokemonRepository.getPokemonById(idPokemon);
    }

}
