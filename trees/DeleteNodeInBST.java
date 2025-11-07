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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(!isNode(root, key)) { 
            return root;
        }
        else if(root.val == key) {
            return mergeTree(root.left, root.right);
        }

        TreeNode curr = root;
        TreeNode prevNode = null;
        TreeNode newRoot = null;
        
        while(curr != null) {
            if(curr.val == key) {
                newRoot = mergeTree(curr.left, curr.right);
                break;
            }
            else if(key < curr.val) {
                prevNode = curr;
                curr = curr.left;
            }
            else {
                prevNode = curr;
                curr = curr.right;
            }
        }

        if(newRoot == null) {
            if(prevNode.val < key) {
                prevNode.right = null;
            }
            else {
                prevNode.left = null;
            }
        }
        else if(newRoot.val < prevNode.val) {
            prevNode.left = newRoot;
        }
        else {
            prevNode.right = newRoot;
        }

        return root;
    
    }

    private boolean isNode(TreeNode root, int val) {

        while(root != null) {
            if(val == root.val) {
                return true;
            }
            else if(val < root.val) {
                root = root.left;
            }
            else {
                root = root.right;
            }
        }

        return false;
    }

    private TreeNode mergeTree(TreeNode root1, TreeNode root2) {

        if(root1 == null) {
            return root2;
        }
        else if(root2 == null) {
            return root1;
        }

        TreeNode curr = root1;
        TreeNode insertNode = null;
        
        while(curr != null) {
            if(root2.val < curr.val) {
                insertNode = curr;
                curr = curr.left;
            }
            else {
                insertNode = curr;
                curr = curr.right;
            }
        }

        if(insertNode.val < root2.val) {
            insertNode.right = root2;
        }
        else {
            insertNode.left = root2;
        }

        return root1;
    }
}

/*

isNode() ->  TC: O(h)  SC: O(1)
mergeTree() -> TC: O(root1->h) SC: O(1)


TC: O(h)
SC: O(1)

*/