/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var hare = head
        var tortoise = head
        
        while (hare != null) {
            hare = hare?.next?.next
            if (hare == tortoise) return true
            tortoise = tortoise?.next
        }
        return false
    }
}
