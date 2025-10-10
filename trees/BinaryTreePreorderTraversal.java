

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

// Recursive solution
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList <Integer> arr = new ArrayList<>();
        return preOrder(root, arr);
    }

    private List<Integer> preOrder(TreeNode root, List<Integer> arr) {
        if(root == null) {
            return arr;
        }
        arr.add(root.val);
        preOrder(root.left, arr);
        preOrder(root.right, arr);

        return arr;
    }
}

// TC: O(n)
// SC: O(n) -> Recursion call stack