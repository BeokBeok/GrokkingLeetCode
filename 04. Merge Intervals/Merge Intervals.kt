class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) return intervals
        
        val sortedIntervals = intervals.sortedWith(
            Comparator { o1, o2 -> compareValues(o1.first(), o2.first()) }
        )

        val result = mutableListOf<IntArray>()
        var temp = IntArray(2).apply { 
            set(0, sortedIntervals.first().first())
            set(1, sortedIntervals.first().last())
        }
        result.add(temp)
        sortedIntervals.forEach { 
            if (it.first() <= temp.last()) {
                temp[1] = it.last().coerceAtLeast(temp.last())
            } else {
                temp = it
                result.add(temp)
            }
        }
        return result.toTypedArray()
    }
}
