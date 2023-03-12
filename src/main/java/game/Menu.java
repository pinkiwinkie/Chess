package game;

import tools.Input;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.IOException;
import java.io.Serializable;

public class Menu implements Serializable {
    /**
     * menu of game
     */
    public static void menu(){
        boolean exit = false;
        Game game,gameAux;
        do {
            int option = Input.getInt("Choose an option: \n1. How to play. \n2. Play. \n3.Load game. \n4. Exit");
            if (option == 1)
                System.out.println("Chess is a turn-based game, in which the white pieces always start, " +
                        "and whose purpose is to defeat the king of the opposing team by checkmate," +
                        " that is, to leave him without possible movements.");
            else if (option == 2) {
                game = new Game();
                game.start();
            } else if (option == 3) {
                try {
//                    File file = fileChooser();
//                    gameAux = File.load(file);
//                    assert gameAux != null;
//                    gameAux.start();
                }catch (Exception e){
                    System.err.println("mistake");
                }
            } else if (option == 4) {
                exit = true;
            }else{
                System.err.println("Introduce a valid number");
            }
        }while(!exit);
    }

//    private static File fileChooser(){
//        java.io.File file = null;
//        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());
//        jfc.setDialogTitle("Choose a file to load your game.");
//        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
//
//        int returnValue = jfc.showSaveDialog(null);
//        if (returnValue == JFileChooser.APPROVE_OPTION){
//            if (jfc.getSelectedFile().isFile())
//                file = jfc.getSelectedFile();
//        }
//        return file;
//    }
}
