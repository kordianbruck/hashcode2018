import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.TestCase.assertTrue;

public class MainTest {


    @Test
    public void testA() throws FileNotFoundException {
        ArrayList<Vehicle> vehicles = new ArrayList<>(Main.maxVehicles);
        ArrayList<Ride> rides = new ArrayList<>(Main.maxRides);
        Parser.readData("indata/a_example.in",vehicles, rides);

    }
}
