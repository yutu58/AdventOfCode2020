import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int x = 0;
        int y = 0;
        int d = 0;

        while (s.hasNextLine()) {
            String l = s.nextLine();
            char a = l.charAt(0);
            int b = Integer.parseInt(l.substring(1));
            switch(a){
                case 'N':
                    y = y + b;
                    break;
                case 'E':
                    x = x + b;
                    break;
                case 'S':
                    y = y - b;
                    break;
                case 'W':
                    x = x - b;
                    break;
                case 'L':
                    d = Math.floorMod((d -b), 360);
                    break;
                case 'R':
                    d = Math.floorMod((d+b), 360);
                    break;
                case 'F':
                    switch (d) {
                        case 0 -> x = x + b;
                        case 90 -> y = y - b;
                        case 180 -> x = x - b;
                        case 270 -> y = y + b;
                    }
                    break;
            }
        }
        System.out.println(Math.abs(x) + Math.abs(y));
    }
}
