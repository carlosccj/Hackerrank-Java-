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
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        String result = "1";
        if(year < 1918) {
            if(year % 4 == 0) {
                result += "2.09." + Integer.toString(year);
            } else {
                result += "3.09." + Integer.toString(year);
            }
        } else if(year > 1918) {
            if(year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
                result += "2.09." + Integer.toString(year);
            } else {
                result += "3.09." + Integer.toString(year);
            }
        } else {
            result = "26.09.1918";
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        while(true) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.dayOfProgrammer(year);
        System.out.println(result);
        }
    }
}
