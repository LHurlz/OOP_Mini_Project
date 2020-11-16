package TopTrumpsApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class TopTrumpsMenu extends JFrame implements ActionListener {
    private JButton playButton;
    private JMenu decksMenu;
    private JLabel imageLabel;
    private JPanel panel;

    public TopTrumpsMenu(){
        this.setTitle("Welcome to Top Trumps");
        this.setSize(750,750);
        this.setLocationRelativeTo(null);


        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout());
        this.createDecksMenu();

        this.imageLabel = new JLabel();
        this.imageLabel.setIcon(new ImageIcon(this.getClass().getResource("images/logo.png")));

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(this.decksMenu);


        this.panel=new JPanel();
        this.panel.setLayout(new BoxLayout(this.panel,1));
        this.panel.add(this.imageLabel);
        pane.add(this.panel);


        playButton = new JButton("Play Top Trumps");
        playButton.addActionListener(this);
        this.add(playButton);




        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void createDecksMenu(){
        this.decksMenu = new JMenu("Decks");

        JMenuItem view = new JMenuItem("View Decks");
        view.addActionListener(this);
        this.decksMenu.add(view);

        JMenuItem edit = new JMenuItem("Edit Decks");
        edit.addActionListener(this);
        this.decksMenu.add(edit);

        JMenuItem add = new JMenuItem("Add Decks");
        add.addActionListener(this);
        this.decksMenu.add(add);

        JMenuItem remove = new JMenuItem("Remove Decks");
        remove.addActionListener(this);
        this.decksMenu.add(remove);

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==playButton){
            int confirm = JOptionPane.showConfirmDialog(null,"Would you like to play Top Trumps?");
                if(confirm==JOptionPane.YES_OPTION){
                        new Game();
                        this.dispose();
                }
        }
    }
}
