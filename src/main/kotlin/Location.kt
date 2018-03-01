data class Location(val r: Int,
                    val c: Int) {

    public fun getDistance(o: Location): Int {
        return Math.abs(c - o.c) + Math.abs(r - o.r)
    }
}
