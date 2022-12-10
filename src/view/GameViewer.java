package view;

import controller.MainGame;
import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameViewer extends JFrame {
    //private static GameViewer instance;
    //private final JPanel gui = new JPanel(new BorderLayout(1, 1));
    private JButton[][] squares = new JButton[8][8];
    private JLabel[][] displayMoves = new JLabel[8][8];
    private static final String COLS = "ABCDEFGH";
    //private JPanel board;

    public GameViewer() {
        super("Chess");
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //GridLayout plateau = new GridLayout(8, 8);

        JPanel chessBoard = new JPanel(new GridLayout(9, 9));
        //chessBoard.setBorder(new LineBorder(Color.BLACK));
        //gui.add(chessBoard);

        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int j = 0; j < squares.length; j++) {
            for (int i = 0; i < squares.length; i++) {
                JButton b = new JButton();
                JLabel l = new JLabel("", JLabel.CENTER);

                l.setVisible(false);
                b.setLayout(new GridBagLayout());
                b.setMargin(buttonMargin);
                /*
                ImageIcon icon = new ImageIcon( new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                 b.setIcon(icon);
                */
                if ((j % 2 == 1 && i % 2 == 1) || (j % 2 == 0 && i % 2 == 0))
                    b.setBackground(new Color(255, 255, 204));
                else
                    b.setBackground(new Color(153, 102, 0));

                squares[i][j] = b;
                displayMoves[i][j] = l;

                squares[i][j].add(displayMoves[i][j], SwingConstants.CENTER);
                System.out.println("Case ligne " + i + " et colonne " + j);
            }
        }

        setActions();

        //fill the chess board
        chessBoard.add(new JLabel(""));
        // fill the top row
        for (int i = 0; i < 8; i++)
            chessBoard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));

        // fill the black non-pawn piece row
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0)
                    chessBoard.add(new JLabel("" + (8 - i), SwingConstants.CENTER));
                chessBoard.add(squares[j][i]);

            }
        }

        this.add(chessBoard);
        chessBoard.setVisible(true);
        //gui.setVisible(true);
        this.setVisible(true);
    }


    /*private static GameViewer getInstance(){
        if(instance == null){
            instance = new GameViewer();
        }
        return instance;
    }*/

    public void resetDisplayMoves(JLabel[][] displayMoves){
        for(int i = 0 ; i < 8; i++){
            for(int j = 0 ; j < 8; j++){
                displayMoves[i][j].setIcon(null);
                displayMoves[i][j].setVisible(false);
            }
        }
    }

    public void displayPieces(Piece[][] piece){
        for(Piece[] col : piece){
            for (Piece p : col) {
                if (p != null) {
                    String color;
                    if (p.getColor() == 0) color = "w_";
                    else color = "b_";
                    try {
                        squares[p.getPosition().getX()][p.getPosition().getY()]
                                .setIcon(new ImageIcon(ImageIO
                                        .read(getClass().getResource("/pieces/" + color + p.getClass().getSimpleName()+".png"))
                                ))
                        ;
                    } catch (Exception e) {
                        System.out.println(e + "\nGiven path : /pieces/" + color + p.getClass().getSimpleName()+".png");
                    }
                }
            }
        }
    }

    public void resetDisplayPiece(Piece[][] piece){
        for(int i = 0 ; i < 8; i++){
            for(int j = 0 ; j < 8; j++){
                squares[i][j].setIcon(null);
            }
        }
    }
    public void update(Piece[][] plateau){
        resetDisplayPiece(plateau);
        displayPieces(plateau);
        for (JButton[] col : squares){
            for(JButton b : col){
                for( ActionListener al : b.getActionListeners() ) {
                    b.removeActionListener( al );
                }
            }
        }
        setActions();
    }

    public void setActions(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int X = j;
                int Y = i;
                squares[X][Y].addActionListener(actionEvent -> {
                    resetDisplayMoves(displayMoves);
                    System.out.println("Button : " + X + " " + Y);
                    if (MainGame.getPlateau()[X][Y] != null) {
                        MainGame.getPlateau()[X][Y].setMove(MainGame.getPlateau());
                        MainGame.setCurrentPos(MainGame.getPlateau()[X][Y].getPosition());
                        MainGame.setCurrentMoves(MainGame.getPlateau()[X][Y].getPossibleMoves());
                        for (Position p : MainGame.getCurrentMoves()) {
                            System.out.println("Possible moves : " + p.getX() + " " + p.getY());
                            try {
                                displayMoves[p.getX()][p.getY()].setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/pieces/circle.png"))));
                            } catch (Exception e) {
                                System.out.println(e + "\nGiven path : /pieces/circle.png");
                            }
                            displayMoves[p.getX()][p.getY()].setVisible(true);
                        }
                    }
                    if(MainGame.getCurrentPos() != null) {
                        for (Position p : MainGame.getCurrentMoves()) {
                            if (p.getX() == X && p.getY() == Y) {
                                System.out.println("ok");
                                MainGame.movePiece(MainGame.getPlateau()[MainGame.getCurrentPos().getX()][MainGame.getCurrentPos().getY()], p);
                            }
                        }
                    }
                    System.out.println(MainGame.getPlateau()[X][Y].getClass().getSimpleName());
                });
            }
        }
    }

    /*public static void main(String args[]){
        GameViewer plateau = GameViewer.getInstance();
        plateau.init();
    }*/
}