package model;

public class Pawn extends Piece {
    private Boolean isPromoted;
    private Boolean isPromotable;

    public Pawn(Integer color, Position position) {
        super(color, position);
        setIsPromoted(false);
        setIsPromotable(false);
    }
    public Boolean getIsPromoted() {
        return this.isPromoted;
    }

    public Boolean getIsPromotable() {
        return this.isPromotable;
    }


    public void setIsPromoted(Boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    public void setIsPromotable(Boolean isPromotable) {
        this.isPromotable = isPromotable;
    }
}
