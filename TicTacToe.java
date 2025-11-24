
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe {

    protected int boardWidth = 600;
    protected int boardHeigth = 650;
    protected Palette color = new Palette();

    protected JFrame frame = new JFrame("Tic-Tac-Toe");
    protected JLabel textLabel = new JLabel();
    protected JPanel textPanel = new JPanel();
    protected JPanel boardPanel = new JPanel();
    protected JButton board[][] = new JButton[3][3];
    protected String playerX = "X";
    protected String playerO = "O";
    protected String currentPlayer = playerX;
    protected boolean gameOver = false;
    protected int turns = 0;

    TicTacToe() {

        frame.setSize(boardWidth, boardHeigth);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textLabel.setBackground(color.darkPink());
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic-Tac-Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
        boardPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        boardPanel.setLayout(new GridLayout(3, 3, 10, 10));
        boardPanel.setBackground(color.salmon());
        frame.add(boardPanel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton tile = new JButton();
                board[i][j] = tile;
                boardPanel.add(tile);

                tile.setBackground(color.pink());
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                tile.setBorder(BorderFactory.createEmptyBorder());

                tile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver)
                            return;
                        JButton tile = (JButton) e.getSource();

                        if (tile.getText() == "") {
                            tile.setText(currentPlayer);
                            turns++;
                            checkWinner();
                            if (!gameOver) {
                                currentPlayer = currentPlayer == playerX ? playerO : playerX;
                                textLabel.setText(currentPlayer + "'s turn.");
                            }
                        }
                    }
                });
            }
        }
    }

    void funcTimer() {
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            new Final();
            frame.dispose();
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void checkWinner() {

        for (int i = 0; i < 3; i++) {
            if (board[i][0].getText() == "")
                continue;

            if (board[i][0].getText() == board[i][1].getText() && board[i][1].getText() == board[i][2].getText()) {
                for (int j = 0; j < 3; j++) {
                    setWinner(board[i][j]);
                }
                gameOver = true;
                funcTimer();
                return;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i].getText() == "")
                continue;

            if (board[0][i].getText() == board[1][i].getText() && board[1][i].getText() == board[2][i].getText()) {
                for (int j = 0; j < 3; j++) {
                    setWinner(board[j][i]);
                }
                funcTimer();
                gameOver = true;
                return;
            }
        }

        if (board[0][0].getText() != "" && board[0][0].getText() == board[1][1].getText()
                && board[1][1].getText() == board[2][2].getText()) {
            for (int i = 0; i < 3; i++)
                setWinner(board[i][i]);
            funcTimer();
            gameOver = true;
            return;
        }

        if (board[0][2].getText() != "" && board[0][2].getText() == board[1][1].getText()
                && board[1][1].getText() == board[2][0].getText()) {
            setWinner(board[0][2]);
            setWinner(board[1][1]);
            setWinner(board[2][0]);
            gameOver = true;
            funcTimer();
            return;
        }

        if (turns == 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    setTie(board[i][j]);
                }
            }
            funcTimer();
            gameOver = true;
        }
    }

    public void setWinner(JButton tile) {

        tile.setForeground(color.blue());
        tile.setBackground(color.darkPink());
        textLabel.setText(currentPlayer + " is the winner!");

    }

    public void setTie(JButton tile) {
        tile.setForeground(color.blue());
        tile.setBackground(color.darkPink());
        textLabel.setText("Tie!");

    }
}