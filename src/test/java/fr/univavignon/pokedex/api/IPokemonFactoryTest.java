package fr.univavignon.pokedex.api;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IPokemonFactoryTest {

	@Test
	public void testCreatePokemon() {
        IPokemonFactory pokemonFactory = new PokemonFactory();
        Pokemon pokemon = pokemonFactory.createPokemon(1, 613, 64, 4000, 4);

        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbizar", pokemon.getName());
        assertEquals(118, pokemon.getAttack());
        assertEquals(111, pokemon.getDefense());
        assertEquals(128, pokemon.getStamina());
    }
}
