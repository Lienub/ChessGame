package model;

public class Pawn extends Piece {
    private Boolean isPromoted;
    private Boolean isPromotable;
    private Boolean firstMove;

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
    public void setMove(Piece[][] plateau, Position coord){
        //White Pawn
        if(this.getColor() == 0){
            if(this.firstMove){
                if(plateau[this.position.getX()][this.position.getY() + 1] == null && plateau[this.position.getX()][this.position.getY() + 2] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() + 2));
                }

                if(plateau[this.position.getX()][this.position.getY() + 1] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() + 1));
                }

                if(this.position.getX() + 1 < 8 && plateau[this.position.getX() + 1][this.position.getY() + 1] != null && plateau[this.position.getX() + 1][this.position.getY() + 1].getColor() == 1){
                    this.possibleMoves.add(new Position(this.position.getX() + 1, this.position.getY() + 1));
                }

                if(this.position.getX() - 1 >= 0 && plateau[this.position.getX() - 1][this.position.getY() + 1] != null && plateau[this.position.getX() - 1][this.position.getY() + 1].getColor() == 1){
                    this.possibleMoves.add(new Position(this.position.getX() - 1, this.position.getY() + 1));
                }

                this.firstMove = false;
            }
            else {
                if(plateau[this.position.getX()][this.position.getY() + 1] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() + 1));
                }

                if(this.position.getX() + 1 < 8 && plateau[this.position.getX() + 1][this.position.getY() + 1] != null && plateau[this.position.getX() + 1][this.position.getY() + 1].getColor() == 1){
                    this.possibleMoves.add(new Position(this.position.getX() + 1, this.position.getY() + 1));
                }

                if(this.position.getX() - 1 >= 0 && plateau[this.position.getX() - 1][this.position.getY() + 1] != null && plateau[this.position.getX() - 1][this.position.getY() + 1].getColor() == 1){
                    this.possibleMoves.add(new Position(this.position.getX() - 1, this.position.getY() + 1));
                }

                if(this.position.getY() == 1 && plateau[this.position.getX()][this.position.getY() + 2] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() + 2));
                }
            }
        }
        else if(this.getColor() == 1)
        {
            if(this.firstMove)
            {
                if(plateau[this.position.getX()][this.position.getY() - 1] == null && plateau[this.position.getX()][this.position.getY() - 2] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() - 2));
                }

                if(plateau[this.position.getX()][this.position.getY() - 1] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() - 1));
                }

                if(this.position.getX() + 1 < 8 && plateau[this.position.getX() + 1][this.position.getY() - 1] != null && plateau[this.position.getX() + 1][this.position.getY() - 1].getColor() == 0){
                    this.possibleMoves.add(new Position(this.position.getX() + 1, this.position.getY() - 1));
                }

                if(this.position.getX() - 1 >= 0 && plateau[this.position.getX() - 1][this.position.getY() - 1] != null && plateau[this.position.getX() - 1][this.position.getY() - 1].getColor() == 0){
                    this.possibleMoves.add(new Position(this.position.getX() - 1, this.position.getY() - 1));
                }

                this.firstMove = false;
            }
            else {
                if(plateau[this.position.getX()][this.position.getY() - 1] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() - 1));
                }

                if(this.position.getX() + 1 < 8 && plateau[this.position.getX() + 1][this.position.getY() - 1] != null && plateau[this.position.getX() + 1][this.position.getY() - 1].getColor() == 0){
                    this.possibleMoves.add(new Position(this.position.getX() + 1, this.position.getY() - 1));
                }

                if(this.position.getX() - 1 >= 0 && plateau[this.position.getX() - 1][this.position.getY() - 1] != null && plateau[this.position.getX() - 1][this.position.getY() - 1].getColor() == 0){
                    this.possibleMoves.add(new Position(this.position.getX() - 1, this.position.getY() - 1));
                }

                if(this.position.getY() == 6 && plateau[this.position.getX()][this.position.getY() - 2] == null){
                    this.possibleMoves.add(new Position(this.position.getX(), this.position.getY() - 2));
                }
            }
        }
    }
}
