package fr.univavignon.pokedex.api;

import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemons;

    public Pokedex(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public Pokedex() {
    }

    public int size() {
        return this.pokemons.size();
    }

    public int addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        return 0;
    }

    public Pokemon getPokemon(int id) throws PokedexException {
        return this.pokemons.get(id);
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        return null;
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        PokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        this.pokemons.add(pokemon);
        return pokemon;
    }

    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return null;
    }
}
