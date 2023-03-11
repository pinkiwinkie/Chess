package game;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class File {
    public static void save(Game game, String file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(game);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
