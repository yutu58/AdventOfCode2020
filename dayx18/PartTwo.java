import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        long result = 0;
        
        while (s.hasNextLine()) {
            Stack<StringBuilder> a = new Stack<>();
            String l = s.nextLine();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < l.length(); i++){
                if (l.charAt(i) == '('){
                    a.push(sb);
                    sb = new StringBuilder();
                }
                else if (l.charAt(i) == ')'){
                    String ex = sb.toString();
                    String p = calc(ex);
                    sb = a.pop();
                    sb.append(p);
                }
                else {
                    sb.append(l.charAt(i));
                }
            }
            String res = calc(sb.toString());
            result += Long.parseLong(res);
        }
        System.out.println(result);
    }

    public static String calc(String ex){
        ex = ex.replaceAll("\\s", "");
        String[] c = ex.split("\\*");
        long prod = 1;
        for (String a : c) {
            String[] b = a.split("\\+");
            long sum = 0;
            for (String q : b) {
                sum += Long.parseLong(q);
            }
            prod *= sum;
        }
        return Long.toString(prod);
    }
}
