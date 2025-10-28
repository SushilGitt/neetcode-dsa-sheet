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
    public boolean isBalanced(TreeNode root) {
        int height[] = new int[1];
        dfs(root, height);

        return (height[0] > 1) ? false : true;
    }

    private int dfs(TreeNode root, int[] height) {
        if(root == null) {
            return 0;
        }

        int lh = dfs(root.left, height);
        int rh = dfs(root.right, height);
        int diff = Math.abs(lh - rh);
        height[0] = Math.max(height[0], diff);

        return 1 + Math.max(lh, rh);
    }
}

// TC: O(n)
// SC: O(n)