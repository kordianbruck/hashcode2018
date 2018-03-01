import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class Main {

    static int maxVehicles = 1000;
    static int maxRides = 1000;

    static ArrayList<Vehicle> vehicles;
    static ArrayList<Ride> rides;


    public static void main(String[] args) throws Exception {
        vehicles = new ArrayList<>(maxVehicles);
        rides = new ArrayList<>(maxRides);

        Parser.readData("indata/a_example.in", vehicles, rides);

        rides.sort(Comparator.comparingInt(Ride::getLatestStart));

        for (Ride ride : rides) {
            Optional<Vehicle> v = getVehicle(ride);
            v.ifPresent(vehicle -> vehicle.addRide(ride));
        }

        for (Vehicle v : vehicles) {
            System.out.println(v.getDoneRidesList());
        }
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


