/**
 * Created by subhransumishra on 2/22/16.
 */
public class Findmaxint {
    public static void main(String[] args){
        System.out.println(maxInt(223336226));
    }

    public static int maxInt(int num){
        String numstr = Integer.toString(num);
        String tempstr = "";
        int max = Integer.MIN_VALUE;
        for(int i=0; i<numstr.length()-1; i++){
            if(numstr.charAt(i) != numstr.charAt(i+1)){
                tempstr = numstr.substring(0, i).concat(numstr.substring(i+1, numstr.length()));
                if(max < Integer.parseInt(tempstr)){
                    max = Integer.parseInt(tempstr);
                }
            }
            if(i+1 == numstr.length()-1 && numstr.charAt(i) == numstr.charAt(i-1)){
                tempstr = numstr.substring(0, i).concat(numstr.substring(i+1, numstr.length()));
                if(max < Integer.parseInt(tempstr)){
                    max = Integer.parseInt(tempstr);
                }
            }
        }
        return max;
    }
}
