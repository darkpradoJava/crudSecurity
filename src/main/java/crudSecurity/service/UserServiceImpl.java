package crudSecurity.service;

import crudSecurity.dao.UserDao;
import crudSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userDao.getUserByLogin(login);
    }

}
