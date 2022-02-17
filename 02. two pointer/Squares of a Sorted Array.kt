class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        var (start, end) = 0 to nums.lastIndex
        val result = IntArray(nums.size)

        for (p in nums.lastIndex downTo 0 step 1) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) {
                result[p] = nums[start] * nums[start]
                start++
            } else {
                result[p] = nums[end] * nums[end]
                end--
            }
        }
        return result
    }
}
