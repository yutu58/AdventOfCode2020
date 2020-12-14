import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));

        String mask = "";
        Map<String, Long> memory = new HashMap<>();

        while(s.hasNextLine()){
            String l = s.nextLine();
            String[] p = l.split(" = ");
            if(p[0].equals("mask")){
                mask = p[1];
            }
            else {
                String binary = Long.toBinaryString(Long.parseLong(p[1]));
                binary = ("000000000000000000000000000000000000" + binary).substring(binary.length());

                StringBuilder a = new StringBuilder();
                for(int i = 0; i<36; i++){
                    if (mask.charAt(i) == 'X'){
                        a.append(binary.charAt(i));
                    }
                    else{
                        a.append(mask.charAt(i));
                    }

                }
                long res = Long.parseLong(a.toString(), 2);
                memory.put(p[0], res);
            }
        }
        long ans = 0;
        for (long i : memory.values()){
            ans += i;
        }
        System.out.println(ans);
    }
}
