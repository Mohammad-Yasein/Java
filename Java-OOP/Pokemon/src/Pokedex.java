import java.io.Serializable;
import java.util.ArrayList;

public class Pokedex extends AbstractPokemon implements Serializable {
    private ArrayList<Pokemon> myPokemons = new ArrayList<>();

    @Override
    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon pokemon = new Pokemon(name, health, type);
        myPokemons.add(pokemon);
        return pokemon;
    }

    @Override
    public void listPokemon() {
        for (Pokemon pokemon : myPokemons) {
            System.out.println(pokemon.getName());
        }
    }
}
