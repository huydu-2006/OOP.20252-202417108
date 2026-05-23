package test.java.util.shutingyard.lexer;

import java.util.*;
import main.java.util.shutingyard.lexer.Lexer;
import main.java.util.shutingyard.model.*;
public class TextLexer {
    public static void main(String[] args) {
        main.java.util.shutingyard.lexer.Lexer a = new Lexer();
        String input1 = "1.2+2.2+3.44133";
        String input2 = "1.2+2.2++3.4+44133.";
        List<Token> tokens = a.tokenize(input2);
        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}