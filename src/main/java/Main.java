import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class Main {

    private static int rideId = 0;

    static ArrayList<Vehicle> vehicles;
    static ArrayList<Ride> rides;

    public static void main(String[] args) throws Exception {
        String filename = "indata/a_example.in";
        Scanner in = new Scanner(new BufferedReader(new FileReader(filename)));

        int rows = in.nextInt();
        int cols = in.nextInt();
        int numVehicles = in.nextInt();
        int numRides = in.nextInt();
        int bonus = in.nextInt();
        int steps = in.nextInt();

        vehicles = new ArrayList<>(numVehicles);
        rides = new ArrayList<>(numRides);

        for (int i = 0; i < numRides; ++i) {
            rides.add(readRide(in));
        }
        for (int i = 0; i < numVehicles; ++i) {
            vehicles.add(new Vehicle(new Location(0, 0), false));
        }

        rides.sort(Comparator.comparingInt(Ride::getLatestStart));

        for (Ride ride : rides) {
            Optional<Vehicle> v = getVehicle(ride);
            v.ifPresent(vehicle -> vehicle.addRide(ride));
        }

        for (Vehicle v : vehicles) {
            v.printDoneRides();
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
        return new Ride(rideId++, new Location(startRow, startCol), new Location(finRow, finCol), earliestStart, latestFinish);
    }

    static Optional<Vehicle> getVehicle(Ride ride) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.canServe(ride))
                .findFirst();
    }


    public static boolean doMagic() {
        Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = new PriorityQueue<String>(10, comparator);


        return true;
    }
}


