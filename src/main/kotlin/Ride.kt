data class Ride(val id: Int,
                val start: Location,
                val finish: Location,
                val timeEarliest: Int,
                val timeLatest: Int) {

    val timeStarted: Int = 0

    fun getTimeFinished(): Int {
        return timeStarted + getTotalDistance()
    }

    public fun getTotalDistance(): Int {
        return start.getDistance(finish)
    }


}
