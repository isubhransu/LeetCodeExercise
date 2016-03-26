import java.util.HashMap;
import java.util.Map;

/**
 * Created by subhransumishra on 2/18/16.
 */

public class Romantonum {
    public static void main(String[] args){
        System.out.println(retNum("MMCDLXXV"));
    }
    public static int retNum(String str){
        int val=0;
        Map<Character, Integer> m = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };

        for(int i=0; i<str.length(); i++){
            if(i == str.length()-1){
                val =val+ m.get(str.charAt(i));
                break;
                }
            if(m.get(str.charAt(i))>=m.get(str.charAt(i+1))){
                val =val+ m.get(str.charAt(i));
            }else{
                val =val- m.get(str.charAt(i));
            }
        }
        return val;
    }
}
