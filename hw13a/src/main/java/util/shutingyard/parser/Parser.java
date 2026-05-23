package main.java.util.shutingyard.parser;

import java.util.*;
import main.java.util.shutingyard.model.*;

public class Parser {
    // postfix form
    public List<Token> parse(List<Token> tokens) {
        List<Token> res = new ArrayList<>();
        Deque<Token> stOperatorToken = new ArrayDeque<>();
        for (Token token : tokens) {
            if (token.getType() == TokenType.NUMBER) {
                res.add(token);
            }
            else {
                while(!stOperatorToken.isEmpty() && stOperatorToken.getLast().getPrecedence() >= token.getPrecedence()) {
                    Token out = stOperatorToken.removeLast();
                    res.add(out);
                }
                stOperatorToken.addLast(token);
            }
        }

        while(!stOperatorToken.isEmpty()) {
            Token out = stOperatorToken.removeLast();
            res.add(out);
        }

        return res;
    }    
}
