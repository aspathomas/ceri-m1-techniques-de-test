package fr.univavignon.pokedex.api;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;


public class IPokedexFactoryTest {

	@Test
	public void testCreatePokedex() {
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex = Mockito.mock(IPokedex.class);
		IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

        Mockito.when(pokedexFactory.createPokedex(metadataProvider, pokemonFactory)).thenReturn(pokedex);
        assertEquals(pokedex, pokedexFactory.createPokedex(metadataProvider, pokemonFactory));
    }

}
