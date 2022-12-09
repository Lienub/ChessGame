package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {
    private Integer color;
    protected Position position;
    protected Boolean isCaptured;
    protected List<Position> possibleMoves;

    public Piece(Integer color, Position position) {
        this.color = color;
        this.position = position;
        this.isCaptured = false;
        this.possibleMoves = new ArrayList<>();
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

    public Boolean move(Position coord)
    {
        if(this.possibleMoves.contains(coord)){
            setPosition(coord);
            possibleMoves.clear();
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

    public void setMove(Piece[][] plateau, Position coord) {
        this.possibleMoves = null;
    }

    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }
}
