package test.java.util.shutingyard.evaluator;

import main.java.util.shutingyard.evaluator.Evaluator;
import main.java.util.shutingyard.lexer.Lexer;
import main.java.util.shutingyard.parser.Parser;

public class TestEvaluator {
    public static void main(String[] args) {
        String input = "1.2+2.2++3.44133";
        System.out.println((new Evaluator()).eval((new Parser()).parse((new Lexer()).tokenize(input))));
    }
}
