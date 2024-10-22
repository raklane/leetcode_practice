import java.util.Stack;

//This is class for leetcode 232

public class QueueUsingStack {

    Node head;
    Node tail;
    Stack<Node> queue;
    int size;

    class Node{
        int value;
        Node prev;
        Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public QueueUsingStack() {

        queue = new Stack<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;

    }

    public void push(int x) {

        Node newNode = new Node(x);
        queue.push(newNode);
        head.next.prev = newNode;
        newNode.next = head.next;
        head.next = newNode;
        newNode.prev = head;
        size++;

    }

    public int pop() {

        Node returnNode = tail.prev;
        if(tail.prev==head)
            return 0;
        returnNode.prev.next = tail;
        tail.prev = returnNode.prev;
        returnNode.prev = null;
        returnNode.next = null;
        queue.remove(size-1);
        size--;
        return returnNode.value;

    }

    public int peek() {

        if(tail.prev == head)
            return 0;
        else return tail.prev.value;

    }

    public boolean empty() {
        return queue.isEmpty();
    }

}
