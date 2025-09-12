
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


// Brute force

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode mover = head;
        ArrayList <Integer> copy = new ArrayList<>();

        while(mover != null) {
            copy.add(mover.val);
            mover = mover.next;
        }

        mover = head;
        int i = copy.size() - 1;

        while(mover != null) {
            mover.val = copy.get(i--);
            mover = mover.next;
        }

        return head;
    }
}

// TC: O(n)
// SC: O(n)



// iterative
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(head != null) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }

        return prevNode;
    }
}

// TC: O(n)
// SC: O(1)


// Recursive

class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    private ListNode reverseList(ListNode prev, ListNode head) {
        if(head == null) {
            return prev;
        }

        ListNode next = head.next;
        head.next = prev;
        prev = head;

        return reverseList(prev, next);
    }
}

// TC: O(n)
// SC: O(n) -> height of the recursion tree