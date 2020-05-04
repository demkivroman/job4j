package tracker;

import org.junit.Test;
import ru.job4j.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream stdout = new PrintStream(out);
    private final Consumer<String> output = new Consumer<String>() {
        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Store memTracker = new TrackerSQL();
        new CreateAction(0, "Create Item").execute(input, memTracker);
        Item created = memTracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Store memTracker = new TrackerSQL();
        Item item = new Item("new item");
        memTracker.add(item);
        String[] answers = {
                item.getId(),
                "replaced item"
        };
        new EditAction(2, "Edit Item").execute(new StubInput(answers), memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void whenDeleteItem() {
        Store memTracker = new TrackerSQL();
        Item item = new Item("delete item");
        memTracker.add(item);
        String[] answers = {
                item.getId()
        };
        new DeleteAction(3, "Delete Item").execute(new StubInput(answers), memTracker);
        Item found = memTracker.findById(answers[0]);
        Item expected = null;
        assertThat(found, is(expected));
    }
}
