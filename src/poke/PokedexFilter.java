package poke;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PokedexFilter {
    public static List<Integer> filterIndexes(String[] names, String query, String filter, Set<String> seen, Set<String> caught) {
        String q = query == null ? "" : query.trim().toLowerCase();
        return java.util.stream.IntStream.range(0, names.length)
                .filter(i -> q.isEmpty() || names[i].toLowerCase().contains(q))
                .filter(i -> {
                    String n = names[i];
                    if ("Seen".equals(filter)) return seen.contains(n);
                    if ("Caught".equals(filter)) return caught.contains(n);
                    if ("Unseen".equals(filter)) return !seen.contains(n) && !caught.contains(n);
                    return true;
                })
                .boxed()
                .collect(Collectors.toList());
    }
}
