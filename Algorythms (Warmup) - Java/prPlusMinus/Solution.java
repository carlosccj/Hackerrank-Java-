import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        double pos = 0;
        double neu = 0;
        double neg = 0;
        for(int i = 0; i < arr.size(); i++) {
            if(0 + arr.get(i) > 0) {
                pos++;
            } else if(0 + arr.get(i) < 0) {
                neg++;
            } else {
                neu++;
            }
        }
        pos = pos == 0 ? 0 : pos / arr.size();
        neg = neg == 0 ? 0 : neg / arr.size();
        neu = neu == 0 ? 0 : neu / arr.size();

        System.out.println((String.format("%.6f", pos)).replace(",", "."));
        System.out.println((String.format("%.6f", neg)).replace(",", "."));
        System.out.println((String.format("%.6f", neu)).replace(",", "."));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
