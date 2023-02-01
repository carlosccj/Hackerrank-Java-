import java.io.*;
import java.util.*;
import javax.imageio.stream.ImageInputStream;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        
        int res = 0;
        int min = a.size() <= b.size() ? 0 : 1;
        int ini = a.get(a.size() - 1);
        int fin = b.get(0);
        
        while(ini <= fin) {
            boolean cont = true;
            int part = -1;
            if(min == 0) {
                for(int i = 0; i < a.size() && cont; i++) {
                    if(ini % a.get(i) == 0 && b.get(i) % ini == 0) {
                        part = i == a.size() - 1 ? a.size() - 1 : -1;
                    } else {
                        cont = false;
                    }
                }
                for(int j = part; j < b.size() && cont; j++) {
                    if(b.get(j) % ini == 0) {
                        res = j == b.size() - 1 ? res + 1 : res;
                    } else {
                        cont = false;
                    }
                }
            } else {
                for(int i = 0; i < b.size() && cont; i++) {
                    if(ini % a.get(i) == 0 && b.get(i) % ini == 0) {
                        part = i == b.size() - 1 ? b.size() - 1 : -1;
                    } else {
                        cont = false;
                    }
                }
                for(int j = part; j < a.size() && cont; j++) {
                    if(ini % a.get(j) == 0) {
                        res = j == a.size() - 1 ? res + 1 : res;
                    } else {
                        cont = false;
                    }
                }
            }
            ini++;
        }
        return res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        /*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());
            */

        List<Integer> arr = new ArrayList<Integer>();
        BufferedReader firstArr = new BufferedReader(new InputStreamReader(System.in));
        String[] a = firstArr.readLine().split(" ");
        for (int i = 0; i < a.length; i++) {
            arr.add(Integer.parseInt(a[i]));
        }
        
        /* arr.add(2);
        arr.add(4); */
        
        List<Integer> brr = new ArrayList<Integer>();
        BufferedReader secondArr = new BufferedReader(new InputStreamReader(System.in));
        String[] b = secondArr.readLine().split(" ");
        for (int i = 0; i < b.length; i++) {
            brr.add(Integer.parseInt(b[i]));
        }

        /* brr.add(16);
        brr.add(32);
        brr.add(96); */
        
        int total = Result.getTotalX(arr, brr);
        System.out.println(total);

        /*
        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
        */
    }
}

