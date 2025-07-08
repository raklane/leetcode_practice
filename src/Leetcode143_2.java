public class Leetcode143_2 {
    public static void main(String[] args){

    }
    public void reorderList(ListNode head) {


        //find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;

        //reverse the second List
        ListNode prev = null, current = slow;
        while (current!=null){
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        //merge two arrays
        ListNode leftNode = head;


    }


}
