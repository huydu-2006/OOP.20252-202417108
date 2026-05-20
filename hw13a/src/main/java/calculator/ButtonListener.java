package main.java.calculator;

import java.awt.event.*;
import java.math.BigDecimal;
import main.java.util.shutingyard.evaluator.Evaluator;
import main.java.util.shutingyard.lexer.Lexer;
import main.java.util.shutingyard.parser.Parser;

public class ButtonListener implements ActionListener {
    Calculator calculator;

    public ButtonListener(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "C" -> {
                calculator.clearInput();
                calculator.clearOutput();
            }
            case "<-" -> calculator.deleteLastCharacter();
            case "=" -> {
                try {
                    BigDecimal val = (new Evaluator())
                            .eval((new Parser()).parse((new Lexer()).tokenize(calculator.getInput())));
                    BigDecimal stripped = val.stripTrailingZeros();
                    String display = (stripped.scale() <= 0)
                            ? stripped.toBigIntegerExact().toString()
                            : stripped.toString();
                    calculator.updateDisplayOutput(display);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    calculator.updateDisplayOutput("Error");
                    calculator.clearInput();
                }
            }
            default -> calculator.appendToInput(command);
        }
    }
}