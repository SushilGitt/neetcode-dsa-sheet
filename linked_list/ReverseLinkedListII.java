
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode prevLeft = dummy;
        ListNode leftNode = head;

        // Getting the left node
        for(int i = 1; i < left; i++) {
            prevLeft = leftNode;
            leftNode = leftNode.next;
        }

        // Changing the links and move to right node
        ListNode prev = null;
        ListNode rightNode = leftNode;

        for(int i = 0; i < (right - left) + 1; i++) {
            ListNode next = rightNode.next;
            rightNode.next = prev;
            prev = rightNode;
            rightNode = next;
        }

        // Links nodes before leftNode to rightNode
        prevLeft.next = prev;
        // Links leftNode to nodes after rightNode
        leftNode.next = rightNode;

        return dummy.next;
    }
}

// TC: O(n)
// SC: O(1)