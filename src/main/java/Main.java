import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class Main {

    static int maxVehicles = 1000;
    static int maxRides = 1000;

    static Comparator<Ride>[] sorters = new Comparator[]{
            Comparator.comparingInt(Ride::getLatestStart),
            Comparator.comparingInt(Ride::getTotalDistance).reversed(),
            Comparator.comparingInt(Ride::getTimeEarliest),
            Comparator.comparingInt(Ride::getDistanceToStart),
    };


    public static void main(String[] args) throws Exception {
        ArrayList<Vehicle> vehicles = new ArrayList<>(maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(maxRides);
        Simulation simulation = new Simulation();
        File[] files = new File("indata").listFiles();

        int total = 0;
        for (File file : files) {
            int max = 0;

            Parser.readData(file, vehicles, rides, simulation);
            for (Comparator c : sorters) {
                for (Vehicle v : vehicles) {
                    v.getDoneRides().clear();
                }
                doCalc(vehicles, rides, simulation, c);
                int pts = simulation.totalPoints(vehicles);
                if (pts > max) {
                    simulation.saveResults(vehicles, file.getName());
                    max = pts;
                }
            }
            total += max;
            System.out.println(simulation.totalPoints(vehicles));
        }

        System.out.println("\n" + total);
    }

    static void doCalc(List<Vehicle> vehicles, List<Ride> rides, Simulation s, Comparator c) {
        rides.sort(c);
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


