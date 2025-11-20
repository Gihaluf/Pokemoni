package poke;


public class UdensP extends Pokemons {
    private String Uelements, watershield, bubbleBeam, hydroPump;
    public UdensP(String Uelements, String name, int HP, int attackPower, int speed) {
        super(name, HP, attackPower, speed);
        this.Uelements = Uelements;
    }

    /*@Override
    public void attack(Pokemons opponent) {
    	
        int damage = getATK()+3;
        System.out.println(getVards() + " uses a water attack against " + opponent.getVards() + "!");

        opponent.health -= damage;
        if (opponent.health < 0) opponent.health = 0;

        System.out.println(opponent.getVards() + " loses " + damage + " HP! Remaining HP: " + opponent.getHP());
    }*/

    @Override
    public void weakness() {
        System.out.println(getVards() + " is weak to Electric and Grass-type attacks!");
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

	@Override
	public void uzbrukt(Pokemons opponent) {
		
	}
}
