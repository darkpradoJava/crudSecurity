package crudSecurity.service;

import crudSecurity.dao.RoleDao;
import crudSecurity.dao.UserDao;
import crudSecurity.model.Role;
import crudSecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public void setUserDao(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public void add(User user, String role) {
        Set<Role> setRoles = new HashSet<>();
        if(role.equals("ADMIN")) {
            setRoles.add(roleDao.getRoleById(1L));
        } else {
            setRoles.add(roleDao.getRoleById(2L));
        }
        user.setRoles(setRoles);
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
