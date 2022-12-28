package view;

import controller.MainGame;
import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameViewer extends JFrame {
    private JButton[][] squares = new JButton[8][8];
    private JLabel[][] displayMoves = new JLabel[8][8];
    private JLabel[][] displayCaptures = new JLabel[8][8];
    private static final String COLS = "ABCDEFGH";

    public GameViewer() {
        super("Chess");
        this.setSize(1000, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.add(panel);


        JPanel chessBoard = new JPanel(new GridLayout(9, 9));
        JPanel J1Capture = new JPanel(new GridLayout(0,2));
        JPanel J2Capture = new JPanel(new GridLayout(0,2));
        JPanel miscInfos = new JPanel(new GridLayout(0,2));

        panel.add(J1Capture, BorderLayout.WEST);
        panel.add(J2Capture, BorderLayout.EAST);
        panel.add(miscInfos, BorderLayout.NORTH);

        J1Capture.add(new JLabel("test"));
        J1Capture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        J2Capture.add(new JLabel("test"));
        J2Capture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        miscInfos.add(new JLabel("test"));
        miscInfos.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        Insets buttonMargin = new Insets(0, 0, 0, 0);
        for (int j = 0; j < squares.length; j++) {
            for (int i = 0; i < squares.length; i++) {
                JButton b = new JButton();
                JLabel l = new JLabel("", JLabel.CENTER);
                JLabel c = new JLabel("", JLabel.CENTER);

                l.setVisible(false);
                c.setVisible(false);
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
                displayCaptures[i][j] = c;

                squares[i][j].add(displayMoves[i][j], SwingConstants.CENTER);
                squares[i][j].add(displayCaptures[i][j], SwingConstants.CENTER);
                System.out.println("Case ligne " + i + " et colonne " + j);
            }
        }

        setActions();

        chessBoard.add(new JLabel(""));
        for (int i = 0; i < 8; i++)
            chessBoard.add(new JLabel(COLS.substring(i, i + 1), SwingConstants.CENTER));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j == 0)
                    chessBoard.add(new JLabel("" + (8 - i), SwingConstants.CENTER));
                chessBoard.add(squares[j][i]);

            }
        }

        panel.add(chessBoard, BorderLayout.CENTER);
        this.setContentPane(panel);
        //gui.setVisible(true);
        this.setVisible(true);
    }


    public void resetDisplayMoves(JLabel[][] display){
        for(int i = 0 ; i < 8; i++){
            for(int j = 0 ; j < 8; j++){
                display[i][j].setIcon(null);
                display[i][j].setVisible(false);
            }
        }
    }

    /*public JPanel setupPanel(){
        JPanel panel = new JPanel(new GridLayout(0, 2));

        for(int i = 0 ; i < 10 ; i++){
            panel.add(new JLabel)
        }
    }*/
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
                    resetDisplayMoves(displayCaptures);
                    System.out.println("Button : " + X + " " + Y);
                    if (MainGame.getPlateau()[X][Y] != null) {
                        MainGame.getPlateau()[X][Y].setMove(MainGame.getPlateau());
                        MainGame.setCurrentPos(MainGame.getPlateau()[X][Y].getPosition());
                        MainGame.setCurrentMoves(MainGame.getPlateau()[X][Y].getPossibleMoves());
                        MainGame.setCurrentCaptures(MainGame.getPlateau()[X][Y].getPossibleCaptures());
                        for (Position p : MainGame.getCurrentMoves()) {
                            System.out.println("Possible moves : " + p.getX() + " " + p.getY());
                            try {
                                displayMoves[p.getX()][p.getY()].setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/pieces/circle.png"))));
                            } catch (Exception e) {
                                System.out.println(e + "\nGiven path : /pieces/circle.png");
                            }
                            displayMoves[p.getX()][p.getY()].setVisible(true);
                        }

                        for(Position p : MainGame.getCurrentCaptures()){
                            System.out.println("Possible captures : " + p.getX() + " " + p.getY());
                            try {
                                displayCaptures[p.getX()][p.getY()].setIcon(new ImageIcon(ImageIO.read(getClass().getResource("/pieces/circle2.png"))));
                            } catch (Exception e) {
                                System.out.println(e + "\nGiven path : /pieces/circle2.png");
                            }
                            displayCaptures[p.getX()][p.getY()].setVisible(true);
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

                });
            }
        }
    }
}