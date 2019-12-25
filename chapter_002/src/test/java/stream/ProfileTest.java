package stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileTest {
    @Test
    public void whenCheckAddress() {
        Address first = new Address("Borislav", "Kovaliva", 5, 1);
        Address second = new Address("Lviv", "Kovaliva", 6, 2);
        Address thirt = new Address("Borislav", "Valova", 10, 1);

        List<Address> expect = new ArrayList<>();
        expect.add(first);
        expect.add(second);
        expect.add(thirt);

        List<Profile> list = new ArrayList<>();
        list.add(new Profile(first));
        list.add(new Profile(second));
        list.add(new Profile(thirt));

        List<Address> rsl = new Profile().collect(list);

        assertThat(
                expect,
                is(rsl)
        );
    }
    @Test
    public void whenCheckAddressUnic() {
        Address first = new Address("Borislav", "Kovaliva", 5, 1);
        Address second = new Address("Lviv", "Kovaliva", 6, 2);
        Address thirt = new Address("Abc", "Valova", 10, 1);
        Address forth = new Address("Borislav", "Kovaliva", 5, 1);


        List<Profile> list = new ArrayList<>();
        list.add(new Profile(first));
        list.add(new Profile(second));
        list.add(new Profile(thirt));
        list.add(new Profile(forth));

        List<Address> rsl = new Profile().collectUnic(list);

        List<String> result = rsl.stream().map(
                el -> el.getCity()
        ).collect(Collectors.toList());
        List<String> expect = List.of("Abc", "Borislav", "Lviv");
        assertThat(
                expect,
                is(result)
        );
    }

}
