
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int nodeIdx = 0;
        ListNode curr = head;
        ListNode dNode = new ListNode(0);
        ListNode tail = dNode;

        while(curr != null) {
            nodeIdx++;
            if(nodeIdx % k != 0) {
                curr = curr.next;
                continue;
            }

            ListNode nextHead = curr.next;
            curr.next = null;
            tail.next = reverseList(head);
            tail = head;
            head = nextHead;
            curr = nextHead;
        }

        tail.next = head;
        return dNode.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}

// TC: O(n)
// SC: O(1)