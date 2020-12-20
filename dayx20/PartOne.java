import java.io.*;
import java.util.*;

public class PartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        Map<String, List<String>> map = new HashMap<>();
        Map<Integer, List<String>> map2 = new HashMap<>();
        int tilesize = 10;

        while(s.hasNextLine()){
            String l = s.nextLine();
            l = l.split(" ")[1];
            List<String> bone = new ArrayList<>();
            StringBuilder up = new StringBuilder();
            StringBuilder down = new StringBuilder();
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int i = 0; i < tilesize; i++){
                String q = s.nextLine();
                if (i == 0) {
                    up.append(q);
                }
                else if (i == tilesize-1){
                    down.append(q);
                }
                left.append(q.charAt(0));
                right.append(q.charAt(q.length()-1));
            }
            bone.add(up.toString());
            bone.add(up.reverse().toString());
            bone.add(down.toString());
            bone.add(down.reverse().toString());
            bone.add(left.toString());
            bone.add(left.reverse().toString());
            bone.add(right.toString());
            bone.add(right.reverse().toString());
            int index = Integer.parseInt(l.substring(0, l.length()-1));
            map2.put(index, new ArrayList<>());
            List<String> b = map2.get(index);
            for (int i = 0; i < bone.size(); i++){
                String rib = bone.get(i);
                b.add(rib);
                if (!map.containsKey(rib)){
                    List<String> q = new ArrayList<>();
                    map.put(rib, q);
                }
                List<String> q = map.get(rib);
                q.add(l + i);
            }
            if (s.hasNextLine()) {
                s.nextLine();
            }
        }

        //map: takes a side and maps to which tiles have that side

        //map2: takes a tile and maps to which sides that tile has.
        long result = 1;
        for (int i : map2.keySet()){
            List<String> ribs = map2.get(i);
            int solocount = 0;
            for (String rib : ribs) {
                int amount = map.get(rib).size();
                if (amount == 1){
                    solocount++;
                }
            }
            if (solocount == 4) { //if it's a corner
                result *= i;
            }
        }
        System.out.println(result);
    }
}
