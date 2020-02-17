package conteiner.cycle;

public class Node<T> {
    private T value;
    public Node next;

    public Node(T value) {
        this.value = value;
    }
}
