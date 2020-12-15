import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        String[] input = s.nextLine().split(",");
        List<Long> sequence = new ArrayList<>();
        long prev = -1;
        for (String i : input){
            sequence.add(prev);
            prev = Integer.parseInt(i);
        }
        while (sequence.size() <= 2020){
            int a = sequence.lastIndexOf(prev);
            long b;
            if (a == -1) {
                b = 0;
            }
            else {
                b = sequence.size()-a;
            }
            sequence.add(prev);
            prev = b;
        }
        System.out.println(sequence.get(2020));
    }
}

