package poke;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveManager {
    private static final String SAVE_DIR = "save";
    private static final String SAVE_FILE = SAVE_DIR + "/game_state.dat";

    public static void save(GameState state) throws IOException {
        File dir = new File(SAVE_DIR);
        if (!dir.exists() && !dir.mkdirs()) {
            throw new IOException("Failed to create save directory");
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            out.writeObject(state);
        }
    }

    public static GameState load() throws IOException, ClassNotFoundException {
        File file = new File(SAVE_FILE);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (GameState) in.readObject();
        }
    }
}
