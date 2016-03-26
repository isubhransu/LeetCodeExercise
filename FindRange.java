/**
 * Created by subhransumishra on 2/9/16.
 */
public class FindRange {
    public static void main(String[] args){
        int[] arr = new int[] {5, 7, 7, 8, 8, 8, 10};
        findRanges(arr, 6, 8);
    }

    public static int[] findRanges(int[] arr, int n, int x){
        int first, last;
        last = 0;
        first=findFirst(arr, n, x, true);
        last=findFirst(arr, n, x, false);
        System.out.println(first);
        System.out.println(last);
        return new int[] {first, last};
    }

    public static int findFirst(int[] arr, int n, int x, boolean flagg){
        int high=n-1;
        int low=0;
        int mid;
        int start = -1;

        while(low < high){
            mid = (high+low)/2;
            if(arr[mid] == x){
                if(flagg){
                    high = mid;
                }else{
                    low = mid;
                }
                start = mid;
            }else
            if(arr[mid] < x){
                low = mid+1;
                start = mid+1;
            }else
            if(arr[mid] > x){
                high = mid;
                start = mid;
            }
        }
        return start;
    }
}
