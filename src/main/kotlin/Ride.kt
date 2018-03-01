data class Ride(val start: Location,
                val finish: Location,
                val timeEarliest: Int,
                val timeLatest: Int) {


    public fun getTotalDistance(): Int {
        return start.getDistance(finish)
    }




}
