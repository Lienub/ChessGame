package model;

public abstract class Piece {
    private Integer color;
    protected Position position;
    protected Boolean isMovable;
    protected Boolean isCaptured;
    protected Boolean firstMove;

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

    public Boolean move(Position coord)
    {
        if(getIsMovable()) {
            setPosition(coord);
            firstMove = false;
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

    public void setIsMovable(Piece[][] plateau, Position coord) {
        this.isMovable = true;
    }

    public void setIsCaptured(Boolean isCaptured) {
        this.isCaptured = isCaptured;
    }
}
