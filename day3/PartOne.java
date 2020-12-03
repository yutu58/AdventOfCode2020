import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int result = 0;
        int index = 0;
        s.nextLine();
        while (s.hasNext()) {
            String input = s.nextLine();
            index = (index + 3) % input.length();
            System.out.println(input.charAt(index));
            if (input.charAt(index) == '#'){
                result++;
            }
        }
        System.out.println(result);
    }
}
