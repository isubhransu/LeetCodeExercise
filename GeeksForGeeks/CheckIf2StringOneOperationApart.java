package GeeksForGeeks;

/**
 * Created by subhransumishra on 7/12/16.
 * Company: Yahoo inc.
 * Problem: Compare two strings if they differ by only one operation (add, remove & replace
 * of single letter) then return true else false.
 *
 * Example: Operations: delete, add, replace.
 *  str1 -> "asrdf", str2 ->  "asdff" :False
    str1 -> "asdf", str2 ->  "asdf"   :True
    str1 -> "asdf", str2 ->  "asrdf"  :True
 * Solution:
 * Complexity: TC -> O(n), SC -> O(1);
 */
public class CheckIf2StringOneOperationApart {

    public static void main(String[] args){
        System.out.println(checkIfOneOperationApart("asdf", "asrdf"));
    }

    public static boolean checkIfOneOperationApart(String str1, String str2){
        int n=str2.length()-1;
        int count=0;

        //If 2 Strings size differ by more than 1 then return false.
        if(Math.abs(str1.length() - str2.length()) > 1){
            return false;
        }

        String small = str1;
        String large = str2;

        //Assigning larger string as large and smaller string as small and 'n' is the length of smaller string
        if(str1.length() > str2.length()){
            n = str1.length()-1;
            large = str1;
            small = str2;
        }

        int j =0;


        //iterate over 2 strings (i over large string and j over small)and check if value in respective
        // strings are equal. if not then count++ and keep j as before.
        for(int i = 0; i<=n; i++){
            if(j > n-1){
                break;
            }

            if(large.charAt(i) == small.charAt(j)){
                j++;
                continue;
            }else{
                count++;
            }
        }

        //If count is 0 or 1 then return true.
        if(count <= 1){
            return true;
        }

        return false;
    }
}
