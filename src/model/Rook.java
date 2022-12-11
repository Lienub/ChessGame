package model;

import java.util.Objects;

public class Rook extends Piece{
    public Rook(Integer color, Position position) {
        super(color, position);
    }
    @Override
    public void setMove(Piece[][] plateau) {
        possibleMoves.clear();
        int pX = this.getPosition().getX(), pY = this.getPosition().getY();

        for (int j = pY + 1; j < plateau.length; j++) {
            if (addMove(plateau, j, pX)) break;
            if (addMove(plateau, pY, j)) break;
        }
        for (int j = pY - 1; j > -1; j--) {
            if (addMove(plateau, j, pX)) break;
            if (addMove(plateau, pY, j)) break;
        }

    }

    private boolean addMove(Piece[][] plateau, int j, int i) {
        if (plateau[i][j] == null) {
            possibleMoves.add(new Position(i, j));
            return false;
        } else if (!Objects.equals(plateau[i][j].getColor(), this.getColor())) {
            possibleMoves.add(new Position(i, j));
            return true;
        } else {
            return true;
        }
    }

}
