import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, result, new ArrayList<>(), 0);
        return result;

    }

    private void dfs(TreeNode currentNode, int targetSum, List<List<Integer>> result, List<Integer> currentNodes, int currentSum){

        if(currentNode == null)
            return;
        currentSum += currentNode.val;
        currentNodes.add(currentNode.val);

        if(currentNode.left == null && currentNode.right == null){
            if(currentSum == targetSum){
                result.add(new ArrayList<>(currentNodes));
                currentNodes.removeLast();
                return;
            }
        }

        dfs(currentNode.left, targetSum, result, currentNodes, currentSum);
        dfs(currentNode.right, targetSum, result, currentNodes, currentSum);
        currentNodes.removeLast();

    }

}
