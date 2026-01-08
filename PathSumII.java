// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths
//  where the sum of the node values in the path equals targetSum. 
// Each path should be returned as a list of the node values, not node references.

// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
/*
        5
       / \
      4   8
     /   / \
    11  13  4
   /  \      \
  7    2      5

 targetSum = 22

 Output: [[5,4,11,2],[5,8,4,5]]

*/

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    static ArrayList<List<Integer>> result = new ArrayList<>();


   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
           this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void pathsSum(TreeNode root, ArrayList<Integer> temp, int targetSum, int sum){
        if(root == null){
            return;
        }

        sum += root.val;
        temp.add(root.val);
        if(root.left == null && root.right == null && targetSum == sum){
            result.add(new ArrayList<>(temp));
        }

        pathsSum(root.left, temp, targetSum, sum);
        pathsSum(root.right, temp, targetSum, sum);
        temp.remove(temp.size() - 1);      
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        ArrayList<Integer> temp = new ArrayList<>();

        int sum = 0;

        pathsSum(root,temp,22,sum);

        for(List<Integer> path : result){
            System.out.println(path);
        }

    }
 
} 
