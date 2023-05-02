package fr.univavignon.pokedex.api;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
public class IPokemonTrainerFactoryTest {

     @Test
    public void testCreateTrainer() throws PokedexException {
        String name = "Ash Ketchum";
        Team team = Team.INSTINCT;

        IPokedexFactory pokedexFactory = new PokedexFactory();
        IPokemonTrainerFactory trainerFactory = new PokemonTrainerFactory();

        PokemonTrainer trainer = trainerFactory.createTrainer(name, team, pokedexFactory);

        assertEquals(name, trainer.getName());
        assertEquals(team, trainer.getTeam());
    }
}