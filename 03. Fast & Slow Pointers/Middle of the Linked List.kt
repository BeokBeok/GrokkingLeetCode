class Solution {
    fun middleNode(head: ListNode?): ListNode? {      
        var hare = head
        var tortoise = head
                
        while (hare?.next != null) {
            hare = hare?.next?.next
            tortoise = tortoise?.next
        }
        return tortoise
    }
}
