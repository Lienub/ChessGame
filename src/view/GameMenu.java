package view;

import controller.MainGame;
import model.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameMenu extends JFrame {
    private String player1Name = "Joueur 1";
    private String player2Name = "Joueur 2";
    public GameMenu() {
        super("Chess");

        // Créer la fenêtre de menu du jeu
        this.setSize(500, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Placer la fenêtre au centre de l'écran
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        this.setLocation(dim.width / 2 - this.getWidth() / 2, dim.height / 2 - this.getHeight() / 2);

        // Créer un panneau de contenu pour la fenêtre
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        // Créer un panneau pour le titre
        JLabel title = new JLabel("Jeu d'échecs", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));

        /*// Créer un panneau pour la présentation du jeu
        JPanel presPanel = new JPanel();
        presPanel.setLayout( new BoxLayout(presPanel,BoxLayout.Y_AXIS) );

        JLabel presentation1 = new JLabel("Bienvenue dans le jeu d'échecs", SwingConstants.CENTER);
        JLabel presentation2 = new JLabel("Veuillez entrer les noms des joueurs en sachant que le joueur blanc jouera en premier :", SwingConstants.CENTER);
        presentation1.setFont(new Font("Arial", Font.PLAIN, 15));
        presentation2.setFont(new Font("Arial", Font.PLAIN, 15));

        presPanel.add(presentation1);*/

        //titlePanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        contentPane.add(title, BorderLayout.NORTH);
        //contentPane.add(titlePanel, BorderLayout.NORTH);
        //contentPane.add(presPanel, BorderLayout.NORTH);

        // Créer un panneau pour les noms des joueurs
            JPanel panel = new JPanel();
            panel.setLayout( new FlowLayout() );

                JTextField txtb_player1 = new JTextField(10);
                txtb_player1.setBounds(50, 100, 200, 30);
                txtb_player1.setText("Player 1");
                txtb_player1.setForeground(Color.BLACK);
                txtb_player1.setBackground(Color.WHITE);

                JTextField txtb_player2 = new JTextField(10);
                txtb_player2.setBounds(50, 100, 200, 30);
                txtb_player2.setText("Player 2");
                txtb_player2.setForeground(Color.WHITE);
                txtb_player2.setBackground(Color.BLACK);

                JButton swap = new JButton("↔");
                swap.addActionListener( actionEvent -> {
                    String temp = txtb_player2.getText();
                    txtb_player2.setText( txtb_player1.getText() );
                    txtb_player1.setText( temp );
                });

                panel.add(txtb_player1);
                panel.add(swap);
                panel.add(txtb_player2);

            contentPane.add(panel, BorderLayout.CENTER);

        this.setContentPane(contentPane);

        JButton start = new JButton("Jouer");
        start.addActionListener( actionEvent -> {
            player1Name = txtb_player1.getText();
            player2Name = txtb_player2.getText();
            this.dispose();
            MainGame.startGame();
        });

        contentPane.add(start, BorderLayout.SOUTH);

        // Afficher la fenêtre
        this.setVisible(true);
    }

    public String getNameP1(){ return player1Name; }

    public String getNameP2(){ return player2Name; }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Rayane
        label1 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("                    Jeu d'\u00e9checs");
        label1.setForeground(Color.black);
        label1.setFont(label1.getFont().deriveFont(Font.BOLD, label1.getFont().getSize() + 10f));
        contentPane.add(label1, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Rayane
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
