import java.util.*;

public class Leetcode314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> order = new ArrayList<>();
        if(root == null)
            return order;

        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, List<Integer>> orderMap = new HashMap<>();
        Map<TreeNode, Integer> treeNodeMap = new HashMap<>();
        List<Integer> listOfNodes = new ArrayList<>();
        listOfNodes.add(root.val);
        orderMap.put(0, listOfNodes);
        treeNodeMap.put(root, 0);
        queue.offer(root);

        int leftMostOrder = 0;
        int rightMostOrder = 0;

        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();
                int orderOfCurrentNode = treeNodeMap.get(currentNode);
                if(currentNode.left != null){
                    TreeNode leftNode = currentNode.left;
                    queue.offer(leftNode);
                    treeNodeMap.put(leftNode, orderOfCurrentNode-1);
                    List<Integer> listOfNodesForCurrentNode = orderMap.getOrDefault(orderOfCurrentNode-1, new ArrayList<>());
                    listOfNodesForCurrentNode.add(leftNode.val);
                    orderMap.put(orderOfCurrentNode-1, listOfNodesForCurrentNode);
                    leftMostOrder = Math.min(leftMostOrder, orderOfCurrentNode-1);
                }
                if(currentNode.right != null){
                    TreeNode rightNode = currentNode.right;
                    queue.offer(rightNode);
                    treeNodeMap.put(rightNode, orderOfCurrentNode+1);
                    List<Integer> listOfNodesForCurrentNode = orderMap.getOrDefault(orderOfCurrentNode+1, new ArrayList<>());
                    listOfNodesForCurrentNode.add(rightNode.val);
                    orderMap.put(orderOfCurrentNode+1, listOfNodesForCurrentNode);
                    rightMostOrder = Math.max(rightMostOrder, orderOfCurrentNode+1);
                }
            }

        }

        for (int i = leftMostOrder; i <= rightMostOrder; i++) {
            order.add(orderMap.get(i));
        }
        return order;
    }

}
