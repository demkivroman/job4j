package stream;

import java.util.*;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile() {

    }

    public Profile(Address address) {
        this.address = address;
    }

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(
                element -> element.address
        ).collect(Collectors.toList());
    }

    public List<Address> collectUnic(List<Profile> profiles) {
        List<Address> rsl = profiles.stream().map(
                element -> element.address
        ).distinct().collect(Collectors.toList());
        rsl.sort(
                new Comparator<Address>() {
                    @Override
                    public int compare(Address o1, Address o2) {
                        return o1.getCity().compareTo(o2.getCity());
                    }
                }
        );
        return rsl;
    }
}
