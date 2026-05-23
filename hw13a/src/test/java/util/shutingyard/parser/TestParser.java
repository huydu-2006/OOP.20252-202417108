package test.java.util.shutingyard.parser;

import java.util.*;
import main.java.util.shutingyard.lexer.Lexer;
import main.java.util.shutingyard.model.Token;
import main.java.util.shutingyard.parser.Parser;

public class TestParser {
    public static void main(String[] args) {
        List<Token> tokens = (new Lexer()).tokenize("1.2+2.2+3.4+44133.");
        Parser parser = new Parser();
        List<Token> res = parser.parse(tokens);
        for (Token token : res) {
            System.out.println(token);
        }
    }
}
