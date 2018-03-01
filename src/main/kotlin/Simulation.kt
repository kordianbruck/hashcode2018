import java.io.PrintWriter
import java.util.stream.Collectors

data class Simulation(
        var rows: Int = 0,
        var cols: Int = 0,
        var bonus: Int = 0,
        var steps: Int = 0,
        var numRides: Int = 0,
        var numVehicles: Int = 0) {

    fun totalPoints(vehicles: List<Vehicle>): Int {
        return vehicles.sumBy { it.calcPoints(bonus) }
    }

    fun saveResults(vehicles: List<Vehicle>, filename: String) {
        val writer = PrintWriter("outdata/$filename", "UTF-8")
        for (v in vehicles) {
            val res = v.doneRides.stream().map { ride -> ride.id.toString() }.collect(Collectors.joining(" "))
            writer.println(v.doneRides.size.toString() + " " + res)
        }
        writer.close()
    }
}
