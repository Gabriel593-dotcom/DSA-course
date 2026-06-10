package DSAStructures.simplelinkedlist;

import java.util.Objects;

public class SimpleLinkedList<T> {
    private Node<T> head;
    private int size;

    public SimpleLinkedList() {
        this.head = null;
        this.size = 0;
    }


    public void add(T value) {
        size++;
        if (Objects.isNull(head)) {
            head = new Node<>(value, null);
            return;
        }

        head.append(value);
    }

    public Node<T> search(T value) {
        Node<T> current = head;

        while (current != null) {
            if (current.getValue().equals(value))
                return current;

            current = current.getNext();
        }

        return new Node<>(null, null);
    }

    public void delete(T value) {

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                if (Objects.isNull(previous)) {
                    head = head.getNext();
                    return;
                }

                previous.updateNext(current.getNext());
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public int size() {
        return this.size;
    }

    public void print() {
        Node<T> current = head;
        while(current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

}
