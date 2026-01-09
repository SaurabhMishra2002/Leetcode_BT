// 236. Lowest Common Ancestor of a Binary Tree
/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on 
Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

/*
Tree Example:

        3
       / \
      5   1
     / \ / \
    6  2 0  8
      / \
     7   4

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
*/

public class LCA {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode LowestCA(TreeNode root,int p, int q){
        if(root == null ){
            return null;
        }

        if(root.val == p || root.val == q){
            return root;
        } 

        TreeNode leftN = LowestCA(root.left,p,q);
        TreeNode rightN = LowestCA(root.right,p,q);

        if(leftN != null && rightN != null){
            return root;
        }

        if(leftN != null){
            return leftN;
        }

        return rightN;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        int p = 5;
        int q = 1;

        TreeNode ans = LowestCA(root,p,q);
        System.out.println("LCA Node Value: " + ans.val);
    }
}
