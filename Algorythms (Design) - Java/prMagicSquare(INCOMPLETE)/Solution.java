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
    private static final int DIMENSIONS = 3;
    private static final int MAGIC_NUMBER = DIMENSIONS * ((DIMENSIONS * DIMENSIONS + 1) / 2);


    /*
     * Complete the 'formingMagicSquare' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY s as parameter.
     */

    public static int numToSum(int sumRow, int sumCol, int sumDiagRight, int sumDiagLeft) {
        // This may have to change to give a result the number which is most far off the MAGIC_NUMBER
        int res = sumRow;
        //System.out.println("PARAMETROS: " + sumRow + ", " + sumCol + ", " + sumDiagRight + ", " + sumDiagLeft);
        if(Math.abs(res) < Math.abs(sumCol)) {
            res = sumCol;
        }
        if(Math.abs(res) <= Math.abs(sumDiagRight)) {
            res = sumDiagRight;
        }
        if(Math.abs(res) <= Math.abs(sumDiagLeft)) {
            res = sumDiagLeft;
        }
        return res;
    }
    
     public static int proveSum(List<List<Integer>> s, int i, int j) {
        int res = -1;
        int sumRow = 0;
        int sumCol = 0;
        int sumDiagRight = 0;
        int sumDiagLeft = 0;

        for(int x = 0; x < DIMENSIONS; x++) {
            sumRow += s.get(i).get(x);
            sumCol += s.get(x).get(j);
        }

        if(i == 0 && j == 0 || i == DIMENSIONS - 1 && j == DIMENSIONS -1) {
            for(int x = 0; x < DIMENSIONS; x++) {
                sumDiagRight += s.get(x).get(x);
            }
            if(sumRow != MAGIC_NUMBER && sumCol != MAGIC_NUMBER && sumDiagRight != MAGIC_NUMBER) {
                sumRow = MAGIC_NUMBER - sumRow;
                sumCol = MAGIC_NUMBER - sumCol;
                sumDiagRight = MAGIC_NUMBER - sumDiagRight;
                res = numToSum(sumRow, sumCol, sumDiagRight, 0) + s.get(i).get(j);
            }
        } else if(i == 0 && j == DIMENSIONS - 1 || i == DIMENSIONS - 1 && j == 0) {
            for(int x = 0; x < DIMENSIONS; x++) {
                sumDiagLeft += s.get(x).get(DIMENSIONS - 1 - x);
            }
            if(sumRow != MAGIC_NUMBER && sumCol != MAGIC_NUMBER && sumDiagLeft != MAGIC_NUMBER) {
                sumRow = MAGIC_NUMBER - sumRow;
                sumCol = MAGIC_NUMBER - sumCol;
                sumDiagLeft = MAGIC_NUMBER - sumDiagLeft;
                res = numToSum(sumRow, sumCol, 0, sumDiagLeft) + s.get(i).get(j);
            }
        } else if(i == 1 && j == 1) {
            for(int x = 0; x < DIMENSIONS; x++) {
                sumDiagRight += s.get(x).get(x);
            }
            for(int x = DIMENSIONS - 1; x > -1; x--) {
                sumDiagLeft = s.get(x).get(x);
            }
            if(sumRow != MAGIC_NUMBER && sumCol != MAGIC_NUMBER && sumDiagRight != MAGIC_NUMBER && sumDiagLeft != MAGIC_NUMBER) {
                sumRow = MAGIC_NUMBER - sumRow;
                sumCol = MAGIC_NUMBER - sumCol;
                sumDiagRight = MAGIC_NUMBER - sumDiagRight;
                sumDiagLeft = MAGIC_NUMBER - sumDiagLeft;
                res = numToSum(sumRow, sumCol, sumDiagRight, sumDiagLeft) + s.get(i).get(j);
            }
        } else {
            if(sumRow != MAGIC_NUMBER && sumCol != MAGIC_NUMBER) {
                sumRow = MAGIC_NUMBER - sumRow;
                sumCol = MAGIC_NUMBER - sumCol;
                res = numToSum(sumRow, sumCol, 0, 0) + s.get(i).get(j); // FALLO AQUI
            }
        }
        return res;
    }

    public static boolean isMagic(List<List<Integer>> s) {
        boolean ok = true;
        int sumRow = 0;
        int sumCol = 0;
        int sumDiagRight = 0;
        int sumDiagLeft = 0;
        for(int i = 0; i < DIMENSIONS; i++) {
            sumDiagRight += s.get(i).get(i);
            sumDiagLeft += s.get(DIMENSIONS - i - 1).get(DIMENSIONS - i - 1);
            for(int j = 0; j < DIMENSIONS; j++) {
                sumRow += s.get(i).get(j);
                sumCol += s.get(j).get(i);
            }
            if(sumRow != MAGIC_NUMBER || sumCol != MAGIC_NUMBER) {
                ok = false;
            }
            sumRow = 0;
            sumCol = 0;
        }
        if(sumDiagRight != MAGIC_NUMBER || sumDiagLeft != MAGIC_NUMBER) {
            ok = false;
        }
        //System.out.println(sumRow + ", " + sumCol + ", " + sumDiagRight + ", " + sumDiagLeft);
        return ok;
    }
    
    public static int formingMagicSquare(List<List<Integer>> s) {
        int numChange = 0;
        int cost = 0;
        boolean ok = isMagic(s);
       
        int cnt = 0;

        while(cnt < 10) {
            for(int i = 0; i < DIMENSIONS; i++) {
                for(int j = 0; j < DIMENSIONS; j++) {
                    //System.out.println(i + " " + j);
                    numChange = proveSum(s, i, j);
                    if(numChange != -1) {
                        cost += Math.abs(s.get(i).get(j) - numChange);
                        //System.out.println("CAMBIADO " + s.get(i).get(j) + " POR " + numChange + " CON COSTE " + Math.abs(s.get(i).get(j) - numChange));
                        List<Integer> newElement = s.get(i);
                        newElement.set(j, numChange);
                        s.set(i, newElement);
                        System.out.println(s);
                    }
                }
            }
            ok = isMagic(s);
            cnt++;
        }
        return cost;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<Integer> a = Arrays.asList(4, 5, 8);
        List<Integer> b = Arrays.asList(2, 4, 1);
        List<Integer> c = Arrays.asList(1, 9, 7);
        List<List<Integer>> s = Arrays.asList(a, b, c);

        int result = Result.formingMagicSquare(s);
        System.out.println(result);
    }
}
