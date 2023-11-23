import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator extends JFrame {
    private final JTextField textField;
    private StringBuilder expression;

    public Calculator() {
        super("原神");

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        expression = new StringBuilder();
        textField.setText("0");
        Font font = new Font("Arial", Font.BOLD, 50);
        textField.setFont(font);
        JScrollPane scrollPane = new JScrollPane(textField, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                ".", "0", "=", "+",
                "(", ")", "C", "<-"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            Color color;
            if(label.equals("=")){
                color = new Color(0, 102, 190);
            }else if(label.equals("/")||label.equals("*")||label.equals("-")||label.equals("+")||label.equals("<-")||label.equals("C")||label.equals("(")||label.equals(")")||label.equals(".")){
                color = new Color(247, 247, 247, 30);
            }else{
                color = new Color(253, 253, 253);
            }
            button.setBackground(color);
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if ("=".equals(buttonText)) {
                try {
                    // 计算表达式结果
                    double result = evaluateExpression(textField.getText());
                    textField.setText(String.valueOf(result));
                } catch (ArithmeticException | IllegalArgumentException ex) {
                    textField.setText("Error");
                }
            } else if ("C".equals(buttonText)) {
                // 清空文本框和表达式
                textField.setText("0");
                expression = new StringBuilder();
            } else if ("<-".equals(buttonText)) {
                // 删除最后一个字符
                String currentText = textField.getText();
                if (!currentText.isEmpty()) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                    expression.deleteCharAt(expression.length() - 1);
                }
            } else {
                // 将按钮文本添加到表达式中
                textField.setText("");
                expression.append(buttonText);
                textField.setText(expression.toString());
            }
        }

        private double evaluateExpression(String expression) {
            Stack<Double> num = new Stack<>();
            Stack<Character> op = new Stack<>();
            if (expression.charAt(0) == '-') {
                expression = '0' + expression;
            }
            char[] ex = expression.toCharArray();
            for (int i = 0; i < expression.length(); i++) {
                if (ex[i] >= '0' && ex[i] <= '9') {
                    int temp = ex[i] - '0';
                    double decimals = 0;
                    boolean tag = false;
                    for (int j = i + 1; j < ex.length; j++) {
                        if (!(ex[j] >= '0' && ex[j] <= '9') && ex[j] != '.') {
                            i = j - 1;
                            break;
                        }
                        if (ex[j] == '.') {
                            tag = true;
                            continue;
                        }
                        if (tag) {
                            decimals = decimals + 0.1 * (ex[j] - '0');
                        } else {
                            temp = temp * 10 + ex[j] - '0';
                        }
                    }
                    num.push(temp + decimals);
                } else if (ex[i] == '(') {
                    op.push(ex[i]);
                } else if (ex[i] == ')') {
                    while (!op.empty() && op.peek() != '(') {
                        double result = calculateResult(num.pop(), num.pop(), op.pop());
                        num.push(result);
                    }
                    op.pop();
                } else {
                    while (!op.empty() && op.peek() != '(' && getPriority(ex[i]) <= getPriority(op.peek())) {
                        double result = calculateResult(num.pop(), num.pop(), op.pop());
                        num.push(result);
                    }
                    op.push(ex[i]);
                }
            }
            while (!op.empty()) {
                double result = calculateResult(num.pop(), num.pop(), op.pop());
                num.push(result);
            }
            return num.peek();
        }

        private double calculateResult(double b, double a, char o) {
            double re;
            switch (o) {
                case '+' -> re = a + b;
                case '-' -> re = a - b;
                case '*' -> re = a * b;
                case '/' -> re = a / b;
                default -> {
                    return 0;
                }
            }
            return re;
        }

        private int getPriority(char c) {
            if (c == '*' || c == '/')
                return 2;
            else if (c == '+' || c == '-')
                return 1;
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}
