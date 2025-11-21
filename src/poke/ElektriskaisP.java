package poke;

public class ElektriskaisP extends Pokemons {
    private String Eelements, overcharge, speedBoost;
    public ElektriskaisP(String Eelements, String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
        this.Eelements = Eelements;
    }

    @Override
    public String uzbrukt(Pokemons opponent) {
    	String txt;
        int damage = this.getATK()+ 7; 
        txt = (this.getVards() + " uses static electricity against " + opponent.getVards() + "!");
        int hploss = opponent.getHP() - damage;
        opponent.setHP(hploss);
        if (opponent.getHP() < 0) opponent.setHP(0);

        txt=(opponent.getVards() + " loses " + damage + " HP! Remaining HP: " + opponent.getHP());
		return txt;
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
