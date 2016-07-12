package GeeksForGeeks;

/**
 * Created by subhransumishra on 7/11/16.
 *
 * Problem: Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). You are given a target value to
 * search. If found in the array return its index, otherwise return -1. You may assume
 * no duplicate exists in the array.
 *
 * Example:
 * Solution:
 * Complexity:
 */
public class FindingElementrRotatedSortedArray {
    //TODO finish this function
    public static void main(String[] args){
        int[] arr ={ 6, 7, 8, 1, 2, 3, 4};

        System.out.println(findVal(arr, 7));
    }

    public static boolean findVal(int[] arr, int val){
        int left=0;
        int right=arr.length-1;

/**
 1) Find middle point mid = (l + h)/2
 2) If key is present at middle point, return mid.
 3) Else If arr[l..mid] is sorted
 a)     If key to be searched lies in range from arr[l]
 to     arr[mid], recur for arr[l..mid].
 b)     Else recur for arr[mid+1..r]
 4) Else (arr[mid+1..r] must be sorted)
 a)     If key to be searched lies in range from arr[mid+1]
 to     arr[r], recur for arr[mid+1..r].
 b)    Else recur for arr[l..mid]
 */

        while(left < right){
            int mid = left + (right-left)/2;

            if(arr[mid] == val){
                return true;
            }

            if(arr[left] < arr[mid]){
                if(arr[left] <= val && val < arr[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }else{
                if( arr[mid] <= val && val <= arr[right]){
                    left = mid+1;
                    }
                    right = mid-1;
                }
            }
        return false;
        }
    }
