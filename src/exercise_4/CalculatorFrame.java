package exercise_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorFrame extends JFrame {

    JTextField textField = new JTextField("", 18);

    public CalculatorFrame() {
        super("Calculator");
        setSize(220, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(4, 4, 10, 5));
        for (String buttonName : buttons) {
            JButton button = new JButton(buttonName);
            if (buttonName.equals("=")) {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        calculate(textField.getText().trim());
                    }
                });
            }
            else {
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String content = textField.getText();
                        textField.setText(content + buttonName);
                    }
                });
            }
            jPanel.add(button);
        }
        setLayout(new FlowLayout());
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField);
        add(jPanel);
        setVisible(true);
    }

    void calculate(String expression) {
        Pattern pattern = Pattern.compile("(-?\\d+(\\.\\d+)?)([+*/](-?\\d+(\\.\\d+)?)|-(\\d+(\\.\\d+)?))");
        Matcher matcher = pattern.matcher(expression);
        if (matcher.matches()) {
            int index;
            if (expression.startsWith("-")) {
                for (index = 1; index < expression.length(); index++) {
                    if (expression.charAt(index) == '+' || expression.charAt(index) == '-' ||
                        expression.charAt(index) == '*' || expression.charAt(index) == '/') {
                        break;
                    }
                }
            }
            else {
                for (index = 0; index < expression.length(); index++) {
                    if (expression.charAt(index) == '+' || expression.charAt(index) == '-' ||
                            expression.charAt(index) == '*' || expression.charAt(index) == '/') {
                        break;
                    }
                }
            }
            try {
                double result = 0.0;
                double x1 = Double.parseDouble(expression.substring(0, index));
                double x2 = Double.parseDouble(expression.substring(index+1));
                switch (expression.charAt(index)) {
                    case '+' -> result = x1 + x2;
                    case '-' -> result = x1 - x2;
                    case '*' -> result = x1 * x2;
                    case '/' -> result = x1 / x2;
                }
                textField.setText(Double.toString(result));
            } catch (Exception e) {
                textField.setText("Ошибка!");
            }
        }
        else {
            textField.setText("Ошибка!");
        }
    }

    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
