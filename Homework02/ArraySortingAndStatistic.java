import java.util.*;
import javax.swing.JOptionPane;

public class ArraySortingAndStatistic {

    public static void main(String[] args) {
        String cmdStr = "Enter 'Y' to enter your array, enter 'N' to use default array";
        System.out.println(cmdStr);
        String inputStr, sumStr = "The sum of array elements is: ", avgStr = "The average of array elements is: ";
        Scanner sc = new Scanner(System.in);
        inputStr = sc.next();
        List<Integer> list = new ArrayList<>();
        if (inputStr.equals("Y")) {
            int n;
            System.out.println("Enter the number of elements in the array: ");
            n = sc.nextInt();
            System.out.println("Enter the elements in the array: ");
            for (int i = 0; i < n; i++) {
                list.add(sc.nextInt());
            }
        }
        else if (inputStr.equals("N")) {
            list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
        }
        else {
            JOptionPane.showMessageDialog(null, "Invalid input enter", "Invalid input enter", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        Collections.sort(list);
        System.out.print("The sorted array is: ");
        int sum = 0;
        for (int i : list) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(sumStr + sum);
        System.out.println(avgStr + String.format("%.2f", (double)sum / list.size()));
        System.exit(0);
    }
}
