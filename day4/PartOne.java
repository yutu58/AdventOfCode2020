import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        String[] required = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
        int result = 0;
        String part = "";
        while(s.hasNextLine()){
            part = s.nextLine();
            int count = 0;
            while (!part.equals("")){
                String[] arrPart = part.split(" ");
                for (String j : arrPart) {
                    for (int i = 0; i < required.length; i++) {
                        if (j.startsWith(required[i])) {
                            count++;
                        }
                    }
                }
                part = s.nextLine();
            }
            if (count == 7) {
                result++;
            }
        }
        System.out.println(result);
    }
}
