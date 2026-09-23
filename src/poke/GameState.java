package poke;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameState implements Serializable {
    private static final long serialVersionUID = 1L;

    public static class PokemonData implements Serializable {
        private static final long serialVersionUID = 1L;
        public String type;
        public String name;
        public int hp;
        public int atk;
        public int spd;
    }

    public List<PokemonData> captured = new ArrayList<>();
    public int pokeball;
    public int mediumball;
    public int ultraball;
    public int pokedexIndex;
    public Set<String> seen = new HashSet<>();
    public Set<String> caught = new HashSet<>();
    public int playerWorldX;
    public int playerWorldY;
    public boolean worldItemCollected;
}
