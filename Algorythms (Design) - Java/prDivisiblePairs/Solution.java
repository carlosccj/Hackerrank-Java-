import java.io.*;
import java.io.ObjectInputStream.GetField;
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
     * Complete the 'divisibleSumPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER_ARRAY ar
     */

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int res = 0;
        for(int i = 0; i < ar.size() - 1; i++) {
            for(int j = i + 1; j < ar.size(); j++) {
                if((ar.get(i) + ar.get(j)) % k == 0) {
                    res++;
                }
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        int k = 3;

        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(6);
        arr.add(1);
        arr.add(2);
        int n = arr.size();

        int result = Result.divisibleSumPairs(n, k, arr);
        System.out.println(result);
    }
}