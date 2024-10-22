import java.util.ArrayList;

public class Leetcode23 {

    public static void main(String[] args) {



    }

    public static ListNode mergeKLists(ListNode[] lists) {


        int totalSize = 0;
        for(ListNode node : lists){
            ListNode currentNode = node;
            while(currentNode != null){
                totalSize++;
                currentNode = currentNode.next;
            }
        }

        ListNode result = null;
        ListNode returnNode = null;
        int index = 0;
        int listSize = lists.length;

        while(index<totalSize){

            int currentValue = Integer.MAX_VALUE;
            int foundIndex = 0;
            for(int i=0; i<listSize; i++){

                ListNode currentNode = lists[i];
                if(currentNode == null)
                    continue;
                int value = currentNode.val;
                if(value < currentValue){
                    currentValue = value;
                    foundIndex = i;
                }

            }
            if(result == null){
                result = new ListNode();
                returnNode = result;
            }else{
                result.next = new ListNode();
                result = result.next;
            }
            result.val = lists[foundIndex].val;
            lists[foundIndex] = lists[foundIndex].next;
            index++;

        }
        return returnNode;
    }

}
