package GUI;

import javax.swing.*;

public class Validation {
    private JPanel rootPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Build Validation");
        frame.setContentPane(new Validation().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);
    }
}
