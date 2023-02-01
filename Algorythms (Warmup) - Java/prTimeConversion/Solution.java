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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        String result = "";
        if(s.charAt(s.length() - 2) == 'A') {
            result = s.charAt(1) == '2' ? "00:" + s.substring(3, s.length() - 2) : s.substring(0, s.length() - 2);
        } else {
            char first, second;
            if(s.charAt(0) == '1' && s.charAt(1) == '2') {
                second = s.charAt(1);
                first = s.charAt(0);
            } else if(((int)(s.charAt(1) - 48) + 2) >= 10) {
                second = (char)((int)(s.charAt(1) - 8));
                first = (char)((int)(s.charAt(0) + 2));
            } else {
                second = (char)((int)(s.charAt(1) + 2));
                first = (char)((int)(s.charAt(0) + 1));
            }
            result = Character.toString(first) + Character.toString(second) + s.substring(2, s.length() - 2);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = "12:26:31PM";

        String result = Result.timeConversion(s);
        System.out.println(result);
        //bufferedWriter.write(result);
        //bufferedWriter.newLine();

        //bufferedReader.close();
        //bufferedWriter.close();
    }
}
