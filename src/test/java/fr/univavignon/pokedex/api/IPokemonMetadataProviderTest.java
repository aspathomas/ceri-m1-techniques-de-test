package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

	@Test
	public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata pokemon = new PokemonMetadata(0, "Bulbizarre", 126, 126, 100);
        IPokemonMetadataProvider iPokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        Mockito.when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(pokemon);
        assertEquals(pokemon, iPokemonMetadataProvider.getPokemonMetadata(0));
    }
}
