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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List <List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        ArrayDeque <TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while(q.size() > 0) {
            int size = q.size();
            ArrayList <Integer> list = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = q.pop();
                list.add(node.val);

                if(node.left != null) q.addLast(node.left);
                if(node.right != null) q.addLast(node.right);
            }
            
            ans.add(list);
        }

        return ans;
    }
}

// TC: O(n)
// SC: O(n)