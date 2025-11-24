
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.Flow;
import javax.swing.*;

public class Final {

    Palette color = new Palette();
    JFrame frame = new JFrame("Tic-Toc-Toe");
    JLabel playText = new JLabel();
    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");
    JPanel buttonsPanel = new JPanel();
    JPanel content = new JPanel();

    public Final() {

        frame.setSize(600, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(color.pink());

        playText.setText("Do you want to play again?");
        playText.setForeground(color.darkPink());
        playText.setFont(new Font("Ariel", Font.BOLD, 20));

        yes.setBackground(color.darkPink()); 
        yes.setOpaque(true); 
        yes.setBorderPainted(false);
        yes.setFocusPainted(false);
        yes.setForeground(Color.white);

        no.setBackground(color.darkPink()); 
        no.setOpaque(true); 
        no.setBorderPainted(false);
        no.setFocusPainted(false);
        no.setForeground(Color.white);

        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonsPanel.add(no);
        buttonsPanel.add(yes);
        buttonsPanel.setBackground(color.pink());

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        playText.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(playText);
        content.add(Box.createVerticalStrut(10));
        content.add(buttonsPanel);
        content.setBackground(color.pink());

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);
        wrapper.add(content); // content will be centered horizontally & vertically
        frame.add(wrapper, BorderLayout.CENTER);

        Dimension originalSize = yes.getPreferredSize();

        yes.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                yes.setPreferredSize(new Dimension(originalSize.width + 10, originalSize.height + 5));
                yes.revalidate(); // refresh layout
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                yes.setPreferredSize(originalSize);
                yes.revalidate();
            }
        });

        no.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                no.setPreferredSize(new Dimension(originalSize.width + 10, originalSize.height + 5));
                no.revalidate(); // refresh layout
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                no.setPreferredSize(originalSize);
                no.revalidate();
            }
        });

        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicTacToe();
                frame.dispose(); 
                
            }
        });

        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                
            }
        });

        frame.setVisible(true);

    }

}
