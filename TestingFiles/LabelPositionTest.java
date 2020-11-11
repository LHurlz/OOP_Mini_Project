package TestingFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LabelPositionTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("label positioning test");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = (JPanel) frame.getContentPane();
        panel.setLayout(null);

        JLabel label=new JLabel("");
        ImageIcon courtois = new ImageIcon("TopTrumps/images/courtois.png");
        label.setIcon(courtois);

        JButton heightButton = new JButton();
        heightButton.setBounds(110,240,83,10);
        heightButton.setOpaque(false);
        heightButton.setContentAreaFilled(false);
        heightButton.setBorderPainted(false);

        JButton capsButton = new JButton();
        capsButton.setBounds(110,256,83,10);
        capsButton.setOpaque(false);
        capsButton.setContentAreaFilled(false);
        capsButton.setBorderPainted(false);

        panel.add(heightButton);
        panel.add(capsButton);
        panel.add(label);

        heightButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                Color selectedColor = new Color(12,246,214,62);
                heightButton.setOpaque(true);
                heightButton.setBackground(selectedColor);
            }

            public void mouseExited(MouseEvent evt) {
                heightButton.setOpaque(false);
                heightButton.setContentAreaFilled(false);
                heightButton.setBorderPainted(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showConfirmDialog(null,"Do you wish to \"call\" the height stat?");
                heightButton.setOpaque(false);
                heightButton.setContentAreaFilled(false);
                heightButton.setBorderPainted(false);
            }
        });

        capsButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e){
                Color selectedColor = new Color(12,246,214,62);
                capsButton.setOpaque(true);
                capsButton.setBackground(selectedColor);
            }

            public void mouseExited(MouseEvent evt) {
                capsButton.setOpaque(false);
                capsButton.setContentAreaFilled(false);
                capsButton.setBorderPainted(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showConfirmDialog(null,"Do you wish to \"call\" the caps stat?");
                capsButton.setOpaque(false);
                capsButton.setContentAreaFilled(false);
                capsButton.setBorderPainted(false);
            }
        });


        Dimension size = label.getPreferredSize();
        label.setBounds(0,0,size.width,size.height);

        frame.setSize(225,380);
        frame.setVisible(true);

    }
}
