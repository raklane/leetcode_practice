import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode653_2 {

    public static void main(String[] args){

    }

    public boolean findTarget(TreeNode root, int k) {

        HashSet<Integer> set = new HashSet<>();
        return addNodesToSet(root,k,set);

    }

    public boolean addNodesToSet(TreeNode node, int k, HashSet<Integer> set){

        if(node==null)
            return false;
        int remaining = k-node.val;
        if(set.contains(remaining))
            return true;
        set.add(node.val);
        return (addNodesToSet(node.left,k,set) || addNodesToSet(node.right,k,set));

    }

}
