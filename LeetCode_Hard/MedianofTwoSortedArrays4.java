package LeetCode_Hard;

/**
 * Created by subhransumishra on 7/9/16.
 * Problem:There are two sorted arrays nums1 and nums2 of size
 * m and n respectively. Find the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 *
 * Solution:
 * Complexity:
 */
public class MedianofTwoSortedArrays4{
    //TODO Understand the solution:

    public static void main(String[] args){
        int[] ar1 = {1, 12, 15, 26, 38};
        int[] ar2 = {2, 13, 17, 30, 45};

        System.out.println(getMedianOfArrays(ar1, 0, ar1.length-1, ar2, 0, ar2.length-1));
    }

    private static int getMedianOfArrays(int[] ar1, int i, int j, int[] ar2, int l, int m){
        int n = j-i;
        int median1 = getMedian(ar1, i, j);
        int median2 = getMedian(ar2, l, m);

        if(median1 == median2){
            return median1;
        }

        if(median1 > median2){
            if(n%2==0){
               return getMedianOfArrays(ar1, i, (n/2)-1, ar2, (n/2)-1, m);
            }else{
                return getMedianOfArrays(ar1, i, n/2, ar2, n/2, m);
            }
        }

        if(median1 > median2){
            if(n%2==0){
                return getMedianOfArrays(ar1, (n/2)-1, j, ar2, l, (n/2)-1);
            }else{
                return getMedianOfArrays(ar1, n/2, j, ar2, l, n/2);
            }
        }
        return 0;
    }

    private static int getMedian(int[] arr, int start, int end){
        int median ;
        int n = end-start;
        if((end - start)%2 != 0){
            median = arr[(n)/2];
        }else{
            median = (arr[n/2]+arr[(n/2)-1])/2;
        }

        System.out.print(median);
        return median;
    }
}
