package controller;

import model.*;
import view.GamePromote;

public class PromoteObserver implements PieceObserver {
    @Override
    public void reactTo(Piece p) {
        ((Pawn) p).setIsPromotable();

        if (((Pawn) p).getIsPromotable()) {
            MainGame.board_view.setEnabled(false);
            new GamePromote(p);
        }
    }
}
