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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList <Integer> arr = new ArrayList<>();
        getInorder(root, arr);
        return arr.get(k-1);
    }

    private void getInorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.val);
        getInorder(root.right, arr);
    }
}

// TC: O(n)
// SC: O(n)




class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int index = 0;
        TreeNode curr = root;
        ArrayDeque <TreeNode> s = new ArrayDeque<>();

        while(curr != null || s.size() > 0) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            TreeNode node = s.pop();
            index++;

            if(index == k) {
                return node.val;
            }

            curr = node.right;
        }

        return 0;
    }
}

// TC: O(n)
// SC: O(n)