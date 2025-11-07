
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue <ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for(ListNode node : lists) {
            if(node != null) {
                minHeap.add(node);
            }
        }

        ListNode dNode = new ListNode(0);
        ListNode tail = dNode;

        while(!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            tail.next = node;
            tail = tail.next;
            if(node.next != null) minHeap.add(node.next);
        }

        return dNode.next;
    }
}

// TC: O(n) + O(n.log(k))
// SC: O(k)