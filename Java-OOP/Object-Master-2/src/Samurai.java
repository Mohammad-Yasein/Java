import java.io.Serializable;

public class Samurai extends Human implements Serializable {
    private static int numOfSamurai = 0;

    public Samurai() {
        this.health = 200;
        Samurai.numOfSamurai++;
    }

    public Samurai(int strength, int stealth, int intelligence, int health) {
        super(strength, stealth, intelligence, health);
        Samurai.numOfSamurai++;
    }

    public void deathBlow(Human human) {
        human.health = 0;
        this.health /= 2;
    }

    public void meditate() {
        int currentHealth = this.health;
        this.health = currentHealth + (currentHealth / 2);
    }

    public int howMany() {
        return Samurai.numOfSamurai;
    }

    @Override
    public String toString() {
        return "Samurai{" +
                "strength=" + strength +
                ", stealth=" + stealth +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}
