package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void saveUser(User user);

    User getUser(int id);

    void deleteUserById(int id);
}
