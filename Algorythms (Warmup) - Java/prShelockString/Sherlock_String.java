import java.util.Arrays;

public class Sherlock_String {
    private String s; // Given String
    private int cnt; // Stores the number of ocurrences of the first analyzed character of String s
    private char ch; // Current character being analyzed
    private int iter; // Current iteration of the 'I go down' letter_Change case
    private int n; // Counts the number of ocurrences of each character in the String s
    private int val; // Counts the how many times has the limit been unfullfiled
    private static final int MAX_VAL = 2; // Set the number of times a character can be repeated

    public Sherlock_String(String s) {
        this.s = sort(s);
        this.cnt = 1;
        this.iter = 0;
        this.ch = s.charAt(0);
        this.n = 1;
        this.val = 0;
    }

    public String sort(String s) {
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        return new String(s);
    }

    // If I go up, only original 'cnt' values may be accepted (depends on 'iter' value)
    // If I go down, only new 'cnt' values may be accepted
    public void letter_Change(int j) {
        ch = s.charAt(j);
        iter++;
        if(n == cnt - 1) { // Down
            if(iter > 1) {
                val = MAX_VAL + 1;
            }
            cnt = n;
            val++;
            n = 1;
            ch = s.charAt(j);
        } else if (n == cnt + 1) { // Up
            val++;
            n = 1;
            ch = s.charAt(j);
        } else if (cnt == n) { // Same
            n = 1;
            ch = s.charAt(j);
        } else {               // Some other thing (automatic Fail)
            val = MAX_VAL + 1;
        }
    }

    public void is_Valid() {
        int i = 1;
        while(s.charAt(i) == ch) {
            n++;
            cnt++;
            i++;
        }

        n = 0;
        ch = s.charAt(i);

        for(int j = i; j < s.length() && val < MAX_VAL; j++) {
            if(s.charAt(j) != ch) {
                letter_Change(j);
            } else {
                n++;
            }
        }

        if(n == cnt - 1 && iter != 0) {
            val = MAX_VAL + 1;
        }

        letter_Change(0);
        System.out.println("cnt is " + cnt);
        if(val < MAX_VAL) {
            System.out.println("val is: " + val);
            System.out.println("YES");
        } else {
            System.out.println("val is: " + val);
            System.out.println("NO");
        }
    }
}



