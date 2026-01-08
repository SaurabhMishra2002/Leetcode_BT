// Given the root of a binary tree, imagine yourself standing on the right side of it, 
// return the values of the nodes you can see ordered from top to bottom.

 

// Example 1:

// Input: root = [1,2,3,null,5,null,4]

// Output: [1,3,4]
///
/*

        1
       / \
      2   3
       \   \
        5   4



*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightSideView {

     static ArrayList<Integer> res = new ArrayList<>();

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

    public static void rightSideView(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> Lq = new LinkedList<>();
        Lq.add(root);

        while(!Lq.isEmpty()){
            int s = Lq.size();
            for(int i = 0; i < s; i++){
                TreeNode curr = Lq.poll();
               
                if(i == s-1){
                    res.add(curr.val);
                }

                if(curr.left != null){
                    Lq.add(curr.left);
                }
                if(curr.right != null){
                    Lq.add(curr.right);
                }
            }
        }
    }
    public static void main(String[] args) {

        // Implement BFS to get right side view of a binary tree

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

       
        rightSideView(root);

        for(int val : res){
            System.out.print(val + " ");
        }        
    }
    
}
