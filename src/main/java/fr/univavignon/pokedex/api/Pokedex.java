package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pokedex implements IPokedex {

    private List<Pokemon> pokemons;
    private PokemonMetadataProvider metadataProvider;
    private PokemonFactory pokemonFactory;

    public Pokedex(PokemonMetadataProvider metadataProvider2, PokemonFactory pokemonFactory2) {
        this.metadataProvider = metadataProvider2;
        this.pokemonFactory = pokemonFactory2;
        this.pokemons = new ArrayList<>();
    }

    public int size() {
        return this.pokemons.size();
    }

    public int addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
        return this.pokemons.size() - 1;
    }

    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= this.pokemons.size()) {
            throw new PokedexException("Invalid Pokemon ID");
        }
        return this.pokemons.get(id);
    }

    public List<Pokemon> getPokemons() {
        return List.copyOf(this.pokemons);
    }

    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(this.pokemons);
        sortedPokemons.sort(order);
        return List.copyOf(sortedPokemons);
    }

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        Pokemon pokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        this.pokemons.add(pokemon);
        return pokemon;
    }

    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return this.metadataProvider.getPokemonMetadata(index);
    }
}