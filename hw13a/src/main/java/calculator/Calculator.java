package main.java.calculator;

import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame {
    private JPanel header;
    private String[] mode = { "Standard", "Scientific" };
    private JComboBox<String> modeComboBox;
    private String[] userMode = { "Simple", "Programmer" };
    private JComboBox<String> userModeComboBox;

    private JPanel screen;
    private JTextField displayInput;
    private JTextField displayOutput;
    private String input = "";
    private String output = "";

    private JPanel buttons;
    private JPanel bottomRow;

    public Calculator() {
        this.setLayout(new FlowLayout());
        // header
        header = new JPanel(new FlowLayout(
                FlowLayout.CENTER,
                100,
                15));
        modeComboBox = new JComboBox<>(mode);
        header.add(modeComboBox);
        userModeComboBox = new JComboBox<>(userMode);
        header.add(userModeComboBox);
        this.add(header);

        // screen
        screen = new JPanel(new GridLayout(2, 1, 0, 0));
        displayInput = new JTextField();
        displayInput.setPreferredSize(new Dimension(300, 60));
        displayInput.setEditable(false);
        displayInput.setFont(new Font("Arial", Font.BOLD, 30));
        displayInput.setHorizontalAlignment(JTextField.LEFT);

        displayOutput = new JTextField();
        displayOutput.setPreferredSize(new Dimension(300, 60));
        displayOutput.setEditable(false);
        displayOutput.setFont(new Font("Arial", Font.BOLD, 30));
        displayOutput.setHorizontalAlignment(JTextField.RIGHT);
        displayInput.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); // Thêm chút lề trái/phải để chữ không
                                                                               // chạm mép
        displayInput.setMargin(new Insets(0, 0, 0, 0));

        displayOutput.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        displayOutput.setMargin(new Insets(0, 0, 0, 0));
        screen.add(displayInput);
        screen.add(displayOutput);
        this.add(screen);
        // buttons
        buttons = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttonLabels = {
                "C", "<-", "%", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonListener(this));
            buttons.add(button);
        }
        bottomRow = new JPanel(new GridLayout(1, 3, 5, 0));
        for (String label : new String[] { ".", "0", "=" }) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonListener(this));
            bottomRow.add(button);
        }
        JPanel allButtons = new JPanel(new BorderLayout(0, 5));
        allButtons.add(buttons, BorderLayout.CENTER);
        allButtons.add(bottomRow, BorderLayout.SOUTH);
        this.add(allButtons);
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public void appendToInput(String text) {
        if (text.isBlank())
            return;
        input += text;
        updateDisplayInput(input);
    }

    public void clearInput() {
        input = "";
        updateDisplayInput(input);
    }

    public void clearOutput() {
        output = "";
        updateDisplayOutput(output);
    }

    public void deleteLastCharacter() {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
            updateDisplayInput(input.isEmpty() ? "0" : input);
        }
    }

    public String getInput() {
        return input;
    }

    public void updateDisplayInput(String text) {
        displayInput.setText(text);
    }

    public void updateDisplayOutput(String text) {
        displayOutput.setText(text);
    }
}
