package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory {

    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) throws PokedexException {

        return new Pokedex(new PokemonMetadataProvider(), new PokemonFactory());
    }
}
