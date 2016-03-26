/**
 * Created by subhransumishra on 2/18/16.
 */
public class Lexmaxmin {
    public static void main(String[] args){
        //System.out.println(retMinmax("baagegeeeefws"));
        retMinmax("aabceioud");
    }

    public static String retMinmax(String str){
        int i = 0;
        int max = 0;
        int st = 0;
        int ed = 0;
        int mini = 9999;

        String maxstr = "";
        String minstr = "";
        while(i < str.length()){
            int j = 0;

            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'i'){
                //System.out.println(str.charAt(i));
                ++j;
                st = i;
                ++i;
                if(i >= str.length()){
                    break;
                }
                //System.out.println(str.charAt(i));
                while(str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'o' && str.charAt(i) != 'u' && str.charAt(i) != 'i'){
                    //System.out.println(str.charAt(i));
                    ++j;
                    i++;
                    //System.out.println(i);
                    //System.out.println("In InnerWEhile");
                    if(i >= str.length()){
                        break;
                    }
                }

                ed = i-1;
                if(j > max){
                    max = j;
                    maxstr = str.substring(st, ed);
                    System.out.println(maxstr);
                }

                if(j < mini){
                    mini = j;
                    minstr = str.substring(st, ed);
                    //System.out.println(minstr);
                }

            }else{
                i++;
            }
        }
        //System.out.println(minstr);
        return maxstr;
    }
}
