import java.io.*;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int result = 0;
        while (s.hasNext()) {
            String input = s.nextLine();
            String[] input1 = input.split(" ");
            String[] input2 = input1[0].split("-");
            int index1 = Integer.parseInt(input2[0]);
            int index2 = Integer.parseInt(input2[1]);
            char character = input1[1].charAt(0);
            String password = input1[2];

            Boolean one = (password.charAt(index1-1) == character);
            Boolean two = (password.charAt(index2-1) == character);
            if (one ^ two) {
                result++;
            }
        }
        System.out.println(result);

    }
}
