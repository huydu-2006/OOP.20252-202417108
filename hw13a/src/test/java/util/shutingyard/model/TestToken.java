package test.java.util.shutingyard.model;

import main.java.util.shutingyard.model.*;
public class TestToken {
    public static void main(String[] args) {
        Token a = new Token("1", TokenType.NUMBER, 0);
        System.out.println(a.toString());
    }
}
