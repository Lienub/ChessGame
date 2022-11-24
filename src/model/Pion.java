package model;

public class Pion extends Piece {
    private Boolean isPromoted;
    private Boolean isPromotable;

    public Pion(Integer color, Position position) {
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
