

public class Leetcode450 {

    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null)
            return null;

        if(root.val > key)
            root.left = deleteNode(root.left,key);
        else if(root.val < key)
            root.right = deleteNode(root.right,key);
        else{

            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;

            root.val = minValue(root.right);
            root.right = deleteNode(root.right,root.val);

        }

        return root;

    }

    private int minValue(TreeNode node) {

        int minValue = Integer.MAX_VALUE;
        while (node != null){
            minValue = Math.min(node.val, minValue);
            node = node.left;
        }

        return minValue;

    }
}
