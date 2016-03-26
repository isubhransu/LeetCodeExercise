/**
 * Created by subhransumishra on 2/20/16.
 */
public class GCDalgo {
    public static void main(String args[]){
        int[] arr = new int[]{36, 12, 23, 6};
        System.out.println(findGCD(arr));
    }
    public static int findGCD(int[] arr){
        int finalgcd =0;
        finalgcd = twoGCD(arr[0], arr[1]);
        for(int i=2; i<=arr.length-1; i++){
            finalgcd = twoGCD(finalgcd, arr[i]);
        }
        return finalgcd;
    }

    public static int twoGCD(int a, int b){
        if(b == 0){
            return a;
        }
        return twoGCD(b, a%b);
    }
}
