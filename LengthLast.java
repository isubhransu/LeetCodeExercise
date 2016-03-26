/**
 * Created by subhransumishra on 2/13/16.
 */
public class LengthLast {
    public static void main(String[] args){
        System.out.println(lastWord("Hello jhfjvj vh "));
    }

    public static int lastWord(String str) {
        int j=0;
        int st=0;
        boolean b = true;

        while(j != str.length()+1 && b) {

            while (str.charAt(j) != ' ') {
                j++;
                if(j == str.length()){

                    b = false;
                    return j-st;
                }
            }
            while(str.charAt(j)==' '){
                j++;
                if(j == str.length()){
                    b = false;
                    return j-st-1;
                }
            }
            st = j+1;
        }

     return st;
    }
}