package poke;

public class ElektriskaisP extends Pokemons {
    private String Eelements, overcharge, speedBoost;
    public ElektriskaisP(String Eelements, String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
        this.Eelements = Eelements;
    }

    /*@Override
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
    }*/

    public String getElements() {
        return Eelements;
    }

    public void setElements(String elements) {
        this.Eelements = elements;
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

	@Override
	public void uzbrukt(Pokemons opponent) {
		// TODO Auto-generated method stub
		
	}

}