package view;

import javax.imageio.ImageIO;
import javax.swing.*;

import model.*;
import controller.MainGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GamePromote extends JFrame {
    private final Piece p;
    private final List<Piece> deadPieces;

    //create new frame with list of all caputred pieces and a button to promote to selected piece type
    public GamePromote(Piece piece) {
        super("Promote");
        p = piece;
        if (MainGame.getCurrentPlayer().getColor() == 0){
            deadPieces = MainGame.player2.getDeadPiece();
        }
        else{
            deadPieces = MainGame.player1.getDeadPiece();
        }

        //frame is not closeable and not unfocusable
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(300, 300);
        setLayout(null);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

        JPanel contentPane = new JPanel(new GridLayout(2,2));
        contentPane.setPreferredSize(new Dimension(300, 300));
        contentPane.setBounds(0, 0, 300, 300);

        this.setContentPane(contentPane);
        initButtons();
        List<String> pieceNames = new ArrayList<>();
        for(Piece deadPiece : deadPieces) {
            if(!pieceNames.contains(deadPiece.getClass().getSimpleName())) {
                pieceNames.add(deadPiece.getClass().getSimpleName());
            }
        }
        System.out.println(pieceNames);
        if (!pieceNames.contains("Queen") && !pieceNames.contains("Rook") && !pieceNames.contains("Bishop") && !pieceNames.contains("Knight")) {
            System.out.println("You don't have enough pieces to promote");
            MainGame.board_view.setEnabled(true);
            this.dispose();
        }
        else {
            this.setVisible(true);
        }
    }

    public void initButtons() {
        List<String> pieces = new ArrayList<>();
        String color;
        if(MainGame.getCurrentPlayer().getColor() == 0){
            color = "w_";
        }
        else{
            color = "b_";
        }

        for(Piece deadPiece : deadPieces) {
            if(!pieces.contains(deadPiece.getClass().getSimpleName())) {
                pieces.add(deadPiece.getClass().getSimpleName());
            }
        }

        System.out.println(pieces);

        if(pieces.contains("Queen")) {
            JButton queen = new JButton("Queen");
            queen.setBounds(50, 50, 100, 50);
            try{
            queen.setIcon(new ImageIcon(ImageIO
                    .read(Objects.requireNonNull(getClass().getResource("/pieces/" + color + "Queen.png")))));
            } catch (Exception e) {
                System.out.println(e + "\nGiven path : /pieces/" + color + "Queen.png");
            }
            queen.addActionListener(e -> {
                operateChanges("Queen");
                dispose();
            });
            getContentPane().add(queen);
        }

        if(pieces.contains("Rook")) {
            JButton rook = new JButton("Rook");
            rook.setBounds(50, 100, 100, 50);
            try{
                rook.setIcon(new ImageIcon(ImageIO
                        .read(Objects.requireNonNull(getClass().getResource("/pieces/" + color + "Rook.png")))));
            } catch (Exception e) {
                System.out.println(e + "\nGiven path : /pieces/" + color + "Rook.png");
            }
            rook.addActionListener(e -> {
                operateChanges("Rook");
                dispose();
            });
            getContentPane().add(rook);
        }

        if(pieces.contains("Bishop")) {
            JButton bishop = new JButton("Bishop");
            bishop.setBounds(50, 150, 100, 50);
            try{
                bishop.setIcon(new ImageIcon(ImageIO
                        .read(Objects.requireNonNull(getClass().getResource("/pieces/" + color + "Bishop.png")))));
            } catch (Exception e) {
                System.out.println(e + "\nGiven path : /pieces/" + color + "Bishop.png");
            }
            bishop.addActionListener(e -> {
                operateChanges("Bishop");
                dispose();
            });
            getContentPane().add(bishop);
        }

        if(pieces.contains("Knight")) {
            JButton knight = new JButton("Knight");
            knight.setBounds(50, 200, 100, 50);
            try{
                knight.setIcon(new ImageIcon(ImageIO
                        .read(Objects.requireNonNull(getClass().getResource("/pieces/" + color + "Knight.png")))));
            } catch (Exception e) {
                System.out.println(e + "\nGiven path : /pieces/" + color + "Knight.png");
            }
            knight.addActionListener(e -> {
                operateChanges("Knight");
                dispose();
            });
            getContentPane().add(knight);
        }
    }

    private void operateChanges(String name) {
        Piece newPiece = switch (name) {
            case "Queen" -> new Queen(p.getColor(), p.getPosition());
            case "Rook" -> new Rook(p.getColor(), p.getPosition());
            case "Bishop" -> new Bishop(p.getColor(), p.getPosition());
            case "Knight" -> new Knight(p.getColor(), p.getPosition());
            default -> null;
        };

        int i = 0;
        System.out.println(name + "\n" + deadPieces);

        for (Piece deadPiece : deadPieces) {
            System.out.println(deadPiece.getClass().getSimpleName());
            if (deadPiece.getClass().getSimpleName().equals(name)) {
                System.out.println("Found, i :"+ i);;
                MainGame.plateau[p.getPosition().getX()][p.getPosition().getY()] = newPiece;
                deadPieces.set(i, p);
                MainGame.board_view.changeCapture(p, i);
                MainGame.board_view.update(MainGame.plateau);
                break;
            }
            i++;
        }
        MainGame.board_view.setEnabled(true);
    }
}