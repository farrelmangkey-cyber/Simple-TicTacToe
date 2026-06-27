import javax.swing.*;
import java.awt.*;

public class StatisticsFrame extends JFrame {
    private Player currentPlayer;

    public StatisticsFrame(Player player) {
        this.currentPlayer = player;

        setTitle("My Statistics");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:"));
        panel.add(new JLabel(currentPlayer.getUsername()));

        panel.add(new JLabel("Wins:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getWins())));

        panel.add(new JLabel("Losses:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getLosses())));

        panel.add(new JLabel("Draws:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getDraws())));

        panel.add(new JLabel("Score:"));
        panel.add(new JLabel(String.valueOf(currentPlayer.getScore())));

        add(panel);
    }
}