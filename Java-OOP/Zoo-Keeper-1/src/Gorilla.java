public class Gorilla extends Mammal {
    public void throwSomething() {
        System.out.println("The gorilla has thrown something ...");
        this.setEnergy(this.displayEnergy() - 5);
    }

    public void eatBananas() {
        System.out.println("The gorilla has eaten bananas ...");
        this.setEnergy(this.displayEnergy() + 10);
    }

    public void climb() {
        System.out.println("The gorilla has climbed a tree ...");
        this.setEnergy(this.displayEnergy() - 10);
    }
}
