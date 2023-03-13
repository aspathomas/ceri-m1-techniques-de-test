package fr.univavignon.pokedex.api;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


public class IPokemonFactoryTest {

	@Test
	public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        IPokemonFactory iPokemonFactory = Mockito.mock(IPokemonFactory.class);
        Mockito.when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        assertEquals(pokemon, iPokemonFactory.createPokemon(0, 613, 64, 4000, 4));
    }
}
