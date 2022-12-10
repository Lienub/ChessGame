package controller;

import model.*;
import view.*;
import java.util.List;

public class MainGame {
    private static Piece[][] plateau = new Piece[8][8];
    private static List<Position> currentMoves;
    private static Position currentPos;
    private static GameViewer board_view;
    public static void main(String args[]) {


        Player player1 = new Player("Julien", 0);
        Player player2 = new Player("Rayane", 1);
        addPiece(player1.getAllPiece());
        addPiece(player2.getAllPiece());

        board_view = new GameViewer();
        board_view.displayPieces(plateau);
    }
    public static void addPiece(List<Piece> pieces) {
        for (Piece p : pieces) {
            plateau[p.getPosition().getX()][p.getPosition().getY()] = p;
        }
    }

    public static void movePiece(Piece p, Position pos) {
        p.move(plateau,pos);
        board_view.update(plateau);
    }

    public static List<Position> getCurrentMoves(){
        return currentMoves;
    }
    public static void setCurrentMoves(List<Position> moves){
        currentMoves = moves;
    }

    public static Piece[][] getPlateau(){
        return plateau;
    }
    public static Position getCurrentPos(){
        return currentPos;
    }
    public static void setCurrentPos(Position pos){
        currentPos = pos;
    }
}
