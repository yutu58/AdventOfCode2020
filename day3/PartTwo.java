import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        long slope1 = rightXdownY(1, 1);
        long slope2 = rightXdownY(3, 1);
        long slope3 = rightXdownY(5, 1);
        long slope4 = rightXdownY(7, 1);
        long slope5 = rightXdownY(1, 2);
        System.out.println(slope1 * slope2 * slope3 * slope4 * slope5);
    }

    public static long rightXdownY(int n, int q) throws FileNotFoundException {
        Scanner b = new Scanner(new File("input1.txt"));
        int result = 0;
        int index = 0;
        b.nextLine();
        while (b.hasNext()) {
            for (int i = 1; i < q; i++){
                b.nextLine();
            }
            String input = b.nextLine();
            index = (index + n) % input.length();
            System.out.println(input.charAt(index));
            if (input.charAt(index) == '#'){
                result++;
            }
        }
        b.close();
        return result;
    }
}
