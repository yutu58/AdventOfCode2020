import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int size = 25;
        Queue<Integer> p1 = new LinkedList<>();
        Queue<Integer> p2 = new LinkedList<>();
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

        while(p1.size() > 0 && p2.size() > 0){
            int p1card = p1.poll();
            int p2card = p2.poll();
            if (p1card > p2card){
                p1.add(p1card);
                p1.add(p2card);
            }
            else if (p2card > p1card){
                p2.add(p2card);
                p2.add(p1card);
            }
            else {
                System.out.println("help");
            }
        }

        int result = 0;
        if (p1.size() != 0){
            int si = p1.size();
            while (si > 0){
                result += si * p1.poll();
                si--;
            }
        }
        else if (p2.size() != 0){
            int si = p2.size();
            while (si > 0){
                result += si * p2.poll();
                si--;
            }
        }
        System.out.println(result);
    }
}
