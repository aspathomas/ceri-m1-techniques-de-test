package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create Pokemon instance.
 *
 * @author fv
 */
public class PokemonFactory implements IPokemonFactory {

	/**
	 * Creates a pokemon instance computing it IVs.
	 *
	 * @param index Pokemon index.
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading pokemon.
	 * @return Created pokemon instance.
	 */
	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		PokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
		PokemonMetadata pokemonMetadata =  pokemonMetadataProvider.getPokemonMetadata(index);
		String name = pokemonMetadata.getName();
		int attack = pokemonMetadata.getAttack();
		int defense = pokemonMetadata.getDefense();
		int stamina = pokemonMetadata.getStamina();
		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, 1);
	};

}
