package exercise_2;

import javax.swing.*;

public class ComboBoxFrame extends JFrame {

    public ComboBoxFrame() {
        super("ComboBox");
        setSize(250, 250);
        String[] countries = {"Russia", "German", "China", "Japan"};
        JComboBox jComboBox = new JComboBox<>(countries);
        add(jComboBox);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ComboBoxFrame();
    }
}
