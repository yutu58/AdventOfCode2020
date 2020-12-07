import java.io.*;
import java.util.*;

public class PartOne {
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        method("shiny gold");
        System.out.println(result.size());
    }

    public static void method(String a) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        while (s.hasNextLine()) {
            String l = s.nextLine();
            if (l.contains(a) && !l.startsWith(a)) {
                String[] b = l.split(" ");
                String valid = b[0] + " " + b[1];
                System.out.println(valid);
                if (!result.contains(valid)) {
                    result.add(valid);
                    method(valid);
                }
            }
        }
    }
}
