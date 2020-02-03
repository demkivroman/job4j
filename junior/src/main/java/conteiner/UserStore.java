package conteiner;

import generic.SimpleArray;

public class UserStore implements Store<User> {
    private SimpleArray<User> array;
    public UserStore(int size) {
        array = new SimpleArray<>(size);
    }
    @Override
    public void add(User model) {
        array.add(model);
    }
    @Override
    public boolean replace(String id, User model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
