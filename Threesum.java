import java.util.Arrays;

/**
 * Created by subhransumishra on 2/20/16.
 */
public class Threesum {
    public static void main(String[] str){
        int[] arr = new int[]{ 7, 2, -5, 10, -3, 4, 9, 1, -6, -10 }; //-4, -1, 1, 2
        System.out.println(getSum(arr, 2));
    }
    public static int getSum(int[] arr, int num){
        Arrays.sort( arr );
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < arr.length - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swapped = true;
                }
            }
        }

        int i=0;
        int k=arr.length-2;
        int r=arr.length-1;
        int min=9999;
        int min2, min3;

        while(i!=k){
            if(Math.abs(num - min) > Math.abs(arr[i]+arr[k]+arr[r] - num)){
                min = arr[i]+arr[k]+arr[r];
            }
            if(arr[i]+arr[k]+arr[r] < num){
                i++;
            }else {
                k--;
                r--;
            }
        }
        return min;
    }
}
