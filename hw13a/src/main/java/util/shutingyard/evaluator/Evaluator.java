package main.java.util.shutingyard.evaluator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.*;
import main.java.util.DoubleInterger;
import main.java.util.shutingyard.model.*;

public class Evaluator {
    public BigDecimal eval(List<Token> tokens) {
        Deque<Token> stNumber = new ArrayDeque<>();
        for (Token token : tokens) {
            System.out.println(token.toString());
        }
        for (Token token : tokens) {
            if (token.getType() == TokenType.NUMBER) {
                stNumber.addLast(token);
            } else {
                if (stNumber.size() < 2)
                    throw new InvalidParameterException("Redundant operator");
                Token b = stNumber.removeLast();
                Token a = stNumber.removeLast();

                BigDecimal valA = new BigDecimal(a.getValue());
                BigDecimal valB = new BigDecimal(b.getValue());
                BigDecimal c = switch (token.getValue()) {
                    case "+" -> valA.add(valB);
                    case "-" -> valA.subtract(valB);
                    case "*" -> valA.multiply(valB);
                    case "/" -> {
                        if (valB.compareTo(BigDecimal.ZERO) == 0)
                            throw new ArithmeticException("Divide by zero");
                        yield valA.divide(valB,
                                new MathContext(12, RoundingMode.HALF_UP));
                    }
                    case "%" -> {
                        if (!(DoubleInterger.check(b.getValue()) && DoubleInterger.check(a.getValue())))
                            throw new ArithmeticException("Module by not integer number");
                        yield BigDecimal.valueOf(
                                (long) Double.parseDouble(a.getValue()) % (long) Double.parseDouble(b.getValue()));
                    }
                    default -> BigDecimal.ZERO;
                };

                stNumber.addLast(new Token(c.toString() + "", TokenType.NUMBER, 0));
            }
        }
        return new BigDecimal(stNumber.removeLast().getValue());
    }
}
