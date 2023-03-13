import org.junit.Test;
import org.mockito.Mockito;

import fr.univavignon.pokedex.api.Pokemon;
import fr.univavignon.pokedex.api.IPokemonFactory;

import static org.junit.Assert.assertEquals;

/**
 * Test Factory interface for class that aims to create Pokemon instance.
 *
 * @author fv
 */
public class IPokemonFactoryTest {

    // @Mock
    // Pokemon pokemon;
    // IPokemonFactory iPokemonFactory;

	@Test
	public void testCreatePokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        IPokemonFactory iPokemonFactory = Mockito.mock(IPokemonFactory.class);
        Mockito.when(iPokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
        assertEquals(pokemon, iPokemonFactory.createPokemon(0, 613, 64, 4000, 4));
    }
}
