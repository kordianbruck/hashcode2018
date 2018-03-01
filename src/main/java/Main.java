import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        String filename = "indata/a_example.in";
        Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));

        int rows = in.nextInt();
        int cols = in.nextInt();
        int numVehicles = in.nextInt();
        int numRides = in.nextInt();
        int bonus = in.nextInt();
        int steps = in.nextInt();

        ArrayList<Vehicle> vehicles = new ArrayList<>(numVehicles);
        ArrayList<Ride> rides = new ArrayList<>(numRides);

        for (int i = 0; i < numRides; ++i) {
            rides.add(readRide(in));
        }
        for (int i = 0; i < numVehicles; ++i) {
            vehicles.add(new Vehicle(new Location(0, 0), false));
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


