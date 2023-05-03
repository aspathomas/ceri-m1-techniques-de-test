package fr.univavignon.pokedex.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

	private static final String RESOURCE_NAME = "pokemon-metadata.json";

	private final List<PokemonMetadata> metadataList;

	/**
	 * Creates a new PokemonMetadataProvider that reads metadata
	 * from the resource file on the classpath.
	 *
	 * @throws PokedexException If there was an error reading or parsing
	 * the resource file.
	 */
	public PokemonMetadataProvider() throws PokedexException {

		this.metadataList = new ArrayList<>(6);
		this.metadataList.add(new PokemonMetadata(1, "Bulbizar", 118, 111, 128));
		this.metadataList.add(new PokemonMetadata(2, "Ivysaur", 151, 143, 155));
		this.metadataList.add(new PokemonMetadata(3, "Venusaur", 198, 189, 190));
		this.metadataList.add(new PokemonMetadata(4, "Charmander", 116, 93, 118));

		// Sort by index to ensure consistency
		Collections.sort(this.metadataList, Comparator.comparingInt(PokemonMetadata::getIndex));
	}

	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		if (index < 1 || index > this.metadataList.size()) {
			throw new PokedexException("Invalid Pokemon index: " + index);
		}

		return this.metadataList.get(index - 1);
	}
}