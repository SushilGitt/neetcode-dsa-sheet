
// Brute force 
// use hashing to keep track of node you have visited thats it.
// TC: O(n)
// SC: O(n)



// Fast and Slow pointers
public class Solution {
    public boolean hasCycle(ListNode head) {

        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;
    }
}

// TC: O(n)
// SC: O(1)