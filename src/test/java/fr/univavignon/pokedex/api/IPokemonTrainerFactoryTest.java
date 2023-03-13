package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

	@Test
	public void testCreateTrainer() {
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);

		PokemonTrainer pokemonTrainer = new PokemonTrainer("toto", Team.INSTINCT, pokedex);

        Mockito.when(pokemonTrainerFactory.createTrainer("toto", Team.INSTINCT, pokedexFactory)).thenReturn(pokemonTrainer);
        assertEquals(pokemonTrainer, pokemonTrainerFactory.createTrainer("toto", Team.INSTINCT, pokedexFactory));
    }
}
