import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private Player currentPlayer;
    private PlayerService playerService;
    private GameLogic gameLogic;
    private JButton[] buttons;
    private JLabel lblStatus;

    public GameFrame(Player player) {
        this.currentPlayer = player;
        this.playerService = new PlayerService();
        this.gameLogic = new GameLogic();

        setTitle("Tic-Tac-Toe Game");
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        lblStatus = new JLabel("Your turn (X)", JLabel.CENTER);
        add(lblStatus, BorderLayout.NORTH);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));

        buttons = new JButton[9];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 40));
            boardPanel.add(buttons[i]);
        }

        add(boardPanel, BorderLayout.CENTER);

        for (int i = 0; i < buttons.length; i++) {
            final int index = i;
            buttons[i].addActionListener(e -> handlePlayerMove(index));
        }
    }

    private void handlePlayerMove(int index) {
        boolean moved = gameLogic.makeMove(index, 'X');
        if (!moved) {
            return;
        }

        buttons[index].setText("X");
        buttons[index].setEnabled(false);

        if (gameLogic.checkWinner('X')) {
            finishGame("WIN");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }

        int computerIndex = gameLogic.computerMove();
        if (computerIndex != -1) {
            gameLogic.makeMove(computerIndex, 'O');
            buttons[computerIndex].setText("O");
            buttons[computerIndex].setEnabled(false);
        }

        if (gameLogic.checkWinner('O')) {
            finishGame("LOSE");
            return;
        }

        if (gameLogic.isDraw()) {
            finishGame("DRAW");
            return;
        }
    }

    private void finishGame(String result) {
        playerService.updateStatistics(currentPlayer, result);
        JOptionPane.showMessageDialog(this, "Game result: " + result);

        MainMenuFrame menuFrame = new MainMenuFrame(currentPlayer);
        menuFrame.setVisible(true);
        this.dispose();
    }
}