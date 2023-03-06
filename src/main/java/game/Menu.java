package game;

import tools.Input;

public class Menu {
    public static void menu(){
        boolean exit = false;
        Game game;
        do {
            int option = Input.getInt("Choose an option: \n1. How to play. \n2. Play. \n3. Exit");
            if (option == 1)
                System.out.println("Chess is a turn-based game, in which the white pieces always start, " +
                        "and whose purpose is to defeat the king of the opposing team by checkmate," +
                        " that is, to leave him without possible movements.");
            else if (option == 2) {
                game = new Game();
                game.start();
            } else if (option == 3) {
                exit = true;
            }else{
                System.out.println("Introduce a valid number");
            }
        }while(!exit);
    }
}