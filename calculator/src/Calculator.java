import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    private JTextField textField;
    private Double firstNumber;
    private String operator;

    public Calculator() {
        super("原神");

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        Font font = new Font("Arial", Font.BOLD, 50);
        textField.setFont(font);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        JPanel lastRowPanel = new JPanel(new GridLayout(1,2,5,5));
        JButton clearButton = new JButton("C");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                firstNumber = 0.0;
                operator = null;
            }
        });
        lastRowPanel.add(clearButton);
        JButton backspaceButton = new JButton("<-");
        backspaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String currentText = textField.getText();
                if (!currentText.isEmpty()) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
        });
        lastRowPanel.add(backspaceButton);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(lastRowPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // ActionListener 用于处理按钮点击事件
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            // 处理数字和小数点输入
            if (Character.isDigit(buttonText.charAt(0)) || buttonText.equals(".")) {
                textField.setText("");
                textField.setText(textField.getText() + buttonText);
            }
            // 处理运算符
            else if (buttonText.equals("+") || buttonText.equals("-") ||
                    buttonText.equals("*") || buttonText.equals("/")) {
                firstNumber = Double.parseDouble(textField.getText());
                operator = buttonText;
                textField.setText(operator);
            }
            // 处理等号
            else if (buttonText.equals("=")) {
                double secondNumber = Double.parseDouble(textField.getText());
                double result = calculate(firstNumber, secondNumber, operator);
                textField.setText(String.valueOf(result));
            }
            // 处理清除按钮
            else {
                textField.setText("");
            }
        }
    }

    // 执行基本的算术运算
    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "*" -> {
                return num1 * num2;
            }
            case "/" -> {
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(this, "Error: Division by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return 0;
                }
            }
            default -> {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
