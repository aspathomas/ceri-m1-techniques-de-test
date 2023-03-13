package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.*;
import org.mockito.Mockito;



public class IPokedexTest {

	// @Before
	// public void setup() {
	// 	IPokedex iPokedex = Mockito.mock(IPokedex.class);
	// }

	IPokedex iPokedex = Mockito.mock(IPokedex.class);

	@Test
	public void testSize() {
        Mockito.when(iPokedex.size()).thenReturn(2);
        assertEquals(2, iPokedex.size());
    }

	@Test
	public void testAddPokemon() {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Mockito.when(iPokedex.addPokemon(pokemon)).thenReturn(2);
        assertEquals(2, iPokedex.addPokemon(pokemon));
    }

	@Test
	public void testGetPokemon() throws PokedexException {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Mockito.when(iPokedex.getPokemon(2)).thenReturn(pokemon);
        assertEquals(pokemon, iPokedex.getPokemon(2));
    }

	@Test
	public void testGetPokemonList() {
		Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        List<Pokemon> list = new ArrayList<Pokemon>();
    	list.add(pokemon);
		Mockito.when(iPokedex.getPokemons()).thenReturn(list);
        assertEquals(list, iPokedex.getPokemons());
    }

	// @Test
	// public void testGetPokemonComparator() {
	// 	Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
    //     List<Pokemon> list = new ArrayList<Pokemon>();
    // 	list.add(pokemon);

	// 	Mockito.when(iPokedexTest.addPokemon()).thenReturn(list);
    //     assertEquals(list, iPokedexTest.addPokemon());
    // }

	// List<Pokemon> getPokemons(Comparator<Pokemon> order);

}
