import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        String input;
        Set<Integer> v = new HashSet<>();
        List<String> fields = new ArrayList<>();
        List<List<Integer>> ranges = new ArrayList<>();
        List<String[]> valid = new ArrayList<>();

        int twenty = 20;

        for (int i = 0; i < 1000; i++){
            v.add(i);
        }

        //Constraints
        for (int q = 0; q < twenty; q++){
            String[] a = s.nextLine().split(": ");
            fields.add(a[0]);
            input = a[1];
            String[] input2 = input.split(" or ");
            ranges.add(new ArrayList<>());
            for (int i = 0; i < 2; i++){
                String[] input3 = input2[i].split("-");
                int j = Integer.parseInt(input3[0]);
                int k = Integer.parseInt(input3[1]);
                for (int l = j; l <= k; l++){
                    v.remove(l);
                    ranges.get(ranges.size()-1).add(l);
                }
            }
        }

        //Own ticket
        s.nextLine();
        s.nextLine();
        String[] myTicket = s.nextLine().split(",");
        s.nextLine();

        //Nearby tickets
        s.nextLine();


        //Get all the valid tickets
        while (s.hasNextLine()){
            String[] input2 = s.nextLine().split(",");
            boolean b = false;
            for (int i = 0; i < input2.length; i++){
                int a = Integer.parseInt(input2[i]);
                if (v.contains(a)){
                    b = true;
                }
            }
            if (!b){
                valid.add(input2);
            }
        }

        //fields has 20 fields
        //ranges has all valid numbers per field
        //valid has all tickets we need to check on now
        List<List<Integer>> possibilities = new ArrayList<>();
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < twenty; i++){
            List<Integer> possible = new ArrayList<>();
            for (int z = 0; z<twenty; z++){
                possible.add(z);
            }
            for (String[] t : valid){
                int a = Integer.parseInt(t[i]);
                for (int j = 0; j < twenty; j++){
                    List<Integer> b = ranges.get(j);
                    if(!b.contains(a)){
                        possible.remove((Integer) j);
                    }
                }
            }
            possibilities.add(possible);
        }

        for(int q = 0; q < twenty; q++) {
            for (int i = 0; i < twenty; i++) {
                if (possibilities.get(i).size() == 1) {
                    int a = possibilities.get(i).get(0);
                    res.put(i, a);
                    for (int j = 0; j < twenty; j++) {
                        if (possibilities.get(j).contains(a)) {
                            possibilities.get(j).remove((Integer) a);
                        }
                    }
                }
            }
        }

        long ans = 1;
        for (int z = 0; z < twenty; z++){
            int q = res.get(z);
            int onMy = Integer.parseInt(myTicket[z]);
            String field = fields.get(q);
            if (field.startsWith("departure")){
                System.out.println(field);
                ans = ans * onMy;
            }
        }
        System.out.println(ans);
    }
}
