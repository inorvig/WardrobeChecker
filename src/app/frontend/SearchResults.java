package app.frontend;
import java.awt.*;

import javax.swing.*;

public class SearchResults {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setLayout(new GridLayout(0, 1));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(createPanel("abc"));
                frame.add(createPanel("defghij"));
                frame.add(createPanel("klmn"));
                frame.add(createPanel("opq"));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

            private JPanel createPanel(String s) {
                JPanel p = new JPanel(new BorderLayout());
                p.add(new JLabel(s, JLabel.LEFT), BorderLayout.WEST);
                ImageIcon icon2 = new ImageIcon(OutfitMakerPanel.class.getResource("/outfitImages/shit1.gif"));
    			Image img2 = icon2.getImage();
    			Image newimg2 = img2.getScaledInstance(120, 138, java.awt.Image.SCALE_SMOOTH);
    			icon2 = new ImageIcon(newimg2);
                p.add(new JLabel(icon2, JLabel.RIGHT), BorderLayout.EAST);
                p.setBorder(BorderFactory.createLineBorder(Color.blue));
                return p;
            }
        });
    }
}