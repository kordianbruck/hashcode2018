data class Simulation(
        var rows: Int = 0,
        var cols: Int = 0,
        var bonus: Int = 0,
        var steps: Int = 0,
        var numRides: Int = 0,
        var numVehicles: Int = 0) {

    fun totalPoints (vehicles: List<Vehicle>): Int {
        var pts : Int = 0
        for(v in vehicles) {
            pts += v.calcPoints(bonus)
        }
        return pts
    }
}
