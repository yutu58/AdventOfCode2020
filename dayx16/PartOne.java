import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        String input;
        Set<Integer> v = new HashSet<>();
        for (int i = 0; i < 1000; i++){
            v.add(i);
        }

        //Constraints
        for (int q = 0; q < 20; q++){
            input = s.nextLine().split(": ")[1];
            String[] input2 = input.split(" or ");
            for (int i = 0; i < 2; i++){
                String[] input3 = input2[i].split("-");
                int j = Integer.parseInt(input3[0]);
                int k = Integer.parseInt(input3[1]);
                for (int l = j; l <= k; l++){
                    v.remove(l);
                }
            }
        }

        //Own ticket
        s.nextLine();
        s.nextLine();
        s.nextLine();
        s.nextLine();

        //Nearby tickets
        s.nextLine();

        int errorRate = 0;
        while (s.hasNextLine()){
            String[] input2 = s.nextLine().split(",");
            for (int i = 0; i < input2.length; i++){
                int a = Integer.parseInt(input2[i]);
                if (v.contains(a)){
                    errorRate += a;
                }
            }
        }
        System.out.println(errorRate);
    }
}
