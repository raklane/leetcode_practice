public class Leetcode61 {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null)
            return head;
        ListNode currentNode = head;
        int size = 0;
        while (currentNode != null){
            currentNode = currentNode.next;
            size++;
        }

        int rotationRequired = k%size;
        int nodeIndexToRotate = size-rotationRequired;

        if(rotationRequired == 0)
            return head;

        ListNode previousNode = currentNode;
        currentNode = head;
        while (nodeIndexToRotate>0){
            previousNode = currentNode;
            currentNode = currentNode.next;
            nodeIndexToRotate--;
        }

        previousNode.next = null;
        ListNode nextNode = currentNode;
        while (nextNode.next != null){
            nextNode = nextNode.next;
        }
        nextNode.next = head;

        return currentNode;

    }

}
