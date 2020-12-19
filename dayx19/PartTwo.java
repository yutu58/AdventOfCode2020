import com.sun.source.tree.BinaryTree;
import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.TreeVisitor;
import org.w3c.dom.*;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
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

        s.nextLine();

        //Genarate possible sequences for rule x
        List<String> t42 = poss(42);
        List<String> t31 = poss(31);
        List<String> cases = new ArrayList<>();
        while (s.hasNextLine()) {
            cases.add(s.nextLine());
        }

        int count = 0;
        for (int j = 0; j < cases.size(); j++){
            String i = cases.get(j);
            String q;

            //needs to have the first 42;
            q = i.substring(0, 8);
            if (!t42.contains(q)){
                cases.remove(i);
                j--;
            }
            //needs to have the 2nd 42
            q = i.substring(8, 16);
            if (!t42.contains(q)){
                cases.remove(i);
                j--;
            }

            //needs to end with a 31
            q = i.substring(i.length()-8);
            if (!t31.contains(q)){
                cases.remove(i);
                j--;
            }
            
            //Now it can only have 42's and 31's, and the amount of 31's cannot be higher than the amount of 42's
            q = i.substring(16, i.length()-8);
            int count0 = 0;
            int count1 = 0;
            while (q.length() > 0 && t42.contains(q.substring(0, 8))){
                q = q.substring(8);
                count0++;
            }
            while (q.length() > 0 && t31.contains(q.substring(0, 8))){
                q = q.substring(8);
                count1++;
            }
            if (q.length() > 0 || count1 > count0){
                cases.remove(i);
                j--;
            }
        }
        System.out.println(cases.size());

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
