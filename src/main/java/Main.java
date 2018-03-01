import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Main {

    static int maxVehicles = 1000;
    static int maxRides = 1000;


    public static void main(String[] args) throws Exception {
        ArrayList<Vehicle> vehicles = new ArrayList<>(maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(maxRides);
        Simulation simulation = new Simulation();
        File[] files = new File("indata").listFiles();

        int total = 0;
        for (File file : files) {
            Parser.readData(file, vehicles, rides, simulation);
            doCalc(vehicles, rides);
            total += simulation.totalPoints(vehicles);
        }

        System.out.println(total);
    }

    static void doCalc(List<Vehicle> vehicles, List<Ride> rides) {
        rides.sort(Comparator.comparingInt(Ride::getLatestStart));

        for (Ride ride : rides) {
            Optional<Vehicle> v = getOptimalVehicle(vehicles, ride);
            if (!v.isPresent()) {
                v = getVehicle(vehicles, ride);
            }
            v.ifPresent(vehicle -> vehicle.addRide(ride));
        }
    }

    static void printResults(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            v.printDoneRides();
        }
    }

    static Optional<Vehicle> getOptimalVehicle(List<Vehicle> vehicles, Ride ride) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.canServeWithBonus(ride))
                .min(Comparator.comparingInt(o -> o.getLastLocation().getDistance(ride.getStart())));
    }

    static Optional<Vehicle> getVehicle(List<Vehicle> vehicles, Ride ride) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.canServe(ride))
                .min(Comparator.comparingInt(o -> o.getLastLocation().getDistance(ride.getStart())));
    }
}


