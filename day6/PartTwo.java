//worst code you'll see today :)

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        List<Character> done = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        String c = s.nextLine();
        for (int i = 0; i<c.length(); i++){
            done.add(c.charAt(i));
        }

        while (s.hasNextLine()) {
            String a = s.nextLine();
            if (a.equals("")){
                counts.add(done.size());
                done = new ArrayList<>();
                String b = s.nextLine();
                for (int i = 0; i<b.length(); i++){
                    done.add(b.charAt(i));
                }
            }
            else {
                List<Character> person = new ArrayList<>();
                for (int i = 0; i<a.length(); i++){
                    person.add(a.charAt(i));
                }
                for (int i = 0; i<done.size(); i++){
                    if (!person.contains(done.get(i))){
                        done.remove(i);
                        i--;
                    }
                }
            }
        }
        counts.add(done.size());
        int sum = counts.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
