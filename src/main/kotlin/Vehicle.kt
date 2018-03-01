import java.util.*
import kotlin.math.max

data class Vehicle(val location: Location) {


    val doneRides: ArrayList<Ride> = ArrayList()

    fun getLastLocation() : Location {
        return if (doneRides.isEmpty()) Location(0, 0) else doneRides.last().finish
    }

    fun canServe(next: Ride): Boolean {
        val location = getLastLocation()
        val lastTime = getLastTime()
        val nextLoc = next.start
        val distance = location.getDistance(nextLoc)
        val nextStart = next.getLatestStart()

        return lastTime + distance <= nextStart
    }

    fun canServeWithBonus(next: Ride): Boolean {
        val location = getLastLocation()
        val lastTime = getLastTime()
        val nextLoc = next.start
        val distance = location.getDistance(nextLoc)
        val earliestStart = lastTime + distance

        return earliestStart <= next.timeEarliest
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
