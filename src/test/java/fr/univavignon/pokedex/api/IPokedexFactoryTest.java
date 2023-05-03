package fr.univavignon.pokedex.api;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class IPokedexFactoryTest {

    @Test
    public void testCreatePokedex() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new PokemonFactory();

        IPokedexFactory pokedexFactory = new PokedexFactory();

        IPokedex pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertEquals(Pokedex.class, pokedex.getClass());
    }
}
