package model;

public interface ChessboardObserver {
    public void reactTo(Piece[][] plateau, int color);
}
