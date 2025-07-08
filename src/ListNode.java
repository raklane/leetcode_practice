//Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode(int[] arr){
         ListNode currentNode = this;
         ListNode previousNode = currentNode;
         for(int num : arr){
             currentNode.val = num;
             currentNode.next = new ListNode();
             previousNode = currentNode;
             currentNode = currentNode.next;
         }
         previousNode.next = null;
    }
 }
