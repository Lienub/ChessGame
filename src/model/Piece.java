package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Piece {
    private Integer color;
    protected Position position;
    protected Boolean isCaptured;
    protected List<Position> possibleMoves;
    protected List<Position> possibleCaptures;

    public Piece(Integer color, Position position) {
        this.color = color;
        this.position = position;
        this.isCaptured = false;
        this.possibleMoves = new ArrayList<>();
        this.possibleCaptures = new ArrayList<>();
    }


    public Integer getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }

    public Boolean getIsCaptured() {
        return null;
    }

    public List<Position> getPossibleMoves() {
        return this.possibleMoves;
    }

    public List<Position> getPossibleCaptures() {
        return this.possibleCaptures;
    }

    public Boolean move(Piece[][] plateau, Position coord)
    {
        if(this.possibleMoves.contains(coord)){
            plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
            setPosition(coord);
            plateau[coord.getX()][coord.getY()] = this;
            System.out.println("c'est bougé");
            return true;
        }
        return false;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }

    public void setMove(Piece[][] plateau) {
        return;
    }

    public void setCapture(Piece[][] plateau) {
        for (Position moves : possibleMoves) {
            if (plateau[moves.getX()][moves.getY()] != null && !Objects.equals(plateau[moves.getX()][moves.getY()].getColor(), this.getColor())) {
                possibleCaptures.add(moves);
            }
        }

        for (Position moves : possibleCaptures){
            possibleMoves.remove(moves);
        }
    }

}
