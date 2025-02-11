package model;

import java.util.Objects;

public class Pawn extends Piece {
    private Boolean isPromoted;
    private Boolean isPromotable;
    private Boolean firstMove;

    public Pawn(Integer color, Position position) {
        super(color, position);
        setIsPromoted(false);
        setIsPromotable(false);
        firstMove = true;
    }

    public Boolean getIsPromoted() {
        return this.isPromoted;
    }

    public Boolean getIsPromotable() {
        return this.isPromotable;
    }

    @Override
    public Boolean move(Piece[][] plateau, Position coord) {
        if(this.possibleMoves.contains(coord) || this.possibleCaptures.contains(coord)){
            plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
            setPosition(coord);
            plateau[coord.getX()][coord.getY()] = this;
            notifyObservers();
            System.out.println("c'est bougé");
            this.firstMove = false;
            return true;
        }
        return false;
    }
    public void setIsPromoted(Boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    public void setIsPromotable(Boolean isPromotable) {
        this.isPromotable = isPromotable;
    }
    @Override
    public void setMove(Piece[][] plateau) {
        possibleMoves.clear();
        possibleCaptures.clear();

        int side, pX = this.getPosition().getX(), pY = this.getPosition().getY();
        System.out.println("Pawn: pX = " + pX + " pY = " + pY);

        if(this.getColor() == 0) { System.out.println("Color White"); side = -1; }
        else { System.out.println("Color Black"); side = 1; }

        if(pY+1 < plateau.length && pY-1 > -1 && plateau[pX][pY+(1*side)] == null) {
            System.out.println("Personne devant");
            if(this.firstMove){
                System.out.println("Premier mouvement");
                if(plateau[pX][pY+2*side] == null) {
                    this.possibleMoves.add(new Position(pX,pY + 2 * side));
                    //System.out.println("Personne devant+1\nPossible move : " + pX + " " + (pY + 2 * side));
                }
            }
            this.possibleMoves.add(new Position(pX,pY + 1 * side));
            //System.out.println("Possible move : " + pX + " " + (pY+1*side));
        }
        if(pX+1 < plateau.length && pY+1 < plateau.length && pY-1 > -1 && plateau[pX+1][pY+1*side] != null && !Objects.equals(plateau[pX + 1][pY + 1 * side].getColor(), this.getColor()) && !plateau[pX + 1][pY + 1 * side].getClass().getSimpleName().equals("King")) {
            this.possibleCaptures.add(new Position(pX+1, pY+1*side));
            //System.out.println("Ennemi dispo devant 1\nPossible move : " + (pX+1) + " " + (pY+1*side))
        }
        if(pX-1 > -1 && pY+1 < plateau.length && pY-1 > -1 && plateau[pX-1][pY+1*side] != null && !Objects.equals(plateau[pX - 1][pY + 1 * side].getColor(), this.getColor()) && !plateau[pX - 1][pY + 1 * side].getClass().getSimpleName().equals("King")) {
            this.possibleCaptures.add(new Position(pX-1, pY+1*side));
            //System.out.println("Ennemi dispo devant 2\nPossible move : " + (pX-1) + " " + (pY+1*side))
        }

    }
}
