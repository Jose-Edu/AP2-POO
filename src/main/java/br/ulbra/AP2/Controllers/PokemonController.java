package br.ulbra.AP2.Controllers;

import br.ulbra.AP2.Models.Pokemon;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PokemonController {

    @GetMapping("/pokemon")
    public List<Pokemon> getPokemon() {}

    @GetMapping("/pokemon/id")
    public Pokemon getPokemonById(@PathVariable int id) {}

    @PostMapping("/pokemon")
    public HttpStatus addPokemon(@RequestBody Pokemon pokemon) {}

    @PutMapping("/pokemon/id")
    public HttpStatus editPokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {}

    @DeleteMapping("/pokemon/id")
    public HttpStatus deletePokemon(@PathVariable int id, @RequestBody Pokemon pokemon) {}
}
