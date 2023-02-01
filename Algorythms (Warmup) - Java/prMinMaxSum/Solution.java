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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int findHigh(List<Integer> arr) {
        int max = 0;
        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()) {
            int present = it.next();
            max = present > arr.get(max) ? arr.indexOf(present) : max;
        }
        return max;
    }

    public static int findLow(List<Integer> arr) {
        int min = 0;
        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()) {
            int present = it.next();
            min = present < arr.get(min) ? arr.indexOf(present) : min;
        }
        return min;
    }

    public static void miniMaxSum(List<Integer> arr) {
        int indexMax = findHigh(arr);
        int indexLow = findLow(arr);
        long minSum = 0;
        long maxSum = 0;
        int min = arr.get(indexLow);
        int max = arr.remove(indexMax);
        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()) {
            minSum += it.next();
        }
        maxSum = minSum - min + max;
        System.out.println(minSum + " " + maxSum);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}