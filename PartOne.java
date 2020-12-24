import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        Set<String> black = new HashSet<>();

        while(s.hasNextLine()){
            String l = s.nextLine();
            int x = 0;
            int y = 0;
            char[] chars = l.toCharArray();
            for (int i = 0; i < chars.length; i++){
                char c = chars[i];
                switch (c) {
                    case 'e' -> x++;
                    case 'w' -> x--;
                    case 's' -> {
                        i++;
                        c = chars[i];
                        switch (c) {
                            case 'e' -> y++;
                            case 'w' -> {
                                y++;
                                x--;
                            }
                        }
                    }
                    case 'n' -> {
                        i++;
                        c = chars[i];
                        switch (c) {
                            case 'e' -> {
                                y--;
                                x++;
                            }
                            case 'w' -> y--;
                        }
                    }
                }
            }
            String code = x + "." + y;
            if (black.contains(code)){
                black.remove(code);
            }
            else {
                black.add(code);
            }
        }
        System.out.println(black.size());
    }
}
