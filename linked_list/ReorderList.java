// Brute force 
// We can store values in array and so we can reorder the list by indies.

// TC: O(n)
// SC: O(n)


// Fast and Slow pointers
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode first = head;
        ListNode second = reverseList(slow.next);
        slow.next = null;

        while(second != null) {
            ListNode nextF = first.next;
            ListNode nextS = second.next;
            first.next = second;
            second.next = nextF;
            first = nextF;
            second = nextS;
        }
        
    }

    private ListNode reverseList(ListNode headNode) {
        ListNode prevNode = null;
        while(headNode != null) {
            ListNode nextNode = headNode.next;
            headNode.next = prevNode;
            prevNode = headNode;
            headNode = nextNode;
        }

        return prevNode;
    }
}

// TC: O(n)
// SC: O(1)