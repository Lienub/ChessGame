package model;

public class Position {
    private int xPos, yPos;

    public Position(int x, int y) {
        xPos = x;
        yPos = y;

    }

    public void setPos(int x, int y)
    {
        xPos = x;
        yPos = y;
    }

    public boolean equals(Position p)
    {
        return xPos == p.getX() && yPos == p.getY();
    }

    public int getX()
    {	return xPos;	}

    public int  getY()
    {	return yPos;	}

    }
