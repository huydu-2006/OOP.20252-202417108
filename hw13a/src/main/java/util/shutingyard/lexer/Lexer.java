package main.java.util.shutingyard.lexer;

import java.security.InvalidParameterException;
import java.util.*;
import main.java.util.shutingyard.model.Token;
import main.java.util.shutingyard.model.TokenType;

public class Lexer {
    public List<Token> tokenize(String input) {
        List<Token> tokens = new ArrayList<>();
        input = input.trim();
        boolean flagFloating = false;
        String number = "";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                if (c == '.' && flagFloating)
                    throw new InvalidParameterException();
                else if (c == '.' && !flagFloating) {
                    number += Character.toString(c);
                    flagFloating = true;
                    if (i == input.length() - 1) 
                        tokens.add(new Token(number, TokenType.NUMBER, 0));
                } else {
                    if (i == input.length() - 1) 
                        throw new InvalidParameterException("Redundant operator");
                    if (!number.isBlank()) tokens.add(new Token(number, TokenType.NUMBER, 0));
                    flagFloating = false;
                    number = "";
                    tokens.add(new Token(Character.toString(c), TokenType.OPERATOR, switch (c) {
                        case '+' -> 1;
                        case '-' -> 1;
                        case '*' -> 2;
                        case '/' -> 2;
                        case '%' -> 2;
                        default -> 0;
                    }));
                }
            } else {
                number += Character.toString(c);
                if (i == input.length() - 1) 
                    tokens.add(new Token(number, TokenType.NUMBER, 0));
            }
        }
        return tokens;
    }
}
