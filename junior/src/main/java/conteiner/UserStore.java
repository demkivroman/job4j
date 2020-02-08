package conteiner;

import generic.SimpleArray;

public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
    }

    @Override
    public User findById(String id) {
        return (User) super.findById(id);
    }
}
