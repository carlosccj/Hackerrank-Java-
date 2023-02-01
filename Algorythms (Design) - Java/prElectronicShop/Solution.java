import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int result = -1;
        int sum = 0;
        for(int k : keyboards) {
            for(int d : drives) {
                sum = k + d;
                result = (sum > result && sum <= b) ? sum : result;
                sum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = 60;
        int[] keyboards = new int[]{40, 50, 60};
        int[] drives = new int[]{5, 8, 12};
        System.out.println(getMoneySpent(keyboards, drives, moneySpent));
    }
}
