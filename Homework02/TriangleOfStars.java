import java.util.Scanner;
import javax.swing.JOptionPane;

public class TriangleOfStars {
    private static int maxWidth;
    private static int n;
    public static char[] getRow(int level) {
        char[] row = new char[maxWidth];
        for (int i = 0; i < maxWidth; ++i) row[i] = '*';
        int leftLimit = maxWidth / 2 - level, rightLimit = maxWidth / 2 + level;
        for (int i = 0; i < maxWidth; ++i) {
            if (i <= leftLimit || i >= rightLimit) row[i] = ' ';
        }
        return row;
    }
    public static void main(String[] args) {
        String commandStr = "Enter your height of tower";
        String errorString = "Invalid height";

        System.out.println(commandStr);
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        try {
            int val = Integer.parseInt(num);
            if (val < 1) {
                JOptionPane.showMessageDialog(null, errorString, "Error format", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, errorString, "Error format", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        n = Integer.parseInt(num);
        maxWidth = 1 + (n - 1) * 2;
        String triangle = "";
        for (int i = 1; i <= n; ++i) {
            triangle += String.valueOf(getRow(i)) + "\n";
        }
        System.out.println(triangle);
        System.exit(0);
    }
}
