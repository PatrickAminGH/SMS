package sms;

public class LinkedList<T extends Identifiable> {
    Node<T> head;
    Node<T> tail;

    LinkedList() {
        head = tail = null;
    }

    public void add(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }
    }

    public boolean remove(int id) {
        Node<T> node = head;
        while (node != null) {
            if (node.data.getId() == id) {
                if (node.prev == null && node.next == null) {
                    head = tail = null;
                }

                else if (node.prev == null) {
                    head = node.next;
                    head.prev = null;
                }

                else if (node.next == null) {
                    tail = node.prev;
                    tail.next = null;
                }

                else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public Node<T> search(int id) {
        Node<T> node = head;
        while (node != null) {
            if(node.data.getId() == id){
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public void display() {
        Node<T> node = head;
        while (node != null) {
            System.out.println(node.data.getId());
            node = node.next;
        }
    }
}
