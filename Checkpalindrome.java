/**
 * Created by subhransumishra on 2/12/16.
 */
public class Checkpalindrome {

    static int fwd=0;
    static int bwd=0;
    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String str){

        int mid = str.length()/2;
        for(int i=0; i<=mid; i++){
            //a-z 65 to 90 & a-z 97 to 122
            if(retChar(str, i+fwd, true)==retChar(str, str.length()-1-i+bwd, false)){
                System.out.println(retChar(str, i+fwd, true)+" is "+retChar(str, str.length()-1-i+bwd, false));
                continue;
            }else{
                System.out.println(retChar(str, i+fwd, true)+" is not "+retChar(str, str.length()-1-i+bwd, false));
                return false;
            }
        }
     return true;
    }

    public static char retChar(String str, int i, boolean dir) {
        if (dir) {
            while (str.charAt(i) < 65 || str.charAt(i) > 122) {
                i++;
                fwd = i;
                //System.out.println(fwd);
            }
            return Character.toLowerCase(str.charAt(fwd));
        } else {
            while (str.charAt(i) < 65 || str.charAt(i) > 122) {
                i--;
                bwd = i;
            }
        return Character.toLowerCase(str.charAt(bwd));
    }

        }
    }


