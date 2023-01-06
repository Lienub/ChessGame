package controller;

import com.sun.tools.javac.Main;
import model.*;

import java.util.List;
import java.util.Objects;

public class GameplayObserver implements ChessboardObserver {
    private static Piece[][] plateau;
    private static int color;

    @Override
    public void reactTo(Piece[][] p, int c) {
        System.out.println("GameplayObserver.reactTo");
        plateau = p;
        color = c;
        for (Piece[] pieces : plateau) {
            for (Piece piece : pieces) {
                if (piece != null && piece.getClass().getSimpleName().equals("King")) {
                    System.out.println("King state : " + ((King) piece).getState());
                    ((King) piece).setState(listCaptures());
                    if (Objects.equals(((King) piece).getState(), "check")) {
                        System.out.println("Check!");
                        piece.setMove(plateau);
                        if (piece.getPossibleMoves().isEmpty() || isSubset(listMoves(), piece.getPossibleMoves())) {
                            System.out.println("Checkmate!");
                            MainGame.endGame(color);
                        }
                    }
                }
            }
        }
    }
    private static List<Position> listCaptures() {
        List<Position> captures = new java.util.ArrayList<>();
        for (Piece[] pieces : plateau) {
            for (Piece piece : pieces) {
                if (piece != null && !Objects.equals(piece.getColor(), color)) {
                    piece.setMove(plateau);
                    captures.addAll(piece.getPossibleCaptures());
                }
            }
        }
        captures.removeIf(capture -> !(plateau[capture.getX()][capture.getY()] != null && plateau[capture.getX()][capture.getY()].getClass().getSimpleName().equals("King")));
        return captures;
    }

    private static List<Position> listMoves(){
        List<Position> moves = new java.util.ArrayList<>();
        for (Piece[] pieces : plateau) {
            for (Piece piece : pieces) {
                if (piece != null && !Objects.equals(piece.getColor(), color)) {
                    piece.setMove(plateau);
                    moves.addAll(piece.getPossibleMoves());
                }
            }
        }
        return moves;
    }

    private static boolean isSubset(List<Position> list1, List<Position> list2){
        int i = 0;
        int j = 0;
        for (i = 0; i < list2.size(); i++) {
            for (j = 0; j < list1.size(); j++)
                if (list2.get(i) == list2.get(j))
                    break;
            if (j == list1.size())
                return false;
        }
        return true;
    }
}
