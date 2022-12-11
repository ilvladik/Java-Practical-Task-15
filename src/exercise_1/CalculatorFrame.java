package exercise_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {

    private JTextField textFieldFirst = new JTextField(10);
    private JTextField textFieldSecond = new JTextField(10);
    private JButton additionButton = new JButton("Addition");
    private JButton subtractionButton = new JButton("Subtraction");
    private JButton multiplicationButton = new JButton("Multiplication");
    private JButton divisionButton = new JButton("Division");

    public CalculatorFrame() {
        super("Calculator");

        setLayout(new FlowLayout());
        setSize(150, 250);

        add(new JLabel("1. "));
        add(textFieldFirst);

        add(new JLabel("2. "));
        add(textFieldSecond);

        add(additionButton);
        additionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(textFieldFirst.getText().trim());
                    double x2 = Double.parseDouble(textFieldSecond.getText().trim());
                    JOptionPane.showMessageDialog(null, "Result = " + (x1 + x2),
                            "Alert", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error in Numbers!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(subtractionButton);
        subtractionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(textFieldFirst.getText().trim());
                    double x2 = Double.parseDouble(textFieldSecond.getText().trim());
                    JOptionPane.showMessageDialog(null, "Result = " + (x1 - x2),
                            "Alert", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error in Numbers!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(multiplicationButton);
        multiplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(textFieldFirst.getText().trim());
                    double x2 = Double.parseDouble(textFieldSecond.getText().trim());
                    JOptionPane.showMessageDialog(null, "Result = " + (x1 * x2),
                            "Alert", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error in Numbers!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        add(divisionButton);
        divisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double x1 = Double.parseDouble(textFieldFirst.getText().trim());
                    double x2 = Double.parseDouble(textFieldSecond.getText().trim());
                    if (x2 != 0) {
                        JOptionPane.showMessageDialog(null, "Result = " + (x1 / x2),
                                "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Division by zero",
                                "Alert", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error in Numbers!", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
