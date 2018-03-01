data class Vehicle(val location: Location,
                   val inTransit: Boolean) {


    val doneRides: ArrayList<Ride> = ArrayList<Ride>()

    fun addRide(r: Ride) {
        doneRides.add(r)
    }

    fun getDoneRidesList(): String {
        var out: String = ""
        for (r in doneRides) {
            out += r.id.toString() + ", "
        }
        return out
    }

    fun calcPoints(bonus: Int): Int {
        var totalPoints = 0
        for (r in doneRides) {
            totalPoints += r.getTotalDistance()

            if (r.timeStarted == r.timeEarliest) {
                totalPoints += bonus
            }
        }

        return totalPoints
    }
}
