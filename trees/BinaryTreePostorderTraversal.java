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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList <Integer> arr = new ArrayList<>();
        return postOrder(root, arr);
    }

    private List<Integer> postOrder(TreeNode root, List<Integer> arr) {
        if(root == null) {
            return arr;
        }

        postOrder(root.left, arr);
        postOrder(root.right, arr);
        arr.add(root.val);

        return arr;
    }
}

// TC: O(n)
// SC: O(n) -> function call stack.