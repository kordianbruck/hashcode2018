import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MainTest {


    @Test
    public void testA() throws FileNotFoundException {
        //Setup
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/a_example.in", vehicles, rides, s);

        //Do stuff


        //Result
        assertTrue(s.totalPoints(vehicles) > 0);
    }

    @Test
    public void testB() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/b_should_be_easy.in", vehicles, rides, s);
    }

    @Test
    public void testC() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/c_no_hurry.in", vehicles, rides, s);
    }

    @Test
    public void testD() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/d_metropolis.in", vehicles, rides, s);
    }

    @Test
    public void testE() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/e_high_bonus.in", vehicles, rides, s);
    }
}
