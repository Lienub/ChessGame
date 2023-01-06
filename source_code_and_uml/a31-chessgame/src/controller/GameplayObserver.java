package controller;

import model.*;

import java.util.List;
import java.util.Objects;

public class GameplayObserver implements ChessboardObserver {
    private static Piece[][] plateau;

    @Override
    public void reactTo(Piece[][] p) {
        System.out.println("GameplayObserver.reactTo");
        plateau = p;
        for (Piece[] pieces : plateau) {
            for (Piece piece : pieces) {
                if (piece != null && piece.getClass().getSimpleName().equals("King")) {
                    ((King) piece).setState(listCaptures(piece));
                    System.out.println("list" + listCaptures(piece));
                    String state = ((King) piece).getState();
                    Player player;
                    if(piece.getColor() == 0)
                        player = MainGame.player1;
                    else {
                        player = MainGame.player2;
                    }
                    System.out.println("King_" + piece.getColor() + "state : " + state);
                    if (Objects.equals(state, "check")) {
                        System.out.println("Check!");
                        piece.setMove(plateau);
                        MainGame.board_view.displayCheck(player, state);
                        if (piece.getPossibleMoves().isEmpty() || isSubset(listMoves(piece), piece.getPossibleMoves())) {
                            System.out.println("Checkmate!");
                            MainGame.endGame(player.getColor());
                        }
                    }
                    else{
                        MainGame.board_view.resetCheck(player);
                    }
                }
            }
        }
    }
    private static List<Position> listCaptures(Piece p) {
        List<Position> captures = new java.util.ArrayList<>();
        for (Piece[] pieces : plateau) {
            for (Piece piece : pieces) {
                if (piece != null && !Objects.equals(piece.getColor(), p.getColor())) {
                    piece.setMove(plateau);
                    captures.addAll(piece.getPossibleCaptures());
                }
            }
        }
        captures.removeIf(capture -> !(plateau[capture.getX()][capture.getY()] != null && plateau[capture.getX()][capture.getY()].getClass().getSimpleName().equals("King")));
        return captures;
    }

    private static List<Position> listMoves(Piece p){
        List<Position> moves = new java.util.ArrayList<>();
        for (Piece[] pieces : plateau) {
            for (Piece piece : pieces) {
                if (piece != null && !Objects.equals(piece.getColor(), p.getColor())) {
                    piece.setMove(plateau);
                    moves.addAll(piece.getPossibleMoves());
                }
            }
        }
        return moves;
    }

    private static boolean isSubset(List<Position> list1, List<Position> list2){
        int count = 0;
        for(Position pos1 : list1){
            for(Position pos2 : list2){
                if(pos1.equals(pos2))
                    count++;
            }
        }
        System.out.println("list2.size : " + list2.size());
        System.out.println("list1.size : " + list1.size());
        System.out.println("count : " + count);
        return count == list2.size();
    }
}
