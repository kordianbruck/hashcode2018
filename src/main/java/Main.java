import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int m = in.nextInt();
            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
        }
    }


    public static boolean doMagic() {
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);


        return true;
    }
}


