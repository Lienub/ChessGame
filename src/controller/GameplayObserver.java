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
        plateau = p;
        color = c;

        for (Piece[] pieces : plateau) {
            for (Piece piece : pieces) {
                if (piece != null && piece.getClass().getSimpleName().equals("King")) {
                    piece.setState(listCaptures());
                    if (Objects.equals(piece.getState(), "check")) {
                        System.out.println("Check!");
                        piece.setMove(plateau);
                        if (piece.getPossibleMoves().isEmpty()) {
                            System.out.println("Checkmate!");
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
}
