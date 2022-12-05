package controller;

import model.*;
import view.*;
import java.util.List;

public class MainGame {
    private static Piece[][] plateau = new Piece[8][8];

    public static void main(String args[]) {

        Player player1 = new Player("Julien", 0);
        Player player2 = new Player("Rayane", 1);
        addPiece(player1.getAllPiece());
        addPiece(player2.getAllPiece());
        showPlateau();


    }

    public static void addPiece(List<Piece> pieces) {
        for (Piece p : pieces) {
            plateau[p.getPosition().getX()][p.getPosition().getY()] = p;
        }
    }

    public static void showPlateau() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(plateau[i][j]+" ");
            }
            System.out.println();
        }
    }
}
