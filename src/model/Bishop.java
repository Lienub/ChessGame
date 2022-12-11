package model;

import java.util.Objects;

public class Bishop extends Piece{
    public Bishop(Integer color, Position position) {
        super(color, position);
    }
    @Override
    public void setMove(Piece[][] plateau) {
        possibleMoves.clear();
        int  pX = this.getPosition().getX(), pY = this.getPosition().getY();

        for (int j = pY + 1, i = pX + 1; j < plateau.length && i < plateau.length ; j++, i++) {
            if (addMove(plateau, j, i)) break;
        }

        for (int j = pY - 1, i = pX + 1; j < -1 && i < plateau.length ; j--, i++) {
            if (addMove(plateau, j, i)) break;
        }

        for (int j = pY - 1, i = pX - 1; j < -1 && i < -1 ; j--, i--) {
            if (addMove(plateau, j, i)) break;
        }

        for (int j = pY + 1, i = pX - 1; j < plateau.length && i < -1 ; j++, i--) {
            if (addMove(plateau, j, i)) break;
        }
    }

    private boolean addMove(Piece[][] plateau, int j, int i) {
        Piece cur_pos = plateau[i][j];
        if (cur_pos == null) {
            possibleMoves.add(new Position(i, j));
        } else if (!Objects.equals(cur_pos.getColor(), this.getColor())) {
            possibleMoves.add(new Position(i, j));
            return true;
        } else {
            return true;
        }
        return false;
    }
}
