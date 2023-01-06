package model;

public class Position {
    private int xPos = -1, yPos = -1;

    public Position(int x, int y) {
        if(!(x < 0 || y < 0 || x > 7 || y > 7)) {
            xPos = x;
            yPos = y;
        }
    }

    public boolean equals(Position p)
    {
        return xPos == p.getX() && yPos == p.getY();
    }

    public int getX()
    {
        return xPos;
    }
    public int  getY()
    {
        return yPos;
    }

    public void setPos(int x, int y)
    {
        xPos = x;
        yPos = y;
    }
}
