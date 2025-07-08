public class Leetcode86 {

    public ListNode partition(ListNode head, int x) {

        ListNode sentinelNode = new ListNode(0, head);

        ListNode prev = sentinelNode;
        ListNode currentNode = head;
        while (currentNode != null && currentNode.val < x){
            prev = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null || currentNode.next == null)
            return sentinelNode.next;

        ListNode prevMovingNode = currentNode;
        ListNode movingNode = currentNode.next;

        while (movingNode != null){

            if(movingNode.val < x){
                prevMovingNode.next = movingNode.next;
                prev.next = movingNode;
                movingNode.next = currentNode;
                prev = movingNode;
                movingNode = prevMovingNode;
            }else{
                prevMovingNode = movingNode;
                movingNode = movingNode.next;
            }

        }
        return sentinelNode.next;

    }

}
