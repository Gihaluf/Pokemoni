package poke;

public class ElektriskaisP extends Pokemons {
    private String Eelements, overcharge, speedBoost;
    public ElektriskaisP(String Eelements, String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
        this.Eelements = Eelements;
    }

    @Override
	public void uzbrukt(Pokemons opponent) {
    			int damage = this.getATK() + 7;
    			opponent.setHP(opponent.getHP() - damage);
    			if (opponent.getHP() < 0) opponent.setHP(0);
    }

    @Override
    public void weakness() {
    String weaknessType = "Earth-type attacks";
    }

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
	}