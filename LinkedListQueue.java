package sms;

public class LinkedListQueue<T extends Identifiable> {
    private Node<T> head;
    private Node<T> tail;

    public LinkedListQueue() {
        head = tail = null;
    }

    // Add to the end of the queue
    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    // Remove from the front of the queue
    public T dequeue() {
        if (head == null) return null;
        T data = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    // Remove by ID
    public boolean remove(int id) {
        Node<T> node = head;
        while (node != null) {
            if (node.data.getId() == id) {
                if (node.prev != null) node.prev.next = node.next;
                else head = node.next;

                if (node.next != null) node.next.prev = node.prev;
                else tail = node.prev;

                return true;
            }
            node = node.next;
        }
        return false;
    }

    // Search by ID
    public Node<T> search(int id) {
        Node<T> node = head;
        while (node != null) {
            if (node.data.getId() == id) return node;
            node = node.next;
        }
        return null;
    }

    // Display queue contents
    public void display() {
        Node<T> node = head;
        while (node != null) {
            System.out.println(node.data.getId() + " - " + node.data);
            node = node.next;
        }
    }

    // Check if empty
    public boolean isEmpty() {
        return head == null;
    }

    // Traverse all elements as array
    public java.util.List<T> toList() {
        java.util.List<T> list = new java.util.ArrayList<>();
        Node<T> node = head;
        while (node != null) {
            list.add(node.data);
            node = node.next;
        }
        return list;
    }
// Adds end of the queue
    public void offer(T subject) {
        enqueue(subject);

    }
}
