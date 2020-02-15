package conteiner.cycle;

public class CycleList {
    public static boolean hasCycle(Node first) {
        boolean rsl = false;
        Node node = first;
        Node nodeNext;
        while (node.next != null) {
            nodeNext = node.next;
            nodeNext.previous = node;
            Node prev = node.previous;
            while (prev != null) {
                if (prev == nodeNext) {
                    rsl = true;
                    break;
                }
                prev = prev.previous;
            }
            if (rsl) {
                break;
            }
            node = nodeNext;
        }
        return rsl;
    }
}
