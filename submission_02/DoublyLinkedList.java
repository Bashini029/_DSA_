
public class DoublyLinkedList {

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        size++;
    }

    public void delete(int data) {
        Node current = head;

        while (current != null && current.data != data) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found");
            return;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
    }

    public boolean search(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        System.out.print("Forward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = tail;

        System.out.print("Backward: ");

        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }

        System.out.println("null");
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {

        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.displayForward();
        list.displayBackward();

        list.insertAtBeginning(5);
        list.displayForward();

        list.delete(20);

        list.displayForward();
        list.displayBackward();

        System.out.println("Search 30: " + list.search(30));
        System.out.println("List Size: " + list.size());
    }
}
