package game;

import java.io.*;

public class File {
    /**
     * @param game that do you want save
     */
    public static void save(Game game) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game.txt"))) {
            oos.writeObject(game);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     *
     * @return Game that you saved.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Game load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("game.txt")))) {
            return (Game)ois.readObject();
        } catch (EOFException ignored) {
            return null;
        }
    }
}
