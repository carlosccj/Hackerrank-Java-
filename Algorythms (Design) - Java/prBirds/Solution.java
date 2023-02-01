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
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        List<Integer> freq = new ArrayList<Integer>(Collections.nCopies(5, 0));
        Iterator<Integer> it = arr.iterator();
        while(it.hasNext()) {
            int aux = it.next();
            freq.set(aux - 1, freq.get(aux - 1) + 1);
        }
        System.out.println(freq);
        int res = 0;
        for(int i = 1; i < freq.size(); i++) {
            res = freq.get(i) > freq.get(res) ? i : res;
        }
        return res + 1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(1);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.add(1);
        

        int result = Result.migratoryBirds(arr);
        System.out.println(result);
    }
}
