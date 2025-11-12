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
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        goodNode(ans, root, root.val);
        return ans[0];
    }

    private void goodNode(int[] ans, TreeNode root, int max) {
        if(root == null) {
            return;
        }

        if(root.val >= max) {
            ans[0]++;
            max = Math.max(max, root.val);
        }

        goodNode(ans, root.left, max);
        goodNode(ans, root.right, max);
    }
}

// TC: O(n)
// SC: O(h)