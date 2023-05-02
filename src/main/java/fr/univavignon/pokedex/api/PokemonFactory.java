package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory {

    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		try {
			PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
			PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);
	
			int attack = metadata.getAttack();
			int defense = metadata.getDefense();
			int stamina = metadata.getStamina();
			double iv = computeIV(cp, hp, dust, candy, attack, defense, stamina);
	
			return new Pokemon(index, metadata.getName(), attack, defense, stamina, cp, hp, dust, candy, iv);
		} catch (PokedexException e) {
			throw new IllegalArgumentException("Failed to create Pokemon", e);
		}
	}

    private double computeIV(int cp, int hp, int dust, int candy, int attack, int defense, int stamina) {
        // IV = (CP * 10 / sqrt(Attack * Defense * Stamina)) - 2 * dust / candy
        double iv = (cp * 10.0 / Math.sqrt(attack * defense * stamina)) - 2.0 * dust / candy;
        return Math.max(0, iv); // IV should be between 0 and 1, inclusive
    }
}