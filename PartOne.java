import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> input = new ArrayList<>();
        Scanner s = new Scanner(new File("input1.txt"));
        while (s.hasNextLine()) {
            String l = s.nextLine();
            input.add(Integer.parseInt(l));
        }

        Collections.sort(input);
        input.add(input.get(input.size()-1)+3);

        int jolt1 = 0;
        int jolt3 = 0;
        int prev = 0;

        for (int i : input){
            if (i - prev == 1) {
                jolt1++;
            }
            else if (i - prev == 3){
                jolt3++;
            }
            prev = i;
        }

        System.out.println(jolt1 * jolt3);
    }
}

