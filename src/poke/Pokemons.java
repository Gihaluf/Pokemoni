package poke;

public abstract class Pokemons {
	private String name;
    private int health;
    private int attackPower;
    private int speed;

    public Pokemons(String name, int HP, int attackPower, int speed) {
        this.name = name;
        this.health = HP;
        this.attackPower = attackPower;
        this.speed = speed;
    }

    public String getVards() {
        return name;
    }
    public void setVards(String name) {
    	this.name=name;
    }

    public int getHP() {
        return health;
    }
    public void setHP(int HP) {
    	health=HP;
    }
    
    public int getATK() {
        return attackPower;
    }
    public void setATK(int atk) {
    	attackPower = atk;
    }

    public int getSPD() {
        return speed;
    }
    public void setSPD(int SPD) {
    	speed = SPD;
    }

    public void heal(int amount) {
        health += amount;
        
    }

    public void evolucija() {
        attackPower += 10;
        speed += 5;
        
    }

    public abstract String uzbrukt(Pokemons opponent);

    public void weakness() {
        System.out.println(name + " has no specific weaknesses.");

    }
}
