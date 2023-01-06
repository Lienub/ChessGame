package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Piece {
    protected ArrayList<PieceObserver> Observers = new ArrayList<>();
    private Integer color;
    protected Position position;
    protected Boolean isCaptured;
    protected List<Position> possibleMoves;
    protected List<Position> possibleCaptures;
    /*Constructor*/
    public Piece(Integer color, Position position) {
        this.color = color;
        this.position = position;
        this.isCaptured = false;
        this.possibleMoves = new ArrayList<>();
        this.possibleCaptures = new ArrayList<>();
    }
    /*Observers methods*/
    public void addObserver(PieceObserver observer){
        Observers.add(observer);
    }
    public void removeObserver(PieceObserver observer){
        Observers.remove(observer);
    }
    public void notifyObservers(){
        for (PieceObserver observer : Observers) {
            observer.reactTo(this);
        }
    }
    /*Getters*/
    public Integer getColor() {
        return this.color;
    }
    public Position getPosition() {
        return this.position;
    }
    public Boolean getIsCaptured() {
        return this.isCaptured;
    }
    public List<Position> getPossibleMoves() {
        return this.possibleMoves;
    }
    public List<Position> getPossibleCaptures() {
        return this.possibleCaptures;
    }
    /*Setters*/
    public Boolean move(Piece[][] plateau, Position coord)
    {
        if(this.possibleMoves.contains(coord) || this.possibleCaptures.contains(coord)){
            plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
            setPosition(coord);
            plateau[coord.getX()][coord.getY()] = this;
            notifyObservers();
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
    public void setIsCaptured(Piece[][] plateau, Boolean isCaptured) {
        this.isCaptured = isCaptured;
        plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
        notifyObservers();
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
