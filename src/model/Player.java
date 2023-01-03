package model;

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
            this.listPiece.add(new Pawn(this.getColor(), new Position(i,column2)));

        //ADDING ROOKS
        this.listPiece.add(new Rook(this.getColor(), new Position(0,column1)));
        this.listPiece.add(new Rook(this.getColor(), new Position(7,column1)));

        //ADDING KNIGHTS
        this.listPiece.add(new Knight(this.getColor(), new Position(1,column1)));
        this.listPiece.add(new Knight(this.getColor(), new Position(6,column1)));

        //ADDING BISHOP
        this.listPiece.add(new Bishop(this.getColor(), new Position(2,column1)));
        this.listPiece.add(new Bishop(this.getColor(), new Position(5,column1)));

        //ADDING KING AND QUEEN
        this.listPiece.add(new King(this.getColor(), new Position(4,column1)));
        this.listPiece.add(new Queen(this.getColor(), new Position(3,column1)));
    }

    public void removePiece(Piece[][] plateau, Piece p){
        System.out.println("Capture!");
        this.deadPiece.add(p);
        p.setIsCaptured(plateau,true);
    }
}
