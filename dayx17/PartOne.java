import java.io.*;
import java.util.*;

public class Main {
    static Set<String> mem = new HashSet<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int x = 0;
        int y = 0;
        int z = 0;

        int cycles = 6;

        int width = 0;
        int height = 0;

        while (s.hasNextLine()) {
            String line = s.nextLine();
            for (char i : line.toCharArray()) {
                if (i == '#') {
                    mem.add(x + "." + y + "." + z);
                }
                x++;
            }
            x = 0;
            y++;
            width = line.length();
            height = y;
        }

        for (int i = 0; i < cycles; i++){
            Set<String> newMem = new HashSet<>();
            for (int j = (-cycles - 1); j <= (width + cycles+1); j++){
                for (int k = (-cycles-1); k <= (height + cycles + 1); k++){
                    for (int m = (-cycles-1); m <= (cycles+1); m++){
                        String abc = j + "." + k + "." + m;
                        int nCount = neighbourCount(abc);
                        boolean oldA = (mem.contains(abc));
                        boolean newA = false;
                        if (oldA){
                            newA = (nCount == 2 || nCount ==3);
                        }
                        else {
                            newA = (nCount == 3);
                        }
                        if (newA){
                            newMem.add(abc);
                        }
                    }
                }
            }
            mem = newMem;
        }
        System.out.println(mem.size());
    }

    public static int neighbourCount(String xyz){
        String[] abc = xyz.split("\\.");
        int x = Integer.parseInt(abc[0]);
        int y = Integer.parseInt(abc[1]);
        int z = Integer.parseInt(abc[2]);
        int count = 0;
        for(int i = -1; i < 2; i++){
            for(int j = -1; j < 2; j++){
                for (int k = -1; k < 2; k++){
                    if (!(i == 0 && j == 0 && k == 0)) {
                        String niw = (x + i) + "." + (y+j) + "." + (z+k);
                        if (mem.contains(niw)){
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
