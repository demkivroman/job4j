package conteiner;

import generic.SimpleArray;

public class RoleStore extends AbstractStore<Role> {
    public RoleStore(int size) {
        super(size);
    }

    @Override
    public Role findById(String id) {
        return (Role) super.findById(id);
    }
}
