package model;

import java.util.Objects;

public class King extends Piece {
    private Boolean isUndefendable;

    public King(Integer color, Position position) {
        super(color, position);
    }


    public Boolean getIsUndefendable() {
        return this.isUndefendable;
    }

    public void setIsUndefendable (Boolean isUndefendable) {
        this.isUndefendable = isUndefendable;
    }
    @Override
    public void setMove(Piece[][] plateau){
        possibleMoves.clear();
        int pX = this.getPosition().getX(), pY = this.getPosition().getY();

        if(pX+1 < plateau.length && (plateau[pX+1][pY] == null))
            possibleMoves.add(new Position(pX+1, pY));
        if(pX-1 > -1 && (plateau[pX-1][pY] == null))
            possibleMoves.add(new Position(pX-1, pY));
        if(pY+1 < plateau.length && (plateau[pX][pY+1] == null ))
            possibleMoves.add(new Position(pX, pY+1));
        if(pY-1 > -1 && (plateau[pX][pY-1] == null))
            possibleMoves.add(new Position(pX, pY-1));
        if(pX+1 < plateau.length && pY+1 < plateau.length && (plateau[pX+1][pY+1] == null))
            possibleMoves.add(new Position(pX+1, pY+1));
        if(pX+1 < plateau.length && pY-1 > -1 && (plateau[pX+1][pY-1] == null))
            possibleMoves.add(new Position(pX+1, pY-1));
        if(pX-1 > -1 && pY+1 < plateau.length && (plateau[pX-1][pY+1] == null))
            possibleMoves.add(new Position(pX-1, pY+1));
        if(pX-1 > -1 && pY-1 > -1 && (plateau[pX-1][pY-1] == null))
            possibleMoves.add(new Position(pX-1, pY-1));
    }
}