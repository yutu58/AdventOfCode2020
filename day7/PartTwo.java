import java.io.*;
import java.util.*;

public class PartTwo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(method("shiny gold"));
    }

    public static int method(String a) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int result = 0;
        while (s.hasNextLine()) {
            String l = s.nextLine();
            if (l.startsWith(a)) {
                String[] b = l.split(" ");
                if (b.length == 7){
                    return 0;
                }
                else {
                    for (int i = 6; i<b.length; i=i+4){
                        String c = b[i-1] + " " + b[i];
                        result += Integer.parseInt(b[i-2]) * (method(c)+1);
                    }
                }
            }
        }
        return result;
    }
}
