import kotlin.math.max

data class Vehicle(val location: Location,
                   val inTransit: Boolean) {


    val doneRides: ArrayList<Ride> = ArrayList()

    fun canServe(next: Ride): Boolean {
        val location = if (doneRides.isEmpty()) Location(0, 0) else doneRides.last().finish
        val lastTime = getLastTime()
        val nextLoc = next.start
        val distance = location.getDistance(nextLoc)
        val nextStart = next.getLatestStart() // TODO optimize bonus

        return lastTime + distance <= nextStart
    }

    fun addRide(r: Ride) {
        val lastTime = getLastTime()
        val nextLoc = r.start
        val distance = location.getDistance(nextLoc)
        val earliestStart = lastTime + distance
        val actualStart = max(r.timeEarliest, earliestStart)
        r.timeStarted = actualStart
        doneRides.add(r)
    }

    fun getLastTime(): Int {
        return if (doneRides.isEmpty()) 0 else doneRides.last().getTimeFinished()
    }

    fun printDoneRides() {
        print(doneRides.size)
        doneRides.forEach {
            print(' ')
            print(it.id)
        }
        println()
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
