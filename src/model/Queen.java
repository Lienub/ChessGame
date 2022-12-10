package model;

public class Queen extends  Piece{
    public Queen(Integer color, Position position) {
        super(color, position);
    }

    @Override
    public void setMove(Piece[][] plateau){
        Piece[] moves = {new Rook(this.getColor(), this.getPosition()), new Bishop(this.getColor(), this.getPosition())};

        for(Piece p : moves){
            p.setMove(plateau);
        }
    }
}
