package model;

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
}