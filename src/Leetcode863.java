import java.util.*;

public class Leetcode863 {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Stack<TreeNode> stack = new Stack<>();
        findTargetNode(root, target, stack);
        Queue<TreeNode> queue = new LinkedList<>();
        int currentDistance = 0;
        queue.offer(stack.pop());
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        while (!queue.isEmpty()){
            if(currentDistance == k) {
                for(TreeNode node : queue)
                    result.add(node.val);
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if(top.left != null && !visited.contains(top.left))
                    queue.offer(top.left);
                if(top.right != null && !visited.contains(top.right))
                queue.offer(top.right);
                visited.add(top);
            }
            if(!stack.isEmpty()){
                queue.offer(stack.pop());
            }
            currentDistance++;

        }
        return result;

    }

    private boolean findTargetNode(TreeNode currentNode, TreeNode target, Stack<TreeNode> stack){

        if(currentNode == null)
            return false;

        if(currentNode.val == target.val) {
            stack.push(currentNode);
            return true;
        }

        stack.push(currentNode);
        if(findTargetNode(currentNode.left, target, stack) ||
                findTargetNode(currentNode.right, target, stack))
            return true;
        stack.pop();
        return false;

    }

}
