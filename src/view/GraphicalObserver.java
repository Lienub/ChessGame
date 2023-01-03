package view;

import model.*;
import controller.*;

public class GraphicalObserver implements PieceObserver {
    @Override
    public void reactTo(Piece p) {
        System.out.println("je réagis");
        if (p.getIsCaptured()){
            System.out.println("je suis capturé");
            MainGame.board_view.addCapture(p);
        }
        MainGame.board_view.update(MainGame.plateau);
    }
}
