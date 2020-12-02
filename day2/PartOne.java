import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int result = 0;
        while (s.hasNext()) {
            String input = s.nextLine();
            String[] input1 = input.split(" ");
            String[] input2 = input1[0].split("-");
            int min = Integer.parseInt(input2[0]);
            int max = Integer.parseInt(input2[1]);
            int count = 0;
            char character = input1[1].charAt(0);
            String password = input1[2];

            for (char i : password.toCharArray()){
                if (i == character) {
                    count++;
                }
            }

            if (count >= min && count <= max){
                result++;
            }
        }
        System.out.println(result);


    }
}
