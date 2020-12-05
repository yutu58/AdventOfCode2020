import java.io.*;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        List<Integer> IDs = new ArrayList<>();
        int myId;
        while (s.hasNextLine()) {
            String l = s.nextLine();
            StringBuilder binary = new StringBuilder();
            StringBuilder binary2 = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                if (l.charAt(i) == 'F') {
                    binary.append('0');
                } else if (l.charAt(i) == 'B') {
                    binary.append("1");
                } else if (l.charAt(i) == 'R') {
                    binary2.append('1');
                } else if (l.charAt(i) == 'L') {
                    binary2.append('0');
                }
            }
            int row = Integer.parseInt(binary.toString(), 2);
            int column = Integer.parseInt(binary2.toString(), 2);
            int id = row * 8 + column;
            IDs.add(id);
        }

        for (int i = 0; i < 994; i++){
            if (!IDs.contains(i) && IDs.contains(i-1) && IDs.contains(i+1)){
                System.out.println(i);
            }
        }
    }
}
