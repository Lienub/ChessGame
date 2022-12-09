package model;

public class Bishop extends Piece{
    public Bishop(Integer color, Position position) {
        super(color, position);
    }

    @Override
    public void setMove(Piece[][] plateau, Position coord) {
        //White Bishop
        if(this.getColor() == 0) {
            //Top Left
            for (int i = 1; i < 8; i++) {
                if (this.position.getX() - i >= 0 && this.position.getY() - i >= 0) {
                    if (plateau[this.position.getX() - i][this.position.getY() - i] == null) {
                        this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() - i));
                    } else if (plateau[this.position.getX() - i][this.position.getY() - i].getColor() == 1) {
                        this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() - i));
                        break;
                    } else {
                        break;
                    }
                }
            }

            //Top Right
            for (int i = 1; i < 8; i++) {
                if (this.position.getX() + i < 8 && this.position.getY() - i >= 0) {
                    if (plateau[this.position.getX() + i][this.position.getY() - i] == null) {
                        this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() - i));
                    } else if (plateau[this.position.getX() + i][this.position.getY() - i].getColor() == 1) {
                        this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() - i));
                        break;
                    } else {
                        break;
                    }
                }
            }

            //Bottom Left
            for (int i = 1; i < 8; i++) {
                if (this.position.getX() - i >= 0 && this.position.getY() + i < 8) {
                    if (plateau[this.position.getX() - i][this.position.getY() + i] == null) {
                        this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() + i));
                    } else if (plateau[this.position.getX() - i][this.position.getY() + i].getColor() == 1) {
                        this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() + i));
                        break;
                    } else {
                        break;
                    }
                }
            }

            //Bottom Right
            for (int i = 1; i < 8; i++) {
                if (this.position.getX() + i < 8 && this.position.getY() + i < 8) {
                    if (plateau[this.position.getX() + i][this.position.getY() + i] == null) {
                        this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() + i));
                    } else if (plateau[this.position.getX() + i][this.position.getY() + i].getColor() == 1) {
                        this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() + i));
                        break;
                    } else {
                        break;
                    }
                }
            }
        }

            //Black Bishop
        else{
                //Top Left
                for (int i = 1; i < 8; i++) {
                    if (this.position.getX() - i >= 0 && this.position.getY() - i >= 0) {
                        if (plateau[this.position.getX() - i][this.position.getY() - i] == null) {
                            this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() - i));
                        } else if (plateau[this.position.getX() - i][this.position.getY() - i].getColor() == 0) {
                            this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() - i));
                            break;
                        } else {
                            break;
                        }
                    }
                }

                //Top Right
                for (int i = 1; i < 8; i++) {
                    if (this.position.getX() + i < 8 && this.position.getY() - i >= 0) {
                        if (plateau[this.position.getX() + i][this.position.getY() - i] == null) {
                            this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() - i));
                        } else if (plateau[this.position.getX() + i][this.position.getY() - i].getColor() == 0) {
                            this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() - i));
                            break;
                        } else {
                            break;
                        }
                    }
                }

                //Bottom Left
                for (int i = 1; i < 8; i++) {
                    if (this.position.getX() - i >= 0 && this.position.getY() + i < 8) {
                        if (plateau[this.position.getX() - i][this.position.getY() + i] == null) {
                            this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() + i));
                        } else if (plateau[this.position.getX() - i][this.position.getY() + i].getColor() == 0) {
                            this.possibleMoves.add(new Position(this.position.getX() - i, this.position.getY() + i));
                            break;
                        } else {
                            break;
                        }
                    }
                }

                //Bottom Right
                for (int i = 1; i < 8; i++) {
                    if (this.position.getX() + i < 8 && this.position.getY() + i < 8) {
                        if (plateau[this.position.getX() + i][this.position.getY() + i] == null) {
                            this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() + i));
                        } else if (plateau[this.position.getX() + i][this.position.getY() + i].getColor() == 0) {
                            this.possibleMoves.add(new Position(this.position.getX() + i, this.position.getY() + i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
}
