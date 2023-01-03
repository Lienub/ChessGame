package controller;

import model.*;

public class GameplayObserver implements ChessboardObserver {
    @Override
    public void reactTo(Piece[][] plateau) {
        for(int i = 0; i < plateau.length; i++){
            for(int j = 0; j < plateau[i].length; j++){
                if(plateau[i][j].getClass().getSimpleName() == "King"){
                    if (plateau[i][j].getState() == "checkmate"){
                        System.out.println("Checkmate!");
                    }
                }
            }
        }
        MainGame.board_view.update(MainGame.plateau);
    }
}
}
