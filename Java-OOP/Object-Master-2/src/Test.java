public class Test {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Ninja ninja = new Ninja();
        Samurai samurai1 = new Samurai();
        Samurai samurai2 = new Samurai();

        System.out.println(ninja.toString());
        wizard.heal(ninja);
        System.out.println(ninja.toString());
        wizard.fireball(ninja);
        System.out.println(ninja.toString());
        ninja.runAway();
        System.out.println(ninja.toString());
        System.out.println(samurai1.toString());
        System.out.println(samurai1.howMany());
        samurai1.meditate();
        System.out.println(samurai1.toString());
        samurai1.deathBlow(samurai2);
        System.out.println(samurai1.toString());
        System.out.println(samurai2.toString());
    }
}
