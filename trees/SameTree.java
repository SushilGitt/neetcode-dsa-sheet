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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        return isSameNode(p, q, ans);
    }

    private boolean isSameNode(TreeNode p, TreeNode q, boolean[] ans) {
        if(p == null && q == null) {
            return true;
        }
        else if(p == null || q == null) {
            return false;
        }

        ans[0] &= p.val == q.val;
        ans[0] &= isSameNode(p.left, q.left, ans);
        ans[0] &= isSameNode(p.right, q.right, ans);

        return ans[0];
    }
}

// TC: O(n)
// SC: O(n)