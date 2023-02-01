import java.io.*;


class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n (number of pages in the book)
     *  2. INTEGER p (number of page to reach)
     */

    public static int pageCount(int n, int p) {
        int forward = (p - (p % 2)) / 2;
        int backwards = n / 2 - forward;
        return Math.min(forward, backwards);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        

        //Compile and execute: javac Solution.java -> java Solution 40 21

        int n = Integer.parseInt(args[0]); //40

        int p = Integer.parseInt(args[1]); //21


        int result = Result.pageCount(n, p);
        System.out.println("Este es el resultado: " + result);
    }
}
