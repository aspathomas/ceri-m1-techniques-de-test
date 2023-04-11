package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create PokemonTrainer instance.
 *
 * @author fv
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    /**
     * Creates and returns a PokemonTrainer instance.
     *
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory for creating pokedex instance.
     * @return Created trainer instance.
     */
    PokemonTrainer createTrainer(
        String name,
        Team team,
        IPokedexFactory pokedexFactory
    ) {
        
    };

}
