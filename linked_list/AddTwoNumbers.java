
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

// Brute force:

// Create numbers and add them to get sum.
// Then create new list with the digits of sum.

import java.math.BigInteger;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = getNumber(l1);
        String num2 = getNumber(l2);

        BigInteger a = new BigInteger(num1);
        BigInteger b = new BigInteger(num2);
        BigInteger sum = a.add(b);

        if(sum.compareTo(BigInteger.ZERO) == 0) {
            return new ListNode(0, null);
        }

        ListNode newList = null;

        while(sum.compareTo(BigInteger.ZERO) > 0) {
            BigInteger digit = sum.mod(BigInteger.TEN);
            sum = sum.divide(BigInteger.TEN);
            int value = digit.intValue();
            ListNode newNode = new ListNode(value, newList);
            newList = newNode;
        }

        return reverseList(newList);
    }

    // Reversing list to get original number.
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

    
    // Getting number in string format
    private String getNumber(ListNode headNode) {
        StringBuilder sb = new StringBuilder();
        
        while(headNode != null) {
            String digit = Integer.toString(headNode.val);
            sb.append(digit);
            headNode = headNode.next;
        }

        return sb.reverse().toString();
    }
}

// TC: O(n)
// SC: O(n)
