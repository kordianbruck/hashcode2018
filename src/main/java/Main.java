import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.PriorityQueue;


public class Main {

    static int maxVehicles = 1000;
    static int maxRides = 1000;

    static ArrayList<Vehicle> vehicles;
    static ArrayList<Ride> rides;
    static Simulation simulation;


    public static void main(String[] args) throws Exception {
        vehicles = new ArrayList<>(maxVehicles);
        rides = new ArrayList<>(maxRides);

        Parser.readData("indata/a_example.in", vehicles, rides, simulation);

        rides.sort(Comparator.comparingInt(Ride::getLatestStart));

        for (Ride ride : rides) {
            Optional<Vehicle> v = getVehicle(ride);
            v.ifPresent(vehicle -> vehicle.addRide(ride));
        }

        for (Vehicle v : vehicles) {
            v.printDoneRides();
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


