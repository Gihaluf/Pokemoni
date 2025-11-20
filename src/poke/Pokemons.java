package poke;

public abstract class Pokemons {
    protected String name;
    protected int health;
    protected int attackPower;
    protected int speed;

    public Pokemons(String name, int HP, int attackPower, int speed) {
        this.name = name;
        this.health = HP;
        this.attackPower = attackPower;
        this.speed = speed;
    }

    public String getVards() {
        return name;
    }

    public int getHP() {
        return health;
    }

    public void heal(int amount) {
        health += amount;
        System.out.println(name + " Izarstēts par " + amount + " HP!");
    }

    public void evolucija() {
        attackPower += 10;
        speed += 5;
        System.out.println(name + " ir evolucejis un tagad ir spēcīgāks!");
    }

    public abstract void attack(Pokemons opponent);

    public void weakness() {
        System.out.println(name + " has no specific weaknesses.");

    }
}
