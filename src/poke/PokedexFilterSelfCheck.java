package poke;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokedexFilterSelfCheck {

    public static void runChecks() {
        String[] names = {"Squirtle", "Wartortle", "Elekid"};
        Set<String> seen = new HashSet<>(Arrays.asList("Squirtle", "Elekid"));
        Set<String> caught = new HashSet<>(Arrays.asList("Elekid"));

        List<Integer> seenOnly = PokedexFilter.filterIndexes(names, "", "Seen", seen, caught);
        if (!seenOnly.equals(Arrays.asList(0, 2))) {
            throw new IllegalStateException("Seen filter failed");
        }

        List<Integer> caughtOnly = PokedexFilter.filterIndexes(names, "", "Caught", seen, caught);
        if (!caughtOnly.equals(Arrays.asList(2))) {
            throw new IllegalStateException("Caught filter failed");
        }

        List<Integer> unseen = PokedexFilter.filterIndexes(names, "", "Unseen", seen, caught);
        if (!unseen.equals(Arrays.asList(1))) {
            throw new IllegalStateException("Unseen filter failed");
        }

        List<Integer> searched = PokedexFilter.filterIndexes(names, "war", "All", seen, caught);
        if (!searched.equals(Arrays.asList(1))) {
            throw new IllegalStateException("Search filter failed");
        }
    }
}
