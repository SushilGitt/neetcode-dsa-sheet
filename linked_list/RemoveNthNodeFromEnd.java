
// two pass 
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode mover = head;

        while(mover != null) {
            length++;
            mover = mover.next;
        }

        if(n == length) {
            return head.next;
        }

        mover = head;
        int res = length - n;

        while(mover != null) {
            res--;
            if(res == 0) break;
            mover = mover.next;
        }

        mover.next = mover.next.next;
        return head;
    }
}

// TC: O(n)
// SC: O(1)