import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input1.txt"));
        int result = 0;
        String part = "";
        while(s.hasNextLine()){
            part = s.nextLine();
            int count = 0;
            while (!part.equals("")){
                String[] arrPart = part.split(" ");
                for (String j : arrPart) {
                    String[] a = j.split(":");
                    switch(a[0]){
                        case "byr":
                            if(isIntegerBetween(a[1], 1920, 2002)){
                                count++;
                            }
                            break;
                        case "iyr":
                            if(isIntegerBetween(a[1], 2010, 2020)){
                                count++;
                            }
                            break;
                        case "eyr":
                            if(isIntegerBetween(a[1], 2020, 2030)){
                                count++;
                            }
                            break;
                        case "hgt":
                            if(a[1].endsWith("cm")){
                                if (isIntegerBetween(a[1].substring(0, a[1].length()-2), 150, 193)){
                                    count++;
                                }
                            }
                            else if (a[1].endsWith("in")){
                                if (isIntegerBetween(a[1].substring(0, a[1].length()-2), 59, 76)){
                                    count++;
                                }
                            }
                            break;
                        case "hcl":
                            if (a[1].length() == 7 && a[1].startsWith("#")){
                                try{
                                    Integer.parseInt(a[1].substring(1), 16);
                                    count++;
                                } catch (Exception ignored){}
                            }
                            break;
                        case "ecl":
                            List<String> validECL = new ArrayList<>();
                            validECL.add("amb");
                            validECL.add("blu");
                            validECL.add("brn");
                            validECL.add("gry");
                            validECL.add("grn");
                            validECL.add("hzl");
                            validECL.add("oth");
                            if (validECL.contains(a[1])){
                                count++;
                            }
                            break;
                        case "pid":
                            if (a[1].length() == 9) {
                                try{
                                    Integer.parseInt(a[1]);
                                    count++;
                                } catch (Exception ignored){};
                            }
                    }
                }
                part = s.nextLine();
            }
            if (count == 7) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean isIntegerBetween(String a, int b, int c) {
        try{
            int d = Integer.parseInt(a);
            return (d >= b && d <= c);
        } catch (Exception e) {
            return false;
        }
    }
}
