/**
 * Created by subhransumishra on 6/8/16.
 */



public class MSsubarray {
    public static void main(String[] args){
        int[] arr = {-1, 2, 3, 4, -5, 6};
        getMaxSubArray(arr, arr.length);
    }

    public static int getMaxSubArray(int[] arr, int n){
        if(arr.length == 1){
            return arr[0];
        }
        int m = n/2;
        int left_MSS = getMaxSubArray(arr, m);
        int right_MSS= getMaxSubArray(arr, n-m);
        int leftsum = Integer.MIN_VALUE; int rightsum = Integer.MAX_VALUE; int sum=0;
        for(int i=m; i<n; i++){
            sum=+arr[i];
            rightsum = Integer.max(rightsum, sum);
        }
        for(int i=(m-1); i>=0; i--){
            sum=+arr[i];
            leftsum = Integer.max(leftsum, sum);
        }
        int ans = Integer.max(left_MSS, right_MSS);
        return Integer.max(ans, leftsum+rightsum);
    }
}