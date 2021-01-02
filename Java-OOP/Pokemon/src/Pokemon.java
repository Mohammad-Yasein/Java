import java.io.Serializable;

public class Pokemon implements Serializable {
    private String name = "";
    private int health = 100;
    private String type = "";
    private static int pokemonsCount = 0;

    public Pokemon() {
        pokemonsCount++;
    }

    public Pokemon(String name, int health, String type) {
        this.name = name;
        this.health = health;
        this.type = type;
        pokemonsCount++;
    }

    public void attackPokemon(Pokemon pokemon) {
        pokemon.health -= 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static int getPokemonCount() {
        return pokemonsCount;
    }

    public static void setPokemonCount(int pokemonsCount) {
        Pokemon.pokemonsCount = pokemonsCount;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", type='" + type + '\'' +
                '}';
    }
}
