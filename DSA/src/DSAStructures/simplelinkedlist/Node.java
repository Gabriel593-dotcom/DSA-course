package DSAStructures.simplelinkedlist;

public class Node<T> {
    private T value;
    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    protected T getValue() {
        return this.value;
    }

    protected void updateNext(Node<T> next) {
        this.next = next;
    }

    protected Node<T> getNext() {
        return this.next;
    }

    protected boolean hasValue() {
        return this.value != null;
    }

    //add in front
    protected void append(T newValue) {
        if (hasValue()) {
            this.next = new Node<>(value, next);
            this.value = newValue;
        }
    }

    @Override
    public String toString() {
        return " value: " +
                this.value +
                "\n  next: " +
                this.next;
    }
}
