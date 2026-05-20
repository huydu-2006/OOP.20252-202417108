package main.java.util.shutingyard.model;

public class Token {
    private String value;
    private TokenType type;
    private int precedence;

    public Token(String value, TokenType type, int precedence) {
        this.value = value;
        this.type = type;
        this.precedence = precedence;
    }

    public String getValue() {
        return value;
    }

    public TokenType getType() {
        return type;
    }

    public int getPrecedence() {
        return precedence;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Token other = (Token) obj;
        return this.value.equals(other.value) && this.type == other.type && this.precedence == other.precedence;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Value : " + value + ", Type : " + switch(type) {
            case TokenType.NUMBER -> "Number";
            case TokenType.OPERATOR -> "Operator";
            default -> " ";
        }
        + ", precedence : " + precedence;
    }
}
