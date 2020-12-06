import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        List<Character> done = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        while (s.hasNextLine()) {
            String a = s.nextLine();
            if (a.equals("")){
                counts.add(done.size());
                done = new ArrayList<>();
            }
            else {
                for (int i = 0; i<a.length(); i++){
                    if (!done.contains(a.charAt(i))){
                        done.add(a.charAt(i));
                    }
                }
            }
        }
        counts.add(done.size());
        int sum = counts.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
