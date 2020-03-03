package conteiner.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private final Node<E> root;
    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> parentEntry = findBy(parent);
        Optional<Node<E>> childEntry = findBy(child);
        if (parentEntry.isPresent() && childEntry.isEmpty()) {
            Node<E> par = parentEntry.get();
            par.children.add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
    public boolean isBinary() {
        boolean rsl = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                rsl = false;
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}