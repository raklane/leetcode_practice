import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingQueue {

    Node head;
    Node tail;
    Queue<Node> queue;
    int size;


    class Node{
        int value;
        Node prev;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public StackUsingQueue() {

        queue = new LinkedList<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        size = 0;

    }

    public void push(int x) {

        Node newNode = new Node(x);
        queue.add(newNode);
        newNode = head.next;
        newNode.prev = head;
        newNode.next = head.next;
        head.next = newNode;
        newNode.next.prev = newNode;
        size++;

    }

    public int pop() {

        if(head.next == tail)
            return 0;
        Node returnNode = head.next;
        returnNode.next = head.next;
        head.next = returnNode.next;
        returnNode.next.prev = head;
        queue.remove(returnNode);
        size--;
        returnNode.next = null;
        returnNode.prev = null;
        return returnNode.value;

    }

    public int top() {
        if(head.next == tail)
            return 0;
        Node returnNode = head.next;
        return returnNode.value;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void printStack(){
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.value + "\t");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}
