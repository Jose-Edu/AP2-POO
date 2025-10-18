package br.ulbra.AP2.Services;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Repositories.PokemonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.getPokemons();
    }

    public Pokemon getPokemonById(int idPokemon) {
        return pokemonRepository.getPokemonById(idPokemon);
    }

    public Pokemon getPokemonByName(String namePokemon) {
        for (Pokemon pokemon : getAllPokemons()) {
            if (pokemon.name.equals(namePokemon)) {
                return pokemon;
            }
        }
        return null;
    }

    public Pokemon updatePokemonById(Pokemon pokemon, int idPokemon) {
        return pokemonRepository.setPokemon(pokemon, idPokemon);
    }

    public Pokemon deletePokemonById(int idPokemon) {
        return pokemonRepository.deletePokemon(idPokemon);
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonRepository.addPokemon(pokemon);
    }

    public void addPokemons(List<Pokemon> pokemons) {
        for (Pokemon pokemon : pokemons) {
            pokemonRepository.addPokemon(pokemon);
        }
    }

}
