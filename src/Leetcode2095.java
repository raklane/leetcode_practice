public class Leetcode2095 {
    public static void main(String[] args){

    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast!=null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev!=null){
            ListNode next = slow.next;
            prev.next = null;
            slow.next = null;
            slow = null;
            prev.next = next;
        }else{
            head=null;
        }
        return head;
    }
}
