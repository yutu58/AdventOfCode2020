import java.io.*;
import java.util.*;

public class PartTwo {
    static Set<Queue<Integer>> p1s = new HashSet<>();
    static Set<Queue<Integer>> p2s = new HashSet<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        Queue<Integer> p1 = new LinkedList<>();
        Queue<Integer> p2 = new LinkedList<>();
        Queue<Integer> winner = null;
        String l;
        do {
            l = s.nextLine();
            try{
                p1.add(Integer.parseInt(l));
            }
            catch (Exception ignored){}
        } while (s.hasNextLine() && !l.equals(""));
        do {
            l = s.nextLine();
            try{
                p2.add(Integer.parseInt(l));
            }
            catch (Exception ignored){}
        } while (s.hasNextLine());
        String win = foo(p1, p2);

        int result = 0;
        if (win.equals("p1")){
            winner = p1;
        }
        else if (win.equals("p2")){
            winner = p2;
        }
        int si = winner.size();
        while (si > 0){
            result += si * p2.poll();
            si--;
        }
        System.out.println(result);
    }

    public static String foo(Queue<Integer> p1, Queue<Integer> p2){
        while(p1.size() > 0 && p2.size() > 0){
            if(p1s.contains(p1) && p2s.contains(p2)){
                return "p1";
            }
            p1s.add(p1);
            p2s.add(p2);
            int p1card = p1.poll();
            int p2card = p2.poll();
            String winner = "";
            if (p1.size() >= p1card && p2.size() >= p2card){
                //dupe p1, p2
                Queue<Integer> p3 = new LinkedList<>(p1);
                Queue<Integer> p4 = new LinkedList<>(p2);
                Queue<Integer> p5 = new LinkedList<>();
                Queue<Integer> p6 = new LinkedList<>();
                for (int i = 0; i < p1card; i++){
                    p5.add(p3.poll());
                }
                for (int i = 0; i < p2card; i++){
                    p6.add(p4.poll());
                }
                winner = foo(p5, p6);
            }
            else if (p1card > p2card){
                winner = "p1";
            }
            else if (p2card > p1card){
                winner = "p2";
            }
            else {
                System.out.println("help");
            }
            if (winner.equals("p1")){
                p1.add(p1card);
                p1.add(p2card);
            }
            else if (winner.equals("p2")){
                p2.add(p2card);
                p2.add(p1card);
            }
        }
        if (p1.size() == 0){
            return "p2";
        }
        else {
            return "p1";
        }
    }
}
