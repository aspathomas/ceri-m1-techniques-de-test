package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(1);

        assertEquals(1, metadata.getIndex());
        assertEquals("Bulbizar", metadata.getName());
        assertEquals(118, metadata.getAttack());
        assertEquals(111, metadata.getDefense());
        assertEquals(128, metadata.getStamina());
    }
}