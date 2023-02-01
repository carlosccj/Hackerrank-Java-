import java.io.*;

class Result {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) {
        String line = "";
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j < (n - i - 1)) {
                    line += " ";
                } else {
                    line += "#";
                }
            }
            System.out.println(line);
            line = "";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result.staircase(n);

        bufferedReader.close();
    }
}
