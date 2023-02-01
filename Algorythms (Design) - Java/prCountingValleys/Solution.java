import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int past = 0;
        int actual = 0;
        int valleys = 0;
        for(int i = 0; i < path.length(); i++) {
            actual = path.charAt(i) == 'U' ? actual + 1 : actual - 1;
            if(past >= 0 && actual < 0) {
                valleys++;
            }
            past = actual;
        }
        return valleys;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String path = bufferedReader.readLine();
            int steps = path.length();

            int result = Result.countingValleys(steps, path);
            System.out.println(result);
        }
    }
}
