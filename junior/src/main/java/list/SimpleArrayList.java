package list;

public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Method add data to the list in the begining
     * @param data - data
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = first;
        this.first = newLink;
        this.size++;
    }

    public E delete() {
        Node<E> rsl = this.first;
        this.first = rsl.next;
        this.size--;
        return rsl.data;
    }
    /**
     * Method retrieving element by index
     * @param index - index of element
     * @return - element
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    /**
     * Method for retrieve size of collection
     * @return - size
     */
    public int getSize() {
        return this.size;
    }

    private static class Node<E> {
        E data;
        Node<E> next;
        public Node(E data) {
            this.data = data;
        }
    }
}
