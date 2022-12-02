package model;

public class King extends Piece {
    private Boolean isCapturable;

    public King(Integer color, Position position) {
        super(color, position);
    }


    public Boolean getIsCapturable() {
        return this.isCapturable;
    }

    public void setIsCapturable(Boolean isCapturable) {
        this.isCapturable = isCapturable;
    }
}