package crudSecurity.dao;

import crudSecurity.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsers() {
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return (User)session.createQuery("from User where login = '" + login + "'").uniqueResult();
    }

}
