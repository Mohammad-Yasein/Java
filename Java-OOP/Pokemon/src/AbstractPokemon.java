import java.io.Serializable;

public abstract class AbstractPokemon implements Serializable, PokemonInterface {
    @Override
    public Pokemon createPokemon(String name, int health, String type) {
        return new Pokemon(name, health, type);
    }

    @Override
    public String pokemonInfo(Pokemon pokemon) {
        return pokemon.toString();
    }
}
