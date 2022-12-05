package view;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String playerName;
    private final Integer playerColor;
    private List<Piece> listPiece;
    private List<Piece> deadPiece;

    public Player(String playerName, Integer playerColor){
        this.playerName = playerName;
        this.playerColor = playerColor;
        listPiece = new ArrayList<>();
        deadPiece = new ArrayList<>();
        initPiece();
    }

    public String getName(){ return this.playerName; }
    public Integer getColor() { return this.playerColor; }
    public List<Piece> getAllPiece() { return this.listPiece; }
    public List<Piece> getDeadPiece() { return this.deadPiece; }
    public void initPiece(){
        int column1 = 7, column2 = 6;
        if(this.getColor() == 1){ column1 = 0; column2 = 1; }

        //ADDING PAWNS
        for (int i = 0 ; i < 8 ; i++)
            this.listPiece.add(new Pawn(this.getColor(), new Position(column2,i)));

        //ADDING ROOKS
        this.listPiece.add(new Rook(this.getColor(), new Position(column1,0)));
        this.listPiece.add(new Rook(this.getColor(), new Position(column1,7)));

        //ADDING KNIGHTS
        this.listPiece.add(new Knight(this.getColor(), new Position(column1,1)));
        this.listPiece.add(new Knight(this.getColor(), new Position(column1,6)));

        //ADDING BISHOP
        this.listPiece.add(new Bishop(this.getColor(), new Position(column1,2)));
        this.listPiece.add(new Bishop(this.getColor(), new Position(column1,5)));

        //ADDING KING AND QUEEN
        this.listPiece.add(new King(this.getColor(), new Position(column1,4)));
        this.listPiece.add(new Queen(this.getColor(), new Position(column1,3)));
    }

    public void removePiece(Position coord){
        for( Piece p : this.listPiece) {
            if (coord.getX() == p.getPosition().getX() && coord.getY() == p.getPosition().getY()) {
                this.listPiece.remove(p);
                this.deadPiece.add(p);
                return;
            }
        }
    }
}
