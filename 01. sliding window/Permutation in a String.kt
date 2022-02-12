class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        var (windowStart, windowEnd) = 0 to 0
        val charFrequencyMap = mutableMapOf<Char, Int>()
        var matched = 0

        s1.forEach {
            charFrequencyMap[it] = charFrequencyMap.getOrDefault(it, 0) + 1
        }

        while (s2.length > windowEnd) {
            val right = s2[windowEnd]
            if (charFrequencyMap.containsKey(right)) {
                charFrequencyMap[right] = charFrequencyMap[right]?.minus(1) ?: 0
                if (charFrequencyMap[right] == 0) matched++
            }

            if (matched == charFrequencyMap.size) return true

            if (windowEnd >= s1.lastIndex) {
                val left = s2[windowStart++]
                if (charFrequencyMap.containsKey(left)) {
                    if (charFrequencyMap[left] == 0) matched--
                    charFrequencyMap[left] = charFrequencyMap[left]?.plus(1) ?: 0
                }
            }
            windowEnd++
        }
        return false
    }
}
