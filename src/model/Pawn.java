package model;

import java.util.Objects;

public class Pawn extends Piece {
    private Boolean isPromotable = false;
    private Boolean firstMove;

    public Pawn(Integer color, Position position) {
        super(color, position);
        firstMove = true;
    }

    @Override
    public Boolean move(Piece[][] plateau, Position coord) {
        if(this.possibleMoves.contains(coord) || this.possibleCaptures.contains(coord)){
            plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
            setPosition(coord);
            plateau[coord.getX()][coord.getY()] = this;
            notifyObservers();
            this.firstMove = false;
            return true;
        }
        return false;
    }

    public Boolean getIsPromotable() {
        return this.isPromotable;
    }

    public void setIsPromotable() {
        int row;
        if(this.getColor() == 0){
            row = 0;
        } else {
            row = 7;
        }
        for (int i = 0 ; i < 8 ; i++){
            if(this.position.equals(new Position(i, row))){
                this.isPromotable = true;
                break;
            }
            else{
                this.isPromotable = false;
            }
        }
    }
    @Override
    public void setMove(Piece[][] plateau) {
        possibleMoves.clear();
        possibleCaptures.clear();

        int side, pX = this.getPosition().getX(), pY = this.getPosition().getY();

        if(this.getColor() == 0) {side = -1; }
        else {side = 1; }

        if(pY+1 < plateau.length && pY-1 > -1 && plateau[pX][pY+(1*side)] == null) {
            if(this.firstMove){
                if(plateau[pX][pY+2*side] == null) {
                    this.possibleMoves.add(new Position(pX,pY + 2 * side));
                    //System.out.println("Personne devant+1\nPossible move : " + pX + " " + (pY + 2 * side));
                }
            }
            this.possibleMoves.add(new Position(pX,pY + 1 * side));
            //System.out.println("Possible move : " + pX + " " + (pY+1*side));
        }
        if(pX+1 < plateau.length && pY+1 < plateau.length && pY-1 > -1 && plateau[pX+1][pY+1*side] != null && !Objects.equals(plateau[pX + 1][pY + 1 * side].getColor(), this.getColor())) {
            this.possibleCaptures.add(new Position(pX+1, pY+1*side));
            //System.out.println("Ennemi dispo devant 1\nPossible move : " + (pX+1) + " " + (pY+1*side))
        }
        if(pX-1 > -1 && pY+1 < plateau.length && pY-1 > -1 && plateau[pX-1][pY+1*side] != null && !Objects.equals(plateau[pX - 1][pY + 1 * side].getColor(), this.getColor())) {
            this.possibleCaptures.add(new Position(pX-1, pY+1*side));
            //System.out.println("Ennemi dispo devant 2\nPossible move : " + (pX-1) + " " + (pY+1*side))
        }

    }
}
