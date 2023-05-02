package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        // Expected metadata for Bulbizar
        PokemonMetadata expected = new PokemonMetadata(1, "Bulbizar", 126, 126, 90);

        // Create a mock object for the IPokemonMetadataProvider interface
        IPokemonMetadataProvider metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

        // Set up the mock object to return the expected metadata for index 1
        Mockito.when(metadataProvider.getPokemonMetadata(1)).thenReturn(expected);

        // Actual metadata
        PokemonMetadata actual = metadataProvider.getPokemonMetadata(1);

        assertEquals(expected.getIndex(), actual.getIndex());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getAttack(), actual.getAttack());
        assertEquals(expected.getDefense(), actual.getDefense());
        assertEquals(expected.getStamina(), actual.getStamina());
    }
}