package view;

import model.*;
import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame {
    private static GameViewer instance;
    private JButton[][] squares = new JButton[8][8];
    //private JPanel board;

    private GameViewer(){
        instance.init();
    }

    private static GameViewer getInstance(){
        if(instance == null){
            instance = new GameViewer();
        }
        return instance;
    }

    public void init(){
        setTitle("Chess Game");
        setSize(1000, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );

        GridLayout plateau = new GridLayout(8, 8);
        
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int i = 0; i < squares.length; i++) {
            for (int j = 0; j < squares.length; j++) {
                JButton b = new JButton();
                b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                /*ImageIcon icon = new ImageIcon( new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                b.setIcon(icon);*/
                if ((j % 2 == 1 && i % 2 == 1)
                        //) {
                        || (j % 2 == 0 && i % 2 == 0))
                    b.setBackground(Color.WHITE);
                else
                    b.setBackground(Color.BLACK);
              squares[j][i] = b;
            }
        }                      
    }

    public void update(Piece[][] listePieces){

    }

    public static void main(String args[]){
        GameViewer plateau = GameViewer.getInstance();
    }
}
