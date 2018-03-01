import java.util.*;


public class Main {

    static int maxVehicles = 1000;
    static int maxRides = 1000;


    public static void main(String[] args) throws Exception {
        ArrayList<Vehicle> vehicles = new ArrayList<>(maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(maxRides);
        Simulation simulation = new Simulation();
        Parser.readData("indata/a_example.in", vehicles, rides, simulation);
        doCalc(vehicles, rides);
        printResults(vehicles);
    }

    static void doCalc(List<Vehicle> vehicles, List<Ride> rides) {
        rides.sort(Comparator.comparingInt(Ride::getLatestStart));

        for (Ride ride : rides) {
            Optional<Vehicle> v = getVehicle(vehicles, ride);
            v.ifPresent(vehicle -> vehicle.addRide(ride));
        }
    }

    static void printResults(List<Vehicle> vehicles) {
        for (Vehicle v : vehicles) {
            v.printDoneRides();
        }
    }

    static Optional<Vehicle> getVehicle(List<Vehicle> vehicles, Ride ride) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.canServe(ride))
                .findFirst();
    }
}


