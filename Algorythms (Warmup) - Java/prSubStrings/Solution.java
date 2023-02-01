import java.io.*;
import java.util.*;

public class Solution {

    public static int isValid(String ss, int palindromeCount) {
        int valid = 0;
        char first = ss.charAt(0);
        if(ss.charAt(ss.length() - 1) == first && (palindromeCount == -1 || ss.length() == palindromeCount * 2 + 1)) {
            valid = 0;
        } else if((ss.charAt(ss.length() - 1) != first && palindromeCount == -1) || (ss.charAt(ss.length() - 1) == first && palindromeCount != -1)) {
            valid = 1;
        } else {
            valid = 2;
        }
        return valid;
    }
    
    // Complete the substrCount function below.
    // isValid will return 0 if it's valid, 1 if palindrome, 2 if not valid
    static long substrCount(int n, String s) {
        int tam = 2;
        int valid = -1;
        int pos = 0;
        int palindromeCount = -1;
        long special = 0;
        while(pos < n) {
            valid = -1;
            while(valid < 2 && (pos + tam) < (s.length() + 1)) {
                String ss = s.substring(pos, pos + tam);
                valid = isValid(ss, palindromeCount);
                if(valid == 0) { 
                    special++;
                    tam++;
                    System.out.println("ENCONTRADO " + ss);
                } else if(valid == 1) {
                    tam++;
                    palindromeCount = palindromeCount == -1 ? palindromeCount = ss.length() - 1 : palindromeCount;
                    System.out.println("POSIBLE PALINDROMO " + ss);
                } else {
                    tam = 2;
                    palindromeCount = -1;
                }
            }
            tam = 2;
            palindromeCount = -1;
            pos++;
        }
        return special + n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        */

        String s = "aabaa";
        int n = s.length();
        long result = substrCount(n, s);
        System.out.println(result);

        /*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
        */
        //scanner.close();
    }
}