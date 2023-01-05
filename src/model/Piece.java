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

    public Piece(Integer color, Position position) {
        this.color = color;
        this.position = position;
        this.isCaptured = false;
        this.possibleMoves = new ArrayList<>();
        this.possibleCaptures = new ArrayList<>();
    }

    public void addObserver(PieceObserver observer){
        Observers.add(observer);
        System.out.println("observer added.");
    }

    public void removeObserver(PieceObserver observer){
        Observers.remove(observer);
    }

    public void notifyObservers(){
        System.out.println("notified?");
        for (PieceObserver observer : Observers) {
            System.out.println("notified.");
            observer.reactTo(this);
        }
    }
    public Integer getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }

    public Boolean getIsCaptured() {
        return this.isCaptured;
    }
    public String getState() {
        return "normal";
    }

    public List<Position> getPossibleMoves() {
        return this.possibleMoves;
    }

    public List<Position> getPossibleCaptures() {
        return this.possibleCaptures;
    }

    public Boolean move(Piece[][] plateau, Position coord)
    {
        if(this.possibleMoves.contains(coord) || this.possibleCaptures.contains(coord)){
            plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
            setPosition(coord);
            plateau[coord.getX()][coord.getY()] = this;
            notifyObservers();
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
    public void setIsCaptured(Piece[][] plateau, Boolean isCaptured) {
        this.isCaptured = isCaptured;
        System.out.println("isCaptured = " + isCaptured);
        System.out.println("captured");
        plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
        notifyObservers();
    }

    public void setMove(Piece[][] plateau) {
        return;
    }
    public void setState(List<Position> captures){
        return;
    }
    public void setInCheckPositions(List<Position> inCheckPositions){
        return;
    }
    public void setCapture(Piece[][] plateau) {
        for (Position moves : possibleMoves) {
            if (plateau[moves.getX()][moves.getY()] != null && !Objects.equals(plateau[moves.getX()][moves.getY()].getColor(), this.getColor()) && !plateau[moves.getX()][moves.getY()].getClass().getSimpleName().equals("King")) {
                possibleCaptures.add(moves);
            }
        }

        for (Position moves : possibleCaptures){
            possibleMoves.remove(moves);
        }
    }
}
