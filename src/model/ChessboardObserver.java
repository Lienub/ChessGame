package model;

public interface ChessboardObserver {
    void reactTo(Piece[][] plateau, int color);
}
