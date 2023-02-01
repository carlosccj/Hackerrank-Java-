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
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        int ini = 0;
        int res = 0;
        while(ini + m <= s.size()) {
            int sum = 0;
            for(int i = ini; i < m + ini; i++) {
                sum += s.get(i);
            }
            res = sum == d ? res + 1 : res;
            sum = 0;
            ini++;
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<Integer> s = new ArrayList<Integer>();
        s.add(4);
        //s.add(2);
        //s.add(1);
        //s.add(3);
        //s.add(2);
    

        int d = 4;

        int m = 1;

        int result = Result.birthday(s, d, m);
        System.out.println(result);
    }
}
