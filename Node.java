package sms;

public class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;
    Node(T data) {
        this.data = data;
        prev = next = null;
    }
}
