import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int x = 0;
        int y = 0;
        int d = 0;

        //The waypoint is represented as a vector (xw, yw) and not by an actual point. The waypoint is relative to the starting point and not to the position of the ship.
        int xw = 10;
        int yw = 1;

        while (s.hasNextLine()) {
            String l = s.nextLine();
            char a = l.charAt(0);
            int b = Integer.parseInt(l.substring(1));
            switch(a){
                case 'N':
                    yw = yw + b;
                    break;
                case 'E':
                    xw = xw + b;
                    break;
                case 'S':
                    yw = yw - b;
                    break;
                case 'W':
                    xw = xw - b;
                    break;
                case 'L':
                    for (int i = 0; i < (b / 90); i++){
                        int oldxw = xw;
                        xw = -yw;
                        yw = oldxw;
                    }
                    break;
                case 'R':
                    for (int i = 0; i < (b / 90); i++) {
                        int oldxw = xw;
                        xw = yw;
                        yw = -oldxw;
                    }
                    break;
                case 'F':
                    for (int i = 0; i < b; i++){
                        x = x + xw;
                        y = y + yw;
                    }
                    break;
            }
        }
        System.out.println(Math.abs(x) + Math.abs(y));
    }
}
