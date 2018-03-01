import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainTest {

    private boolean validate (Simulation s, List<Vehicle> vehicleList) {
        for(int i=0; i<s.getSteps(); i++) {

        }

        return true;
    }


    @Test
    public void testA() throws FileNotFoundException {
        //Setup
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/a_example.in", vehicles, rides, s);

        //Do stuff
        Main.doCalc(vehicles, rides);

        //Result
        s.saveResults(vehicles, "a");
        System.out.println(s.totalPoints(vehicles));
        assertTrue(validate(s, vehicles));
        assertTrue(s.totalPoints(vehicles) > 0);
    }

    @Test
    public void testB() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/b_should_be_easy.in", vehicles, rides, s);

        //Do stuff
        Main.doCalc(vehicles, rides);

        //Result
        s.saveResults(vehicles, "b");
        System.out.println(s.totalPoints(vehicles));
        assertTrue(s.totalPoints(vehicles) > 0);
    }

    @Test
    public void testC() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/c_no_hurry.in", vehicles, rides, s);

        //Do stuff
        Main.doCalc(vehicles, rides);

        //Result

        s.saveResults(vehicles, "c");
        System.out.println(s.totalPoints(vehicles));
        assertTrue(s.totalPoints(vehicles) > 0);
    }

    @Test
    public void testD() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/d_metropolis.in", vehicles, rides, s);

        //Do stuff
        Main.doCalc(vehicles, rides);

        //Result


        s.saveResults(vehicles, "d");
        System.out.println(s.totalPoints(vehicles));
        assertTrue(s.totalPoints(vehicles) > 0);
    }

    @Test
    public void testE() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Simulation s = new Simulation();
        Parser.readData("indata/e_high_bonus.in", vehicles, rides, s);

        //Do stuff
        Main.doCalc(vehicles, rides);

        //Result
        s.saveResults(vehicles, "e");
        System.out.println(s.totalPoints(vehicles));
        assertTrue(s.totalPoints(vehicles) > 0);
    }
}
