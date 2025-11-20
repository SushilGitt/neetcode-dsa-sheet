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
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int start, int end, HashMap<Integer, Integer> map) {
        if(start > end) {
            return null;
        }

        int rootVal = preorder[index++];
        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(preorder, inorder, start, rootIdx - 1, map);
        root.right = buildTree(preorder, inorder, rootIdx + 1, end, map);

        return root;
    }
}

// TC: O(N)
// SC: O(N)