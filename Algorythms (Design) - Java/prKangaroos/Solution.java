import java.io.*;

class Result {

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        String res = "NO";
        double jumps = 0;
        if(x1 < x2 && v1 >= v2 || x1 > x2 && v1 <= v2) {
            jumps = Math.abs((double)(x1 - x2) / (double)(v1 - v2));
            System.out.println(jumps);
        }
        if(jumps != 0 && jumps == (int)jumps || x1 == x2) {
            res = "YES";
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        int x1 = Integer.parseInt(args[0]); //0

        int v1 = Integer.parseInt(args[1]); //3

        int x2 = Integer.parseInt(args[2]); //0

        int v2 = Integer.parseInt(args[3]); //2

        System.out.println(Result.kangaroo(x1, v1, x2, v2));
    }
}
