import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        String filename = "indata/a_example.in";
        Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));

        int rows = in.nextInt();
        int cols = in.nextInt();
        int vehicles = in.nextInt();
        int rides = in.nextInt();
        int bonus = in.nextInt();
        int steps = in.nextInt();

        for (int i = 1; i <= rides; ++i) {
            Ride ride = readRide(in);
            System.out.println(ride);
        }
    }

    @NotNull
    private static Ride readRide(Scanner in) {
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        int finRow = in.nextInt();
        int finCol = in.nextInt();
        int earliestStart = in.nextInt();
        int latestFinish = in.nextInt();
        return new Ride(new Location(startRow, startCol), new Location(finRow, finCol), earliestStart, latestFinish);
    }


    public static boolean doMagic() {
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);


        return true;
    }
}


