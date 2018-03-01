data class Location(val r: Int,
                    val c: Int) {

    fun getDistance(o: Location): Int {
        return Math.abs(c - o.c) + Math.abs(r - o.r)
    }
}
