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
    public boolean isValidBST(TreeNode root) {
        ArrayList <Integer> arr = new ArrayList<>();
        getInorder(root, arr);
        return isSorted(arr);
    }

    private void getInorder(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.val);
        getInorder(root.right, arr);
    }

    private boolean isSorted(ArrayList<Integer> arr) {
        if(arr.size() == 1) {
            return true;
        }

        for(int i = 1; i < arr.size(); i++) {
            if(arr.get(i) <= arr.get(i-1)) {
                return false;
            }
        }

        return true;
    }
}

// TC: O(n)
// SC: O(n)



class Solution {
    public boolean isValidBST(TreeNode root) {
        TreeNode curr = root;
        long prevVal = Long.MIN_VALUE;
        ArrayDeque <TreeNode> s = new ArrayDeque<>();

        while(curr != null || s.size() > 0) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            TreeNode node = s.pop();

            if(prevVal >= node.val) {
                return false;
            }

            prevVal = node.val;
            curr = node.right;
        }

        return true;
    }
}

// TC: O(n)
// SC: O(n)