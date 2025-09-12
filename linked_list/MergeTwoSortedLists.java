
// Brute force 
// Using two loops

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null && list2 == null) {
            return null;
        }
        else if(list1 == null) {
            return list2;
        }


        ListNode nodeB = list2;
        while(nodeB != null) {
            ListNode prevNode = null;
            ListNode nodeA = list1;

            while(nodeA != null && nodeA.val <= nodeB.val) {
                prevNode = nodeA;
                nodeA = nodeA.next;
            }

            ListNode nextB;

            if(nodeA == list1) {
                nextB = nodeB.next;
                nodeB.next = nodeA;
                list1 = nodeB;
                nodeB = nextB;
            }
            else {
                nextB = nodeB.next;
                nodeB.next = nodeA;
                prevNode.next = nodeB;
                nodeB = nextB;
            }    
        }

        return list1;
    }
}

// TC: O(n * n)
// SC: O(1)


// Two pointers 
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode nodeA = list1;
        ListNode nodeB = list2;
        ListNode newList = null;

        while(nodeA != null && nodeB != null) {
            if(nodeA.val <= nodeB.val) {
                ListNode nextA = nodeA.next;
                nodeA.next = newList;
                newList = nodeA;
                nodeA = nextA;
            }
            else {
                ListNode nextB = nodeB.next;
                nodeB.next = newList;
                newList = nodeB;
                nodeB = nextB;
            }
        }

        while(nodeA != null) {
            ListNode nextA = nodeA.next;
            nodeA.next = newList;
            newList = nodeA;
            nodeA = nextA;
        }

        while(nodeB != null) {
            ListNode nextB = nodeB.next;
            nodeB.next = newList;
            newList = nodeB;
            nodeB = nextB;
        }

        return reverseList(null, newList);
    }

    private ListNode reverseList(ListNode prevNode, ListNode head) {
        if(head == null) {
            return prevNode;
        }

        ListNode nextNode = head.next;
        head.next = prevNode;
        prevNode = head;
        return reverseList(prevNode, nextNode);
    }
}

// TC: O(n)
// SC: O(1) or O(n) depending upon which method you used to reverse list.