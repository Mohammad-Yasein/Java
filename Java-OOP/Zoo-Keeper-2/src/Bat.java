public class Bat extends Mammal {
    public Bat() {
        super(300);
    }

    public Bat(int energyLevel) {
        super(energyLevel);
    }

    public void fly() {
        System.out.println("Sound a bat taking off ...");
        this.setEnergyLevel(this.getEnergyLevel() - 50);
    }

    public void eatHumans() {
        System.out.println("So-well, never mind ...");
        this.setEnergyLevel(this.getEnergyLevel() + 25);
    }

    public void attackTown() {
        System.out.println("Sound of a town on fire ...");
        this.setEnergyLevel(this.getEnergyLevel() - 100);
    }
}
