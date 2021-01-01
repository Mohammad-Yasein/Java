import java.io.Serializable;

public class Wizard extends Human implements Serializable {
    public Wizard() {
        this.intelligence = 8;
        this.health = 50;
    }

    public Wizard(int strength, int stealth, int intelligence, int health) {
        super(strength, stealth, intelligence, health);
    }

    public void heal(Human human) {
        human.health += this.intelligence;
    }

    public void fireball(Human human) {
        human.health -= this.intelligence * 3;
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "strength=" + strength +
                ", stealth=" + stealth +
                ", intelligence=" + intelligence +
                ", health=" + health +
                '}';
    }
}
