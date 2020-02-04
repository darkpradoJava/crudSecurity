package crudSecurity.service;

import crudSecurity.model.User;

import java.util.List;

public interface UserService {

    void add(User user);
    void update(User user);
    void delete(User user);
    List<User> getUsers();
    User getUserById(Long id);
    User getUserByLogin(String login);

}
