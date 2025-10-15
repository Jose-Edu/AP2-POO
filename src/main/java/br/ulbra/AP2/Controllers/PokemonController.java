package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public List<Pokemon> getPokemon() {
        return this.pokemonService.getAllPokemons();
    }

    @PostMapping("/pokemon")
    public HttpStatus addPokemon(@RequestBody Pokemon pokemon) {
        this.pokemonService.addPokemon(pokemon);
        return HttpStatus.OK;
    }

    @PostMapping("/pokemon/list")
    public HttpStatus addPokemons(@RequestBody List<Pokemon> pokemons) {
        this.pokemonService.addPokemons(pokemons);
        return HttpStatus.OK;
    }

    @GetMapping("/pokemon/name")
    public Pokemon getPokemonByName(@RequestBody String pokemonName) {
        return this.pokemonService.getPokemonByName(pokemonName);
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable int id) {
        return this.pokemonService.getPokemonById(id);
    }

    @PutMapping("/pokemon/{id}")
    public HttpStatus editPokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {
        this.pokemonService.updatePokemonById(pokemon, id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/pokemon/{id}")
    public HttpStatus deletePokemon(@PathVariable int id) {
        this.pokemonService.deletePokemonById(id);
        return HttpStatus.OK;
    }
}
