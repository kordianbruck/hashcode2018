import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private static int rideId = 0;

    public static void readData(String filename, ArrayList<Vehicle> vehicles, ArrayList<Ride> rides, Simulation s) throws FileNotFoundException {
        readData(new File(filename), vehicles, rides, s);
    }

    public static void readData(File file, ArrayList<Vehicle> vehicles, ArrayList<Ride> rides, Simulation s) throws FileNotFoundException {
        rideId = 0;
        vehicles.clear();
        rides.clear();
        Scanner in = new Scanner(new BufferedReader(new FileReader(file)));

        s.setRows(in.nextInt());
        s.setCols(in.nextInt());
        s.setNumVehicles(in.nextInt());
        s.setNumRides(in.nextInt());
        s.setBonus(in.nextInt());
        s.setSteps(in.nextInt());

        for (int i = 0; i < s.getNumRides(); ++i) {
            rides.add(readRide(in));
        }
        for (int i = 0; i < s.getNumVehicles(); ++i) {
            vehicles.add(new Vehicle(new Location(0, 0)));
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
