import java.io.Serializable;

public class PokedexTest implements Serializable {
    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        Pokemon pokemon1 = pokedex.createPokemon("pokemon1", 200, "type1");
        Pokemon pokemon2 = pokedex.createPokemon("pokemon2", 300, "type2");
        pokemon1.attackPokemon(pokemon2);
        pokedex.listPokemon();
        System.out.println(pokedex.pokemonInfo(pokemon1));
        System.out.println(pokedex.pokemonInfo(pokemon2));
    }
}
