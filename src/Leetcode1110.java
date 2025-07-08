import java.util.ArrayList;
import java.util.List;

public class Leetcode1110 {

    public static void main(String[] args){

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        for(int num : to_delete){
            deleteNode(list,num);
        }
        return list;
    }

    public void deleteNode(List<TreeNode> list, int num){
        if(list==null)
            return;

        for (int i = 0; i < list.size(); i++) {
            TreeNode returnedNode = deleteNumFromCurrentTreeNode(list,list.get(i),num);
            if(returnedNode == null)
                list.remove(i);
            else
                list.set(i,deleteNumFromCurrentTreeNode(list,list.get(i),num));
        }

    }

    public TreeNode deleteNumFromCurrentTreeNode(List<TreeNode> list, TreeNode treeNode, int num){
        if(treeNode == null)
            return null;
        if(treeNode.val == num){
            if(treeNode.left != null)
                list.add(treeNode.left);
            if(treeNode.right != null)
                list.add(treeNode.right);
            treeNode = null;
            return treeNode;
        }
        treeNode.left = deleteNumFromCurrentTreeNode(list,treeNode.left,num);
        treeNode.right = deleteNumFromCurrentTreeNode(list,treeNode.right,num);
        return treeNode;
    }


}
