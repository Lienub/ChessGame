package model;

public class Roi extends Piece {
    private Boolean isCapturable;

    public Boolean getIsCapturable() {
        return this.isCapturable;
    }

    public void setIsCapturable(Boolean isCapturable) {
        this.isCapturable = isCapturable;
    }
}