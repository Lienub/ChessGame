package view;

import model.*;
import controller.*;

public class GraphicalObserver implements PieceObserver {
    @Override
    public void reactTo(Piece p) {
        if (p.getIsCaptured()){
            MainGame.board_view.addCapture(p);
        }
        MainGame.board_view.update(MainGame.plateau);
    }
}
