import java.io.*;
import java.util.*;

public class PartOne {
    static int amount = 135;
    static String[] rules = new String[amount];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));

        //Add the rules into the array
        for (int i = 0; i < amount; i++){
            String l = s.nextLine();
            String[] parts = l.split(": ");
            int a = Integer.parseInt(parts[0]);
            rules[a] = parts[1];
        }

        //Genarate possible sequences for rule x
        List<String> test = poss(0);
        int count = 0;
        while (s.hasNextLine()){
            String l = s.nextLine();
            if (test.contains(l)){
                count++;
            }
        }
        System.out.println(count);

    }

    public static List<String> poss(int x){
        List<String> res = new ArrayList<>();
        if (x == 116){
            res.add("a");
            return res;
        }
        else if (x == 119){
            res.add("b");
            return res;
        }
        String rule = rules[x];
        String[] r = rule.split(" \\| ");
        for (String s : r) {
            List<List<String>> children = new ArrayList<>();
            String[] ru = s.split(" ");
            for (String value : ru) {
                children.add(poss(Integer.parseInt(value)));
            }
            if (children.size() == 1){
                res.addAll(children.get(0));
            }
            else if (children.size() == 2){
               for (int i = 0; i < children.get(0).size(); i++){
                   for (int j = 0; j < children.get(1).size(); j++){
                       res.add(children.get(0).get(i) + children.get(1).get(j));
                   }
               }
            }
            else if (children.size() > 2){
                System.out.println("error");
                return null;
            }
        }
        return res;
    }
}
