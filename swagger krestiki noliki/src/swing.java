import javax.swing.*;
import java.awt.*;

public class swing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("крестики нолики");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gridLayout = new GridLayout(3, 3);
        frame.setLayout(gridLayout);
        JButton[] cells = new JButton[9];
        for (int i = 0; i < 9; i++) {
            cells[i] = new JButton();
            frame.add(cells[i]);
        }
        String[] XorO = {"X"};
        for (int i = 0; i < 9; i++) {
            JButton btn = cells[i];
            btn.addActionListener(e -> {
                if (btn.getText().equals("")) {
                    btn.setText(XorO[0]);
                    if (check_win(cells)) {
                        JOptionPane.showMessageDialog(frame, "Победил " + XorO[0]);
                        for (JButton c : cells) c.setEnabled(false);
                    }
                    if (XorO[0].equals("X")) {
                        XorO[0] = "O";
                    } else {
                        XorO[0] = "X";
                    }
                }
            });
        }
        frame.setVisible(true);
    }

    public static boolean check_win(JButton[] cells) {
        if (!cells[0].getText().equals("") && cells[0].getText().equals(cells[1].getText()) && cells[1].getText().equals(cells[2].getText()) ||
                !cells[3].getText().equals("") && cells[3].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[5].getText()) ||
                !cells[6].getText().equals("") && cells[6].getText().equals(cells[7].getText()) && cells[7].getText().equals(cells[8].getText()) ||
                !cells[0].getText().equals("") && cells[0].getText().equals(cells[3].getText()) && cells[3].getText().equals(cells[6].getText()) ||
                !cells[1].getText().equals("") && cells[1].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[7].getText()) ||
                !cells[2].getText().equals("") && cells[2].getText().equals(cells[5].getText()) && cells[5].getText().equals(cells[8].getText()) ||
                !cells[0].getText().equals("") && cells[0].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[8].getText()) ||
                !cells[2].getText().equals("") && cells[2].getText().equals(cells[4].getText()) && cells[4].getText().equals(cells[6].getText())) {
            return true;
        } else {
            return false;
        }
    }
}
