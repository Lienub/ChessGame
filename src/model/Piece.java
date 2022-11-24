package model;

public abstract class Piece {
    private Integer color;
    private Position position;
    private Boolean isMovable;
    private Boolean isCaptured;

    public Piece(Integer color, Position position) {
        this.color = color;
        this.position = position;
        this.isMovable = true;
        this.isCaptured = false;
    }


    public Integer getColor() {
        return this.color;
    }

    public Position getPosition() {
        return this.position;
    }

    public Boolean getIsMovable() {
        return this.isMovable;
    }

    public Boolean getIsCaptured() {
        return null;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setIsMovable(Boolean isMovable) {
        this.isMovable = isMovable;
    }


    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }
}
