import java.io.Serializable;

public class Ninja extends Human implements Serializable {
    public Ninja() {
        this.stealth = 10;
    }

    public Ninja(int strength, int stealth, int intelligence, int health) {
        super(strength, stealth, intelligence, health);
    }

    public void steal(Human human) {
        human.health -= this.stealth;
        this.health += this.stealth;
    }

    public void runAway() {
        this.health -= 10;
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "strength=" + strength +
                ", stealth=" + stealth +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}
