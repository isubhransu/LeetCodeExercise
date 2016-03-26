/**
 * Created by subhransumishra on 2/13/16.
 */

import java.util.ArrayList;

public class FindLCP {
    public static void main(String[] args){
        ArrayList<String> strArray = new ArrayList<String>();
        strArray.add("aaaaaaaaaaaaaaaaaaaaaaa");
        strArray.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        strArray.add("aaaaaa");
        strArray.add("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        System.out.println(longestCommonPrefix(strArray));
    }

    public static String longestCommonPrefix(ArrayList<String> strArr) {
        int j=0;
        int p=0;
        boolean b = true;
        if (strArr.get(0).charAt(0) != strArr.get(1).charAt(0)) {
            return "";
        }
        while(b) {
            for (int i = 0; i < strArr.size()-1; i++) {
                if (strArr.get(i).charAt(j) == strArr.get(i + 1).charAt(j)) {
                    p = j;
                } else {
                    b = false;
                }
                j++;
                System.out.println(j);
                System.out.println(strArr.get(i).length());
                if(j == strArr.get(i).length()){
                    b=false;
                    break;
                }
            }
        }

        return strArr.get(0).substring(0, p+1);
    }


}
