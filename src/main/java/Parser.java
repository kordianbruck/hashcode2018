import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private static int rideId = 0;

    public static void readData(String filename, ArrayList<Vehicle> vehicles, ArrayList<Ride> rides) throws FileNotFoundException {
        rideId = 0;
        Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));

        int rows = in.nextInt();
        int cols = in.nextInt();
        int numVehicles = in.nextInt();
        int numRides = in.nextInt();
        int bonus = in.nextInt();
        int steps = in.nextInt();

        for (int i = 0; i < numRides; ++i) {
            rides.add(readRide(in));
        }
        for (int i = 0; i < numVehicles; ++i) {
            vehicles.add(new Vehicle(new Location(0, 0), false));
        }
    }

    @NotNull
    public static Ride readRide(Scanner in) {
        int startRow = in.nextInt();
        int startCol = in.nextInt();
        int finRow = in.nextInt();
        int finCol = in.nextInt();
        int earliestStart = in.nextInt();
        int latestFinish = in.nextInt();
        return new Ride(rideId++, new Location(startRow, startCol), new Location(finRow, finCol), earliestStart, latestFinish);
    }
}
