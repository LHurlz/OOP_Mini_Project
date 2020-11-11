package TestingFiles;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MouseListenTest extends JFrame {
    private JLabel label;
    private JLabel label2;
    public MouseListenTest() {
        setTitle("MouseOver Test");
        setLayout(new FlowLayout());

        label = new JLabel("Attack Label");
        label.setOpaque(true);
        add(label);


        /*label2 = new JLabel("Defence Label");
        label2.setOpaque(true);
        add(label2);*/

        label.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                Color c = label.getBackground(); // When the mouse moves over a label, the background color changed.
                label.setBackground(label.getForeground());
                label.setForeground(c);
            }
            public void mouseExited(MouseEvent evt) {
                Color c = label.getBackground();
                label.setBackground(label.getForeground());
                label.setForeground(c);
            }

            public void mouseClicked(MouseEvent evt){
                JOptionPane.showConfirmDialog(null,"Are you sure you wish to use the attack stat?");
            }
        });

        setSize(400, 275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        /*label2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                Color c = label2.getBackground(); // When the mouse moves over a label, the background color changed.
                label2.setBackground(label2.getForeground());
                label2.setForeground(c);
            }
            public void mouseExited(MouseEvent evt) {
                Color c = label2.getBackground();
                label2.setBackground(label2.getForeground());
                label2.setForeground(c);
            }

            public void mouseClicked(MouseEvent evt){
                JOptionPane.showConfirmDialog(null,"Are you sure you wish to use the defence stat?");
            }
        });*/
    }
    public static void main(String[] args) {
        new MouseListenTest();
    }
}
