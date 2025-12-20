/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> preorder = new ArrayList<>();
        dfsSerialize(root, preorder);
        return String.join(" ", preorder);
    }

    private void dfsSerialize(TreeNode root, ArrayList<String> preorder) {
        if(root == null) {
            preorder.add("N");
            return;
        }

        preorder.add(Integer.toString(root.val));
        dfsSerialize(root.left, preorder);
        dfsSerialize(root.right, preorder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        return dfsDeserialize(nodes);
    }

    private TreeNode dfsDeserialize(String[] nodes) {
        if(nodes[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodes[index++]));
        root.left = dfsDeserialize(nodes);
        root.right = dfsDeserialize(nodes);

        return root;
    }
}

// TC: O(N)
// SC: O(N)


// -----------------------------------------------------------------------------
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "N";
        StringBuilder str = new StringBuilder();
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(node == null) {
                str.append("N ");
                continue;
            }
            str.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(" ");
        if(nodes[0].equals("N")) return null;
        Queue <TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);

        int index = 1;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            if(!nodes[index].equals("N")) {
                node.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.left);
            }
            index++;
            
            if(!nodes[index].equals("N")) {
                node.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(node.right);
            }
            index++;
        }

        return root;
    }
}

// TC: O(N)
// SC: O(N)