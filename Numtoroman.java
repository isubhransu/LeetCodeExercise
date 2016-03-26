import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by subhransumishra on 2/19/16.
 */
public class Numtoroman {
    public static void main(String[] args){
        System.out.println(numRoman(19));
    }

    public static String numRoman(int num){
        String roman = "";
        String str = String.valueOf(num);
        int i=0;
        int len = str.length();

        ArrayList<String> listchar = new ArrayList<String>() {{
            add("I"); //repeats
            add("V");
            add("X"); //repeats
            add("L");
            add("C"); //repeats
            add("D");
            add("M"); //repeats
        }};
        ArrayList<Integer> listval = new ArrayList<Integer>() {{
            add(1);  //0
            add(5);
            add(10);  //2
            add(50);
            add(100);  //4
            add(500);
            add(1000);  //6
        }};

        while(Integer.parseInt(str) != 0){
            int b= 0;
            String rom ="";
            String romprev ="";
            String tr ="";
            int t = 0;
            System.out.println("NumString is: "+str);

            b = Integer.parseInt(""+str);

            if( Integer.parseInt(""+str.charAt(0)) == 4 || Integer.parseInt(""+str.charAt(0))  == 9){
                int j =0;
                while(listchar.get(j) != "M") {
                    if (listval.get(j) < b) {
                        j++;
                        continue;
                    } else {
                        romprev = listchar.get(j-1);
                        rom = listchar.get(j);
                        break;
                    }
                }
                str = ""+(Integer.parseInt(""+str)-(listval.get(j)-listval.get(j-1)));
                roman = roman.concat(romprev);
                roman = roman.concat(rom);
            }else{
                int j =0;
                while(listchar.get(j) != "M"){
                    if(listval.get(j) < b){
                        j++;
                        continue;
                    }else{
                        rom = listchar.get(j-1);
                        break;
                    }
                }
                System.out.println(listval.get(j-1));
                str = ""+(Integer.parseInt(""+str)-listval.get(j-1));
                roman = roman.concat(rom);
            }
            if(Integer.parseInt(str) == 1){
                roman = roman.concat("I");
                break;
            }
            if(Integer.parseInt(str) == 5){
                roman = roman.concat("V");
                break;
            }
            i++;
            //System.out.println(roman);
        }
        return roman;
    }
}
