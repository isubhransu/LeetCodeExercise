import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by subhransumishra on 2/17/16.
 */
public class RotateArray {
    public static void main(String[] args){
        int[]ArrList = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(getRotated(ArrList, 3)));
    }

    public static int[] getRotated(int[] arr, int k){
        int[] arret = new int[arr.length];
        int n = arr.length;

        for(int i=0; i<n; i++){
        if(i<k) {
            arret[i] = arr[n - k + i];

        }else{
                arret[i] = arr[i - k];
            }
        }
        return arret;
    }
}
