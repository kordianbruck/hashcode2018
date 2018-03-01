data class Ride(val id: Int,
                val start: Location,
                val finish: Location,
                val timeEarliest: Int,
                val timeLatest: Int) {

    var timeStarted: Int = 0

    fun getTimeFinished(): Int {
        return timeStarted + getTotalDistance()
    }

    fun getLatestStart(): Int {
        return timeLatest - getTotalDistance()
    }

    fun getTotalDistance(): Int {
        return start.getDistance(finish)
    }
}
