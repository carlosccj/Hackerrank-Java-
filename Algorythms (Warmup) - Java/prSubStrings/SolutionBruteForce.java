import java.io.*;
import java.util.*;

public class SolutionBruteForce {

    public static boolean isValid(String ss) {
        boolean valid = false;
        char first = ss.charAt(0);
        int fails = 0;
        for(int i = 1; i < ss.length() && fails < 2; i++) {
            fails = ss.charAt(i) == first ? fails : fails + 1;
        }
        if(fails == 0 || fails == 1 && ss.length() % 2 != 0 && ss.charAt(ss.length() / 2) != first) {
            valid = true;
        }
        return valid;
    }
    
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        int tam = 2;
        long special = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j + tam <= n; j++) {
                if(isValid(s.substring(j, j + tam))) {
                    special++;
                }
            }
            tam++;
        }
        return special + n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        */

        String s = "aaaa";
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
