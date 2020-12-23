import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        String input = s.nextLine();
        int moves = 100;
        String[] cup = input.split("");
        List<Integer> cups = new ArrayList<>();
        int[] picked = new int[3];
        for (int i = 0; i < cup.length; i++){
            cups.add(Integer.parseInt(cup[i]));
        }
        for (int i = 0; i < moves; i++){
            List<Integer> niew = new ArrayList<>();
            int pointer = cups.get(0);
            for (int j = 0; j < 3; j++){
                picked[j] = cups.get((1));
                cups.remove((Integer) picked[j]);
            }
            int newNumber = pointer-1;
            while(!cups.contains(newNumber)){
                newNumber--;
                newNumber = Math.floorMod(newNumber, 10);
            }
            for (int j = 0; j < 6; j++){
                int z = cups.get(j);
                niew.add(z);
                if (z == newNumber){
                    niew.add(picked[0]);
                    niew.add(picked[1]);
                    niew.add(picked[2]);
                }
            }
            cups = niew;
            cups.add(cups.remove(0));
        }
        System.out.println(cups);
        //Now you can find the real result manually
    }
}
