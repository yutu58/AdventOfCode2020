import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        long time = Long.parseLong(s.nextLine());
        long start = time;

        String[] input = s.nextLine().split(",");
        List<Integer> busses = new ArrayList<>();

        for(String i : input){
            try {
                busses.add(Integer.parseInt(i));
            } catch (Exception ignored){}
        }

        while (true){
            for(int bus : busses){
                if (time % bus == 0){
                    System.out.println((time - start) * bus);
                    return;
                }
            }
            time++;
        }
    }
}

