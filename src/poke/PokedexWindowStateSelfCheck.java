package poke;

public class PokedexWindowStateSelfCheck {
    public static void runChecks() {
        if (PokedexWindowState.normalizeIndex(0, 0) != 0) {
            throw new IllegalStateException("Empty state normalization failed");
        }
        if (PokedexWindowState.normalizeIndex(5, 3) != 0) {
            throw new IllegalStateException("Overflow index normalization failed");
        }
        if (PokedexWindowState.normalizeIndex(-1, 3) != 2) {
            throw new IllegalStateException("Underflow index normalization failed");
        }
        if (PokedexWindowState.normalizeIndex(1, 3) != 1) {
            throw new IllegalStateException("In-range index normalization failed");
        }
    }
}
