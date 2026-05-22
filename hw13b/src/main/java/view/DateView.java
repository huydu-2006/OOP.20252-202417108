package main.java.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DateView extends JFrame {
    private JTextField dateDisplayField;
    private JTextField inputField;
    private JButton subtractDaysBtn;
    private JButton addDaysBtn;
    private JButton subtractMonthsBtn;
    private JButton addMonthsBtn;
    private JLabel errorLabel;

    public DateView() {
        setTitle("Date display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        pack();
        setResizable(false);
        setMinimumSize(new Dimension(460, 300));
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        this.add(buildTitlePanel(), BorderLayout.NORTH);
        this.add(buildCenterPanel(), BorderLayout.CENTER);
        this.add(buildErrorPanel(), BorderLayout.SOUTH);
    }

    private JPanel buildTitlePanel() {
        JLabel title = new JLabel("DATE DISPLAY", JLabel.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setBorder(new EmptyBorder(0, 0, 10, 0));
        JPanel p = new JPanel(new BorderLayout());
        p.add(title, BorderLayout.CENTER);
        JSeparator sep = new JSeparator();
        sep.setForeground(Color.BLACK);
        p.add(sep, BorderLayout.SOUTH);
        return p;
    }

    private JPanel buildCenterPanel() {
        JPanel p = new JPanel(new GridBagLayout());
        p.setBorder(new EmptyBorder(12, 0, 12, 0));
        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(6, 4, 6, 4);

        // Date display label
        g.gridx = 0;
        g.gridy = 0;
        g.gridwidth = 4;
        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        p.add(dateLabel, g);

        // Date display field
        g.gridy = 1;
        dateDisplayField = new JTextField();
        dateDisplayField.setEditable(false);
        dateDisplayField.setHorizontalAlignment(JTextField.CENTER);
        dateDisplayField.setFont(new Font("SansSerif", Font.BOLD, 16));
        dateDisplayField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 2, true),
                new EmptyBorder(6, 10, 6, 10)));
        p.add(dateDisplayField, g);

        // Input row
        g.gridy = 2;
        g.gridwidth = 1;
        g.weightx = 0;
        JLabel inputLabel = new JLabel("Enter x:");
        inputLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
        p.add(inputLabel, g);

        g.gridx = 1;
        g.gridwidth = 3;
        g.weightx = 1.0;
        inputField = new JTextField();
        inputField.setFont(new Font("SansSerif", Font.PLAIN, 14));
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                new EmptyBorder(4, 8, 4, 8)));
        p.add(inputField, g);

        // Day buttons
        g.gridx = 0;
        g.gridy = 3;
        g.gridwidth = 2;
        subtractDaysBtn = createButton("← x Day");
        p.add(subtractDaysBtn, g);

        g.gridx = 2;
        addDaysBtn = createButton("x Day →");
        p.add(addDaysBtn, g);

        // Month buttons
        g.gridx = 0;
        g.gridy = 4;
        subtractMonthsBtn = createButton("← x Month");
        p.add(subtractMonthsBtn, g);

        g.gridx = 2;
        addMonthsBtn = createButton("x Month →");
        p.add(addMonthsBtn, g);

        return p;
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("SansSerif", Font.BOLD, 13));
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1, true),
                new EmptyBorder(7, 14, 7, 14)));
        return btn;
    }

    private JPanel buildErrorPanel() {
        errorLabel = new JLabel(" ");
        errorLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
        errorLabel.setForeground(Color.RED);
        errorLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel p = new JPanel(new BorderLayout());
        JSeparator sep = new JSeparator();
        sep.setForeground(Color.BLACK);
        p.add(sep, BorderLayout.NORTH);
        p.add(errorLabel, BorderLayout.CENTER);
        return p;
    }

    public void setDateDisplay(String text) {
        dateDisplayField.setText(text);
    }

    public void showError(String message) {
        errorLabel.setText(message);
    }

    public void clearError() {
        errorLabel.setText(" ");
    }

    public String getInputText() {
        return inputField.getText();
    }

    public JButton getSubtractDaysBtn() {
        return subtractDaysBtn;
    }

    public JButton getAddDaysBtn() {
        return addDaysBtn;
    }

    public JButton getSubtractMonthsBtn() {
        return subtractMonthsBtn;
    }

    public JButton getAddMonthsBtn() {
        return addMonthsBtn;
    }
}
