/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode copyRoot = root;
        ArrayList <TreeNode> pArr = new ArrayList<>();
        ArrayList <TreeNode> qArr = new ArrayList<>();

        pArr = getPath(copyRoot, p, pArr);
        copyRoot = root;
        qArr = getPath(copyRoot, q, qArr);

        int i = Math.min(qArr.size(), pArr.size()) - 1;

        while(i >= 0) {
            if(pArr.get(i) == qArr.get(i)) {
                copyRoot = pArr.get(i);
                break;
            }
            i--;
        } 

        return copyRoot;
    }

    private ArrayList<TreeNode> getPath(TreeNode root, TreeNode node, ArrayList<TreeNode> arr) {
        if(root.val == node.val) {
            arr.add(root);
            return arr;
        }
        else if(node.val < root.val) {
            arr.add(root);
            getPath(root.left, node, arr);
        }
        else {
            arr.add(root);
            getPath(root.right, node, arr);
        }

        return arr;
    }
}

// TC: O(n)
// SC: O(n)
