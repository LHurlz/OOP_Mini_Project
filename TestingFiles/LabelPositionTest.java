package TestingFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelPositionTest {

    static JFrame frame;

    public static void main(String[] args) {
        frame = new JFrame("label positioning test");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JLabel label=new JLabel("");
        label.setLayout(null);

        ImageIcon courtois = new ImageIcon("images/courtois.png");
        label.setIcon(courtois);

        JButton heightButton = new JButton();
        heightButton.setBounds(110,240,83,10);

        heightButton.setBorderPainted(false);

        JButton capsButton = new JButton();
        capsButton.setBounds(110,256,83,10);

        capsButton.setBorderPainted(false);

        Color selectedColor = new Color(150,150,250,62);

        capsButton.setOpaque(false);

        capsButton.setBackground(selectedColor); //interestingly if this isn't done then you will see the "grey" button on startup

        heightButton.setOpaque(false);

        heightButton.setBackground(selectedColor); //as above

        // followed the advice at https://stackoverflow.com/questions/24275267/placing-button-on-top-of-image
        // and added the buttons to the label rather than to the panel

        label.add(heightButton);
        label.add(capsButton);

        panel.add(label);

        /*Fantastic to see you using anonymous inner classes and they are perfectly acceptable but in this
        situation, given that the code will be very similar across the various buttons, it would be easier for
        you to either create a private inner class or let the class itself implement the listener interface*/


        heightButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){

                panel.repaint(); //necessary to prevent the painting problems encountered (stick one in each method)

                Color selectedColor = new Color(150,150,250,62);

                heightButton.setOpaque(true);

                heightButton.setBackground(selectedColor);

            }

            public void mouseExited(MouseEvent evt) {

                heightButton.setOpaque(false);

                panel.repaint();

            }

            @Override
            public void mouseClicked(MouseEvent e) {

                heightButton.setOpaque(false);

                JOptionPane.showConfirmDialog(null,"Do you wish to \"call\" the height stat?");

            }

        });

        capsButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){

                panel.repaint();

                Color selectedColor = new Color(150,150,250,62);
                capsButton.setOpaque(true);

                capsButton.setBackground(selectedColor);

            }

            public void mouseExited(MouseEvent evt) {

                capsButton.setOpaque(false);

                panel.repaint();

            }


            @Override
            public void mouseClicked(MouseEvent e) {
                capsButton.setOpaque(false);

                JOptionPane.showConfirmDialog(null,"Do you wish to \"call\" the caps stat?");

            }
        });


        label.setBounds(0,0, courtois.getIconWidth(), courtois.getIconHeight());
        label.setPreferredSize(new Dimension(courtois.getIconWidth(),courtois.getIconHeight()));
        frame.setContentPane(panel);

        frame.setSize(225,380);
        frame.setVisible(true);

    }
}
