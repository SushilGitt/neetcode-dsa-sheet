
/*
Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node mover1 = head;
        Node newHead = null;

        // Create new list with values in reverse order
        while(mover1 != null) {
            Node newNode = new Node(mover1.val);
            newNode.next = newHead;
            newHead = newNode;
            mover1 = mover1.next;
        }

        // Reverse list to get original list
        Node prevNode = null;
        while(newHead != null) {
            Node nextNode = newHead.next;
            newHead.next = prevNode;
            prevNode = newHead;
            newHead = nextNode;
        }
        newHead = prevNode;

        int node = 0;
        mover1 = head;
        Node mover2 = newHead;

        HashMap <Node, Integer> map1 = new HashMap<>();
        HashMap <Integer, Node> map2 = new HashMap<>();

        while(mover1 != null) {
            map1.put(mover1, node);
            map2.put(node, mover2);
            mover1 = mover1.next;
            mover2 = mover2.next;
            node++;
        }

        mover1 = head;
        mover2 = newHead;

        while(mover1 != null) {
            if(mover1.random != null) {
                int random = map1.get(mover1.random);
                mover2.random = map2.get(random);
            }
            mover1 = mover1.next;
            mover2 = mover2.next;
        }

        return newHead;
    }
}

// TC: O(n)
// SC: O(n)