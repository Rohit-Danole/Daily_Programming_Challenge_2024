import java.util.Scanner;

class TreeNode
{
    int val;
    TreeNode left, right;

    public TreeNode(int val)
    {
        this.val = val;
        left = right = null;
    }
}

public class Day_24_LCA_BT
{
    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || root == p || root == q)
        {
            return root;
        }
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        if (left != null && right != null)
        {
            return root;
        }
        return (left != null) ? left : right;
    }
    public static TreeNode insertNode(TreeNode root, int val)
    {
        if (root == null)
        {
            return new TreeNode(val);
        }
        if (val < root.val)
        {
            root.left = insertNode(root.left, val);
        } else if (val > root.val)
        {
            root.right = insertNode(root.right, val);
        }
        return root;
    }
    public static TreeNode findNode(TreeNode root, int val)
    {
        if (root == null || root.val == val)
        {
            return root;
        }
        if (val < root.val)
        {
            return findNode(root.left, val);
        } else {
            return findNode(root.right, val);
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        TreeNode root = null;
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        System.out.println("Enter the node values:");
        for (int i = 0; i < n; i++)
        {
            int val = sc.nextInt();
            root = insertNode(root, val);
        }
        System.out.println("Enter the value of the first node (p):");
        int pVal = sc.nextInt();
        System.out.println("Enter the value of the second node (q):");
        int qVal = sc.nextInt();
        TreeNode p = findNode(root, pVal);
        TreeNode q = findNode(root, qVal);
        if (p == null || q == null)
        {
            System.out.println("Both nodes must exist in the tree.");
        } else {
            TreeNode lca = findLCA(root, p, q);
            if (lca != null)
            {
                System.out.println("The Lowest Common Ancestor of " + pVal + " and " + qVal + " is: " + lca.val);
            } else {
                System.out.println("No common ancestor found.");
            }
        }
        sc.close();
    }
}