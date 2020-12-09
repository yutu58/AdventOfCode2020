import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<Long> input = new ArrayList<>();
        Scanner s = new Scanner(new File("input1.txt"));
        while (s.hasNextLine()) {
            String l = s.nextLine();
            input.add(Long.parseLong(l));
        }

        long number = 15353384;

        for (int i = 0; input.get(i) < number; i++){
            int j = i;
            long sum = 0;
            long min = Long.MAX_VALUE;
            long max = 0;
            while (sum < number){
                long q = input.get(j);
                if (q < min){
                    min = q;
                }
                if (q > max){
                    max = q;
                }
                sum += q;
                j++;
            }
            if (sum == number){
                System.out.println(min + max);
            }
        }
    }
}

