package model;

import java.util.Objects;

public class Pawn extends Piece {
    private Boolean isPromoted;
    private Boolean isPromotable;
    private Boolean firstMove;

    public Pawn(Integer color, Position position) {
        super(color, position);
        setIsPromoted(false);
        setIsPromotable(false);
        firstMove = true;
    }

    public Boolean getIsPromoted() {
        return this.isPromoted;
    }

    public Boolean getIsPromotable() {
        return this.isPromotable;
    }

    @Override
    public Boolean move(Piece[][] plateau, Position coord) {
        if(this.possibleMoves.contains(coord) || this.possibleCaptures.contains(coord)){
            plateau[this.getPosition().getX()][this.getPosition().getY()] = null;
            setPosition(coord);
            plateau[coord.getX()][coord.getY()] = this;
            notifyObservers();
            System.out.println("c'est bougé");
            this.firstMove = false;
            return true;
        }
        return false;
    }
    public void setIsPromoted(Boolean isPromoted) {
        this.isPromoted = isPromoted;
    }

    public void setIsPromotable(Boolean isPromotable) {
        this.isPromotable = isPromotable;
    }
    @Override
    public void setMove(Piece[][] plateau) {
        possibleMoves.clear();
        possibleCaptures.clear();

        int side, pX = this.getPosition().getX(), pY = this.getPosition().getY();
        System.out.println("Pawn: pX = " + pX + " pY = " + pY);

        if(this.getColor() == 0) { System.out.println("Color White"); side = -1; }
        else { System.out.println("Color Black"); side = 1; }

        if(pY+1 < plateau.length && pY-1 > -1 && plateau[pX][pY+(1*side)] == null) {
            System.out.println("Personne devant");
            if(this.firstMove){
                System.out.println("Premier mouvement");
                if(plateau[pX][pY+2*side] == null) {
                    this.possibleMoves.add(new Position(pX,pY + 2 * side));
                    //System.out.println("Personne devant+1\nPossible move : " + pX + " " + (pY + 2 * side));
                }
            }
            this.possibleMoves.add(new Position(pX,pY + 1 * side));
            //System.out.println("Possible move : " + pX + " " + (pY+1*side));
        }
        C:\Users\julie\.jdks\openjdk-19.0.1\bin\java.exe "-javaagent:E:\IntelliJ IDEA 2022.2.4\lib\idea_rt.jar=65498:E:\IntelliJ IDEA 2022.2.4\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath "E:\Utilisateur\Documents\Scolaire\BUT S1\Seafile\A2\A31\chessgame_project\a31-chessgame\out\production\a31-chessgame" controller.MainGame
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        observer added.
        Case ligne 0 et colonne 0
        Case ligne 1 et colonne 0
        Case ligne 2 et colonne 0
        Case ligne 3 et colonne 0
        Case ligne 4 et colonne 0
        Case ligne 5 et colonne 0
        Case ligne 6 et colonne 0
        Case ligne 7 et colonne 0
        Case ligne 0 et colonne 1
        Case ligne 1 et colonne 1
        Case ligne 2 et colonne 1
        Case ligne 3 et colonne 1
        Case ligne 4 et colonne 1
        Case ligne 5 et colonne 1
        Case ligne 6 et colonne 1
        Case ligne 7 et colonne 1
        Case ligne 0 et colonne 2
        Case ligne 1 et colonne 2
        Case ligne 2 et colonne 2
        Case ligne 3 et colonne 2
        Case ligne 4 et colonne 2
        Case ligne 5 et colonne 2
        Case ligne 6 et colonne 2
        Case ligne 7 et colonne 2
        Case ligne 0 et colonne 3
        Case ligne 1 et colonne 3
        Case ligne 2 et colonne 3
        Case ligne 3 et colonne 3
        Case ligne 4 et colonne 3
        Case ligne 5 et colonne 3
        Case ligne 6 et colonne 3
        Case ligne 7 et colonne 3
        Case ligne 0 et colonne 4
        Case ligne 1 et colonne 4
        Case ligne 2 et colonne 4
        Case ligne 3 et colonne 4
        Case ligne 4 et colonne 4
        Case ligne 5 et colonne 4
        Case ligne 6 et colonne 4
        Case ligne 7 et colonne 4
        Case ligne 0 et colonne 5
        Case ligne 1 et colonne 5
        Case ligne 2 et colonne 5
        Case ligne 3 et colonne 5
        Case ligne 4 et colonne 5
        Case ligne 5 et colonne 5
        Case ligne 6 et colonne 5
        Case ligne 7 et colonne 5
        Case ligne 0 et colonne 6
        Case ligne 1 et colonne 6
        Case ligne 2 et colonne 6
        Case ligne 3 et colonne 6
        Case ligne 4 et colonne 6
        Case ligne 5 et colonne 6
        Case ligne 6 et colonne 6
        Case ligne 7 et colonne 6
        Case ligne 0 et colonne 7
        Case ligne 1 et colonne 7
        Case ligne 2 et colonne 7
        Case ligne 3 et colonne 7
        Case ligne 4 et colonne 7
        Case ligne 5 et colonne 7
        Case ligne 6 et colonne 7
        Case ligne 7 et colonne 7
        java.awt.Dimension[width=861,height=861]
        Button : 4 6
        Pawn: pX = 4 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Possible moves : 4 4
        Possible moves : 4 5
        Button : 4 4
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        King
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        King
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 6
        Color White
        Personne devant
        Premier mouvement
        J'ai bougé
        Tour au joueur Rayane
        Button : 3 1
        Pawn: pX = 3 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Possible moves : 3 3
        Possible moves : 3 2
        Button : 3 3
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        King
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        King
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        J'ai bougé
        Tour au joueur Julien
        Button : 7 6
        Pawn: pX = 7 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Possible moves : 7 4
        Possible moves : 7 5
        Button : 7 4
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        King
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        King
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        J'ai bougé
        Tour au joueur Rayane
        Button : 7 5
        Button : 4 7
        Button : 4 7
        Button : 4 0
        King
        Possible moves : 3 1
        Button : 3 1
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        J'ai bougé
        Tour au joueur Julien
        Button : 4 7
        King
        Possible moves : 4 6
        Button : 4 6
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        King
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        King
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        J'ai bougé
        Tour au joueur Rayane
        Button : 3 1
        King
        Possible moves : 3 2
        Possible moves : 4 2
        Possible moves : 4 0
        Possible moves : 2 2
        Button : 4 2
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        King
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        King
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        J'ai bougé
        Tour au joueur Julien
        Button : 4 6
        King
        Possible moves : 4 7
        Possible moves : 4 5
        Possible moves : 5 5
        Possible moves : 3 5
        Button : 3 5
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 6
        Color White
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 6
        Color White
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 6
        Color White
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        J'ai bougé
        Tour au joueur Rayane
        Button : 4 2
        King
        Possible moves : 5 2
        Possible moves : 3 2
        Possible moves : 4 3
        Possible moves : 5 3
        Possible moves : 3 1
        Button : 3 2
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        J'ai bougé
        Tour au joueur Julien
        Button : 3 5
        King
        Possible moves : 4 5
        Possible moves : 2 5
        Possible moves : 3 4
        Possible moves : 4 6
        Possible moves : 2 4
        Button : 2 5
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 2 pY = 6
        Color White
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 2 pY = 6
        Color White
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        J'ai bougé
        Tour au joueur Rayane
        Button : 3 3
        Pawn: pX = 3 pY = 3
        Color Black
        Personne devant
        Possible moves : 3 4
        Possible captures : 4 4
        Button : 3 4
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 4
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Check!
                King
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 3 pY = 4
        Color Black
        Personne devant
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        J'ai bougé
        Tour au joueur Julien
        Button : 3 4
        Button : 3 6
        Pawn: pX = 3 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Possible moves : 3 5
        Button : 3 5
        ok
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 2 pY = 6
        Color White
        Pawn: pX = 3 pY = 5
        Color White
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        Check!
                King
        Pawn: pX = 0 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 6
        Color White
        Personne devant
        Premier mouvement
        King
        Pawn: pX = 2 pY = 6
        Color White
        Pawn: pX = 3 pY = 5
        Color White
        Pawn: pX = 4 pY = 4
        Color White
        Personne devant
        Pawn: pX = 5 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 6
        Color White
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 4
        Color White
        Personne devant
        J'ai bougé
        Tour au joueur Rayane
        Button : 3 4
        Pawn: pX = 3 pY = 4
        Color Black
        Possible captures : 2 5
        Button : 2 5
        notified?
                notified.
                        Update
        Update done
        c'est bougé
        Pawn: pX = 0 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 1 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 2 pY = 5
        Color Black
        King
        Pawn: pX = 4 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 5 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 6 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        Pawn: pX = 7 pY = 1
        Color Black
        Personne devant
        Premier mouvement
        J'ai bougé
        Tour au joueur Julien

        Process finished with exit code 0

        if(pX+1 < plateau.length && pY+1 < plateau.length && pY-1 > -1 && plateau[pX+1][pY+1*side] != null && !Objects.equals(plateau[pX + 1][pY + 1 * side].getColor(), this.getColor()) && !plateau[pX + 1][pY + 1 * side].getClass().getSimpleName().equals("King")) {
            this.possibleCaptures.add(new Position(pX+1, pY+1*side));
            //System.out.println("Ennemi dispo devant 1\nPossible move : " + (pX+1) + " " + (pY+1*side))
        }
        if(pX-1 > -1 && pY+1 < plateau.length && pY-1 > -1 && plateau[pX-1][pY+1*side] != null && !Objects.equals(plateau[pX - 1][pY + 1 * side].getColor(), this.getColor()) && !plateau[pX - 1][pY + 1 * side].getClass().getSimpleName().equals("King")) {
            this.possibleCaptures.add(new Position(pX-1, pY+1*side));
            //System.out.println("Ennemi dispo devant 2\nPossible move : " + (pX-1) + " " + (pY+1*side))
        }

    }
}
