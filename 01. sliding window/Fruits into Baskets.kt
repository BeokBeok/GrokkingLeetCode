class Solution {
    fun totalFruit(fruits: IntArray): Int {
        if (fruits.isEmpty()) return 0

        var (windowStart, windowEnd) = 0 to 0
        var result = 0
        val fruitsFrequencyMap = mutableMapOf<Int, Int>()

        while (windowEnd < fruits.size) {
            val right = fruits[windowEnd]
            fruitsFrequencyMap[right] = fruitsFrequencyMap.getOrDefault(right, 0) + 1

            while (fruitsFrequencyMap.size > 2) {
                val left = fruits[windowStart]
                fruitsFrequencyMap[left] = (fruitsFrequencyMap[left] ?: 0) - 1

                if (fruitsFrequencyMap[left] == 0) {
                    fruitsFrequencyMap.remove(left)
                }
                windowStart++
            }
            result = result.coerceAtLeast(windowEnd - windowStart + 1)
            windowEnd++
        }
        return result
    }
}
