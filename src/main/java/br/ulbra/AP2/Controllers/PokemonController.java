package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Models.Pokemon;
import br.ulbra.AP2.Services.PokemonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getPokemon() {
        return this.pokemonService.getAllPokemons();
    }

    @GetMapping("/id")
    public Pokemon getPokemonById(@PathVariable int id) {
        return this.pokemonService.getPokemonById(id);
    }

    @PostMapping
    public HttpStatus addPokemon(@RequestBody Pokemon pokemon) {
        this.pokemonService.addPokemon(pokemon);
        return HttpStatus.OK;
    }

    @PutMapping("/id")
    public HttpStatus editPokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {
        this.pokemonService.updatePokemonById(pokemon, id);
        return HttpStatus.OK;
    }

    @DeleteMapping("/id")
    public HttpStatus deletePokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {
        this.pokemonService.deletePokemonById(id);
        return HttpStatus.OK;
    }
}
