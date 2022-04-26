class Solution {
    fun isHappy(n: Int): Boolean {
        var (slow, fast) = n to value(n)
        while (slow != fast) {
            slow = value(slow)
            fast = value(value(fast))
        }
        return slow == 1
    }
    
    private fun value(n: Int): Int {
        var (value, result) = n to 0
        while (value > 0) {
            val digit = value.rem(10)
            result += digit.times(digit)
            value /= 10
        }
        return result
    }
}
