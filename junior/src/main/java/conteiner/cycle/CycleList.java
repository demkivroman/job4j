package conteiner.cycle;

public class CycleList {
    public static boolean hasCycle(Node first) {
        boolean rsl = false;
        Node turtle = first.next;
        Node hare = first.next != null ? first.next.next : null;
        while (turtle != hare && hare != null) {
            turtle = turtle.next;
            hare = hare.next != null ? hare.next.next : null;
        }
        if (turtle == hare) {
            rsl = true;
        }
        return rsl;
    }
}
