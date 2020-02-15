package cycle;

import conteiner.cycle.CycleList;
import conteiner.cycle.Node;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CycleListTest {
    @Test
    public void whenCheckListIsCycled() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> forth = new Node<>(4);

        first.next = second;
        second.next = third;
        third.next = forth;
        forth.next = first;

        boolean rsl = CycleList.hasCycle(first);

        assertThat(
                rsl,
                is(true)
        );
    }

    @Test
    public void whenCheckListIsNotCycled() {
        Node<Integer> first = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> forth = new Node<>(4);

        first.next = second;
        second.next = third;
        third.next = forth;

        boolean rsl = CycleList.hasCycle(first);

        assertThat(
                rsl,
                is(false)
        );
    }

    @Test
    public void whenCheckListIsCycledInTheMiddle() {
        Node<Integer> first = new Node<>(1);
        Node<String> second = new Node<>("2");
        Node<Double> third = new Node<>(3.0d);
        Node<Integer> forth = new Node<>(4);

        first.next = second;
        second.next = first;
        third.next = forth;
        forth.next = first;

        boolean rsl = CycleList.hasCycle(first);

        assertThat(
                rsl,
                is(true)
        );
    }
}
