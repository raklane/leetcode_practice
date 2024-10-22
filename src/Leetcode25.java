public class Leetcode25 {

    public static void main(String[] args) {
        ListNode head = new ListNode();
        int[] arr = new int[]{1,2,3,4,5};
        ListNode node = head;
        for (int i = 0; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        head = head.next;

        ListNode result = reverseKGroup(head,3);
        while(result!=null){
            System.out.print(result.val + "/t");
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode previousNode = null;
        ListNode currentNode = head;
        ListNode nodeToReturn = head;
        ListNode nextNode = null;
        ListNode nodeToSwap = null;
        ListNode swappedNode = null;
        ListNode movingNode = null;

        while(currentNode != null && currentNode.next != null){

            int i=0;
            movingNode = currentNode;
            while(i++<k){
                if(movingNode == null)
                    return nodeToReturn;
                movingNode = movingNode.next;
            }

            i=0;
            nodeToSwap = currentNode.next;
            while(i++<k-1){

                nextNode = currentNode.next;
                currentNode.next = nodeToSwap.next;
                nodeToSwap.next = nextNode;
                swappedNode = currentNode;

                currentNode = nodeToSwap;
                nodeToSwap = swappedNode.next;


            }
            if(previousNode != null){
                previousNode.next = currentNode;
            }else{
                nodeToReturn = currentNode;
            }
            previousNode = swappedNode;
            previousNode.next = movingNode;
            currentNode = movingNode;

        }

        return nodeToReturn;

    }

}
