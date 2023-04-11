package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    public Pokedex createPokedex(PokemonMetadataProvider metadataProvider, PokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
