import java.io.*;
import java.util.*;

public class partOne {
    public static void main(String[] args) throws FileNotFoundException {
        List<Long> input = new ArrayList<>();
        Scanner s = new Scanner(new File("input1.txt"));
        while (s.hasNextLine()) {
            String l = s.nextLine();
            input.add(Long.parseLong(l));
        }

        for (int i = 25; i < input.size(); i++){
            boolean valid = false;
            for (int j = i - 25; j < i; j++) {
                for (int k = j; k < i; k++) {
                    if (input.get(j) + input.get(k) == input.get(i)){
                        valid = true;
                    }
                }
            }
            if (!valid){
                System.out.println(input.get(i));
            }
        }
    }
}

