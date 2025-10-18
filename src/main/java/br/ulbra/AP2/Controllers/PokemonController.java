package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public ResponseEntity<List<Pokemon>> getPokemon() {
        return ResponseEntity.status(HttpStatus.OK).body(this.pokemonService.getAllPokemons());
    }

    @PostMapping("/pokemon")
    public ResponseEntity<Pokemon> addPokemon(@RequestBody Pokemon pokemon) {
        this.pokemonService.addPokemon(pokemon);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/pokemon/list")
    public ResponseEntity<Pokemon> addPokemons(@RequestBody List<Pokemon> pokemons) {
        this.pokemonService.addPokemons(pokemons);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/pokemon/name/{pokemonName}")
    public ResponseEntity<Pokemon> getPokemonByName(@PathVariable String pokemonName) {
        Pokemon pokemon = pokemonService.getPokemonByName(pokemonName);
        if (pokemon != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pokemon);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable int id) {
        Pokemon poke = this.pokemonService.getPokemonById(id);
        if (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> editPokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {
        Pokemon poke = this.pokemonService.updatePokemonById(pokemon, id);
        if  (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/pokemon/{id}")
    public ResponseEntity<Pokemon> deletePokemon(@PathVariable int id) {
        Pokemon poke = this.pokemonService.deletePokemonById(id);
        if  (poke != null) {
            return ResponseEntity.status(HttpStatus.OK).body(poke);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
