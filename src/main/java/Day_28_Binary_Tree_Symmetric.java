// Definition for a binary tree node.
class TreeNodee {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNodee() {}
    TreeNodee(int val) { this.val = val; }
    TreeNodee(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Day_28_Binary_Tree_Symmetric {

    // Function to check if the tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // An empty tree is symmetric
        if (root == null) {
            return true;
        }
        // Check if the left and right subtrees are mirror images of each other
        return isMirror(root.left, root.right);
    }

    // Helper function to check if two trees are mirror images of each other
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // If both are null, they are symmetric (mirrors of each other)
        if (t1 == null && t2 == null) {
            return true;
        }
        // If only one is null, they are not symmetric
        if (t1 == null || t2 == null) {
            return false;
        }
        // Check if the current nodes are the same and their subtrees are mirrors
        return (t1.val == t2.val)
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        // Test case 1
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, new TreeNodee(3), new TreeNodee(4)),
                new TreeNode(2, new TreeNodee(4), new TreeNodee(3)));
        Day_28_Binary_Tree_Symmetric solution1 = new Day_28_Binary_Tree_Symmetric();
        System.out.println(solution1.isSymmetric(root1));  // Output: true

        // Test case 2
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNodee(3)),
                new TreeNode(2, null, new TreeNodee(3)));
        Day_28_Binary_Tree_Symmetric solution2 = new Day_28_Binary_Tree_Symmetric();
        System.out.println(solution2.isSymmetric(root2));  // Output: false
    }
}