package tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1");
        tracker.add(previous);
        Item next = new Item("test2");
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenDeleteItemThenTrackerHasNullInEnd() {
        Tracker tracker = new Tracker();
        Item first = new Item("first");
        Item second = new Item("second");
        Item third = new Item("third");
        Item forth = new Item("forth");
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        tracker.add(forth);
        boolean del = tracker.delete(second.getId());
        String[] expected = {"first", "third", "forth"};
        String[] cmp = new String[tracker.findAll().length];
        int index = 0;
        for (Item im : tracker.findAll()) {
            cmp[index++] = im.getName();
        }
        assertThat(expected, is(cmp));
    }
    @Test
    public void whenFindItemByNameReturnArr() {
        Tracker tracker = new Tracker();
        Item test1 = new Item("test");
        Item test2 = new Item("test");
        Item test3 = new Item("test");
        Item test4 = new Item("test4");
        Item test5 = new Item("test5");
        tracker.add(test1);
        tracker.add(test2);
        tracker.add(test3);
        tracker.add(test4);
        tracker.add(test5);
        Item[] found = tracker.findByName("test");
        String[] expected = {"test", "test", "test"};
        String[] cmp = new String[found.length];
        int index = 0;
        for (Item im : found) {
            cmp[index++] = im.getName();
        }
        assertThat(expected, is(cmp));
    }
    @Test
    public void whenFindItemByIdReturnItem() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test");
        tracker.add(previous);
        Item next = new Item("next");
        next.setId(previous.getId());
        String expected = previous.getId();
        assertThat(expected, is(next.getId()));
    }
}
