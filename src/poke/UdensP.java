package poke;


public class UdensP extends Pokemons {
    private String Uelements, watershield, bubbleBeam, hydroPump;
    public UdensP(String Uelements, String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
        this.Uelements = Uelements;
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
    String weaknessType = "Electric and Earth-type attacks";
    }
    
    public String getElements() {
        return Uelements;
    }

    public void setElements(String elements) {
        this.Uelements = elements;
    }
    public String getHydroPump() {
        return hydroPump;
    }

    public void setHydroPump(String hydroPump) {
        this.hydroPump = hydroPump;
    }

    public String getWatershield() {
        return watershield;
    }

    public void setWatershield(String watershield) {
        this.watershield = watershield;
    }

    public String getBubbleBeam() {
        return bubbleBeam;
    }

    public void setBubbleBeam(String bubbleBeam) {
        this.bubbleBeam = bubbleBeam;
    }
}
