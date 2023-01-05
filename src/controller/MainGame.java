package controller;

import model.*;
import view.*;
import java.util.List;

public class MainGame {
    public static Piece[][] plateau = new Piece[8][8];
    private static List<Position> currentMoves;
    private static List<Position> currentCaptures;
    private static Position currentPos;
    private static Player currentPlayer;
    private static Player player1;
    private static Player player2;

    public static GameViewer board_view;

    public static GameMenu menu_view;

    public static void main(String args[]) {
        menu_view = new GameMenu();
    }

    public static void startGame(){
        player1 = new Player(menu_view.getNameP1(), 0);
        player2 = new Player(menu_view.getNameP2(), 1);
        currentPlayer = player1;
        addPiece(player1.getAllPiece());
        addPiece(player2.getAllPiece());
        for(Piece p : player1.getAllPiece()){
            p.addObserver(new GraphicalObserver());
        }
        for(Piece p : player2.getAllPiece()){
            p.addObserver(new GraphicalObserver());
        }
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
        if (currentPlayer == player1) {
            currentPlayer = player2;
        }
        else{
            currentPlayer = player1;
        }
        System.out.println("J'ai bougé");
        System.out.println("Tour au joueur "+ currentPlayer.getName());
    }

    public static void capturePiece(Piece p) {
        if (p.getColor() == 0) {
            player2.removePiece(plateau,p);
        }
        else{
            player1.removePiece(plateau,p);
        }
        System.out.println("Je vais bouger?");


        System.out.println("Tour de "+ currentPlayer.getName());
    }
    public static List<Position> getCurrentMoves(){
        return currentMoves;
    }
    public static void setCurrentMoves(List<Position> moves){
        currentMoves = moves;
    }
    public static List<Position> getCurrentCaptures(){
        return currentCaptures;
    }
    public static void setCurrentCaptures(List<Position> captures){
        currentCaptures = captures;
    }
    public static Piece[][] getPlateau(){
        return plateau;
    }
    public static Position getCurrentPos(){
        return currentPos;
    }

    public static Player getCurrentPlayer(){
        return currentPlayer;
    }
    public static void setCurrentPos(Position pos){
        currentPos = pos;
    }
}
