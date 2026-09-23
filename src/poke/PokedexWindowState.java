package poke;

public class PokedexWindowState {
    public static int normalizeIndex(int index, int size) {
        if (size <= 0) {
            return 0;
        }
        if (index >= size) {
            return 0;
        }
        if (index < 0) {
            return size - 1;
        }
        return index;
    }
}
