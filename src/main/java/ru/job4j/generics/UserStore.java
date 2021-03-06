package ru.job4j.generics;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, User model) {
        boolean result;
        if (store.findById(id) != null) {
            store.replace(id, model);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result;
        if (store.findById(id) != null) {
            store.delete(id);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public User findById(String id) {
        User result;
        if (store.findById(id) != null) {
            result = store.findById(id);
        } else {
            result = null;
        }
        return result;
    }
}
