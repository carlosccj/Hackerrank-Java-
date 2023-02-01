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
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static Map<Integer, Integer> createMap(List<Integer> ar) {
        Map<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        Iterator<Integer> it = ar.iterator();
        while(it.hasNext()) {
            int aux = it.next();
            if(freqs.get(aux) == null) {
                freqs.put(aux, 1);
            } else {
                freqs.put(aux, freqs.get(aux) + 1);
            }
        }
        return freqs;
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> freqs = createMap(ar);
        int res = 0;
        for(Integer key : freqs.keySet()) {
            res += ((freqs.get(key) - freqs.get(key) % 2) / 2);
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
