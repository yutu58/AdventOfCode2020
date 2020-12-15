import java.io.*;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        String[] input = s.nextLine().split(",");
        List<Long> sequence = new ArrayList<>();

        Map<Long, Long> seq = new HashMap<>();
        long prev = -1;
        long count = 0;
        for (String i : input){
            seq.put(prev, count);
            count++;
            prev = Integer.parseInt(i);
        }
        while (count <= 30000000){
            long b;
            if (!seq.containsKey(prev)) {
                b = 0;
            }
            else {
                b =count-seq.get(prev);
            }
            seq.put(prev, count);
            count++;
            prev = b;
        }
        for (Map.Entry<Long, Long> m : seq.entrySet()){
            if (30000000 == m.getValue()){
                System.out.println(m.getKey());
            }
        }
    }
}

