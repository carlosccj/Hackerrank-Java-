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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int high = scores.get(0);
        int low = scores.get(0);
        List<Integer> res = new ArrayList<Integer>(Collections.nCopies(2, 0));
        for(int i = 1; i < scores.size(); i++) {
            if(scores.get(i) > high) {
                high = scores.get(i);
                res.set(0, res.get(0) + 1);
            } else if(scores.get(i) < low) {
                low = scores.get(i);
                res.set(1, res.get(1) + 1);
            }
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //sint n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = new ArrayList<Integer>();
        scores.add(10);
        scores.add(5);
        scores.add(20);
        scores.add(20);
        scores.add(4);
        scores.add(5);
        scores.add(2);
        scores.add(25);
        scores.add(1);
        
        /*
        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
        */

        List<Integer> result = Result.breakingRecords(scores);
        System.out.println(result);
/* 
        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
        */
    }
}
