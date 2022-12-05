package model;

public class Pawn extends Piece {
    private Boolean isPromoted;
    private Boolean isPromotable;


    public Pawn(Integer color, Position position) {
        super(color, position);
        setIsPromoted(false);
        setIsPromotable(false);
        firstMove = true;
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

    @Override
    public void setIsMovable(Piece[][] plateau, Position coord){
        //White Pawn
        if(this.getColor() == 0){
            if(this.firstMove){
                if(getPosition().getX() == coord.getX() && getPosition().getY()-2 == coord.getY() && plateau[coord.getX()][coord.getY()] == null)
                    this.isMovable = true;
                else if(getPosition().getX() == coord.getX() && getPosition().getY()-1 ==coord.getY() && plateau[coord.getX()][coord.getY()] == null)
                    this.isMovable = true;
                else if(getPosition().getX()-1 ==coord.getX() && getPosition().getY()-1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 1)
                    this.isMovable = true;
                else if(getPosition().getX()+1 ==coord.getX() && getPosition().getY()-1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 1)
                    this.isMovable = true;
                else
                    this.isMovable = false;
            }
            else {
                if(getPosition().getX() == coord.getX() && getPosition().getY()-1 == coord.getY() && plateau[coord.getX()][coord.getY()] == null)
                    this.isMovable = true;
                else if(getPosition().getX()-1 ==coord.getX() && getPosition().getY()-1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 1)
                    this.isMovable = true;
                else if(getPosition().getX()+1 ==coord.getX() && getPosition().getY()-1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 1)
                    this.isMovable = true;
                else
                    this.isMovable = false;
            }
        }
        else if(this.getColor() == 1)
        {
            if(this.firstMove)
            {
                if(getPosition().getX() == coord.getX() && getPosition().getY()+2 == coord.getY() && plateau[coord.getX()][coord.getY()] == null)
                    this.isMovable = true;
                else if(getPosition().getX() == coord.getX() && getPosition().getY()+1 == coord.getY() && plateau[coord.getX()][coord.getY()] == null)
                    this.isMovable = true;
                else if(getPosition().getX()-1 == coord.getX() && getPosition().getY()+1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 0)
                    this.isMovable = true;
                else if(getPosition().getX()+1 == coord.getX() && getPosition().getY()+1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 0)
                    this.isMovable = true;
                else
                    this.isMovable = false;
            }
            else
            {
                if(getPosition().getX() == coord.getX() && getPosition().getY()+1 == coord.getY() && plateau[coord.getX()][coord.getY()] == null)
                    this.isMovable = true;
                else if(getPosition().getX()-1 == coord.getX() && getPosition().getY()+1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 0)
                    this.isMovable = true;
                else if(getPosition().getX()+1 == coord.getX() && getPosition().getY()+1 == coord.getY() && plateau[coord.getX()][coord.getY()] != null && plateau[coord.getX()][coord.getY()].getColor() == 0)
                    this.isMovable = true;
                else
                    this.isMovable = false;
            }
        }
    }
}
