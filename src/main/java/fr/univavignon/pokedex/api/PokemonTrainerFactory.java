package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    public PokemonTrainerFactory() {
        
    }

    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) throws PokedexException {
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        return new PokemonTrainer(name, team, pokedex);
    }

}