package poke;

public class ElektriskaisP extends Pokemons {
    private String elements, overcharge, speedBoost;
    public ElektriskaisP(String elements, String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
        this.elements = elements;
    }

    @Override
    public void attack(Pokemons opponent) {
        int damage = this.attackPower + 5; 
        System.out.println(name + " uses static electricity against " + opponent.getVards() + "!");

        opponent.health -= damage;
        if (opponent.health < 0) opponent.health = 0;

        System.out.println(opponent.getVards() + " loses " + damage + " HP! Remaining HP: " + opponent.getHP());
    }

    @Override
    public void weakness() {
        System.out.println(name + " is weak to Ground-type attacks!");
    }

    public String getElements() {
        return elements;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String getSpeedBoost() {
        return speedBoost;
    }

    public void setSpeedBoost(String speedBoost) {
        this.speedBoost = speedBoost;
    }

    public String getOvercharge() {
        return overcharge;
    }

    public void setOvercharge(String overcharge) {
        this.overcharge = overcharge;
    }

}