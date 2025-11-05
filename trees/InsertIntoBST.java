/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }

        TreeNode curr = root;
        TreeNode prevNode = null;

        while(curr != null) {
            if(val > curr.val) {
                prevNode = curr;
                curr = curr.right;
            }
            else {
                prevNode = curr;
                curr = curr.left;
            }
        }

        if(prevNode.val > val) {
            prevNode.left = new TreeNode(val);
        }
        else {
            prevNode.right = new TreeNode(val);
        }

        return root;
    }
}

// TC: O(h)
// SC: O(1)