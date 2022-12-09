package model;

public class Knight extends Piece{
    public Knight(Integer color, Position position) {
        super(color, position);
    }

    public void setIsMovable(Piece[][] plateau, Position coord) {
        //The knight moves multiple squares each move. It either moves up or down one square vertically and over two squares horizontally OR up or down two squares vertically and over one square horizontally. This movement can be remembered as an "L-shape" because it looks like a capital "L". and can't move over another piece
        if (coord.getX() == this.position.getX() || coord.getY() == this.position.getY()) {
            this.isMovable = false;
        } else {
            if (coord.getX() > this.position.getX() && coord.getY() > this.position.getY()) {
                for (int i = 1; i < coord.getX() - this.position.getX(); i++) {
                    if (plateau[this.position.getX() + i][this.position.getY() + i] != null) {
                        this.isMovable = false;
                    }
                }
            } else if (coord.getX() < this.position.getX() && coord.getY() < this.position.getY()) {
                for (int i = 1; i < this.position.getX() - coord.getX(); i++) {
                    if (plateau[this.position.getX() - i][this.position.getY() - i] != null) {
                        this.isMovable = false;
                    }
                }
            } else if (coord.getX() > this.position.getX() && coord.getY() < this.position.getY()) {
                for (int i = 1; i < coord.getX() - this.position.getX(); i++) {
                    if (plateau[this.position.getX() + i][this.position.getY() - i] != null) {
                        this.isMovable = false;
                    }
                }
            } else if (coord.getX() < this.position.getX() && coord.getY() > this.position.getY()) {
                for (int i = 1; i < this.position.getX() - coord.getX(); i++) {
                    if (plateau[this.position.getX() - i][this.position.getY() + i] != null) {
                        this.isMovable = false;
                    }
                }
            }
        }
    }
}
