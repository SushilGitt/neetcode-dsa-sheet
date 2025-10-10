
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList <Integer> arr = new ArrayList<>();
        return inorder(root, arr);
    }

    private List<Integer> inorder(TreeNode root, List<Integer> arr) {
        if(root == null) {
            return arr;
        }

        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);

        return arr;
    }
}

// TC: O(n)
// SC: O(n) -> Recursion call stack


// Iterative solution
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode node = root;
        List <Integer> arr = new ArrayList<>();
        Deque <TreeNode> stack = new ArrayDeque<>();

        while(true) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                if(stack.isEmpty()) {
                    break;
                }
                
                node = stack.pop();
                arr.add(node.val);
                node = node.right;
            }
        }

        return arr;
    }
}

// TC: O(n)
// SC: O(n)