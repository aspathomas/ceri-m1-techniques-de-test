package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;
// import java.util.Comparator;
import java.util.List;

import org.junit.*;
import org.mockito.Mockito;



public class IPokedexTest {

	private IPokedex iPokedex;

	@Before
    public void setUp() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
		IPokemonFactory pokemonFactory = new PokemonFactory();
        IPokedexFactory pokedexFactory = new PokedexFactory();
		iPokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
    }

	@Test
    public void testSize() {
        assertEquals(0, iPokedex.size());
        iPokedex.addPokemon(new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56));
        assertEquals(1, iPokedex.size());
    }

    @Test
    public void testAddPokemon() {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        assertEquals(0, iPokedex.addPokemon(pokemon));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        iPokedex.addPokemon(pokemon);
        assertEquals(pokemon, iPokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemonList() {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 1);
        iPokedex.addPokemon(pokemon1);
        iPokedex.addPokemon(pokemon2);
        List<Pokemon> list = new ArrayList<Pokemon>();
        list.add(pokemon1);
        list.add(pokemon2);
        assertEquals(list, iPokedex.getPokemons());
    }


    @Test
    public void testGetPokemonsSorted() {
        Pokemon pokemon1 = iPokedex.createPokemon(1, 126, 126, 4000, 4);
        Pokemon pokemon2 = iPokedex.createPokemon(2, 186, 168, 5000, 4);

        Comparator<Pokemon> attackComparator = new Comparator<Pokemon>() {
            public int compare(Pokemon pokemon1, Pokemon pokemon2) {
                int result = Integer.compare(pokemon1.getAttack(), pokemon2.getAttack());

                if (result == 0) {
                    result = Integer.compare(pokemon1.getDefense(), pokemon2.getDefense());
                }

                return result;
            }
        };

        List<Pokemon> expectedPokemons = new ArrayList<Pokemon>();
        expectedPokemons.add(pokemon1);
        expectedPokemons.add(pokemon2);

        List<Pokemon> pokemons = iPokedex.getPokemons(attackComparator);
        assertEquals(expectedPokemons, pokemons);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon pokemon = iPokedex.createPokemon(1, 126, 126, 4000, 4);

        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbizar", pokemon.getName());
        assertEquals(118, pokemon.getAttack());
        assertEquals(111, pokemon.getDefense());
        assertEquals(128, pokemon.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataNotFound() throws PokedexException {
        iPokedex.getPokemonMetadata(-1);
    }
}
