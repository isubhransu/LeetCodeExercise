package GeeksForGeeks;

/**
 * Created by subhransumishra on 7/10/16.
 * Problem:
 * Example:
 * Solution:
 * Complexity:
 */


public class SearchInSorted2DArray{
    //TODO learn how to binary search along 2d row, col
    public static void main(String[] args){
        int[][] arr = {{10, 20, 30, 40},
                       {15, 25, 35, 45},
                       {27, 29, 37, 48},
                       {32, 33, 39, 50}};

        System.out.print(findElement(arr, 29));
    }

    public static boolean findElement(int [][] arr, int num){

        int n = arr.length-1;
        int row = 0;
        int col = n;

        while(col != 0){
            if(arr[row][col] == num){
                return true;
            }

            if(arr[row][col] > num && ifExist(arr, row, col-1, 0)){
                return true;
            }

            if(arr[row][col] < num && ifExist(arr, row-1, col, 1)){
                return true;
            }

            row++;
            col--;
        }
        return false;
    }


    public static  boolean ifExist(int[][] arr, int row, int col, int flip){
        if(flip == 0){
            int mid = (col - row)/2 ;
        }
        return true;
    }


}
