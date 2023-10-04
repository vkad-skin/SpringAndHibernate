package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUserById(int id);
}
