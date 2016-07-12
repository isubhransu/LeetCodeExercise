package GeeksForGeeks;

/**
 * Created by subhransumishra on 7/11/16.
 * Problem:
 * Example:
 * Solution:
 * Complexity:
 */
public class PermutationsOfAGivenString {
    public static void main(String[] args){
        String str = "abc";
        char[] arr = str.toCharArray();
        printPermutaion(arr, 0, str.length());
    }

    public static void printPermutaion(char[] arr, int start, int end){

        if(start == end){
            return;
        }

        for(int i=1; i<=end; i++){
            char temp = arr[i]; arr[i] = arr[i+start]; arr[i+start] = temp;
            System.out.println(arr);
            printPermutaion(arr, start+1, end);
            temp = arr[i]; arr[i] = arr[i+start]; arr[i+start] = temp;
        }
    }
}
