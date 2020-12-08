import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        List<String> instructions = new ArrayList<>();

        while (s.hasNextLine()){
            instructions.add(s.nextLine());
        }

        for (int i = 0; i < instructions.size(); i++) {
            int q = 0;
            String a = instructions.get(i);
            if (a.startsWith("jmp")){
                instructions.set(i, "nop" + a.substring(3));
                q = method(instructions);
                instructions.set(i, "jmp" + a.substring(3));
            }
            else if (a.startsWith("nop")){
                instructions.set(i, "jmp" + a.substring(3));
                q = method(instructions);
                instructions.set(i, "nop" + a.substring(3));
            }
            if (q != 0) {
                System.out.println(q);
                break;
            }
        }
    }

    public static int method(List<String> instru) throws FileNotFoundException {
        int i = 0;
        int prev = 0;
        int accumulator = 0;
        List<Integer> done = new ArrayList<>();

        while(!done.contains(i) && i < instru.size()){
            done.add(i);
            String instr = instru.get(i);
            int value = Integer.parseInt(instr.substring(4));
            if (instr.startsWith("acc")){
                accumulator += value;
            }
            else if (instr.startsWith("jmp")) {
                prev = i;
                i += value;
                i--;
            }
            i++;
        }
        if (i >= instru.size()){
            return accumulator;
        }
        return 0;
    }
}
