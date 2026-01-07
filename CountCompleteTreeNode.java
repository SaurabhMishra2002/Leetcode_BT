public class CountCompleteTreeNode {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val,TreeNode left,TreeNode right) {
           this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int getleftheight(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = 0;
        TreeNode temp = root;

        while(temp != null){
            lh++;
            temp = temp.left;
        }
        return lh;

    }

        public static int getrightheight(TreeNode root){
        if(root == null){
            return 0;
        }
        int rh = 0;
        TreeNode temp = root;

        while(temp != null){
            rh++;
            temp = temp.right;
        }
        return rh;

    }


    public static int countnode(TreeNode root){

        if(root == null){
            return 0;
        }

        int lh = getleftheight(root);
        int rh = getrightheight(root);

        if(lh == rh){
            return (int) (Math.pow(2,lh) - 1);
        }

        return countnode(root.left)+countnode(root.right)+1;
    }
    public static void main(String[] args) {
        // Example usage
        TreeNode root = new TreeNode(1, null, null);
        root.left = new TreeNode(2, root, root);
        root.right = new TreeNode(3, root, root);
        root.left.left = new TreeNode(4, null, null);
        root.left.right = new TreeNode(5, null, null);
        root.right.left = new TreeNode(6, null, null);

        int count = countnode(root);
        System.out.println("Number of nodes in the complete binary tree: " + count);
    }
}
