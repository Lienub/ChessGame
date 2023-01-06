package model;

import java.util.Objects;

public class Knight extends Piece{
    public Knight(Integer color, Position position) {
        super(color, position);
    }

    @Override
    public void setMove(Piece[][] plateau) {
        possibleMoves.clear();
        possibleCaptures.clear();

        int  pX = this.getPosition().getX(), pY = this.getPosition().getY();

        if(pX+2 < plateau.length && pY+1 < plateau.length && (plateau[pX+2][pY+1] == null || !Objects.equals(plateau[pX + 2][pY + 1].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX + 2, pY + 1));
        if(pX+2 < plateau.length && pY-1 > -1 && (plateau[pX+2][pY-1] == null || !Objects.equals(plateau[pX + 2][pY - 1].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX + 2, pY - 1));
        if(pX-2 > -1 && pY+1 < plateau.length && (plateau[pX-2][pY+1] == null || !Objects.equals(plateau[pX - 2][pY + 1].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX - 2, pY + 1));
        if(pX-2 > -1 && pY-1 > -1 && (plateau[pX-2][pY-1] == null || !Objects.equals(plateau[pX - 2][pY - 1].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX - 2, pY - 1));
        if(pX+1 < plateau.length && pY+2 < plateau.length && (plateau[pX+1][pY+2] == null || !Objects.equals(plateau[pX + 1][pY + 2].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX+1, pY+2));
        if(pX+1 < plateau.length && pY-2 > -1 && (plateau[pX+1][pY-2] == null || !Objects.equals(plateau[pX + 1][pY - 2].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX+1, pY-2));
        if(pX-1 > -1 && pY+2 < plateau.length && (plateau[pX-1][pY+2] == null || !Objects.equals(plateau[pX - 1][pY + 2].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX-1, pY+2));
        if(pX-1 > -1 && pY-2 > -1 && (plateau[pX-1][pY-2] == null || !Objects.equals(plateau[pX - 1][pY - 2].getColor(), this.getColor())))
            possibleMoves.add(new Position(pX-1, pY-2));

        setCapture(plateau);

    }
}
