
import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Home{

    JFrame frame = new JFrame("Tic-Tac-Toe");
    JLabel title = new JLabel(new ImageIcon("img/title.png"));
    JPanel buttonPanel = new JPanel();
    ImageIcon pb1 = new ImageIcon("img/playButton.png");
    ImageIcon pb2 = new ImageIcon("img/playButton2.png");
    JButton playButton = new JButton(pb1);

    public Home(){
        
        frame.setSize(600, 650);
        frame.getContentPane().setBackground(new Color(255, 211, 182));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        frame.add(title, BorderLayout.CENTER);

        playButton.setBorderPainted(false);
        playButton.setContentAreaFilled(false);
        playButton.setFocusPainted(false);
        playButton.setOpaque(false);

        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 20));
        buttonPanel.setPreferredSize(new Dimension(600, 120));
        buttonPanel.setBackground(new Color(255, 211, 182));
        buttonPanel.add(playButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        playButton.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent e){
                playButton.setIcon(pb2);
            }

            public void mouseExited(MouseEvent e){
                playButton.setIcon(pb1);
            }
        });

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicTacToe();
                frame.dispose(); 
                
            }
        });

        frame.setVisible(true);
    }




    }




