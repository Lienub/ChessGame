package view;

import com.sun.tools.javac.Main;
import controller.MainGame;
import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

public class GameViewer extends JFrame {
    private JButton[][] squares = new JButton[8][8];
    private JLabel[][] displayMoves = new JLabel[8][8];
    private JLabel[][] displayCaptures = new JLabel[8][8];
    private JLabel turn = new JLabel("Tour du joueur "+ (MainGame.getCurrentPlayer().getName()), SwingConstants.CENTER);
    JPanel J1Capture = new JPanel(new GridLayout(8,2));
    int J1CaptureCount = 0;
    JPanel J2Capture = new JPanel(new GridLayout(8,2));
    int J2CaptureCount = 0;
    private static final String COLS = "ABCDEFGH";

    public GameViewer() {
        super("Chess");
        this.setSize(1277, 1000);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Placer la fenêtre au centre de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        this.add(panel);


        JPanel chessBoard = new JPanel(new GridLayout(9, 9));
        J1Capture.setPreferredSize(new Dimension(200, 1000));
        for(int i = 0; i < 10; i++){
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(60,60));
            J1Capture.add(label);
        }
        J2Capture.setPreferredSize(new Dimension(200, 1000));
        for(int i = 0; i < 10; i++){
            JLabel label = new JLabel();
            label.setPreferredSize(new Dimension(60,60));
            J2Capture.add(label);
        }
        JPanel miscInfos = new JPanel(new GridLayout(0,2));
        miscInfos.setPreferredSize(new Dimension(1120, 100));
        miscInfos.add(turn);

        panel.add(J1Capture, BorderLayout.WEST);
        panel.add(J2Capture, BorderLayout.EAST);
        panel.add(miscInfos, BorderLayout.NORTH);

        J1Capture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        J2Capture.setBorder(BorderFactory.createLineBorder(Color.BLACK));
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
        this.setVisible(true);

        System.out.println(chessBoard.getSize());
    }
    public void resetDisplayMoves(JLabel[][] display){
        for(int i = 0 ; i < 8; i++){
            for(int j = 0 ; j < 8; j++){
                display[i][j].setIcon(null);
                display[i][j].setVisible(false);
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
                                        .read(Objects.requireNonNull(getClass().getResource("/pieces/" + color + p.getClass().getSimpleName() + ".png")))
                                ))
                        ;
                    } catch (Exception e) {
                        System.out.println(e + "\nGiven path : /pieces/" + color + p.getClass().getSimpleName()+".png");
                    }
                }
            }
        }
    }

    public void resetDisplayPiece(){
        for(int i = 0 ; i < 8; i++){
            for(int j = 0 ; j < 8; j++){
                squares[i][j].setIcon(null);
            }
        }
    }
    public void update(Piece[][] plateau){
        System.out.println("Update");
        resetDisplayPiece();
        displayPieces(plateau);
        for (JButton[] col : squares){
            for(JButton b : col){
                for( ActionListener al : b.getActionListeners() ) {
                    b.removeActionListener( al );
                }
            }
        }
        setActions();
        System.out.println("Update done");
    }

    public void addCapture(Piece p){
        Component c = null;
        if(p.getColor() == 0) {
            c = J1Capture.getComponent(J1CaptureCount);
            J1CaptureCount++;
        }
        else {
            c = J2Capture.getComponent(J2CaptureCount);
            J2CaptureCount++;
        }
        if(c instanceof JLabel){
            JLabel l = (JLabel) c;
            String color;
            if (p.getColor() == 0) color = "w_";
            else color = "b_";
            try {
                l.setIcon(new ImageIcon(ImageIO
                        .read(Objects.requireNonNull(getClass().getResource("/pieces/" + color + p.getClass().getSimpleName() + ".png")))
                ));
            } catch (Exception e) {
                System.out.println(e + "\nGiven path : /pieces/" + color + p.getClass().getSimpleName()+".png");
            }
        }
    }
    public void changeCapture(Piece p, int index){
        Component c = null;
        if(p.getColor() == 0) {
            c = J1Capture.getComponent(index);
        }
        else {
            c = J2Capture.getComponent(index);
        }
        System.out.println(c);
        if(c instanceof JLabel){
            JLabel l = (JLabel) c;
            String color;
            if (p.getColor() == 0) color = "w_";
            else color = "b_";
            try {
                l.setIcon(new ImageIcon(ImageIO
                        .read(Objects.requireNonNull(getClass().getResource("/pieces/" + color + p.getClass().getSimpleName() + ".png")))
                ));
            } catch (Exception e) {
                System.out.println(e + "\nGiven path : /pieces/" + color + p.getClass().getSimpleName()+".png");
            }
            System.out.println(c);
        }
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
                    if (MainGame.getPlateau()[X][Y] != null && MainGame.getPlateau()[X][Y].getColor() == MainGame.getCurrentPlayer().getColor()){
                        MainGame.getPlateau()[X][Y].setMove(MainGame.getPlateau());
                        MainGame.setCurrentPos(MainGame.getPlateau()[X][Y].getPosition());
                        MainGame.setCurrentMoves(MainGame.getPlateau()[X][Y].getPossibleMoves());
                        MainGame.setCurrentCaptures(MainGame.getPlateau()[X][Y].getPossibleCaptures());
                        for (Position p : MainGame.getCurrentMoves()) {
                            System.out.println("Possible moves : " + p.getX() + " " + p.getY());
                            try {
                                displayMoves[p.getX()][p.getY()].setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("/pieces/circle.png")))));
                            } catch (Exception e) {
                                System.out.println(e + "\nGiven path : /pieces/circle.png");
                            }
                            displayMoves[p.getX()][p.getY()].setVisible(true);
                        }

                        for(Position p : MainGame.getCurrentCaptures()){
                            System.out.println("Possible captures : " + p.getX() + " " + p.getY());
                            try {
                                displayCaptures[p.getX()][p.getY()].setIcon(new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResource("/pieces/circle2.png")))));
                            } catch (Exception e) {
                                System.out.println(e + "\nGiven path : /pieces/circle2.png");
                            }
                            displayCaptures[p.getX()][p.getY()].setVisible(true);
                        }
                    }
                    if(MainGame.getCurrentPos() != null) {
                        boolean present = false;
                        for (Position p : MainGame.getCurrentMoves()) {
                            if (p.equals(new Position(X, Y))) {
                                System.out.println("ok");
                                MainGame.movePiece(MainGame.getPlateau()[MainGame.getCurrentPos().getX()][MainGame.getCurrentPos().getY()], p);
                                turn.setText("Tour du joueur " + (MainGame.getCurrentPlayer().getName()));
                                present = true;
                                break;
                            }
                        }
                        for (Position c : MainGame.getCurrentCaptures()) {
                            if (c.equals(new Position(X, Y))) {
                                MainGame.capturePiece(MainGame.getPlateau()[X][Y]);
                                MainGame.movePiece(MainGame.getPlateau()[MainGame.getCurrentPos().getX()][MainGame.getCurrentPos().getY()], c);
                                MainGame.setCurrentPos(null);
                                MainGame.setCurrentMoves(null);
                                turn.setText("Tour du joueur " + (MainGame.getCurrentPlayer().getName()));
                                present = true;
                                break;
                            }
                        }
                        if(!present && !MainGame.getCurrentPos().equals(new Position(X,Y))){
                            MainGame.setCurrentPos(null);
                        }
                    }
                });
            }
        }
    }
}