import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class NumberOfDaysInMonth {
    public static Map<String, Integer> getDict() {
        Map<String, Integer> dict = new HashMap<String, Integer>();
        dict.put("January", 31);
        dict.put("February", 28);
        dict.put("March", 31);
        dict.put("April", 30);
        dict.put("May", 31);
        dict.put("June", 30);
        dict.put("July", 31);
        dict.put("August", 31);
        dict.put("September", 30);
        dict.put("October", 31);
        dict.put("November", 30);
        dict.put("December", 31);

        dict.put("Jan.", 31);
        dict.put("Feb.", 28);
        dict.put("Mar.", 31);
        dict.put("Apr.", 30);
        // dict.put("May.", 31);
        dict.put("Jun.", 30);
        // dict.put("July", 31);
        dict.put("Aug.", 31);
        dict.put("Sept.", 30);
        dict.put("Oct.", 31);
        dict.put("Nov.", 30);
        dict.put("Dec.", 31);

        dict.put("Jan", 31);
        dict.put("Feb", 28);
        dict.put("Mar", 31);
        dict.put("Apr", 30);
        // dict.put("May", 31);
        dict.put("Jun", 30);
        dict.put("Jul", 31);
        dict.put("Aug", 31);
        dict.put("Sep", 30);
        dict.put("Oct", 31);
        dict.put("Nov", 30);
        dict.put("Dec", 31);

        dict.put("1", 31);
        dict.put("2", 28);
        dict.put("3", 31);
        dict.put("4", 30);
        dict.put("5", 31);
        dict.put("6", 30);
        dict.put("7", 31);
        dict.put("8", 31);
        dict.put("9", 30);
        dict.put("10", 31);
        dict.put("11", 30);
        dict.put("12", 31);
        return dict;
    }

    public static boolean isValidYear(String year) {
        for (int i = 0; i < year.length(); i++) {
            if (!Character.isDigit(year.charAt(i))) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Map<String, Integer> dict = getDict();
        String monthStr, yearStr, dayStr = "The number of days in this month is: ";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the month number: ");
        monthStr = input.next();
        if (!dict.containsKey(monthStr)) {
            JOptionPane.showMessageDialog(null, "Invalid month number", "Month error format", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        System.out.print("Enter the year number: ");
        yearStr = input.next();
        if (!isValidYear(yearStr)) {
            JOptionPane.showMessageDialog(null, "Invalid year", "Year error format", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        if (dict.get(monthStr) == 28) {
            int year = Integer.parseInt(yearStr);
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                dayStr = dayStr + "29";
            }
            else {
                dayStr = dayStr + "28";
            }
        }
        else {
            dayStr = dayStr + dict.get(monthStr);
        }

        System.out.println(dayStr);
        System.exit(0);
    }
}
