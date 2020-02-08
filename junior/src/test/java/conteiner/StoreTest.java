package conteiner;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StoreTest {
    @Test
    public void whenCheckAddItemToUserStore() {
        UserStore store = new UserStore(3);
        User ob1 = new User("1");
        User ob2 = new User("2");
        store.add(ob1);
        store.add(ob2);
        User rsl = store.findById("1");

        assertThat(
                rsl.getId(),
                is(ob1.getId())
        );
    }
    @Test(expected = ClassCastException.class)
    public void whenCheckAddIncorrectElementThrowCastExeption() {
        UserStore store = new UserStore(3);
        User ob1 = new User("1");
        Role ob2 = new Role("2");
        store.add(ob1);
        store.add(ob2);
    }
    @Test
    public void whenCheckRemoveItem() {
        UserStore store = new UserStore(3);
        User ob1 = new User("1");
        User ob2 = new User("2");
        store.add(ob1);
        store.add(ob2);
        store.delete("1");
        User rsl = store.findById("1");
        User expected = null;

        assertThat(
                rsl,
                is(expected)
        );
    }

    @Test
    public void whenCheckReplace() {
        UserStore store = new UserStore(3);
        User ob1 = new User("1");
        User ob2 = new User("2");
        User ob3 = new User("3");
        store.add(ob1);
        store.add(ob2);
        store.replace("2", ob3);

        User n = null;
        User expected = store.findById("3");
        assertThat(
                store.findById("2"),
                is(n)
        );

        assertThat(
                expected.getId(),
                is("3")
        );
    }

    @Test
    public void whenCheckAddRoleItm() {
        RoleStore store = new RoleStore(2);
        Role ob1 = new Role("1");
        Role ob2 = new Role("2");
        store.add(ob1);
        store.add(ob2);
        Role rsl = store.findById("1");

        assertThat(
                rsl.getId(),
                is(ob1.getId())
        );
    }
}
