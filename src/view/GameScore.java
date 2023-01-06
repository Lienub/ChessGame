package view;

import model.*;

import javax.swing.*;
import java.awt.*;


public class GameScore extends JFrame {
    public GameScore(Player winner){
        super("Chess");

        // Créer la fenêtre d'écran de fin'
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

        JLabel title = new JLabel("Fin de la partie", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 40));

        JLabel winnerName = new JLabel(winner.getName() + " a gagné la partie !", JLabel.CENTER);
        winnerName.setFont(new Font("Arial", Font.PLAIN, 18));

        // Créer un panneau pour les boutons
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout( new BoxLayout(buttonPane,BoxLayout.Y_AXIS) );
        Dimension buttonSize = new Dimension(500, 35);

        JButton back = new JButton("Retour au menu");
        back.setPreferredSize(buttonSize);
        back.setMinimumSize(buttonSize);
        back.setMaximumSize(buttonSize);
        back.addActionListener( actionEvent -> {
            this.dispose();
            new GameMenu();
        });

        JButton exit = new JButton("Quitter");
        exit.setPreferredSize(buttonSize);
        exit.setMinimumSize(buttonSize);
        exit.setMaximumSize(buttonSize);
        exit.addActionListener( actionEvent -> {
            this.dispose();
            System.exit(0);
        });

        buttonPane.add(back);
        buttonPane.add(exit);

        // Ajouter les éléments à la fenêtre
        contentPane.add(title, BorderLayout.NORTH);
        contentPane.add(winnerName, BorderLayout.CENTER);
        contentPane.add(buttonPane, BorderLayout.SOUTH);
        this.add(contentPane);

        this.setVisible(true);

    }

}
